/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.control;

import app.modelo.dao.OfertaDAO;
import app.modelo.vo.Oferta;
import app.utils.AppException;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author JAVIER
 */
public class ControlOferta extends ControlGenerico<OfertaDAO, Oferta>{

    public ControlOferta(Connection cnn) {
        super(cnn, new OfertaDAO());
    }
    public ArrayList<Oferta> consultarPorIdUsuario(int idUsuario) throws AppException{
        OfertaDAO ofertaDao = new OfertaDAO();
        return ofertaDao.consultarPorIdUsuario(idUsuario);
    }
    public Oferta consultarPorIdOferta(int idOferta) throws AppException{
        OfertaDAO ofertaDao = new OfertaDAO();
        return ofertaDao.consultarPorIdOferta(idOferta);
        
    }
}
