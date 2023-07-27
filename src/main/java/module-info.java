module com.dark.prueba2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.dark.controller to javafx.fxml;
    exports com.dark.controller;
    exports com.dark.application;
    opens com.dark.application to javafx.fxml;
}