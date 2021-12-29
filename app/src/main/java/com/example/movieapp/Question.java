package com.example.movieapp;

import java.util.ArrayList;

// Question class that consists of the question, all answers, the correct answer and image
public class Question {
    private final String question;      // the question
    private ArrayList<String> answers;  // a list of all possible answers
    private final int answer;           // the right answer 0 or 1 or 2 or 3, 9 for all for now
    private final int image;            // R.id of the image (int)
    private int points;                 // points
    private int difficulty;             // 0-Easy 1-Medium 2-Hard

    public Question(String question, ArrayList<String> answers, int answer, int difficulty, int points, int image) {
        this.question = question;
        this.answers = answers;
        this.answer = answer;
        this.difficulty = difficulty;
        this.points = points;
        this.image = image;
    }

    public Question() {
        this.question=null;
        this.answers=null;
        this.answer=0;
        this.image=0;
    }

    public int getImage() {
        return image;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public String getRightAnswerString(){
        return answers.get(answer-1);
    }

    public int getRightAnswer() {
        return answer;
    }

    public String getQuestion() {
        return question;
    }

    public int getPoints() {
        return points;
    }

    boolean isCorrect(int a) {
        if(answer==9) return true;
        return answer==a;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answers=" + answers +
                ", answer='" + answer + '\'' +
                '}';
    }
}
