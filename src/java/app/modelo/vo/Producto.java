package app.modelo.vo;

import app.utils.interfaces.IVo;

public class Producto  implements IVo {


    int idProducto;
    int Categoria_idCategoria;
    
    int Marca_idMarca;
    String nombreProducto;

    public int getCategoria_idCategoria() {
        return Categoria_idCategoria;
    }

    public void setCategoria_idCategoria(int Categoria_idCategoria) {
        this.Categoria_idCategoria = Categoria_idCategoria;
    }


public Producto(){}


    public int getIdProducto(){
        return idProducto;
    }

    public int getMarca_idMarca(){
        return Marca_idMarca;
    }
    public String getNombreProducto(){
        return nombreProducto;
    }




    public void setIdProducto(int idProducto){
        this.idProducto = idProducto;
    }

    public void setMarca_idMarca(int Marca_idMarca){
        this.Marca_idMarca = Marca_idMarca;
    }
    public void setNombreProducto(String nombreProducto){
        this.nombreProducto = nombreProducto;
    }

    @Override
    public String toString() {
        return "Producto [" + "getCategoria_idCategoria " + getCategoria_idCategoria() + " " + "getIdProducto " + getIdProducto() + " " + "getMarca_idMarca " + getMarca_idMarca() + " " + "getNombreProducto " + getNombreProducto() + "]";
    }

}
