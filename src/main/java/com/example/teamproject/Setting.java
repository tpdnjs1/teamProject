package com.example.teamproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Setting {
    MovePage movePage = new MovePage();

    @FXML
    private Button main;
    @FXML
    private Button question;
    @FXML
    private Button setting;
    @FXML
    private Label account;
    @FXML
    private Label signUp;

    @FXML
    private void moveMain(){movePage.changeScene("Main", main);}
    @FXML
    private void moveQuestion(){movePage.changeScene("Questions", question);}
    @FXML
    private void moveSetting(){movePage.changeScene("Setting", setting);}
    @FXML
    private void moveAccount(){movePage.popUpLabel("AccountPopUp",account);}
    @FXML
    private void moveSingUp(){movePage.changeSceneLabel("Login",signUp);}
}




