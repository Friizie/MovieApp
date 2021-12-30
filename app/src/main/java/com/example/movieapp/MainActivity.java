package com.example.movieapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import java.util.ArrayList;
import java.util.Hashtable;

public class MainActivity extends AppCompatActivity {
    NavigationBarView navBar;
    public static boolean active = false;
    Button toWatchButton, watchedButton;
    FloatingActionButton addMovie;
    View bar1, bar2;
    ArrayList<Movie> watched = new ArrayList<>();
    Hashtable<Integer,Movie> movies;
    int i=0;
    RecyclerView recyclerView;
    MovieListAdapter adapter = new MovieListAdapter();
    boolean left = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, 0);
        this.finish();
    }

    @Override
    public void onStart() {
        super.onStart();
        active = true;
    }

    @Override
    public void onStop() {
        super.onStop();
        active = false;
        overridePendingTransition(0, 0);
    }

    @Override
    protected void onResume() {
        super.onResume();
        navBar.setSelectedItemId(R.id.mHome);
        overridePendingTransition(0, 0);
    }

    void init() {

        toWatchButton = findViewById(R.id.toWatch);
        watchedButton = findViewById(R.id.watched);
        addMovie = findViewById(R.id.AddMovie);
        bar1 = findViewById(R.id.rectangle1);
        bar2 = findViewById(R.id.rectangle2);
        navBar = findViewById(R.id.BottomNavView);
        navBar.setBackground(null);
        navBar.setSelectedItemId(R.id.mHome);
        bar1.setVisibility(View.VISIBLE);



        toWatchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                bar2.setVisibility(View.INVISIBLE);
//                bar1.setVisibility(View.VISIBLE);
                bar1.animate().translationX(0).setDuration(200);
                left=true;
            }
        });
        watchedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bar1.animate().translationX(bar1.getWidth()).setDuration(200);
                left = false;
//                bar1.setVisibility(View.INVISIBLE);
//                bar2.setVisibility(View.VISIBLE);
            }
        });

        addMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddMovie.class)
                .addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
                watched.add(new Movie(i++ + ""));
            }
        });

        navBar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.mHome: break;
                    case R.id.mCalendar:
                        startActivity(new Intent(MainActivity.this, CalendarActivity.class)
                                .addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
                        break;
                    case R.id.mTrivia:
                        startActivity(new Intent(MainActivity.this, BeginTrivia.class)
                                .addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
                        break;
                }
                return true;
            }
        });

    }

    void initRecyclerView() {
        recyclerView=findViewById(R.id.listRecycler);
        recyclerView.setAdapter(adapter);

        adapter.submitList(watched);
    }

    void doSomethingIdk() {
        if(left) {

        }
        else {

        }
    }

}