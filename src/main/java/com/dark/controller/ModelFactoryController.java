package com.dark.controller;


import model.Banco;
import model.Cliente;
import model.Empleado;
import java.lang.module.Configuration;
import java.util.List;

public class ModelFactoryController {

    Banco banco = null;

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public static class SingletonHolder{

        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController(){
        System.out.println("Invocacion clase singleton");
        inicializarDatos();
    }

    private void inicializarDatos() {
        banco = new Banco("Social");
    //Inicializador de datos de empleado y cliente
        Empleado empleado1 = new Empleado("Camioo","Albaran","1234","Dark","1234");
        banco.getListaEmpleado().add(empleado1);
        Cliente cliente1 = new Cliente("Valeria","Mahecha","4567", empleado1);
        banco.getListaCliente().add(cliente1);
    }

    //=================================== VIEW LOGIN ===================================================

    /**
     *
     */

    public Empleado darEmpleadoLogin(String usuario, String contrasenia){
            return banco.darEmpleadoLogin(usuario,contrasenia);
    }

}
