package com.example.teamproject;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Diary implements Initializable {

    @FXML
    private Label title;
    @FXML
    private Label text;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DiaryList diaryList = new DiaryList();

        System.out.println(diaryList.getTitle() + diaryList.getStText());
        title.setText(diaryList.getTitle());
        text.setText(diaryList.getStText());
    }

}
