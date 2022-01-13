package com.example.movieapp;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.util.ArrayList;

public class Movie implements Parcelable, Comparable<Movie>  {
    private int id;
    private String title;
    private int year;
    private int min;
    private ArrayList<String> genres;
    private String info;
    private double rating = 0;
    private String date = "";

    public Movie(int id,String title, int year, int min, ArrayList<String> genres, String info,double rating) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.min = min;
        this.genres = genres;
        this.info = info;
        this.rating=rating;
    }

    public Movie(String title, int year, int min, ArrayList<String> genres) {
        this.id = 0;
        this.title = title;
        this.year = year;
        this.min = min;
        this.genres = genres;
        this.info = "";
        this.rating = 0;
    }
    public Movie(String title, int year) {
        this.id = 0;
        this.title=title;
        this.year=year;
        this.genres = new ArrayList<>();
        this.min = 0;
        this.info = "";
        this.rating = 0;
    }

    public Movie(String title) {
        this.title = title;
    }

    public Movie(String title, int year, int min) {
        this.id = 0;
        this.title = title;
        this.year = year;
        this.min = min;
        this.genres = new ArrayList<>();
        this.info = "";
        this.rating = 0;
    }

    public Movie(String title, int year, int min, String info) {
        this.id = 0;
        this.title = title;
        this.year = year;
        this.min = min;
        this.info = info;
        this.genres = new ArrayList<>();
        this.rating = 0;
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

    public Movie() {
        this.id = 0;
        this.title = "";
        this.year = 0;
        this.min = 0;
        this.info = "";
        this.genres = new ArrayList<>();
        this.rating = 0;
    }

    String convertMinToHrs() {
        int h =  this.min / 60;
        int m = this.min % 60;
        return h+":"+m;
    }
    int convertHrsToMin(String H){
        String[] time=H.split(":");
        return Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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

    public double getRating() {
        return rating;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getGenresToString() {
        return String.join(", ",genres);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    void setDateNow() {
        this.date = CalendarUtils.formattedDateDigits(LocalDate.now());
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeInt(year);
        dest.writeInt(min);
        dest.writeStringList(genres);
        dest.writeString(info);
    }

    @Override
    public int compareTo(Movie o) {
        if(o != null)
            return this.title.compareTo(o.title);
        return 0;
    }


}
