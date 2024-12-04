module com.example.dataeditor {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dataeditor to javafx.fxml;
    exports com.example.dataeditor;
}