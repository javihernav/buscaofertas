package app.modelo.vo;

import app.utils.interfaces.IVo;

public class Tipo  implements IVo {


    int idTipo;
    int Categoria_idCategoria;
    String nombreTipo;

public Tipo(){}


    public int getIdTipo(){
        return idTipo;
    }
    public int getCategoria_idCategoria(){
        return Categoria_idCategoria;
    }
    public String getNombreTipo(){
        return nombreTipo;
    }



    public void setIdTipo(int idTipo){
        this.idTipo = idTipo;
    }
    public void setCategoria_idCategoria(int Categoria_idCategoria){
        this.Categoria_idCategoria = Categoria_idCategoria;
    }
    public void setNombreTipo(String nombreTipo){
        this.nombreTipo = nombreTipo;
    }

    @Override
    public String toString() {
        return "Tipo [" + "getCategoria_idCategoria " + getCategoria_idCategoria() + " " + "getIdTipo " + getIdTipo() + " " + "getNombreTipo " + getNombreTipo() + "]";
    }

}
