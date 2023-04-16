package com.example.bookapp;

public class Hymns {
    public String title;
    public int number;


    public Hymns() {
    }

    public Hymns(String title, int number) {
        this.title = title;
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


}
