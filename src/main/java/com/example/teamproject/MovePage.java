package com.example.teamproject;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MovePage {

    public void changeScene(String pageName, Button changeBtn) {
        try {
            Parent nextPage = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(pageName + ".fxml")));
            Scene scene = new Scene(nextPage);
            Stage primaryStage = (Stage) changeBtn.getScene().getWindow();
            primaryStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void changeSceneLabel(String pageName, Label change) {
        try {
            Parent nextPage = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(pageName + ".fxml")));
            Scene scene = new Scene(nextPage);
            Stage primaryStage = (Stage) change.getScene().getWindow();
            primaryStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
