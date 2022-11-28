package com.example.teamproject;

import java.util.Date;

public class DiaryList {
    private String title;
    private String stText;
    private Date date;


    public DiaryList(String title, Date date, String stText) {
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

    public String getStText() {
        return stText;
    }

    public void setStText(String stText) {
        this.stText = stText;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "" + date + " : " + title;
    }


}
