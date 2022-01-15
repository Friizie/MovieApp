package com.example.movieapp;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WatchedMovieListAdapter extends RecyclerView.Adapter<WatchedMovieListAdapter.MovieViewHolder> {
    ArrayList<Movie> items;
    ArrayList<Movie> temp_items;
    WatchedMovieListAdapter.RecyclerViewClickListener listener;

    public WatchedMovieListAdapter(ArrayList<Movie> items,WatchedMovieListAdapter.RecyclerViewClickListener listener){
        this.items=items;
        this.listener = listener;
        this.temp_items=items;
    }
    public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        View itemView;
        TextView title,year,date;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.movieTitle);
            year =  (TextView) itemView.findViewById(R.id.movieYear);
            date  = (TextView) itemView.findViewById(R.id.movieDateAdded);
            itemView.setOnClickListener(this);
        }

        public void bind(Movie m) {
            title.setText(m.getTitle());
            year.setText(m.getYear());
        }
        @Override
        public void onClick(View v) {
            listener.onClick(v,getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public WatchedMovieListAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new WatchedMovieListAdapter.MovieViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.movie_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull WatchedMovieListAdapter.MovieViewHolder holder, int position) {
//        holder.bind(items.get(position));
        holder.title.setText(items.get(position).getTitle());
        holder.year.setText(items.get(position).getYear()+"");
        holder.date.setText(items.get(position).getDate());
    }
    public interface RecyclerViewClickListener {
        void onClick(View view, int position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public Filter getFilter() {
        return filter;
    }

    private final Filter filter= new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Movie> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(items);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Movie movie : items) {
                    if (movie.getTitle().toLowerCase().contains(filterPattern)) {
                        filteredList.add(movie);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @SuppressLint("NotifyDataSetChanged")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            temp_items.clear();
            temp_items.addAll((ArrayList) results.values);
            notifyDataSetChanged();
        }
    };

    @SuppressLint("NotifyDataSetChanged")
    void filter(ArrayList<Movie> list) {
        this.items = list;
        notifyDataSetChanged();
    }
}








