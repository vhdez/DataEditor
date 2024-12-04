package com.example.dataeditor;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller1 extends SuperController {
    // This controls text fields and buttons
    TextField rankText;
    TextField titleText;
    TextField fullText;
    Button nextButton;
    Button previousButton;

    public void initialize() throws Exception {
        super.initialize();
        super.currentSceneChoice = "Text Fields";
        sceneChoiceBox.setValue("Text Fields");
        textButton.setDisable(true);
        textButton.setVisible(false);
    }

    public void previousData() {

    }

    public void nextData() {

    }

}