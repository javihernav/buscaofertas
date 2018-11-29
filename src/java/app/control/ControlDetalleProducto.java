/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.control;

import app.modelo.dao.DetalleProductoDAO;
import app.modelo.vo.DetalleProducto;
import java.sql.Connection;

/**
 *
 * @author JAVIER
 */
public class ControlDetalleProducto extends ControlGenerico<DetalleProductoDAO,DetalleProducto>{

    public ControlDetalleProducto(Connection cnn) {
        super(cnn, new DetalleProductoDAO(cnn));
    }
    
}
