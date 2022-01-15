package com.example.movieapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class AddMovie extends AppCompatActivity {
    Button save,cancel;
    EditText title,year,min,rating,info;
    TextView additionalTV,genres;
    RatingBar bar;
    static int id = 0, id2 = 0;
    Database db;
    boolean additional = false;
    ArrayList<String> genresList = new ArrayList<>();
    boolean[] selected;

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
        min  = (EditText) findViewById(R.id.enterMinutes);
        genres  = (TextView) findViewById(R.id.enterGenres);
        info  = (EditText) findViewById(R.id.enterInfo);
        rating  = (EditText) findViewById(R.id.enterRating);
        save  =  (Button)  findViewById(R.id.save_data_button);
        cancel=  (Button)  findViewById(R.id.cancel_data_button);
        additionalTV = (TextView)  findViewById(R.id.additional);
        bar = findViewById(R.id.enterRatingBar);

        additionalTV.setVisibility(MainActivity.left ? View.VISIBLE : View.GONE);

        min.setVisibility(MainActivity.left ? View.GONE : View.VISIBLE);
        rating.setVisibility(MainActivity.left ? View.GONE : View.VISIBLE);
        genres.setVisibility(MainActivity.left ? View.GONE : View.VISIBLE);
        bar.setVisibility(MainActivity.left ? View.GONE : View.VISIBLE);

        info.setVisibility(View.VISIBLE);

        additionalTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                additional = !additional;
                additionalTV.setText(additional ? "Additional"+" ↑" : "Additional"+" ↓");

                min.setVisibility(additional ? View.VISIBLE : View.GONE);
                rating.setVisibility(additional ? View.VISIBLE : View.GONE);
                genres.setVisibility(additional ? View.VISIBLE : View.GONE);
                bar.setVisibility(additional ? View.VISIBLE : View.GONE);

            }
        });

        bar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float Rating, boolean fromUser) {
                rating.setText(Rating+"");
            }
        });

        popup();



        save.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {
                String t = title.getText().toString();
                String Y = year.getText().toString();
                String Min = min.getText().toString();
                String Genres = genres.getText().toString();
                String Info = info.getText().toString();
                String Rating = rating.getText().toString();
                Pattern p = Pattern.compile("[^0-9]+");
                Pattern p1 = Pattern.compile("\\d+\\.\\d+");


                boolean condition1 = !p.matcher(Y).find() &&
                        !p.matcher(Min).find() &&
                        p1.matcher(Rating).find();
                boolean condition2 = !p.matcher(Y).find() && !p.matcher(Min).find();

                boolean condition3 = additional ? condition1 : condition2;
                if(condition3) {
                    if(t.equals("")) t = "No title";
                    int y = Y.equals("") ? 0 : Integer.parseInt(Y);
                    int mins; double r;
                    if(!additional && MainActivity.left) r = 0;
                    else r = Rating.equals("") ? 0 : Double.parseDouble(Rating);

                    if(!additional && MainActivity.left) mins = 0;
                    else mins = Min.equals("") ? 0 : Integer.parseInt(Min);

                    r = Double.parseDouble(String.format("%.1f", r));
                    add(t,y,mins,r,Genres,Info);
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
    void add(String t, int y,int mins, double r, String genres, String info) {
        Movie movie = new Movie();
        movie.setId(MainActivity.left ? id++ : id2++);
        movie.setTitle(t);
        movie.setYear(y);
        movie.setMin(mins);
        movie.setRating(r);
        movie.setGenres(new ArrayList<>(Arrays.asList(genres.split(", "))));
        movie.setInfo(info);
        movie.setDateNow();

        if(MainActivity.left) {
            ListFragment1.movieList.add(movie);
            addToDatabase(MainActivity.TO_WATCH, movie);
        } else {
            ListFragment2.movieList.add(movie);
            addToDatabase(MainActivity.WATCHED, movie);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void addToDatabase(String table_name, Movie movie) {
        String genres = String.join(", ",movie.getGenres());
        db.addToWatchList(table_name,movie.getId(),movie.getTitle(),
                movie.getYear(),movie.getMin(),genres,movie.getInfo(), movie.getRating(),
                movie.getDate());
    }

    void popup(){
        selected = new boolean[MovieInfo.genreArr.length];
        String[] a = genres.getText().toString().split(", ");
        for (String str : a) {
            for (int i = 0;i < MovieInfo.genreArr.length;i++) {
                if (MovieInfo.genreArr[i].equals(str)) {
                    selected[i] = true;
                    genresList.add(i+"");
                    break;
                }
            }
        }
        Collections.sort(genresList);


        Context ct = this;
        genres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ct);
                builder.setTitle("Select genres");
                builder.setCancelable(false);
                builder.setMultiChoiceItems(MovieInfo.genreArr, selected, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked) {
                            genresList.add(which+"");
                            Collections.sort(genresList);
                        } else genresList.remove(which+"");
                    }
                });
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        genresList = (ArrayList<String>) genresList.stream().distinct().collect(Collectors.toList());
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < genresList.size(); i++) {
                            sb.append(MovieInfo.genreArr[Integer.parseInt(genresList.get(i))]);
                            if (i != genresList.size() - 1)
                                sb.append(", ");
                        }
                        genres.setText(sb.toString());
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
                        genresList.clear();
                        genres.setText("");
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


    void updateRV() {
        int insertIndex = (MainActivity.left) ? ListFragment1.movieList.size() : ListFragment2.movieList.size();
        if(MainActivity.left)
            ListFragment1.adapter.notifyItemInserted(insertIndex);
        else
            ListFragment2.adapter.notifyItemInserted(insertIndex);
    }
}