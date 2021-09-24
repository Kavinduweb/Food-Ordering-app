package com.example.myapplication;


public class FeedBack {
    private int id;
    private String feedbackMzg;

    public FeedBack() {
    }

    public FeedBack(int id, String title) {
        this.id = id;
        this.feedbackMzg = title;
    }

    public FeedBack(String title) {
        this.feedbackMzg = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFeedbackMzg() {
        return feedbackMzg;
    }

    public void setFeedbackMzg(String message) {
        this.feedbackMzg = message;
    }

}


