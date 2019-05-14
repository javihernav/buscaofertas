package app.modelo.vo;

import app.utils.interfaces.IVo;
import java.io.InputStream;
import java.util.Arrays;

public class Imagen implements IVo {

    int idImagen;
    String nombreImagen;
    private InputStream fotoInputStream;
    private byte[] fotoByteArray;

    /**
     * @return the foto2
     */
    public InputStream getFotoInputStream() {
        return fotoInputStream;
    }

    /**
     * @param foto2 the foto2 to set
     */
    public void setFotoInputStream(InputStream foto2) {
        this.fotoInputStream = foto2;
    }

    /**
     * @return the foto
     */
    public byte[] getFotoByteArray() {
        return fotoByteArray;
    }

    /**
     * @param foto the foto to set
     */
    public void setFotoByteArray(byte[] foto) {
        this.fotoByteArray = foto;
    }

    public Imagen() {
    }

    public int getIdImagen() {
        return idImagen;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public void setNombreImagen(String linkImagen) {
        this.nombreImagen = linkImagen;
    }

    @Override
    public String toString() {
        return "Imagen [" + "fotoByteArray " + Arrays.toString(fotoByteArray) + " " + "fotoInputStream " + fotoInputStream + " " + "idImagen " + idImagen + " " + "nombreImagen " + nombreImagen + "]";
    }



}
