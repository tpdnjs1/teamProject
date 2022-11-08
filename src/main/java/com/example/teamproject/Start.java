package com.example.teamproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Start {
    MovePage movePage = new MovePage();

    @FXML
    private Button btn;

    @FXML
    private void nextPage(){
        movePage.changeScene("SplashScreen", btn);
    }
}
