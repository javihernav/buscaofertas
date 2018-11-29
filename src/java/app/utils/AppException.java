/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.utils;

/**
 *
 * @author Sena
 */
public class AppException extends Exception{

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    private int codigo;    
    private String mensaje;

    public AppException(int codigo, String mensaje) {
        super(mensaje);
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    public AppException(int codigo, String mensaje, Throwable thrwbl) {
        super(thrwbl);
        this.codigo = codigo;
        this.mensaje = mensaje;
    }
  
    
}
