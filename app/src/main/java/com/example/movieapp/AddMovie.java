package com.example.movieapp;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddMovie extends AppCompatActivity {
    Button save,cancel;
    EditText title,year;
    static int id = 0, id2 = 0;
    Database db;

    @Override
    @RequiresApi(api = Build.VERSION_CODES.O)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_movie);
        init();
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    void init() {
        db = new Database(getApplicationContext());
        title = (EditText) findViewById(R.id.enterTitle);
        year  = (EditText) findViewById(R.id.enterYear);
        save  =  (Button)  findViewById(R.id.save_data_button);
        cancel=  (Button)  findViewById(R.id.cancel_data_button);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t = title.getText().toString();
                String Y = year.getText().toString();
                Matcher m = Pattern.compile("[^0-9]+").matcher(Y);
                if(!t.equals("") && !m.find() && !Y.equals("")) {
                    int y = Integer.parseInt(Y);
                    if(MainActivity.left) add(t,y);
                    else add2(t,y,1,1);
                    updateRV();
                    finish();
                    return;
                }
                Toast.makeText(AddMovie.this,
                        "Please enter valid information",Toast.LENGTH_SHORT).show();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    void add(String t, int y) {
        Movie movie = new Movie(t,y);
        movie.setId(id++);
        movie.setDateNow();
        ListFragment1.movieList.add(movie);
        addToDatabase(MainActivity.TO_WATCH,movie);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void addToDatabase(String table_name, Movie movie) {
//        StringBuilder sb = new StringBuilder();
//        for (int i=0;i<movie.getGenres().size();i++){
//            sb.append(movie.getGenres().get(i));
//            if(movie.getGenres().size()-1!=i)
//                sb.append(", ");
//        }
        String genres = String.join(", ",movie.getGenres());
        db.addToWatchList(table_name,movie.getId(),movie.getTitle(),
                movie.getYear(),movie.getMin(),genres,movie.getInfo(), movie.getRating(),
                movie.getDate());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    void add2(String t, int y, int min,double rating) {
        Movie movie = new Movie(t,y,min);
        movie.setId(id2++);
        movie.setDateNow();
        ListFragment2.movieList.add(movie);
        addToDatabase(MainActivity.WATCHED,movie);
    }

    void updateRV() {
        int insertIndex = (MainActivity.left) ? ListFragment1.movieList.size() : ListFragment2.movieList.size();
        if(MainActivity.left)
            ListFragment1.adapter.notifyItemInserted(insertIndex);
        else
            ListFragment2.adapter.notifyItemInserted(insertIndex);
    }
}