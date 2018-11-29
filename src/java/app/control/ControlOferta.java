/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.control;

import app.modelo.dao.OfertaDAO;
import app.modelo.vo.Oferta;
import java.sql.Connection;

/**
 *
 * @author JAVIER
 */
public class ControlOferta extends ControlGenerico<OfertaDAO, Oferta>{

    public ControlOferta(Connection cnn) {
        super(cnn, new OfertaDAO());
    }
    
}
