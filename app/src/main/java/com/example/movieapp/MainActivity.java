package com.example.movieapp;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    static String TO_WATCH = "toWatch", WATCHED = "watched", EVENT = "event";
    NavigationBarView navBar;
    public static boolean active = false,active2 = false;
    FloatingActionButton addMovie;
    static boolean left = true, emptySearch = true;
    static boolean asc = true, asc2 = true;
    Comparator<Movie> comparator;
    ViewPager2 vp;
    PagerAdapter pa;
    TabLayout tabLayout;
    Database db;
    SearchView search;

    @RequiresApi(api = Build.VERSION_CODES.O)
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
//        db.deleteAllData(TO_WATCH);
//        db.deleteAllData(WATCHED);
//        insertAll();
    }
    @Override
    protected void onResume() {
        super.onResume();
        navBar.setSelectedItemId(R.id.mHome);
        overridePendingTransition(0, 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_menu, menu);

        SearchManager manager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        search = (SearchView) menu.findItem(R.id.search).getActionView();

        search.setSearchableInfo(manager.getSearchableInfo(getComponentName()));


        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @SuppressLint("NotifyDataSetChanged")
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public boolean onQueryTextChange(String query) {
                emptySearch = query.equals("");
                filter(query);
                return false;
            }
        });
        return true;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    void filter(String text) {
        ArrayList<Movie> filter_list = new ArrayList<>();
        ArrayList<Movie> list = (left) ? ListFragment1.movieList : ListFragment2.movieList;
        for (Movie movie : list) {
            if(movie.getTitle().toLowerCase().contains(text.toLowerCase())) {
                filter_list.add(movie);
            }
        }
        if(emptySearch) filter_list = list;
        if(left)
            ListFragment1.adapter.filter(filter_list);
        else
            ListFragment2.adapter.filter(filter_list);

    }
    @SuppressLint("NonConstantResourceId")
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.sortMenu){
            return super.onOptionsItemSelected(item);
        }
//        String newTitle = item.getTitle().toString().split(" ")[0] + ((!asc) ? " ↑" : " ↓");
//        item.setTitle(newTitle);
        comparator = new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                switch (item.getItemId()) {
                    case R.id.sortByDefault:
                    return o1.getId() - o2.getId();
                    case R.id.sortByTitle:
                        return o1.getTitle().compareTo(o2.getTitle());
                    case R.id.sortByYear:
                        return o1.getYear() - o2.getYear();
                    case R.id.sortByMin:
                        return o1.getMin() - o2.getMin();
                    case R.id.sortByRating:
                        return Double.compare(o1.getRating(),o2.getRating());
                }
                return 0;
            }
        };
        sort();
        return super.onOptionsItemSelected(item);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    void init() {

        db = new Database(this);
//        if(!doesDatabaseExist(this,"MovieList.db"))
//        db.deleteAllData(TO_WATCH);
//        db.deleteAllData(WATCHED);

        List<Fragment> f = new ArrayList<>();
        f.add(new ListFragment1());
        f.add(new ListFragment2());
        vp = findViewById(R.id.pager);
        pa = new PagerAdapter(getSupportFragmentManager(),getLifecycle(),f);
        vp.setAdapter(pa);
        load();
        addMovie = findViewById(R.id.AddMovie);
        navBar = findViewById(R.id.BottomNavView);
        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp.setCurrentItem(tab.getPosition());
                left = tab.getPosition() == 0;
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        vp.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

        navBar.setBackground(null);
        navBar.setSelectedItemId(R.id.mHome);

        addMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddMovie.class)
                        .addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
            }
        });

        navBar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.mHome: break;
                    case R.id.mCalendar:
