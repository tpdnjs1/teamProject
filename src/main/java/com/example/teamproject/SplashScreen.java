package com.example.teamproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SplashScreen {
    MovePage movePage = new MovePage();

    @FXML
    private Button btn;
    @FXML
    private Label skip;

    @FXML
    private void skipPage(){
        movePage.changeSceneLabel("Login", skip);
    }
    @FXML
    private void nextPage(){
        movePage.changeScene("SplashScreen2", btn);
    }
}
