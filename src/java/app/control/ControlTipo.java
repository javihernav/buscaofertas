/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.control;

import app.modelo.dao.TipoDAO;
import app.modelo.vo.Tipo;
import java.sql.Connection;

/**
 *
 * @author JAVIER
 */
public class ControlTipo extends ControlGenerico<TipoDAO,Tipo>{

    public ControlTipo(Connection cnn) {
        super(cnn, new TipoDAO());
    }
    
}
