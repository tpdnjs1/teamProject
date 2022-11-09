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
    private void popUpPage(){
        movePage.popUp("DiaryAdd", add);
    }
}
