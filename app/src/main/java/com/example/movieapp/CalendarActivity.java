package com.example.movieapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

import java.time.LocalDate;
import java.util.ArrayList;

@RequiresApi(api = Build.VERSION_CODES.O)
public class CalendarActivity extends AppCompatActivity implements CalendarAdapter.OnItemListener {
    Database db;
    private TextView monthYearText;
    private RecyclerView calendarRecyclerView;
    private ArrayList<Event> eventlist;
    private RecyclerView eventListView;
    FloatingActionButton add;
    NavigationBarView navBarCalendar;
    static CalendarEventAdapter adapter;
    CalendarEventAdapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        db = new Database(this);
//        db.deleteAllData();
//        for (Event e : eventlist) {
//            db.add(e.getName(), e.getTime().toString(), e.getDate().toString());
//        }
        navInit();
        calendarRecyclerView = findViewById(R.id.calendarRecyclerView);
        monthYearText = findViewById(R.id.monthYearTV);
        eventListView = findViewById(R.id.eventListViewC);
        CalendarUtils.selectedDate = LocalDate.now();
        init();
        setMonthView();
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onResume() {
        super.onResume();
        setMonthView();
        changeAdapter();
        adapter.notifyDataSetChanged();
    }

    private void setMonthView() {
        monthYearText.setText(CalendarUtils.monthYearFromDate(CalendarUtils.selectedDate));
        ArrayList<LocalDate> daysInMonth = CalendarUtils.daysInMonthArray(CalendarUtils.selectedDate);

        CalendarAdapter calendarAdapter = new CalendarAdapter(daysInMonth, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calendarAdapter);
//        setEventAdapter();
    }

    public void previousMonthAction(View view) {
        CalendarUtils.selectedDate = CalendarUtils.selectedDate.minusMonths(1);
        setMonthView();
        changeAdapter();
    }

    public void nextMonthAction(View view) {
        CalendarUtils.selectedDate = CalendarUtils.selectedDate.plusMonths(1);
        setMonthView();
        changeAdapter();
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onItemClick(int position, LocalDate date) {
        if(date != null) {
            CalendarUtils.selectedDate = date;
            setMonthView();
            changeAdapter();
        }

    }

    public void weeklyAction(View view) {
        startActivity(new Intent(this, WeekViewActivity.class)
                .addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
    }
    public void newEventAction(View view) {
        startActivity(new Intent(this, EventEditActivity.class)
                .addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
    }


    void init() {
        eventListView = findViewById(R.id.eventListViewC);
        setOnClickListener();
        eventlist = Event.eventsForDate(CalendarUtils.selectedDate);
        adapter = new CalendarEventAdapter(eventlist, listener);

        add = findViewById(R.id.Add);

        RecyclerView.LayoutManager lm = new LinearLayoutManager(getApplicationContext());
        eventListView.setLayoutManager(lm);
        eventListView.setItemAnimator(new DefaultItemAnimator());
        eventListView.setAdapter(adapter);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newEventAction(v);
            }
        });

    }

    void changeAdapter() {
        eventlist = Event.eventsForDate(CalendarUtils.selectedDate);
        adapter = new CalendarEventAdapter(eventlist, listener);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(getApplicationContext());
        eventListView.setLayoutManager(lm);
        eventListView.setItemAnimator(new DefaultItemAnimator());
        eventListView.setAdapter(adapter);

    }
    private void setOnClickListener() {
        listener = new CalendarEventAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                startActivity(new Intent(getApplicationContext(), EventInfo.class)
                        .putExtra("name", eventlist.get(position).getName())
                        .putExtra("id", eventlist.get(position).getId())
                        .putExtra("index",position)
                        .addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
            }
        };

    }


    void navInit() {
        navBarCalendar = (NavigationBarView) findViewById(R.id.BottomNavViewCalendar);
        navBarCalendar.setBackground(null);
        navBarCalendar.setSelectedItemId(R.id.mCalendar);

        navBarCalendar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.mHome:
//                        startActivity(new Intent(CalendarActivity.this,MainActivity.class)
//                                .addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
                        finish();
                        break;
                    case R.id.mCalendar:
                        break;
                    case R.id.mTrivia:
                        startActivity(new Intent(CalendarActivity.this,BeginTrivia.class)
                                .addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
                        finish();
                        break;
                }
                return true;
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        navBarCalendar.setSelectedItemId(R.id.mHome);
        overridePendingTransition(0, 0);
        this.finish();
    }



}
