package com.example.dataeditor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DataEditor extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DataEditor.class.getResource("View1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 400);
        stage.setTitle("Data Editor");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        Film.saveData();
    }

    public static void main(String[] args) {
        launch();
    }
}