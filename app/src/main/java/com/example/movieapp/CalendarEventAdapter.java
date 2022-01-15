package com.example.movieapp;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CalendarEventAdapter extends RecyclerView.Adapter<CalendarEventAdapter.CalendarEventHolder> {
    ArrayList<Event> items;
    RecyclerViewClickListener listener;

    public CalendarEventAdapter(ArrayList<Event> items, RecyclerViewClickListener listener){
        this.items=items;
        this.listener = listener;
    }
    public class CalendarEventHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        View itemView;
        TextView title,date;

        public CalendarEventHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.eventTitle);
            date  = (TextView) itemView.findViewById(R.id.eventDateAdded);
            itemView.setOnClickListener(this);
        }

        public void bind(Movie m) {
            title.setText(m.getTitle());
        }

        @Override
        public void onClick(View v) {
            listener.onClick(v,getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public CalendarEventHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CalendarEventHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.eventitem,parent,false));
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull CalendarEventAdapter.CalendarEventHolder holder, int position) {
//        holder.bind(items.get(position));
        holder.title.setText(items.get(position).getName());
        holder.date.setText(items.get(position).getDateAndTime());
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    void submitList(ArrayList<Event> movies) {
        items = movies;
    }


    public interface RecyclerViewClickListener {
        void onClick(View view, int position);
    }

}


