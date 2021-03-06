package app.modelo.vo;

import app.utils.interfaces.IVo;
import java.util.Date;

public class Oferta  implements IVo {


    private int idOferta;
    private int Usuario_idUsuario;
    private String nombreOferta;
    private Date fechaCreacion;
    private Date fechaInicio;
    private Date fechaFin;
    private int vecesCompartida;

    public Oferta(int idOferta, int Usuario_idUsuario, String nombreOferta, Date fechaCreacion, Date fechaInicio, Date fechaFin, int vecesCompartida) {
        this.idOferta = idOferta;
        this.Usuario_idUsuario = Usuario_idUsuario;
        this.nombreOferta = nombreOferta;
        this.fechaCreacion = fechaCreacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.vecesCompartida = vecesCompartida;
    }

public Oferta(){}


    public int getIdOferta(){
        return idOferta;
    }
    public int getUsuario_idUsuario(){
        return Usuario_idUsuario;
    }
    public String getNombreOferta(){
        return nombreOferta;
    }
    public Date getFechaCreacion(){
        return fechaCreacion;
    }
    public Date getFechaInicio(){
        return fechaInicio;
    }
    public Date getFechaFin(){
        return fechaFin;
    }
    public int getVecesCompartida(){
        return vecesCompartida;
    }



    public void setIdOferta(int idOferta){
        this.idOferta = idOferta;
    }
    public void setUsuario_idUsuario(int Usuario_idUsuario){
        this.Usuario_idUsuario = Usuario_idUsuario;
    }
    public void setNombreOferta(String nombreOferta){
        this.nombreOferta = nombreOferta;
    }
    public void setFechaCreacion(Date fechaCreacion){
        this.fechaCreacion = fechaCreacion;
    }
    public void setFechaInicio(Date fechaInicio){
        this.fechaInicio = fechaInicio;
    }
    public void setFechaFin(Date fechaFin){
        this.fechaFin = fechaFin;
    }
    public void setVecesCompartida(int vecesCompartida){
        this.vecesCompartida = vecesCompartida;
    }
    
    @Override
    public String toString(){
        return "idUsuario: "+this.getUsuario_idUsuario()+ " idOferta: "+this.getIdOferta()+" Nombre Oferta: "+this.getNombreOferta()+" Fecha Inicio: "+this.getFechaInicio().toString()+" Fecha Final: "+this.getFechaFin().toString();
    }
   
}
