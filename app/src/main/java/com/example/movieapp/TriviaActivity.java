package com.example.movieapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.Arrays;

public class TriviaActivity extends AppCompatActivity {
    Button b1,b2,b3,b4;
    TextView displayedQuestion,questionNum;
    ImageView displayedImage;
    Trivia t;
    int questionIndex = -1, totalPoints = 0, difficulty = 0;
    int answer,totalq, NUM_OF_QUESTIONS = 10;
    NavigationBarView navBarTrivia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia);
        navInit();
        setTrivia();
        setUpClicks();
        nextQuestion();
        update();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        navBarTrivia.setSelectedItemId(R.id.mHome);
        overridePendingTransition(0, 0);
        this.finish();
    }
    // button listeners setup function
    void setUpClicks() {
        b1 = (Button) findViewById(R.id.one);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer = 1;
                Answer();
            }
        });
        b2 = (Button) findViewById(R.id.two);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer = 2;
                Answer();
            }
        });

        b3 = (Button) findViewById(R.id.three);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer = 3;
                Answer();
            }
        });
        b4 = (Button) findViewById(R.id.four);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer = 4;
                Answer();
            }
        });
    }
    // update function for updating screen information
    void update() {
        if(isNextQuestion()) {
            displayedQuestion.setText(getCurrentQuestion().getQuestion());
            if(getCurrentQuestion().getImage()==0) {
                displayedImage.setVisibility(View.INVISIBLE);
                displayedImage.getLayoutParams().width = 0;
                displayedImage.getLayoutParams().height = 0;
            }
            else {
                displayedImage.setVisibility(View.VISIBLE);
                displayedImage.getLayoutParams().width = 200;
                displayedImage.getLayoutParams().height = 200;
                displayedImage.setImageResource(getCurrentQuestion().getImage());
            }
            String num = (questionIndex+1) + "/" + NUM_OF_QUESTIONS;
            questionNum.setText(num);

            b1.setText(getCurrentQuestion().getAnswers().get(0));
            b2.setText(getCurrentQuestion().getAnswers().get(1));
            b3.setText(getCurrentQuestion().getAnswers().get(2));
            b4.setText(getCurrentQuestion().getAnswers().get(3));
        }
    }

    //initializer function
    void navInit() {
        displayedQuestion = (TextView) findViewById(R.id.questionTV);
        displayedImage = findViewById(R.id.imageIV);
        questionNum = findViewById(R.id.questionNum);
        navBarTrivia = (NavigationBarView) findViewById(R.id.BottomNavViewTrivia);

        navBarTrivia.setBackground(null);
        navBarTrivia.setSelectedItemId(R.id.mTrivia);

        navBarTrivia.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.mHome:
                        startActivity(new Intent(TriviaActivity.this,MainActivity.class)
                                .addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
                        finish(); break;
                    case R.id.mCalendar:
                        startActivity(new Intent(TriviaActivity.this,CalendarActivity.class)
                                .addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
                        finish(); break;
                    case R.id.mTrivia: break;
                }
                return true;
            }
        });
    }

    // check if entered answer is correct
    boolean check(int answer) {
        if (isNextQuestion())
            return getCurrentQuestion().isCorrect(answer);
        return false;
    }

    // display if the picked answer was correct or not. Also go to next question.
    void Answer() {
        if(questionIndex==NUM_OF_QUESTIONS-1) { finished(); return; }
        if(isNextQuestion()) {
            if (check(answer)) {
                Toast.makeText(this,"Correct",Toast.LENGTH_SHORT).show();
                // ovde mozda nesto
                // da se smenet boine na kopcinjana i posle 2 sec da ojt na sledno
                // namesto ova
                totalPoints+=getCurrentQuestion().getPoints();
            } else {
                String a = "The correct answer was " + getAnswer() + ": " + getCurrentQuestion().getRightAnswerString().toUpperCase();
                Toast.makeText(this,"Incorrect",Toast.LENGTH_SHORT).show();
                Toast.makeText(this, a, Toast.LENGTH_SHORT).show();
            }
            nextQuestion();
            update();
        }
    }

    // get the right answer
    public int getAnswer() {
        if(isNextQuestion())
            return getCurrentQuestion().getRightAnswer();
        return -1;
    }

    // next question
    void nextQuestion() {
        questionIndex++;
    }

    // check if there is next question (test)
    boolean isNextQuestion() {
        return t.getSelectedQuestions().size()!=questionIndex;
    }

    //get the current question
    Question getCurrentQuestion() {
        if(isNextQuestion())
            return t.getSelectedQuestions().get(questionIndex);
        return new Question();
    }

    // helper function for easier setup
    private ArrayList<String> setAnswers(String one, String two, String three, String four){
        return new ArrayList<>(Arrays.asList(one,two,three,four));
    }


    void difficulty() {
        Bundle bundle = getIntent().getExtras();
        difficulty = bundle.getInt("difficulty");
    }


    // init final screen
    void finished() {
        Bundle bundle = new Bundle();
        bundle.putInt("score", totalPoints);

        startActivity(new Intent(TriviaActivity.this,EndTrivia.class)
                        .putExtras(bundle)
                        .addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
        finish();
    }


    // setting the questions
    public void setTrivia() {
        t = new Trivia();
//        ArrayList<String> answers;
//
//        answers = setAnswers("Answer 1","Answer 2","Answer 3","Answer 4");
//        t.addQuestion(new Question("Question?", answers,1,1,5,R.drawable.qmark));
//                                            // question // list // correct // 0,1,2 poeni // sllika
//        answers = setAnswers("The Wolf Of Wall Street","Ride along","Sudden impact","The day the earth stood still");
//        t.addQuestion(new Question("\"Go ahead, make my day.\"",answers,3,2,5,R.drawable.qmark));
//
//        answers = setAnswers("","","","");
//        t.addQuestion(new Question("",answers,0,2,5,R.drawable.qmark));
//

        t.initQuestions();
        t.shuffleQuestions();
        difficulty();
        t.questionsByDifficulty(difficulty);
        totalq = t.getSelectedQuestions().size();
    }
}