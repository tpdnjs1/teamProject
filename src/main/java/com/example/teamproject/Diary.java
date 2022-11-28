package com.example.teamproject;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Diary implements Initializable {
    Main main = new Main();

    @FXML
    private Label title;
    @FXML
    private Label text;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        title.setText(main.getStTitle());
        text.setText(main.getStText());
    }
}
