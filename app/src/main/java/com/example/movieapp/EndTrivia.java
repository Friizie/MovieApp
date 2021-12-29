package com.example.movieapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationBarView;

public class EndTrivia extends AppCompatActivity {
    Button tryAgain;
    NavigationBarView navBarTriviaTry;
    TextView scoreText;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_trivia);
        init();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        navBarTriviaTry.setSelectedItemId(R.id.mHome);
        overridePendingTransition(0, 0);
        this.finish();
    }


    void init() {
        tryAgain = (Button) findViewById(R.id.tryButton);
        navBarTriviaTry = (NavigationBarView) findViewById(R.id.BottomNavViewTriviaTry);
        scoreText = (TextView) findViewById(R.id.FinalScore);

        navBarTriviaTry.setBackground(null);
        navBarTriviaTry.setSelectedItemId(R.id.mTrivia);


        Bundle bundle = getIntent().getExtras();

        score = bundle.getInt("score");
        String s = "Your score is: " + score;
        scoreText.setText(s);


        tryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EndTrivia.this,BeginTrivia.class)
                        .addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
                finish();
            }
        });

        navBarTriviaTry.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.mHome:
//                        startActivity(new Intent(EndTrivia.this,MainActivity.class)
//                                .addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
                        finish();
                        break;
                    case R.id.mCalendar:
                        startActivity(new Intent(EndTrivia.this,CalendarActivity.class)
                                .addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
                        finish();
                        break;
                    case R.id.mTrivia:
                        break;
                }
                return true;
            }
        });
    }
}