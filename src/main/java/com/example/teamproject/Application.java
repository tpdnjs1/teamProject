package com.example.teamproject;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Start.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 650);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("images/Crescent.png")));
        stage.setTitle("Crescent Account Book");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}