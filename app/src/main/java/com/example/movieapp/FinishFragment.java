package com.example.movieapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class FinishFragment extends Fragment {
    private final String SCORE = "score";
    private int score;
    TextView scoreText;

    public FinishFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scoreText = (TextView) getView().findViewById(R.id.score);
        if (getArguments() != null) {
            score = getArguments().getInt(SCORE);
        }
        scoreText.setText(score);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_finish, container, false);
    }


}