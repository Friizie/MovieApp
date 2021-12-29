package com.example.movieapp;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.time.LocalTime;
import java.util.ArrayList;

@RequiresApi(api = Build.VERSION_CODES.O)
public class EventEditActivity extends AppCompatActivity {
    private EditText eventNameET;
    private TextView eventDateTV, eventTimeTV;
    private LocalTime time;
    private ArrayList<Event> eventlist;
    private static final String EVENTS = "events";
    private static final String SHARED_PREFS = "shared preferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_edit);
        load();
        init();
        time = LocalTime.now();
        eventDateTV.setText("Date: " + CalendarUtils.formattedDate(CalendarUtils.selectedDate));
        eventTimeTV.setText("Time: " + CalendarUtils.formattedTime(time));
    }

    private void init() {
        eventNameET = findViewById(R.id.eventNameET);
        eventDateTV = findViewById(R.id.eventDateTV);
        eventTimeTV = findViewById(R.id.eventTimeTV);
    }

    public void saveEventAction(View view) {
        String eventName = eventNameET.getText().toString();
        Event newEvent = new Event(eventName, CalendarUtils.selectedDate, time);
        Event.eventsList.add(newEvent);
        eventlist.add(newEvent);
        save();
        finish();
    }

    public void save() {
        SharedPreferences sp = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        Gson gson= new Gson();
        String json = gson.toJson(eventlist);
        editor.putString(EVENTS,json);
        editor.apply();
    }
    public void load() {
        SharedPreferences sp = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        Gson gson= new Gson();
        String json = sp.getString(EVENTS,null);
        Type type = new TypeToken<ArrayList<Event>>() {}.getType();
        eventlist=gson.fromJson(json,type);
        if(eventlist == null) {
            eventlist = new ArrayList<>();
        }
    }



}