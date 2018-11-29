package  app.modelo.vo;

import app.utils.interfaces.IVo;

public class Ciudad implements IVo  {


    int idCiudad;
    String nombreCiudad;
    String departamentoCiudad;

public Ciudad(){}


    public int getIdCiudad(){
        return idCiudad;
    }
    public String getNombreCiudad(){
        return nombreCiudad;
    }
    public String getDepartamentoCiudad(){
        return departamentoCiudad;
    }



    public void setIdCiudad(int idCiudad){
        this.idCiudad = idCiudad;
    }
    public void setNombreCiudad(String nombreCiudad){
        this.nombreCiudad = nombreCiudad;
    }
    public void setDepartamentoCiudad(String departamentoCiudad){
        this.departamentoCiudad = departamentoCiudad;
    }

}
