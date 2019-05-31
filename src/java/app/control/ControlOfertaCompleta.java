/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.control;

import app.modelo.dao.OfertaCompletaDAO;
import app.modelo.dao.OfertaDAO;
import app.modelo.vo.Oferta;
import app.modelo.vo.OfertaCompleta;
import app.utils.AppException;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author JAVIER
 */
public class ControlOfertaCompleta extends ControlGenerico<OfertaDAO, Oferta> {

    public ControlOfertaCompleta(Connection cnn) {
        super(cnn, new OfertaDAO());
    }

    public ArrayList<Oferta> consultarPorIdUsuario(int idUsuario) throws AppException {
        OfertaDAO ofertaDao = new OfertaDAO();
        return ofertaDao.consultarPorIdUsuario(idUsuario);
    }

    public OfertaCompleta consultarOfertaCompletaPorIdOferta(int idOferta) throws AppException {
        OfertaCompletaDAO ofertaCompletaDao = new OfertaCompletaDAO();
        return ofertaCompletaDao.consultarOfertaCompletaPorIdOferta(idOferta);
    }

    public ArrayList<OfertaCompleta> ConsultarOfertaCompleta(String consulta) throws AppException {
        OfertaCompletaDAO ofertaCompletaDAO = new OfertaCompletaDAO();
        return ofertaCompletaDAO.ConsultarOfertaCompleta(consulta);
    }
}
