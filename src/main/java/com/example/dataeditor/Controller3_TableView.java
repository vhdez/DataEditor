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
    public void initialize() {
        super.initialize();
        super.currentSceneChoice = "Table";
        sceneChoiceBox.setValue("Table");
        tableButton.setDisable(true);
        tableButton.setVisible(false);

        // TableView Display: get data values into each row/column/cell
        rankColumn.setCellValueFactory(new PropertyValueFactory<>("rank"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        fullTextColumn.setCellValueFactory(new PropertyValueFactory<>("toString"));

        // TableView Display: detect when a row is selected
        theTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    // oldValue can be null if nothing WAS selected
                    // newValue can be null if nothing IS NOW selected
                    System.out.println("SELECTED ROW FOR: " + newValue);
                });

        // TableView Edit: when user double-clicks on cell, turn it into a TextField for editing
        rankColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        titleColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        // TableView Edit: when user is done editing, store new value in selected data object
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

        // This makes the TableView's ObservableList contain the SAME objects as the original ArrayList
        for (Film eachFilm : Film.getAllFilms()) {
            theTable.getItems().add(eachFilm);
        }
    }
}