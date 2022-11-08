package com.example.teamproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Login {
    MovePage movePage = new MovePage();

    @FXML
    private Button loginBtn;

    @FXML
    private Label signUp;
    @FXML
    private TextField id;
    @FXML
    private TextField pw;

    @FXML
    private void login(){
        movePage.changeScene("main", loginBtn);
    }

    @FXML
    private void moveSignUp(){
        movePage.changeSceneLabel("SignUp", signUp);
    }

}