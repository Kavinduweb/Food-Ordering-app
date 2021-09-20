package com.example.myapplication;

public class CardModle {

    private int id;
    private String Number,Exdate,Cvv;

    public CardModle(){};

    public CardModle(int id, String number, String exdate, String cvv) {
        this.id = id;
        Number = number;
        Exdate = exdate;
        Cvv = cvv;
    }

    public CardModle(String number, String exdate, String cvv) {
        Number = number;
        Exdate = exdate;
        Cvv = cvv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getExdate() {
        return Exdate;
    }

    public void setExdate(String exdate) {
        Exdate = exdate;
    }

    public String getCvv() {
        return Cvv;
    }

    public void setCvv(String cvv) {
        Cvv = cvv;
    }
}
