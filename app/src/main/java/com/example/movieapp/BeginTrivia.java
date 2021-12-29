package com.example.movieapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationBarView;

public class BeginTrivia extends AppCompatActivity {
    Button start;
    NavigationBarView navBarTriviaStart, mainNavBar;
    Button d1,d2,d3;
    int difficulty = 0;
    int     SELECTED_COLOUR = Color.parseColor("#b80000"),
            DEFAULT_COLOUR = Color.parseColor("#FF6200EE");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin_trivia);
        init();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        navBarTriviaStart.setSelectedItemId(R.id.mHome);
        overridePendingTransition(0, 0);
        this.finish();
    }


    void init() {
        start = (Button) findViewById(R.id.startButton);
        d1    = (Button) findViewById(R.id.EasyDifButton);
        d2    = (Button) findViewById(R.id.MediumDifButton);
        d3    = (Button) findViewById(R.id.HardDifButton);
        navBarTriviaStart = (NavigationBarView) findViewById(R.id.BottomNavViewTriviaStart);
        mainNavBar = (NavigationBarView) findViewById(R.id.BottomNavView);

        d1.setBackgroundColor(SELECTED_COLOUR);

        navBarTriviaStart.setBackground(null);
        navBarTriviaStart.setSelectedItemId(R.id.mTrivia);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("difficulty", difficulty);

                startActivity(new Intent(BeginTrivia.this,TriviaActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                        .putExtras(bundle));
                finish();
            }
        });

        d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                difficulty = 0;
                d1.setBackgroundColor(SELECTED_COLOUR);
                d2.setBackgroundColor(DEFAULT_COLOUR);
                d3.setBackgroundColor(DEFAULT_COLOUR);
            }
        });
        d2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                difficulty = 1;
                d1.setBackgroundColor(DEFAULT_COLOUR);
                d2.setBackgroundColor(SELECTED_COLOUR);
                d3.setBackgroundColor(DEFAULT_COLOUR);
            }
        });
        d3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                difficulty = 2;
                d1.setBackgroundColor(DEFAULT_COLOUR);
                d2.setBackgroundColor(DEFAULT_COLOUR);
                d3.setBackgroundColor(SELECTED_COLOUR);
            }
        });

        navBarTriviaStart.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.mHome:
//                        startActivity(new Intent(BeginTrivia.this,MainActivity.class)
//                                .addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
                        finish(); break;
                    case R.id.mCalendar:
                        startActivity(new Intent(BeginTrivia.this,CalendarActivity.class)
                                .addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
                        finish(); break;
                    case R.id.mTrivia: break;
                }
                return true;
            }
        });
    }


}