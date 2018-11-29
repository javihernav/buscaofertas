package app.modelo.vo;

import app.utils.interfaces.IVo;

public class Usuario implements IVo {

    int idUsuario;
    int Ciudad_idCiudad;
    String nombreUsuario;
    String contrasena;
    String nombre;
    String apellido;
    String telefono;
    String correo;
    String fechaNacimiento;
    char genero;
    String rol;

    public Usuario() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public int getCiudad_idCiudad() {
        return Ciudad_idCiudad;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
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

    public String getCorreo() {
        return correo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public char getGenero() {
        return genero;
    }

    public String getRol() {
        return rol;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setCiudad_idCiudad(int Ciudad_idCiudad) {
        this.Ciudad_idCiudad = Ciudad_idCiudad;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

}
