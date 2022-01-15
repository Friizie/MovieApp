package com.example.movieapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class EventInfo extends AppCompatActivity {
    TextView name,dateAndTime;
    Button remove;
    int index;
    Database db;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_info);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    void init() {
        db = new Database(getApplicationContext());
        name = findViewById(R.id.EventName);
        dateAndTime = findViewById(R.id.EventDateAndTime);

        remove = findViewById(R.id.DeleteEvent);

        Bundle bundle = getIntent().getExtras();
        index = bundle.getInt("index");
        name.setText(bundle.getString("name"));
        dateAndTime.setText(bundle.getString("date"));

        int idIndex = bundle.getInt("id");


        Context ct = this;
        remove.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ct);
                builder.setTitle("Delete Event?");
                builder.setCancelable(false);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (Event e: Event.eventsList) {
                            if (e.getId() == idIndex) {
                                Event.eventsList.remove(e);
                                db.deleteItem(MainActivity.EVENT, idIndex + "");
                                break;
                            }
                        }
                        finish();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog alertDialog = builder.create();

                alertDialog.show();
                alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.white));

                alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.white));

                alertDialog.getButton(DialogInterface.BUTTON_NEUTRAL).setTextColor(getResources().getColor(R.color.white));


            }
        });
    }
}