//                        startActivity(new Intent(MainActivity.this, CalendarActivity.class)
//                                .addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
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

    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint("NotifyDataSetChanged")
    void sort(){
        if(left) {
            if(ListFragment1.movieList.isEmpty()) return;
            if(asc) Collections.sort(ListFragment1.movieList,comparator);
            else    Collections.sort(ListFragment1.movieList,comparator.reversed());
            asc = !asc;
            ListFragment1.adapter.notifyDataSetChanged();
            return;
        }
        if(ListFragment2.movieList.isEmpty()) return;
        if(asc2) Collections.sort(ListFragment2.movieList,comparator);
        else    Collections.sort(ListFragment2.movieList,comparator.reversed());
        asc2 = !asc2;
        ListFragment2.adapter.notifyDataSetChanged();
    }

    private static boolean doesDatabaseExist(Context context, String dbName) {
        File dbFile = context.getDatabasePath(dbName);
        return dbFile.exists();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    void insertAll() {
        for(Movie m : ListFragment1.movieList) {
            String genres = String.join(", ",m.getGenres());
            db.addToWatchList(TO_WATCH,m.getId(),m.getTitle(),m.getYear(),m.getMin(),
                   genres,m.getInfo(),m.getRating(),m.getDate());
        }

        for(Movie m : ListFragment2.movieList) {
            String genres = String.join(", ",m.getGenres());
            db.addToWatchList(WATCHED,m.getId(),m.getTitle(),m.getYear(),m.getMin(),
                    genres,m.getInfo(),m.getRating(),m.getDate());
        }

    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    static void DeleteAndInsertAll(Database db) {
        db.deleteAllData(TO_WATCH);
        db.deleteAllData(WATCHED);
        for(Movie m : ListFragment1.movieList) {
            String genres = String.join(", ",m.getGenres());
            db.addToWatchList(TO_WATCH,m.getId(),m.getTitle(),m.getYear(),m.getMin(),
                    genres,m.getInfo(),m.getRating(),m.getDate());
        }

        for(Movie m : ListFragment2.movieList) {
            String genres = String.join(", ",m.getGenres());
            db.addToWatchList(WATCHED,m.getId(),m.getTitle(),m.getYear(),m.getMin(),
                    genres,m.getInfo(),m.getRating(),m.getDate());
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint({"Range", "NotifyDataSetChanged"})
    void load(){
        Cursor c; Movie m;
        c = db.readAllData(TO_WATCH);
        while (c.moveToNext()) {
            int id = c.getInt(c.getColumnIndex("id"));
            String title = c.getString(c.getColumnIndex("title"));
            int year = c.getInt(c.getColumnIndex("_year"));
            int min = c.getInt(c.getColumnIndex("minutes"));
            String genres = c.getString(c.getColumnIndex("genres"));
            String info = c.getString(c.getColumnIndex("info"));
            double rating = c.getDouble(c.getColumnIndex("rating"));
            String date_added = c.getString(c.getColumnIndex("date_added"));
            m = new Movie();
            m.setId(id); m.setTitle(title);
            m.setYear(year); m.setMin(min);
            m.setGenres(new ArrayList<>(Arrays.asList(genres.split(", "))));
            m.setInfo(info);
            m.setRating(rating);
            m.setDate(date_added);
            ListFragment1.movieList.add(m);
            AddMovie.id = id+1;
        }

        c = db.readAllData(WATCHED);
        while (c.moveToNext()) {
            int id = c.getInt(c.getColumnIndex("id"));
            String title = c.getString(c.getColumnIndex("title"));
            int year = c.getInt(c.getColumnIndex("_year"));
            int min = c.getInt(c.getColumnIndex("minutes"));
            String genres = c.getString(c.getColumnIndex("genres"));
            String info = c.getString(c.getColumnIndex("info"));
            double rating = c.getDouble(c.getColumnIndex("rating"));
            String date_added = c.getString(c.getColumnIndex("date_added"));
            m = new Movie();
            m.setId(id); m.setTitle(title);
            m.setYear(year); m.setMin(min);
            m.setGenres(new ArrayList<>(Arrays.asList(genres.split(", "))));
            m.setInfo(info);
            m.setRating(rating);
            m.setDate(date_added);
            ListFragment2.movieList.add(m);
            AddMovie.id2 = id+1;
        }
        ListFragment1.adapter.notifyDataSetChanged();
        ListFragment2.adapter.notifyDataSetChanged();

        Event e;
        c = db.readAllData(EVENT);
        while (c.moveToNext()) {
            int id = c.getInt(c.getColumnIndex("id"));
            String name = c.getString(c.getColumnIndex("name"));
            String date = c.getString(c.getColumnIndex("date_"));
            String time = c.getString(c.getColumnIndex("time"));
            e = new Event(id,name, LocalDate.parse(date), LocalTime.parse(time));
            Event.eventsList.add(e);
            Event.ids++;
        }
        c.close();
//        CalendarActivity.adapter.notifyDataSetChanged();
    }

}