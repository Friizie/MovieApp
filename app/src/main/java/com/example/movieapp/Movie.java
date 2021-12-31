package com.example.movieapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Movie implements Parcelable {
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


    protected Movie(Parcel in) {
        title = in.readString();
        year = in.readInt();
        min = in.readInt();
        genres = in.createStringArrayList();
        info = in.readString();
        id = in.readInt();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeInt(year);
        dest.writeInt(min);
        dest.writeStringList(genres);
        dest.writeString(info);
        dest.writeInt(id);
    }
}
