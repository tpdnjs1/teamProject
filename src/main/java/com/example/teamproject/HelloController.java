package com.example.teamproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("HI");
    }

    private void test(){
        welcomeText.setText("시방세");
    }
}