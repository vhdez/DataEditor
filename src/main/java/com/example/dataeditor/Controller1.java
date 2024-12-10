package com.example.dataeditor;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller1 extends SuperController {
    // This controls text fields and buttons
    public TextField rankText;
    public TextField titleText;
    public TextArea fullText;
    public Button nextButton;
    public Button previousButton;
    int currentFilmNumber;

    public void initialize() throws Exception {
        super.initialize();
        super.currentSceneChoice = "Text Fields";
        sceneChoiceBox.setValue("Text Fields");
        textButton.setDisable(true);
        textButton.setVisible(false);

        currentFilmNumber = 0;
        Film firstFilm = Film.getAllFilms().get(currentFilmNumber);
        rankText.setText(String.valueOf(firstFilm.getRank()));
        titleText.setText(String.valueOf(firstFilm.getTitle()));
        fullText.setText(String.valueOf(firstFilm));
    }

    public void previousData() {
        if (currentFilmNumber > 0) {
            currentFilmNumber = currentFilmNumber - 1;
        } else {
            currentFilmNumber = Film.getAllFilms().size()-1;
        }
        Film prevFilm = Film.getAllFilms().get(currentFilmNumber);
        rankText.setText(String.valueOf(prevFilm.getRank()));
        titleText.setText(String.valueOf(prevFilm.getTitle()));
        fullText.setText(String.valueOf(prevFilm));
    }

    public void nextData() {
        if (currentFilmNumber < Film.getAllFilms().size() - 2) {
            currentFilmNumber = currentFilmNumber + 1;
        } else {
            currentFilmNumber = 0;
        }
        Film nextFilm = Film.getAllFilms().get(currentFilmNumber);
        rankText.setText(String.valueOf(nextFilm.getRank()));
        titleText.setText(String.valueOf(nextFilm.getTitle()));
        fullText.setText(String.valueOf(nextFilm));
    }

    public void titleChanged() {
        String newTitle = titleText.getText();
        Film currentFilm = Film.getAllFilms().get(currentFilmNumber);
        currentFilm.setTitle(newTitle);
    }
}