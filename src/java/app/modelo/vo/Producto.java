package app.modelo.vo;

import app.utils.interfaces.IVo;

public class Producto  implements IVo {


    int idProducto;
    int Tipo_idTipo;
    int Marca_idMarca;
    String nombreProducto;
    String fabricanteProducto;
    String modeloProducto;
    String presentacionProducto;

public Producto(){}


    public int getIdProducto(){
        return idProducto;
    }
    public int getTipo_idTipo(){
        return Tipo_idTipo;
    }
    public int getMarca_idMarca(){
        return Marca_idMarca;
    }
    public String getNombreProducto(){
        return nombreProducto;
    }
    public String getFabricanteProducto(){
        return fabricanteProducto;
    }
    public String getModeloProducto(){
        return modeloProducto;
    }
    public String getPresentacionProducto(){
        return presentacionProducto;
    }



    public void setIdProducto(int idProducto){
        this.idProducto = idProducto;
    }
    public void setTipo_idTipo(int Tipo_idTipo){
        this.Tipo_idTipo = Tipo_idTipo;
    }
    public void setMarca_idMarca(int Marca_idMarca){
        this.Marca_idMarca = Marca_idMarca;
    }
    public void setNombreProducto(String nombreProducto){
        this.nombreProducto = nombreProducto;
    }
    public void setFabricanteProducto(String fabricanteProducto){
        this.fabricanteProducto = fabricanteProducto;
    }
    public void setModeloProducto(String modeloProducto){
        this.modeloProducto = modeloProducto;
    }
    public void setPresentacionProducto(String presentacionProducto){
        this.presentacionProducto = presentacionProducto;
    }

}
