/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.control;

import app.modelo.dao.UbicacionDAO;
import app.modelo.vo.Ubicacion;
import java.sql.Connection;

/**
 *
 * @author JAVIER
 */
public class ControlUbicacion extends ControlGenerico<UbicacionDAO,Ubicacion>{

    public ControlUbicacion(Connection cnn) {
        super(cnn, new UbicacionDAO());
    }
    
}
