package co.edu.udistrital.agenda.logica;

public class Contacto {

    int id;
    String nombre;
    String apellido;
    String telefono;
    String celular;
    String correo;
    String telefonoOficina;
    String direccion;
    String direccionTrabajo;

    public Contacto() {
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCelular() {
        return celular;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefonoOficina() {
        return telefonoOficina;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getDireccionTrabajo() {
        return direccionTrabajo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefonoOficina(String telefonoOficina) {
        this.telefonoOficina = telefonoOficina;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setDireccionTrabajo(String direccionTrabajo) {
        this.direccionTrabajo = direccionTrabajo;
    }

}