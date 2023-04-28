package com.example.bookapp;

public class Hymns {
    public String[] title;
    public int[] number;
    public String[] content;


//    public Hymns() {
//    }



    public Hymns(String[] title, int[] number,String[] content) {
        this.title = title;
        this.number = number;
        this.content = content;
    }

    public String[] getTitle() {
        return title;
    }

    public void setTitle(String[] title) {
        this.title = title;
    }

    public int[] getNumber() {
        return number;
    }

    public void setNumber(int[] number) {
        this.number = number;
    }

    public String[] getContent() {
        return content;
    }

    public void setContent(String[] content) {
        this.content = content;
    }
}
