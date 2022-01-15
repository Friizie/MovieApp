package com.example.movieapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MovieInfo extends AppCompatActivity {
    Database db;
    Movie movie;
    TextView title, year,genres,min,info,rating,date;
    TextView popupTitle,popupYear,popupMin,popupGenres,popupInfo,popupRating;
    NavigationBarView navBar;
    RatingBar bar,infoBar;
    Button move, save, cancel, remove;
    int index;
    AlertDialog alertDialog;
    AlertDialog.Builder builder;
    static boolean delete = false;
    boolean skipOnChange = false;
    boolean edit = false, error = false;
    boolean[] selected;
    ArrayList<String> genresList = new ArrayList<>();
    static String[] genreArr = {"Action", "Adventure", "Animation", "Biography", "Comedy", "Crime",
            "Drama", "Family", "Fantasy", "History", "Horror", "Music", "Musical", "Mystery",
            "Romance", "Sci-Fi", "Sport", "Thriller", "War", "Western"};

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_info);
        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.info_menu, menu);
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        moveToWatched();
        edit = true;
        return super.onOptionsItemSelected(item);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    void init() {
        db = new Database(getApplicationContext());
        title = findViewById(R.id.infoTitle);
        year = findViewById(R.id.infoYear);

        min = findViewById(R.id.infoMin);
        genres = findViewById(R.id.infoGenres);
        info = findViewById(R.id.infoInfo);
        rating = findViewById(R.id.infoRating);
        infoBar = findViewById(R.id.infoRatingBar);
        date = findViewById(R.id.infoDate);
        min.setVisibility(View.VISIBLE);
        genres.setVisibility(View.VISIBLE);
        info.setVisibility(View.VISIBLE);
        rating.setVisibility(View.VISIBLE);
        infoBar.setVisibility(View.VISIBLE);
//        if(MainActivity.left) {
//            min.setVisibility(View.GONE);
//            genres.setVisibility(View.GONE);
//            info.setVisibility(View.GONE);
//            rating.setVisibility(View.GONE);
//            infoBar.setVisibility(View.GONE);
//        }

        move = findViewById(R.id.infoMoveButton);
        remove = findViewById(R.id.remove);
        navBar = findViewById(R.id.BottomNavViewInfo);
        Bundle bundle = getIntent().getExtras();
//        title.setText(bundle.getString("title"));
//        year.setText(bundle.getInt("year") + "");
//        min.setText(bundle.getString("min"));
//        genres.setText(bundle.getString("genres"));
//        info.setText(bundle.getString("info"));
//        rating.setText(bundle.getString("rating"));
//        date.setText(bundle.getString("date"));
        index = bundle.getInt("index");

        movie = (MainActivity.left) ? ListFragment1.movieList.get(index) : ListFragment2.movieList.get(index);

        title.setText(movie.getTitle());
        year.setText(movie.getYear()+"");
        min.setText(movie.convertMinToHrs());
        genres.setText(movie.getGenresToString());
        info.setText(movie.getInfo());
        rating.setText(movie.getRating()+"");
        date.setText(movie.getDate());
        infoBar.setRating((float) movie.getRating());

        if(!MainActivity.left) move.setText("Watch Again");


        move.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View v) {
                if(MainActivity.left)
                    moveToWatched();
                else
                    moveBack();
            }
        });
        Context ct = this;
        remove.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ct);
                builder.setTitle("Delete Movie?");
                builder.setCancelable(false);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        delete = true;
                        if(MainActivity.left){
                            db.deleteItem(MainActivity.TO_WATCH,ListFragment1.movieList.get(index).getId()+"");
                            if(Database.deleted){
                                ListFragment1.movieList.remove(index);
                                ListFragment1.adapter.notifyDataSetChanged();
                                finish();
                                return;
                            }
                        }
                        db.deleteItem(MainActivity.WATCHED,ListFragment2.movieList.get(index).getId()+"");
                        if(Database.deleted) {
                            ListFragment2.movieList.remove(index);
                            ListFragment2.adapter.notifyDataSetChanged();
                            finish();
                        }
                        delete = false;
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


        navBar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.mHome:
                        finish();
                        break;
                    case R.id.mCalendar:
                        startActivity(new Intent(MovieInfo.this, CalendarActivity.class)
                                .addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
                        break;
                    case R.id.mTrivia:
                        startActivity(new Intent(MovieInfo.this, BeginTrivia.class)
                                .addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
                        break;
                }
                return true;
            }
        });

    }

    @SuppressLint("NotifyDataSetChanged")
    @RequiresApi(api = Build.VERSION_CODES.O)
    void moveBack() {
        Movie movie = ListFragment2.movieList.get(index);

        int previd = movie.getId();
        movie.setId(AddMovie.id++);
        String genres = String.join(", ", movie.getGenres());
        db.addToWatchList(MainActivity.TO_WATCH,movie.getId(),
                movie.getTitle(),movie.getYear(),movie.getMin(),
                genres,movie.getInfo(),movie.getRating(),movie.getDate());
        db.deleteItem(MainActivity.WATCHED,previd+"");
        ListFragment2.movieList.remove(index);
        ListFragment1.movieList.add(movie);
        ListFragment1.adapter.notifyDataSetChanged();
        ListFragment2.adapter.notifyDataSetChanged();
        finish();
    }

    void moveToWatched() {
        builder = new AlertDialog.Builder(this);
        View popup = getLayoutInflater().inflate(R.layout.popup, null);

        popupTitle = popup.findViewById(R.id.editEnterTitle);
        popupYear = popup.findViewById(R.id.editEnterYear);
        popupMin = popup.findViewById(R.id.editEnterMinutes);
        popupGenres = popup.findViewById(R.id.editGenres);
        popupInfo = popup.findViewById(R.id.editInfo);
        popupRating = popup.findViewById(R.id.editRating);
        bar = popup.findViewById(R.id.ratingBar);
        save = popup.findViewById(R.id.save_edit_data_button);
        cancel = popup.findViewById(R.id.cancel_edit_data_button);

        selected = new boolean[genreArr.length];
        String[] a = genres.getText().toString().split(", ");
        for (String str : a) {
            for (int i = 0;i < genreArr.length;i++) {
                if (genreArr[i].equals(str)) {
                    selected[i] = true;
                    genresList.add(i+"");
                    break;
                }
            }
        }
        Collections.sort(genresList);

        popupTitle.setText(title.getText().toString());
        popupYear.setText(year.getText().toString());
        String[] s = min.getText().toString().replaceAll("[A-Za-z]","").split(":");
        String mins = Integer.parseInt(s[0])*60+Integer.parseInt(s[1])+"";
        popupMin.setText(mins.equals("0") ? "" : mins);
        popupGenres.setText(genres.getText().toString());
        popupInfo.setText(info.getText().toString());
        popupRating.setText(rating.getText().toString());
        bar.setRating(Float.parseFloat(rating.getText().toString()));

        builder.setView(popup);
        alertDialog = builder.create();
        alertDialog.show();

        bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                bar.setRating(Float.parseFloat(popupRating.getText().toString()));
                popupRating.setText(bar.getRating()+"");
            }
        });
        bar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                popupRating.setText(rating+"");
            }
        });



        save.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                if(MainActivity.left && !edit) updateRV();
                else edit();
                if(!error){
                    alertDialog.dismiss();
                    updateData();
//                  finish();
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });


        Context ct = this;

        popupGenres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ct);
                builder.setTitle("Select Genres");
                builder.setCancelable(false);
                builder.setMultiChoiceItems(genreArr, selected, new DialogInterface.OnMultiChoiceClickListener() {
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
                            sb.append(genreArr[Integer.parseInt(genresList.get(i))]);
                            if (i != genresList.size() - 1)
                                sb.append(", ");
                        }
                        popupGenres.setText(sb.toString());
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
                        popupGenres.setText("");
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


//    void add2(String t, int y, int min,double rating) {
//        Movie movie = new Movie(t,y,min);
//        movie.setId(AddMovie.id2++);
//        ListFragment2.movieList.add(movie);
//    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    void updateData() {
        title.setText(movie.getTitle());
        year.setText(movie.getYear()+"");
        min.setText(movie.convertMinToHrs());
        genres.setText(movie.getGenresToString());
        info.setText(movie.getInfo());
        rating.setText(movie.getRating()+"");
        date.setText(movie.getDate());
        infoBar.setRating((float) movie.getRating());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("NotifyDataSetChanged")
    void updateRV() {
        Movie movie = ListFragment1.movieList.get(index);

        String t = popupTitle.getText().toString();
        String Y = popupYear.getText().toString();
        String min = popupMin.getText().toString();
        String info = popupInfo.getText().toString();
        String genres = popupGenres.getText().toString();
        String rating = popupRating.getText().toString();
        int previd = movie.getId();
        Pattern p = Pattern.compile("[^0-9]+");
        Pattern p1 = Pattern.compile("\\d+\\.\\d+");
        Matcher m = p.matcher(Y);
        if (!m.find() && !p.matcher(min).find() &&
                p1.matcher(rating).find()) {
            if(t.equals("")) t = "No title";
            int y = Y.equals("") ? 0 : Integer.parseInt(Y);
            int mins = min.equals("") ? 0 : Integer.parseInt(min);
            double r = rating.equals("") ? 0 : Double.parseDouble(rating);
            r = Double.parseDouble(String.format("%.1f", r));
            if(r > 5 || r < 0) {
                error = true;
                Toast.makeText(MovieInfo.this,
                    "Rating must be between 0 and 5", Toast.LENGTH_SHORT).show();
                return;
            }
            error = false;
            movie.setId(AddMovie.id2++);
            movie.setTitle(t);
            movie.setYear(y);
            movie.setMin(mins);
            movie.setRating(r);
            movie.setGenres(new ArrayList<>(Arrays.asList(genres.split(", "))));
            movie.setInfo(info);
            movie.setDateNow();


//            MainActivity.DeleteAndInsertAll(db);
            db.addToWatchList(MainActivity.WATCHED,movie.getId(),
                    movie.getTitle(),movie.getYear(),movie.getMin(),
                    genres,movie.getInfo(),movie.getRating(),movie.getDate());
            db.deleteItem(MainActivity.TO_WATCH,previd+"");
        }
        else {
            error = true;
            Toast.makeText(MovieInfo.this,
                "Please enter valid information", Toast.LENGTH_SHORT).show();
            return;
        }
        error = false;
        ListFragment1.movieList.remove(index);
        ListFragment2.movieList.add(movie);
        ListFragment1.adapter.notifyDataSetChanged();
        ListFragment2.adapter.notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    @RequiresApi(api = Build.VERSION_CODES.O)
    void edit(){
        Movie movie = MainActivity.left ?
                ListFragment1.movieList.get(index) :
                ListFragment2.movieList.get(index);

        String t = popupTitle.getText().toString();
        String Y = popupYear.getText().toString();
        String min = popupMin.getText().toString();
        String info = popupInfo.getText().toString();
        String genres = popupGenres.getText().toString();
        String rating = popupRating.getText().toString();
        Pattern p = Pattern.compile("[^0-9]+");
        Pattern p1 = Pattern.compile("\\d+\\.\\d+");
        Matcher m = p.matcher(Y);
        if (!m.find() && !p.matcher(min).find() &&
                p1.matcher(rating).find()) {
            if(t.equals("")) t = "No title";
            int y = Y.equals("") ? 0 : Integer.parseInt(Y);
            int mins = min.equals("") ? 0 : Integer.parseInt(min);
            double r = rating.equals("") ? 0 : Double.parseDouble(rating);
            r = Double.parseDouble(String.format("%.1f", r));
            if(r > 5 || r < 0) {
                error = true;
                Toast.makeText(MovieInfo.this,
                        "Rating must be between 0 and 5", Toast.LENGTH_SHORT).show();
                return;
            }
            error = false;
            movie.setTitle(t);
            movie.setYear(y);
            movie.setMin(mins);
            movie.setRating(r);
            movie.setGenres(new ArrayList<>(Arrays.asList(genres.split(", "))));
            movie.setInfo(info);
            movie.setDateNow();
        }
        else {
            error = true;
            Toast.makeText(MovieInfo.this,
                    "Please enter valid information", Toast.LENGTH_SHORT).show();
            return;
        }
        ListFragment1.adapter.notifyDataSetChanged();
        ListFragment2.adapter.notifyDataSetChanged();
        edit = false;
        error = false;
//        MainActivity.DeleteAndInsertAll(db);
        db.updateDataWatchList((MainActivity.left) ? MainActivity.TO_WATCH : MainActivity.WATCHED,
                movie.getId(),movie.getTitle(),movie.getYear(),movie.getMin(),
                movie.getGenresToString(),movie.getInfo(),movie.getRating(),movie.getDate());

    }
}