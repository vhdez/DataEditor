package com.example.dataeditor;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Controller3 extends SuperController {
    public TableView theTable;
    public TableColumn rankColumn;
    public TableColumn titleColumn;
    public TableColumn fullTextColumn;

    // This controls table view
    public void initialize() throws Exception {
        super.initialize();
        super.currentSceneChoice = "Table";
        sceneChoiceBox.setValue("Table");
        tableButton.setDisable(true);
        tableButton.setVisible(false);
    }
}