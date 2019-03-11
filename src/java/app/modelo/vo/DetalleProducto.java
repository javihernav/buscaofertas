package app.modelo.vo;

import app.utils.interfaces.IVo;

public class DetalleProducto  implements IVo {


    int Oferta_idOferta;
    int Producto_idProducto;
    double precio;

    public DetalleProducto(int Oferta_idOferta, int Producto_idProducto, double precio) {
        this.Oferta_idOferta = Oferta_idOferta;
        this.Producto_idProducto = Producto_idProducto;
        this.precio = precio;
    }


public DetalleProducto(){}


    public int getOferta_idOferta(){
        return Oferta_idOferta;
    }
    public int getProducto_idProducto(){
        return Producto_idProducto;
    }
    public double getPrecio(){
        return precio;
    }




    public void setOferta_idOferta(int Oferta_idOferta){
        this.Oferta_idOferta = Oferta_idOferta;
    }
    public void setProducto_idProducto(int Producto_idProducto){
        this.Producto_idProducto = Producto_idProducto;
    }
    public void setPrecio(double precio){
        this.precio = precio;
    }


}
