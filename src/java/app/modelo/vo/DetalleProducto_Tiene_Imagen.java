package app.modelo.vo;

import app.utils.interfaces.IVo;

public class DetalleProducto_Tiene_Imagen  implements IVo {


    int Id_DetalleProducto_tiene_Imagen;
    int Imagen_idImagen;
    int DetalleProducto_Oferta_idOferta;
    int DetalleProducto_Producto_idProducto;

public DetalleProducto_Tiene_Imagen(){}


    public int getId_DetalleProducto_tiene_Imagen(){
        return Id_DetalleProducto_tiene_Imagen;
    }
    public int getImagen_idImagen(){
        return Imagen_idImagen;
    }
    public int getDetalleProducto_Oferta_idOferta(){
        return DetalleProducto_Oferta_idOferta;
    }
    public int getDetalleProducto_Producto_idProducto(){
        return DetalleProducto_Producto_idProducto;
    }



    public void setId_DetalleProducto_tiene_Imagen(int Id_DetalleProducto_tiene_Imagen){
        this.Id_DetalleProducto_tiene_Imagen = Id_DetalleProducto_tiene_Imagen;
    }
    public void setImagen_idImagen(int Imagen_idImagen){
        this.Imagen_idImagen = Imagen_idImagen;
    }
    public void setDetalleProducto_Oferta_idOferta(int DetalleProducto_Oferta_idOferta){
        this.DetalleProducto_Oferta_idOferta = DetalleProducto_Oferta_idOferta;
    }
    public void setDetalleProducto_Producto_idProducto(int DetalleProducto_Producto_idProducto){
        this.DetalleProducto_Producto_idProducto = DetalleProducto_Producto_idProducto;
    }

}
