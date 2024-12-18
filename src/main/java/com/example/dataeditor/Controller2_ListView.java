package com.example.dataeditor;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.util.StringConverter;

import java.io.File;

public class Controller2_ListView extends SuperController {
    // This controls list view
    public ListView<Film> theListView;
    public TextField titleEditor;
    public TextField rankEditor;
    public Button addPosterButton;
    public ImageView posterImageView;

    public void initialize() {
        super.initialize();
        super.currentSceneChoice = "List";
        sceneChoiceBox.setValue("List");
        listButton.setDisable(true);
        listButton.setVisible(false);

        // when user selects a row in list, update the text fields where the values will be editted
        theListView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    // oldValue can be null if nothing WAS selected
                    // newValue can be null if nothing IS NOW selected
                    if (newValue != null) {
                        rankEditor.setText(String.valueOf(newValue.getRank()));
                        titleEditor.setText(String.valueOf(newValue.getTitle()));
                        addPosterButton.setDisable(false);
                        Image poster = newValue.getMoviePoster();
                        if (poster != null) {
                            posterImageView.setImage(poster);
                        } else {
                            posterImageView.setImage(null);
                        }
                    } else {
                        rankEditor.setText("");
                        titleEditor.setText("");
                    }
                });

        // let user edit each row in the list
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

        // This makes the ListView's ObservableList contain the SAME objects as the original ArrayList
        for (Film eachFilm : Film.getAllFilms()) {
            theListView.getItems().add(eachFilm);
        }
    }

    public void editRank() {
        Film selectedFilm = theListView.getSelectionModel().getSelectedItem();
        if (selectedFilm != null) {
            selectedFilm.setRank(Integer.parseInt(rankEditor.getText()));
            theListView.refresh();
        }
    }

    public void editTitle() {
        Film selectedFilm = theListView.getSelectionModel().getSelectedItem();
        if (selectedFilm != null) {
            selectedFilm.setTitle(titleEditor.getText());
            theListView.refresh();
        }
    }

    public void addPosterImage() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Select Movie Poster");
        File posterFile = chooser.showOpenDialog(addPosterButton.getScene().getWindow());
        if (posterFile != null) {
            Image posterImage = new Image(posterFile.toURI().toString());
            posterImageView.setImage(posterImage);
            Film selectedFilm = theListView.getSelectionModel().getSelectedItem();
            selectedFilm.setMoviePoster(posterImage);
        }
    }
}