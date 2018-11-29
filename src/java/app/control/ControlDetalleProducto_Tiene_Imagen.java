/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.control;

import app.modelo.dao.DetalleProducto_Tiene_ImagenDAO;
import app.modelo.vo.DetalleProducto_Tiene_Imagen;
import java.sql.Connection;

/**
 *
 * @author JAVIER
 */
public class ControlDetalleProducto_Tiene_Imagen extends ControlGenerico<DetalleProducto_Tiene_ImagenDAO,DetalleProducto_Tiene_Imagen>{

    public ControlDetalleProducto_Tiene_Imagen(Connection cnn) {
        super(cnn, new DetalleProducto_Tiene_ImagenDAO());
    }
    
} 
