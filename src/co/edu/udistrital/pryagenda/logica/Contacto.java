package co.edu.udistrital.pryagenda.logica;

public class Contacto {

    int id;
    String nombre;
    String apellido;
    String telefono;
    String celular;
    String correo;

    public Contacto() {
    }

    public String getApellido() {
    return apellido;
    }

    public void setApellido(String apellido) {
    this.apellido = apellido;
    }

    public String getCelular() {
    return celular;
    }

    public void setCelular(String celular) {
    this.celular = celular;
    }

    public String getCorreo() {
    return correo;
    }

    public void setCorreo(String correo) {
    this.correo = correo;
    }

    public int getId() {
    return id;
    }

    public void setId(int id) {
    this.id = id;
    }

    public String getNombre() {
    return nombre;
    }

    public void setNombre(String nombre) {
    this.nombre = nombre;
    }

    public String getTelefono() {
    return telefono;
    }

    public void setTelefono(String telefono) {
    this.telefono = telefono;
    }
}