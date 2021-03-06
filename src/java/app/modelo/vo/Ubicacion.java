package app.modelo.vo;

import app.utils.interfaces.IVo;

public class Ubicacion  implements IVo {


    int idUbicacion;
    String nombreTienda;
    String direccion;
    String ciudad;

public Ubicacion(){}

    public Ubicacion(String nombreTienda, String direccion, String ciudad) {
        this.nombreTienda = nombreTienda;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }


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

    @Override
    public String toString() {
        return "Ubicacion [" + "getCiudad " + getCiudad() + " " + "getDireccion " + getDireccion() + " " + "getIdUbicacion " + getIdUbicacion() + " " + "getNombreTienda " + getNombreTienda() + "]";
    }

}
