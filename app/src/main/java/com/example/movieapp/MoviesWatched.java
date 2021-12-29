package com.example.movieapp;

import java.util.ArrayList;

public class MoviesWatched extends Movie {
    private double rating;
    ArrayList<Movie> movies;

    public MoviesWatched(String title, double rating) {
        super(title);
        this.rating = rating;
    }

    public MoviesWatched(String title, int year, double rating) {
        super(title, year);
        this.rating = rating;
    }


}
