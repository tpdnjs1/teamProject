package com.example.teamproject;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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

    public void popUp(String pageName, Button popBtn){
        Stage mainStage = (Stage) popBtn.getScene().getWindow();
        Stage pop = new Stage(StageStyle.DECORATED);
        pop.initModality(Modality.WINDOW_MODAL);
        pop.initOwner(mainStage);
        try {
            Parent nextScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(pageName + ".fxml")));
            Scene scene = new Scene(nextScene);
            pop.setTitle("Crescent Account Book");

            pop.getIcons().add(new Image(getClass().getResourceAsStream("images/Crescent.png")));

            pop.setScene(scene);
            pop.setResizable(false);
            pop.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
