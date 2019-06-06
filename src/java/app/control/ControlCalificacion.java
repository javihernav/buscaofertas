/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.control;

import app.modelo.dao.CalificacionDAO;
import app.modelo.dao.CategoriaDAO;
import app.modelo.vo.Calificacion;
import app.modelo.vo.Categoria;
import app.modelo.vo.Promedio;
import app.utils.AppException;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author JAVIER
 */
public class ControlCalificacion extends ControlGenerico<CalificacionDAO,Calificacion>{

    public ControlCalificacion(Connection cnn) {
        super(cnn, new CalificacionDAO(cnn));
    }
    public ArrayList<Calificacion> consultarCalificacionesOferta(int idOferta) throws AppException{
        return this.getDao().consultarCalificacionesOferta(idOferta);
    }
    public Promedio obtenerCalificacionPromedio(int idOferta) throws AppException{
        return this.getDao().obtenerCalificacionPromedio(idOferta);
    }
}
