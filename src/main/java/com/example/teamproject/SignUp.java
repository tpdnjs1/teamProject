package com.example.teamproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SignUp {
    MovePage movePage = new MovePage();

    @FXML
    private Button signUpBtn;
    @FXML
    private Label login;

    @FXML
    private TextField id;
    @FXML
    private TextField pw;
    @FXML
    private TextField name;

    @FXML
    private void signUp(){
        movePage.changeScene("main", signUpBtn);
    }

    @FXML
    private void moveLogin(){
        movePage.changeSceneLabel("Login", login);
    }
}
