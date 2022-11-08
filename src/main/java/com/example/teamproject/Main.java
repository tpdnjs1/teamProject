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

    private void popUpPage(){
        Stage mainStage = (Stage) add.getScene().getWindow();
        Stage pop = new Stage(StageStyle.DECORATED);
        pop.initModality(Modality.WINDOW_MODAL);
        pop.initOwner(mainStage);
        try {
            Parent nextScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("DiaryAdd.fxml")));
            Scene scene = new Scene(nextScene);

            pop.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/Crescent.png"))));
            pop.setTitle("Crescent Account Book");

            pop.setScene(scene);
            pop.setResizable(false);
            pop.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
