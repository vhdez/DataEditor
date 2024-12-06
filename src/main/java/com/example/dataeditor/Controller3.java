package com.example.dataeditor;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

public class Controller3 extends SuperController {
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

        rankColumn.setOnEditCommit(
                (TableColumn.CellEditEvent<Film, Integer> t) -> {
                    int tableRow = t.getTablePosition().getRow();
                    Film filmFromTableRow = t.getTableView().getItems().get(tableRow);
                    filmFromTableRow.setRank(t.getNewValue());
                });
        titleColumn.setOnEditCommit(
                (TableColumn.CellEditEvent<Film, String> t) -> {
                    int tableRow = t.getTablePosition().getRow();
                    Film filmFromTableRow = t.getTableView().getItems().get(tableRow);
                    filmFromTableRow.setTitle(t.getNewValue());
                });

        for (Film eachFilm : Film.getAllFilms()) {
            theTable.getItems().add(eachFilm);
        }

    }
}