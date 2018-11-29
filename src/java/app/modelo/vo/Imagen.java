package app.modelo.vo;

import app.utils.interfaces.IVo;

public class Imagen  implements IVo {


    int idImagen;
    String linkImagen;

public Imagen(){}


    public int getIdImagen(){
        return idImagen;
    }
    public String getLinkImagen(){
        return linkImagen;
    }



    public void setIdImagen(int idImagen){
        this.idImagen = idImagen;
    }
    public void setLinkImagen(String linkImagen){
        this.linkImagen = linkImagen;
    }

}
