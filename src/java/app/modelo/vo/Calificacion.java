package app.modelo.vo;

import app.utils.interfaces.IVo;

public class Calificacion implements IVo {

    int idCalificacion;
    int idUsuario;
    int idOferta;
    int puntosPrecio;
    int puntosCalidad;
    String resumen;
    String opinion;

    public Calificacion() {
    }

    public Calificacion(int idCalificacion, int idUsuario, int idOferta, int puntosPrecio, int puntosCalidad, String resumen, String opinion) {
        this.idCalificacion = idCalificacion;
        this.idUsuario = idUsuario;
        this.idOferta = idOferta;
        this.puntosPrecio = puntosPrecio;
        this.puntosCalidad = puntosCalidad;
        this.resumen = resumen;
        this.opinion = opinion;
    }

    public int getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(int idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(int idOferta) {
        this.idOferta = idOferta;
    }

    public int getPuntosPrecio() {
        return puntosPrecio;
    }

    public void setPuntosPrecio(int puntosPrecio) {
        this.puntosPrecio = puntosPrecio;
    }

    public int getPuntosCalidad() {
        return puntosCalidad;
    }

    public void setPuntosCalidad(int puntosCalidad) {
        this.puntosCalidad = puntosCalidad;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    @Override
    public String toString() {
        return "Calificacion [" + "idCalificacion " + idCalificacion + " " + "idOferta " + idOferta + " " + "idUsuario " + idUsuario + " " + "opinion " + opinion + " " + "puntosCalidad " + puntosCalidad + " " + "puntosPrecio " + puntosPrecio + " " + "resumen " + resumen + "]";
    }
    

}
