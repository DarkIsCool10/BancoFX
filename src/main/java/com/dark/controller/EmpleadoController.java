package com.dark.controller;

import com.dark.application.Application;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import model.Empleado;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class EmpleadoController implements Initializable {

    ModelFactoryController msf = ModelFactoryController.getInstance();
    private Application application;
    private Stage stage;
    private VentanaPrincipalController ventanaPrincipalController;
    private Empleado empleadoLogin;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public void init(Stage stage, VentanaPrincipalController ventanaPrincipalController, Empleado empleadoLogin){
        this.ventanaPrincipalController = ventanaPrincipalController;
        this.empleadoLogin = empleadoLogin;
        this.stage = stage;
    }
}
