package model;

public class Empleado extends Persona {

    private String usuario;
    private String contrasenia;

    public Empleado(String nombre, String apellido, String id, String usuario,String contrasenia) {
        super(nombre, apellido, id);
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public Empleado() {

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContraseña(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
