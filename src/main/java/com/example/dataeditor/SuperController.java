package com.example.dataeditor;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class SuperController {
    public ChoiceBox<String> sceneChoiceBox;
    String currentSceneChoice;

    public Button textButton;
    public Button listButton;
    public Button tableButton;

    public void initialize() throws Exception {
        sceneChoiceBox.getItems().add("Text Fields");
        sceneChoiceBox.getItems().add("List");
        sceneChoiceBox.getItems().add("Table");
        sceneChoiceBox.setOnAction((event)  -> {
            changeScene();
        });
    }

    public void switchToTextFieldView() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(DataEditor.class.getResource("View1.fxml"));
        Scene textFieldScene = new Scene(fxmlLoader.load(), 600, 400);
        Stage mainStage = (Stage)textButton.getScene().getWindow();
        mainStage.setScene(textFieldScene);
    }

    public void switchToListView() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(DataEditor.class.getResource("View2.fxml"));
        Scene listScene = new Scene(fxmlLoader.load(), 600, 400);
        Stage mainStage = (Stage)textButton.getScene().getWindow();
        mainStage.setScene(listScene);
    }

    public void switchToTableView() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(DataEditor.class.getResource("View3.fxml"));
        Scene tableScene = new Scene(fxmlLoader.load(), 600, 400);
        Stage mainStage = (Stage)textButton.getScene().getWindow();
        mainStage.setScene(tableScene);
    }

    public void changeScene() {
        if (sceneChoiceBox.getValue().contains(currentSceneChoice)) {
            // Don't change scene if we're already at choice.
            return;
        }
        try {
            if (sceneChoiceBox.getValue().contains("Text Fields")) {
                switchToTextFieldView();
            }

            if (sceneChoiceBox.getValue().contains("List")) {
                switchToListView();
            }

            if (sceneChoiceBox.getValue().contains("Table")) {
                switchToTableView();
            }
        } catch (Exception ex) {
            System.out.println("changeScene failed: " + ex);
        }
    }
}
