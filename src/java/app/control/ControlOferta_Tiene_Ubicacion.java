/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.control;

import app.modelo.dao.Oferta_Tiene_UbicacionDAO;
import app.modelo.vo.Oferta_Tiene_Ubicacion;
import java.sql.Connection;

/**
 *
 * @author JAVIER
 */
public class ControlOferta_Tiene_Ubicacion extends ControlGenerico<Oferta_Tiene_UbicacionDAO,Oferta_Tiene_Ubicacion> {

    public ControlOferta_Tiene_Ubicacion(Connection cnn) {
        super(cnn, new Oferta_Tiene_UbicacionDAO());
    }
    
}
