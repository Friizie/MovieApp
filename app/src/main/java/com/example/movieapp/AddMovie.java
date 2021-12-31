package com.example.movieapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AddMovie extends AppCompatActivity {
    Button save;
    EditText title,year;
    Movie movie;
    ArrayList<Movie> list;
//    Database db = new Database(AddMovie.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_movie);
        init();
    }



    void init() {
        title = (EditText) findViewById(R.id.enterTitle);
        year  = (EditText) findViewById(R.id.enterYear);
        save  =  (Button)  findViewById(R.id.save_data_button);

        list = new ArrayList<>();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t = title.getText().toString();
                int y = Integer.parseInt(year.getText().toString());
                MainActivity.movieList.add(new Movie(t,y));
                updateRV();
                finish();
            }
        });
    }

    void passData() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("list",list);

    }
    void updateRV() {
        int insertIndex = MainActivity.movieList.size();
        MainActivity.adapter.notifyItemInserted(insertIndex);
        MainActivity.adapter2.notifyItemInserted(insertIndex);
    }
}