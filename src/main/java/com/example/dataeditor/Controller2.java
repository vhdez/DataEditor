package com.example.dataeditor;

import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.StringConverter;
import javafx.util.converter.DefaultStringConverter;

public class Controller2 extends SuperController {
    // This controls list view
    public ListView<Film> theListView;
    public TextField titleEditor;
    public TextField rankEditor;
    public Film currentFilm;

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
                    rankEditor.setText(String.valueOf(newValue.getRank()));
                    titleEditor.setText(String.valueOf(newValue.getTitle()));
                    currentFilm = newValue;
                   /*
                    String newText = newValue;
                    if (newText != null) {
                        // Populate controls with selected Person
                        firstnameTextField.setText(selectedPerson.getFirstname());
                        lastnameTextField.setText(selectedPerson.getLastname());
                        notesTextArea.setText(selectedPerson.getNotes());
                    } else {
                        firstnameTextField.setText("");
                        lastnameTextField.setText("");
                        notesTextArea.setText("");
                    }

                    */
                });

        // This makes the ListView's ObservableList contain the SAME objects as the original ArrayList
        for (Film eachFilm : Film.getAllFilms()) {
            theListView.getItems().add(eachFilm);
        }
    }

    public void editRank() {
        currentFilm.setRank(Integer.parseInt(rankEditor.getText()));
    }

    public void editTitle() {
        currentFilm.setTitle(titleEditor.getText());
    }

}