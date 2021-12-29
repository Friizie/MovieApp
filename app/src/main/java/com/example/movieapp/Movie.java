package com.example.movieapp;

import java.util.ArrayList;

public class Movie {
    private String title;
    private int year;
    private int min;
    private ArrayList<String> genres;
    private String info;
    private int id;

    public Movie(int id,String title, int year, int min, ArrayList<String> genres, String info) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.min = min;
        this.genres = genres;
        this.info = info;
    }

    public Movie(String title, int year, int min, ArrayList<String> genres) {
        this.title = title;
        this.year = year;
        this.min = min;
        this.genres = genres;
    }
    Movie(String title, int year) {
        this.title=title;
        this.year=year;
    }

    public Movie(String title) {
        this.title = title;
    }

    public Movie(String title, int year, int min) {
        this.title = title;
        this.year = year;
        this.min = min;
    }

    public Movie(String title, int year, int min, String info) {
        this.title = title;
        this.year = year;
        this.min = min;
        this.info = info;
    }


    String convertMinsToHrs() {
        int h =  this.min / 60;
        int m = this.min % 60;
        return h+":"+m;
    }

    public String getInfo() {
        return info;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getMin() {
        return min;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public int getId() {
        return id;
    }
}
