package com.example.teamproject;

public class MainThread implements Runnable{
    Main main = new Main();
    DiaryAdd diaryAdd = new DiaryAdd();

    @Override
    public void run(){
        while (true){
            if (diaryAdd.needAdd){
                main.addDiaryList();
                diaryAdd.needAdd = false;
            }
        }
    }
}
