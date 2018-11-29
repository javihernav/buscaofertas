/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.control;

import app.modelo.dao.MarcaDAO;
import app.modelo.vo.Marca;
import java.sql.Connection;

/**
 *
 * @author JAVIER
 */
public class ControlMarca extends ControlGenerico<MarcaDAO,Marca>{

    public ControlMarca(Connection cnn) {
        super(cnn, new MarcaDAO());
    }
    
}
