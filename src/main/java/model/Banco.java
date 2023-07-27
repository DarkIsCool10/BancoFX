package model;

import com.dark.controller.EmpleadoController;

import java.util.ArrayList;
import java.util.List;
public class Banco {

    private String nombre;
    private List<Empleado> listaEmpleado;
    private List<Cliente> listaCliente;

    public Banco(String nombre) {
        this.nombre = nombre;
        this.listaEmpleado = new ArrayList<Empleado>();
        this.listaCliente = new ArrayList<Cliente>();
    }

    public Banco(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Empleado> getListaEmpleado() {
        return listaEmpleado;
    }

    public void setListaEmpleado(List<Empleado> listaEmpleado) {
        this.listaEmpleado = listaEmpleado;
    }

    public List<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }


    //============================= VIEW LOGIN ==============================================

    /**
     * Retorna el empleado dado el usario y la contraseña
     * @param usuario
     * @param contrasenia
     * @return
     */

    public Empleado darEmpleadoLogin(String usuario, String contrasenia) {
        Empleado empleadoEncontrado = null;
            for(Empleado empleado :listaEmpleado){
                if(empleado.getUsuario().equals(usuario) && empleado.getContrasenia().equals(contrasenia)){
                    empleadoEncontrado = empleado;
                }
            }
            return empleadoEncontrado;
    }
}
