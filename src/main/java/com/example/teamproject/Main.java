package com.example.teamproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class Main {
    MovePage movePage = new MovePage();

    @FXML
    private Button add;
    @FXML
    private Button main;
    @FXML
    private Button question;
    @FXML
    private Button setting;

    @FXML
    private void popUpPage(){
        movePage.popUp("DiaryAdd", add);
    }
    @FXML
    private void moveMain(){movePage.changeScene("Main", main);}
    @FXML
    private void moveQuestion(){movePage.changeScene("Questions", question);}
    @FXML
    private void moveSetting(){movePage.changeScene("Setting", setting);}

}
