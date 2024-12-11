package com.example.dataeditor;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

public class Controller3_TableView extends SuperController {
    public TableView<Film> theTable;
    public TableColumn<Film, Integer> rankColumn;
    public TableColumn<Film, String> titleColumn;
    public TableColumn<Film, String> fullTextColumn;

    // This controls table view
    public void initialize() throws Exception {
        super.initialize();
        super.currentSceneChoice = "Table";
        sceneChoiceBox.setValue("Table");
        tableButton.setDisable(true);
        tableButton.setVisible(false);

        // This causes Film's values to be displayed in TableView
        rankColumn.setCellValueFactory(new PropertyValueFactory<>("rank"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        fullTextColumn.setCellValueFactory(new PropertyValueFactory<>("toString"));

        // This causes TableView's values to be editable
        rankColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        titleColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        // This causes TableView's edited values to stored in original ArrayList objects
        rankColumn.setOnEditCommit(
                (TableColumn.CellEditEvent<Film, Integer> t) -> {
                    int selectedRow = t.getTablePosition().getRow();
                    Film selectedFilm = t.getTableView().getItems().get(selectedRow);
                    selectedFilm.setRank(t.getNewValue());
                });
        titleColumn.setOnEditCommit(
                (TableColumn.CellEditEvent<Film, String> t) -> {
                    int selectedRow = t.getTablePosition().getRow();
                    Film selectedFilm = t.getTableView().getItems().get(selectedRow);
                    selectedFilm.setTitle(t.getNewValue());
                });

        theTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    // oldValue can be null if nothing WAS selected
                    // newValue can be null if nothing IS NOW selected
                    System.out.println("TableView select oldValue: " + oldValue);
                    System.out.println("TableView select newValue: " + newValue);
                });

                    // This makes the TableView's ObservableList contain the SAME objects as the original ArrayList
        for (Film eachFilm : Film.getAllFilms()) {
            theTable.getItems().add(eachFilm);
        }
    }
}