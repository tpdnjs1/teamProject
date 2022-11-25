package com.example.teamproject;

public class MainThread extends Thread {
    Main main = new Main();

    public boolean threadOn;

    @Override
    public void run() {

        while (true) {
            try {
                main.addDiaryList();
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
