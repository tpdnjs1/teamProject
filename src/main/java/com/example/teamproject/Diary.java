package com.example.teamproject;

import java.util.Date;

public class Diary {
    private String title;
    private String stText;
    private Date date;

    public Diary(String title, Date date, String stText){
        this.title = title;
        this.stText = stText;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStText() {
        return stText;
    }

    public void setStText(String text) {
        this.stText = text;
    }

    @Override
    public String toString() {
        return "" + date + " : " + title;
    }
}
