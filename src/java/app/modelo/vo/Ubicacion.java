package app.modelo.vo;

import app.utils.interfaces.IVo;

public class Ubicacion  implements IVo {


    int idUbicacion;
    String nombreTienda;
    String direccion;
    String ciudad;

public Ubicacion(){}


    public int getIdUbicacion(){
        return idUbicacion;
    }
    public String getNombreTienda(){
        return nombreTienda;
    }
    public String getDireccion(){
        return direccion;
    }
    public String getCiudad(){
        return ciudad;
    }



    public void setIdUbicacion(int idUbicacion){
        this.idUbicacion = idUbicacion;
    }
    public void setNombreTienda(String nombreTienda){
        this.nombreTienda = nombreTienda;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    public void setCiudad(String ciudad){
        this.ciudad = ciudad;
    }

}
