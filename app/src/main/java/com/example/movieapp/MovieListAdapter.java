package com.example.movieapp;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


@RequiresApi(api = Build.VERSION_CODES.O)
public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {
    ArrayList<Movie> items;
    ArrayList<Movie> temp_items;
    RecyclerViewClickListener listener;

    public MovieListAdapter(ArrayList<Movie> items,RecyclerViewClickListener listener){
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
            year  = (TextView) itemView.findViewById(R.id.movieYear);
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
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MovieViewHolder(
                LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_item,parent,false));
    }


    @Override
    public void onBindViewHolder(@NonNull MovieListAdapter.MovieViewHolder holder, int position) {
//        holder.bind(items.get(position));
        holder.title.setText(items.get(position).getTitle());
        holder.year.setText(items.get(position).getYear()+"");
        holder.date.setText(items.get(position).getDate());
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    void submitList(ArrayList<Movie> movies) {
        items = movies;
    }


    public interface RecyclerViewClickListener {
        void onClick(View view, int position);
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
            ArrayList<Movie> get_back = (ArrayList<Movie>) items.clone();
            temp_items.clear();
            items = get_back;
            temp_items.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };


    @SuppressLint("NotifyDataSetChanged")
    void filter(ArrayList<Movie> list) {
        this.items = list;
        notifyDataSetChanged();
    }

}


