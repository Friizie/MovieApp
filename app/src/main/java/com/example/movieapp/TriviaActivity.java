package com.example.movieapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationBarView;

public class TriviaActivity extends AppCompatActivity {
    Button b1, b2, b3, b4;
    TextView displayedQuestion, questionNum;
    ImageView displayedImage;
    Trivia t;
    int questionIndex = -1, totalPoints = 0, difficulty = 0;
    int answer, totalq, NUM_OF_QUESTIONS = 10, timer = 0;
    NavigationBarView navBarTrivia;
    int     SELECTED_COLOUR = Color.parseColor("#b80000"),          // crvena
            CORRECT_ANSWER_COLOUR = Color.parseColor("#00a616"),    // zelena
            DEFAULT_COLOUR = Color.parseColor("#FF6200EE");         // default violetova
    boolean anifinished = true;

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
                if(anifinished){
                answer = 1;
                Answer();
                }
            }
        });
        b2 = (Button) findViewById(R.id.two);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(anifinished) {
                    answer = 2;
                    Answer();
                }
            }
        });

        b3 = (Button) findViewById(R.id.three);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(anifinished){
                answer = 3;
                Answer();
                }
            }
        });
        b4 = (Button) findViewById(R.id.four);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(anifinished) {
                    answer = 4;
                    Answer();
                }
            }
        });
    }

    // update function for updating screen information
    void update() {
        if(questionIndex<1) timer = 0; else timer = 1000;
        // https://stackoverflow.com/questions/18712955/i-want-to-change-the-color-of-a-button-for-a-few-seconds-than-change-it-back
        new CountDownTimer(timer, 50) {
            @Override
            public void onTick(long arg0) {
            }
            @Override
            public void onFinish() {
                b1.setBackgroundColor(DEFAULT_COLOUR);
                b2.setBackgroundColor(DEFAULT_COLOUR);
                b3.setBackgroundColor(DEFAULT_COLOUR);
                b4.setBackgroundColor(DEFAULT_COLOUR);

                if (isNextQuestion()) {
                    displayedQuestion.setText(getCurrentQuestion().getQuestion());
                    if (getCurrentQuestion().getImage() == 0) {
                        displayedImage.setVisibility(View.INVISIBLE);
                        displayedImage.getLayoutParams().width = 0;
                        displayedImage.getLayoutParams().height = 0;
                        displayedImage.requestLayout();
                    } else {
                        displayedImage.setVisibility(View.VISIBLE);
                        displayedImage.getLayoutParams().width = 200;
                        displayedImage.getLayoutParams().height = 200;
                        displayedImage.requestLayout();
                        displayedImage.setImageResource(getCurrentQuestion().getImage());
                    }
                    String num = (questionIndex + 1) + "/" + NUM_OF_QUESTIONS;
                    questionNum.setText(num);

                    b1.setText(getCurrentQuestion().getAnswers().get(0));
                    b2.setText(getCurrentQuestion().getAnswers().get(1));
                    b3.setText(getCurrentQuestion().getAnswers().get(2));
                    b4.setText(getCurrentQuestion().getAnswers().get(3));

                }
                anifinished = true;
            }
        }.start();
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
                        startActivity(new Intent(TriviaActivity.this, MainActivity.class)
                                .addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
                        finish();
                        break;
                    case R.id.mCalendar:
                        startActivity(new Intent(TriviaActivity.this, CalendarActivity.class)
                                .addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
                        finish();
                        break;
                    case R.id.mTrivia:
                        break;
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
        anifinished = false;
        if (isNextQuestion()) {
            if (check(answer)) {
                totalPoints += getCurrentQuestion().getPoints();
            }
            else {
                switch (answer) {
                    case 1: b1.setBackgroundColor(SELECTED_COLOUR);break;
                    case 2: b2.setBackgroundColor(SELECTED_COLOUR);break;
                    case 3: b3.setBackgroundColor(SELECTED_COLOUR);break;
                    case 4: b4.setBackgroundColor(SELECTED_COLOUR);break;
                    default: break;
                }
            }
            switch (getAnswer()) {
                case 1: b1.setBackgroundColor(CORRECT_ANSWER_COLOUR);break;
                case 2: b2.setBackgroundColor(CORRECT_ANSWER_COLOUR);break;
                case 3: b3.setBackgroundColor(CORRECT_ANSWER_COLOUR);break;
                case 4: b4.setBackgroundColor(CORRECT_ANSWER_COLOUR);break;
                default: break;
            }
            if (questionIndex == NUM_OF_QUESTIONS - 1) { finished(); return; }
            nextQuestion();
            update();
        }
    }

    // get the right answer
    public int getAnswer() {
        if (isNextQuestion())
            return getCurrentQuestion().getRightAnswer();
        return -1;
    }

    // next question
    void nextQuestion() {
        questionIndex++;
    }

    // check if there is next question (test)
    boolean isNextQuestion() {
        return t.getSelectedQuestions().size() != questionIndex;
    }

    //get the current question
    Question getCurrentQuestion() {
        if (isNextQuestion())
            return t.getSelectedQuestions().get(questionIndex);
        return new Question();
    }

    // get difficulty from previous screen
    void difficulty() {
        Bundle bundle = getIntent().getExtras();
        difficulty = bundle.getInt("difficulty");
    }


    // init final screen
    void finished() {
        Bundle bundle = new Bundle();
        bundle.putInt("score", totalPoints);
        new CountDownTimer(timer, 50) {
            @Override
            public void onTick(long arg0) {
            }
            @Override
            public void onFinish() {
                startActivity(new Intent(TriviaActivity.this, EndTrivia.class)
                        .putExtras(bundle)
                        .addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
                finish();
            }
        }.start();
    }


    // setting the questions
    public void setTrivia() {
        t = new Trivia();
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