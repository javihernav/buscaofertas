package app.modelo.vo;

import app.utils.interfaces.IVo;
import java.util.Date;
import java.util.Arrays;

public class OfertaCompleta implements IVo {

    private int idOferta;
    private int idUsuario;
    private String nombreOferta;
    private Date fechaCreacion;
    private Date fechaInicio;
    private Date fechaFin;
    private int vecesCompartida;
    int Id_Oferta_tiene_Ubicacion;
    int idUbicacion;
    String nombreTienda;
    String direccion;
    String ciudad;
    int idProducto;
    String nombreProducto;
    int precio;
    int idCategoria;
    String nombreCategoria;
    int idMarca;
    String categoriaPrincipal;
    int Id_DetalleProducto_tiene_Imagen;
    int idImagen;
    String linkImagen;
    byte[] foto;

    public OfertaCompleta(int idOferta, int idUsuario, String nombreOferta, Date fechaCreacion, Date fechaInicio, Date fechaFin, int vecesCompartida, int Id_Oferta_tiene_Ubicacion, int idUbicacion, String nombreTienda, String direccion, String ciudad, int idProducto, String nombreProducto, int precio, int idCategoria, String nombreCategoria, int idMarca, String categoriaPrincipal, int Id_DetalleProducto_tiene_Imagen, int idImagen, String linkImagen, byte[] foto) {
        this.idOferta = idOferta;
        this.idUsuario = idUsuario;
        this.nombreOferta = nombreOferta;
        this.fechaCreacion = fechaCreacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.vecesCompartida = vecesCompartida;
        this.Id_Oferta_tiene_Ubicacion = Id_Oferta_tiene_Ubicacion;
        this.idUbicacion = idUbicacion;
        this.nombreTienda = nombreTienda;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.idMarca = idMarca;
        this.categoriaPrincipal = categoriaPrincipal;
        this.Id_DetalleProducto_tiene_Imagen = Id_DetalleProducto_tiene_Imagen;
        this.idImagen = idImagen;
        this.linkImagen = linkImagen;
        this.foto = foto;
    }

    public OfertaCompleta() {
    }

    public int getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(int idOferta) {
        this.idOferta = idOferta;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreOferta() {
        return nombreOferta;
    }

    public void setNombreOferta(String nombreOferta) {
        this.nombreOferta = nombreOferta;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getVecesCompartida() {
        return vecesCompartida;
    }

    public void setVecesCompartida(int vecesCompartida) {
        this.vecesCompartida = vecesCompartida;
    }

    public int getId_Oferta_tiene_Ubicacion() {
        return Id_Oferta_tiene_Ubicacion;
    }

    public void setId_Oferta_tiene_Ubicacion(int Id_Oferta_tiene_Ubicacion) {
        this.Id_Oferta_tiene_Ubicacion = Id_Oferta_tiene_Ubicacion;
    }

    public int getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(int idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getCategoriaPrincipal() {
        return categoriaPrincipal;
    }

    public void setCategoriaPrincipal(String categoriaPrincipal) {
        this.categoriaPrincipal = categoriaPrincipal;
    }

    public int getId_DetalleProducto_tiene_Imagen() {
        return Id_DetalleProducto_tiene_Imagen;
    }

    public void setId_DetalleProducto_tiene_Imagen(int Id_DetalleProducto_tiene_Imagen) {
        this.Id_DetalleProducto_tiene_Imagen = Id_DetalleProducto_tiene_Imagen;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getLinkImagen() {
        return linkImagen;
    }

    public void setLinkImagen(String linkImagen) {
        this.linkImagen = linkImagen;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "OfertaCompleta [" + "Id_DetalleProducto_tiene_Imagen " + Id_DetalleProducto_tiene_Imagen + " " + "Id_Oferta_tiene_Ubicacion " + Id_Oferta_tiene_Ubicacion + " " + "categoriaPrincipal " + categoriaPrincipal + " " + "ciudad " + ciudad + " " + "direccion " + direccion + " " + "fechaCreacion " + fechaCreacion + " " + "fechaFin " + fechaFin + " " + "fechaInicio " + fechaInicio + " " + "foto " + Arrays.toString(foto) + " " + "idCategoria " + idCategoria + " " + "idImagen " + idImagen + " " + "idMarca " + idMarca + " " + "idOferta " + idOferta + " " + "idProducto " + idProducto + " " + "idUbicacion " + idUbicacion + " " + "idUsuario " + idUsuario + " " + "linkImagen " + linkImagen + " " + "nombreCategoria " + nombreCategoria + " " + "nombreOferta " + nombreOferta + " " + "nombreProducto " + nombreProducto + " " + "nombreTienda " + nombreTienda + " " + "precio " + precio + " " + "vecesCompartida " + vecesCompartida + "]";
    }

}
