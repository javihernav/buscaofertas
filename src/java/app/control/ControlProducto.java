/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.control;

import app.modelo.dao.ProductoDAO;
import app.modelo.vo.Producto;
import java.sql.Connection;

/**
 *
 * @author JAVIER
 */
public class ControlProducto extends ControlGenerico<ProductoDAO, Producto>{

    public ControlProducto(Connection cnn) {
        super(cnn, new ProductoDAO());
    }
    
}
