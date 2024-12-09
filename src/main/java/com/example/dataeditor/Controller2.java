package com.example.dataeditor;

import javafx.scene.control.ListView;

public class Controller2 extends SuperController {
    // This controls list view
    public ListView<String> theListView;

    public void initialize() throws Exception {
        super.initialize();
        super.currentSceneChoice = "List";
        sceneChoiceBox.setValue("List");
        listButton.setDisable(true);
        listButton.setVisible(false);

        theListView.getItems().clear();
        for (Film eachFilm : Film.getAllFilms()) {
            theListView.getItems().add(eachFilm.toString());
        }

        System.out.println("Controller2 # of objects: " + Film.getAllFilms().size());
    }

}