package com.example.movieapp;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@RequiresApi(api = Build.VERSION_CODES.O)
public class EventEditActivity extends AppCompatActivity {
    private EditText eventNameET,weeklyText;
    private TextView eventDateTV, eventTimeTV;
    private LocalTime time;
    CheckBox weeklyCheck;
    Database db;
    boolean weekly = false;
    int k;

    boolean[] selected;
    ArrayList<String> movies = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_edit);
        init();
        time = LocalTime.now();
        eventDateTV.setText("Date: " + CalendarUtils.formattedDate(CalendarUtils.selectedDate));
        eventTimeTV.setText("Time: " + CalendarUtils.formattedTime(time));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_from_list_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String[] movieArr = new String[ListFragment1.movieList.size()];
        for (int i = 0; i<ListFragment1.movieList.size();i++) {
            movieArr[i] = ListFragment1.movieList.get(i).getTitle();
        }

        selected = new boolean[movieArr.length];

        String[] a = eventNameET.getText().toString().split(", ");
        for (String str : a) {
            for (int i = 0;i < movieArr.length;i++) {
                if (movieArr[i].equals(str)) {
                    selected[i] = true;
                    movies.add(i+"");
                    break;
                }
            }
        }
        Collections.sort(movies);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select Titles");
        builder.setCancelable(false);
        builder.setMultiChoiceItems(movieArr, selected, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked) {
                    movies.add(which+"");
                    Collections.sort(movies);
                } else movies.remove(which+"");
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(DialogInterface dialog, int which) {
                movies = (ArrayList<String>) movies.stream().distinct().collect(Collectors.toList());
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < movies.size(); i++) {
                    sb.append(movieArr[Integer.parseInt(movies.get(i))]);
                    if (i != movies.size() - 1)
                        sb.append(", ");
                }
                eventNameET.setText(sb.toString());
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setNeutralButton("Clear", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Arrays.fill(selected, false);
                movies.clear();
                eventNameET.setText("");
            }
        });
        AlertDialog alertDialog = builder.create();

        alertDialog.show();
        alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.white));

        alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.white));

        alertDialog.getButton(DialogInterface.BUTTON_NEUTRAL).setTextColor(getResources().getColor(R.color.white));

        return super.onOptionsItemSelected(item);
    }

    void init() {
        db = new Database(getApplicationContext());
        eventNameET = findViewById(R.id.eventNameET);
        eventDateTV = findViewById(R.id.eventDateTV);
        eventTimeTV = findViewById(R.id.eventTimeTV);
        weeklyText = findViewById(R.id.weeklyText);
        weeklyCheck = findViewById(R.id.weeklyCheck);

        weeklyCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                weekly = isChecked;
                if(weekly) weeklyText.setVisibility(View.VISIBLE);
                else weeklyText.setVisibility(View.GONE);
            }
        });
    }

    @SuppressLint("NotifyDataSetChanged")
    public void saveEventAction(View view) {
        String n = weeklyText.getText().toString();
        Matcher m = Pattern.compile("\\d+").matcher(n);
        if(weekly && (Pattern.compile("[^0-9]+").matcher(n).find() || n.equals(""))){
            Toast.makeText(this,"Please enter valid information"
                    ,Toast.LENGTH_SHORT).show();
            return;
        }

        int N = !m.find() ? 0 : Integer.parseInt(n);
        k = weekly ? N : 0;
        for(int i = 0;i <= k; i++) {
            String eventName = eventNameET.getText().toString();
            eventName = eventName.equals("") ? "No Title" : eventName;
            Event newEvent = new Event(eventName, CalendarUtils.selectedDate, time);
            newEvent.setId();
            if(weekly) newEvent.setDate(CalendarUtils.selectedDate.plusWeeks(i));
            Event.eventsList.add(newEvent);

            db.addEvent(MainActivity.EVENT, newEvent.getId(), newEvent.getName(),
                    newEvent.getDate().toString(), newEvent.getTime().toString());

//            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CalendarActivity.NOTIFICATION_SERVICE)
//                    .setSmallIcon(R.drawable.ic_calendar)
//                    .setContentTitle(eventName)
//                    .setContentText("")
//                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//                    .setWhen(CalendarUtils.selectedDate.atTime(time)
//                            .atZone(ZoneId.systemDefault())
//                            .toInstant().toEpochMilli()+5000);
//
//            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//            notificationManager.notify(1,builder.build());
        }
        CalendarActivity.adapter.notifyItemInserted(Event.eventsList.size());
        finish();
    }


}