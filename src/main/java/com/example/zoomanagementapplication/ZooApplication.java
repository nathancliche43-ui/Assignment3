package com.example.zoomanagementapplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ZooApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ZooApplication.class.getResource("zoo-section-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Zoo Management App");
        stage.setScene(scene);
        stage.show();
    }
}
