package com.dark.controller;


import com.dark.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Empleado;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VentanaPrincipalController implements Initializable {

    ModelFactoryController msf = ModelFactoryController.getInstance();
    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtContraseniaLogin;

    @FXML
    private TextField txtUsuarioLogin;



    private Application application;
    private Stage stage;
    private Empleado empleadologin;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    //================================== Funciones Login ==============================================

    @FXML
    void loginEmpleado(ActionEvent event) throws IOException {
        String usuario = txtUsuarioLogin.getText();
        String contrasenia = txtContraseniaLogin.getText();
        if(datosValidosEmpleado(usuario, contrasenia)){
            empleadologin = msf.darEmpleadoLogin(usuario, contrasenia);
            if (empleadologin == null){
               mostrarMensaje("Error Login","No existe el empleado", "No existe un empleado con esos datos",Alert.AlertType.WARNING);
            }else{
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Application.class.getResource("/com/dark/view/EmpleadoView.fxml"));
                BorderPane borderPane = (BorderPane) loader.load();
                EmpleadoController controller = loader.getController();
                controller.setApplication(application);
                Scene scene = new Scene(borderPane);
                Stage stage = new Stage();
                stage.setTitle("Manejo de empleados");
                stage.setScene(scene);
                controller.init(stage,this, empleadologin);
                stage.show();
                this.stage.close();
            }

        }

    }

    /**
     *  Verifiar espacios en blanco
     * @param usuario
     * @param contrasenia
     * @return
     */

    private boolean datosValidosEmpleado(String usuario, String contrasenia) {
        String notificacion = "";
        if(usuario == null || usuario.equals("")){
            notificacion +="El usuario esta en blanco\n";
        }
        if (contrasenia == null || contrasenia.equals("")){
            notificacion +="La contraseña esta en blanco";
        }
        if(notificacion == ""){
            return true;
        }
        mostrarMensaje("Error login","Informacion invalida", notificacion, Alert.AlertType.WARNING);
        return false;
    }

    /**
     * muestra mensaje en la interfaz
     * @param title
     * @param header
     * @param content
     * @param alertType
     */
    public void mostrarMensaje(String title, String header, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}

