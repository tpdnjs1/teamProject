package com.example.teamproject;

import java.util.Date;

public class QuList {
    private int listNum;
    private String qNum;
    private String answer;
    private Date date;

    public QuList(int listNum, String qNum, String answer, Date date){
        this.listNum = listNum;
        this.qNum = qNum;
        this.answer = answer;
        this.date = date;
    }

    public String getqNum() {
        return qNum;
    }

    public void setqNum(String qNum) {
        this.qNum = qNum;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getListNum() {
        return listNum;
    }

    public void setListNum(int listNum) {
        this.listNum = listNum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Answer."+ listNum +"  by." + date;
    }
}
