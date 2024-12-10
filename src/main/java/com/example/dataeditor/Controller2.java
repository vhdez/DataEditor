package com.example.dataeditor;

import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.util.StringConverter;

public class Controller2 extends SuperController {
    // This controls list view
    public ListView<Film> theListView;
    public TextField titleEditor;
    public TextField rankEditor;

    public void initialize() throws Exception {
        super.initialize();
        super.currentSceneChoice = "List";
        sceneChoiceBox.setValue("List");
        listButton.setDisable(true);
        listButton.setVisible(false);

        theListView.setEditable(true);
        StringConverter<Film> filmConverter = new StringConverter<Film>() {
            @Override
            public String toString(Film film) {
                if (film != null) {
                    return film.toString();
                } else {
                    return "";
                }
            }

            @Override
            public Film fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    // NOT DONE: need to turn text String back into Film
                    return null;
                } else {
                    return null;
                }
            }
        };
        theListView.setCellFactory(value -> new TextFieldListCell<>(filmConverter));
        theListView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    // oldValue can be null if nothing WAS selected
                    // newValue can be null if nothing IS NOW selected
                    System.out.println("ListView select oldValue: " + oldValue);
                    System.out.println("ListView select newValue: " + newValue);
                    if (newValue != null) {
                        rankEditor.setText(String.valueOf(newValue.getRank()));
                        titleEditor.setText(String.valueOf(newValue.getTitle()));
                    } else {
                        rankEditor.setText("");
                        titleEditor.setText("");
                    }
                });

        // This makes the ListView's ObservableList contain the SAME objects as the original ArrayList
        for (Film eachFilm : Film.getAllFilms()) {
            theListView.getItems().add(eachFilm);
        }
    }

    public void editRank() {
        Film selectedFilm = theListView.getSelectionModel().getSelectedItem();
        selectedFilm.setRank(Integer.parseInt(rankEditor.getText()));
        theListView.refresh();
    }

    public void editTitle() {
        Film selectedFilm = theListView.getSelectionModel().getSelectedItem();
        selectedFilm.setTitle(titleEditor.getText());
        theListView.refresh();
    }

}