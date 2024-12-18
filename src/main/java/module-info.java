module com.example.dataeditor {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swing;
    requires java.desktop;


    opens com.example.dataeditor to javafx.fxml;
    exports com.example.dataeditor;
}