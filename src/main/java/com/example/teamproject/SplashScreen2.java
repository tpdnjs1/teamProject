package com.example.teamproject;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;

public class SplashScreen2 {
    MovePage movePage = new MovePage();

    @FXML
    private Label skip;

    @FXML
    private void skipPage(){
        movePage.changeSceneLabel("Login", skip);
    }
    @FXML
    private AnchorPane container;

    @FXML
    private Button nextBtn;

    @FXML
    private void animationNextPage(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SplashScreen3.fxml"));

        Scene scene = nextBtn.getScene();

        root.translateXProperty().set(scene.getWidth());

        AnchorPane parentContainer = (AnchorPane) scene.getRoot();
        parentContainer.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(event1 -> {
            parentContainer.getChildren().remove(container);
        });

        timeline.play();
    }

}
