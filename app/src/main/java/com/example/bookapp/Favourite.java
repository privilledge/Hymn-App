package com.example.bookapp;

public class Favourite {
    public String title;
    public String number;


    public Favourite() {
    }

    public Favourite(String title, String number) {
        this.title = title;
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


}
