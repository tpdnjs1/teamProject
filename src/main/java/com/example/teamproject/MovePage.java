package com.example.teamproject;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MovePage {

    public void changeScene(String pageName, Button changeBtn) {
        try {
            Parent nextPage = FXMLLoader.load(getClass().getResource(pageName + ".fxml"));
            Scene scene = new Scene(nextPage);
            Stage primaryStage = (Stage) changeBtn.getScene().getWindow();
            primaryStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
