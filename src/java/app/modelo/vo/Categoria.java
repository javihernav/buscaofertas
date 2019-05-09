package app.modelo.vo;

import app.utils.interfaces.IVo;

public class Categoria implements IVo {

    int idCategoria;
    String nombreCategoria;
    String categoriaPrincipal;

    public String getCategoriaPrincipal() {
        return categoriaPrincipal;
    }

    public void setCategoriaPrincipal(String categoriaPrincipal) {
        this.categoriaPrincipal = categoriaPrincipal;
    }

    public Categoria() {
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    @Override
    public String toString() {
        return "Categoria [" + "getCategoriaPrincipal " + getCategoriaPrincipal() + " " + "getIdCategoria " + getIdCategoria() + " " + "getNombreCategoria " + getNombreCategoria() + "]";
    }

}
