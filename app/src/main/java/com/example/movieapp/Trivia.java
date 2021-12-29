package com.example.movieapp;

import java.util.ArrayList;
import java.util.Collections;

// Trivia class, contains a list of Questions
public class Trivia {
    private ArrayList<Question> questions;
    private ArrayList<Question> selectedquestions; // by difficulty

    public Trivia() {
        this.questions = new ArrayList<>();
    }

    void addQuestion(Question q){
        questions.add(q);
    }

    void removeQuestion(int i) {
        questions.remove(i);
    }

    public ArrayList<Question> getSelectedQuestions() {
        return selectedquestions;
    }
    public ArrayList<Question> getQuestions() {
        return questions;
    }

    void shuffleQuestions() {
        Collections.shuffle(this.questions);
    }
    void shuffleSelectedQuestions() {
        Collections.shuffle(this.selectedquestions);
    }


//    ArrayList<Question> nQuestions(int n) {
//        ArrayList<Question> nq = new ArrayList<>();
//        int j=0;
//        for (int i = 0; i < n; i++) {
//            if(i >= questions.size())
//                j=0;
//            nq.add(questions.get(j++));
//        }
//        return nq;
//    }

    void questionsByDifficulty(int dif) {
        ArrayList<Question> list = new ArrayList<>();
        for (Question q : questions) {
            if(q.getDifficulty() == dif) {
                list.add(q);
            }
        }
        selectedquestions = list;
    }

}
