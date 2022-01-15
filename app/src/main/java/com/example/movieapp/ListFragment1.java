package com.example.movieapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListFragment1 extends Fragment {
    static ArrayList<Movie> movieList;
    RecyclerView recyclerView;
    static MovieListAdapter adapter;
    static MovieListAdapter.RecyclerViewClickListener listener;
    TextView empt;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public ListFragment1() {
        movieList = new ArrayList<>();
        adapter = new MovieListAdapter(movieList,listener);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public ListFragment1(ArrayList<Movie> movies) {
        movieList = movies;
        adapter = new MovieListAdapter(movieList,listener);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.list1_fragment, container, false);
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!movieList.isEmpty()) empt.setVisibility(View.GONE);
        else empt.setVisibility(View.VISIBLE);
        MainActivity.active2 = false;
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    void init() {
        recyclerView = (RecyclerView) getView().findViewById(R.id.listRecycler);
        empt = (TextView) getView().findViewById(R.id.emptyListText);
        recyclerView.setVisibility(View.VISIBLE);
        setOnClickListener();
        adapter = new MovieListAdapter(movieList, listener);

        RecyclerView.LayoutManager lm = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(lm);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        if (!movieList.isEmpty()) empt.setVisibility(View.GONE);
    }

    private void setOnClickListener() {
        listener = new MovieListAdapter.RecyclerViewClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view, int position) {
                startActivity(new Intent(getContext(), MovieInfo.class)
                        .putExtra("title", movieList.get(position).getTitle())
                        .putExtra("year", movieList.get(position).getYear())
                        .putExtra("min",movieList.get(position).convertMinToHrs())
                        .putExtra("genres",movieList.get(position).getGenresToString())
                        .putExtra("rating",movieList.get(position).getRating())
                        .putExtra("info",movieList.get(position).getInfo())
                        .putExtra("date",movieList.get(position).getDate())
                        .putExtra("index",position)
                        .addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
            }
        };
    }

}
