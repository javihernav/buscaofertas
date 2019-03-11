/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.control;


import app.modelo.dao.CiudadDAO;
import app.modelo.vo.Ciudad;
import app.utils.interfaces.IDao;
import java.sql.Connection;

/**
 *
 * @author JAVIER
 */
public class ControlCiudad extends ControlGenerico<CiudadDAO,Ciudad>{

    public ControlCiudad(Connection cnn) {
        super(cnn, new CiudadDAO(cnn));
    }


    
}
