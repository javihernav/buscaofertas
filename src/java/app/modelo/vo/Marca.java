package app.modelo.vo;

import app.utils.interfaces.IVo;

public class Marca  implements IVo {

    int idMarca;
    String nombreMarca;


    @Override
    public String toString() {
        return "Marca [" + "getIdMarca " + getIdMarca() + " " + "getNombreMarca " + getNombreMarca() + " " + "idMarca " + idMarca + " " + "nombreMarca " + nombreMarca + "]";
    }

public Marca(){}


    public int getIdMarca(){
        return idMarca;
    }
    public String getNombreMarca(){
        return nombreMarca;
    }



    public void setIdMarca(int idMarca){
        this.idMarca = idMarca;
    }
    public void setNombreMarca(String nombreMarca){
        this.nombreMarca = nombreMarca;
    }

}
