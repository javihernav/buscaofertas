package app.modelo.vo;

import app.utils.interfaces.IVo;

public class Oferta_Tiene_Ubicacion  implements IVo {


    int Id_Oferta_tiene_Ubicacion;
    int Oferta_idOferta;
    int Ubicacion_idUbicacion;

public Oferta_Tiene_Ubicacion(){}

    public Oferta_Tiene_Ubicacion(int Oferta_idOferta, int Ubicacion_idUbicacion) {
        this.Oferta_idOferta = Oferta_idOferta;
        this.Ubicacion_idUbicacion = Ubicacion_idUbicacion;
    }


    public int getId_Oferta_tiene_Ubicacion(){
        return Id_Oferta_tiene_Ubicacion;
    }
    public int getOferta_idOferta(){
        return Oferta_idOferta;
    }
    public int getUbicacion_idUbicacion(){
        return Ubicacion_idUbicacion;
    }



    public void setId_Oferta_tiene_Ubicacion(int Id_Oferta_tiene_Ubicacion){
        this.Id_Oferta_tiene_Ubicacion = Id_Oferta_tiene_Ubicacion;
    }
    public void setOferta_idOferta(int Oferta_idOferta){
        this.Oferta_idOferta = Oferta_idOferta;
    }
    public void setUbicacion_idUbicacion(int Ubicacion_idUbicacion){
        this.Ubicacion_idUbicacion = Ubicacion_idUbicacion;
    }

    @Override
    public String toString() {
        return "Oferta_Tiene_Ubicacion [" + "getId_Oferta_tiene_Ubicacion " + getId_Oferta_tiene_Ubicacion() + " " + "getOferta_idOferta " + getOferta_idOferta() + " " + "getUbicacion_idUbicacion " + getUbicacion_idUbicacion() + "]";
    }

}
