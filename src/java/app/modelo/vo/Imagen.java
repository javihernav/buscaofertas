package app.modelo.vo;

import app.utils.interfaces.IVo;
import java.io.InputStream;

public class Imagen implements IVo {

    /**
     * @return the foto2
     */
    public InputStream getFoto2() {
        return foto2;
    }

    /**
     * @param foto2 the foto2 to set
     */
    public void setFoto2(InputStream foto2) {
        this.foto2 = foto2;
    }

    /**
     * @return the foto
     */
    public byte[] getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    int idImagen;
    String linkImagen;
    private InputStream foto2;
    private byte[] foto;

    public Imagen() {
    }

    public int getIdImagen() {
        return idImagen;
    }

    public String getLinkImagen() {
        return linkImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public void setLinkImagen(String linkImagen) {
        this.linkImagen = linkImagen;
    }

}
