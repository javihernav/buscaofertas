/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.control;

import app.modelo.dao.CategoriaDAO;
import app.modelo.vo.Categoria;
import java.sql.Connection;

/**
 *
 * @author JAVIER
 */
public class ControlCategoria extends ControlGenerico<CategoriaDAO,Categoria>{

    public ControlCategoria(Connection cnn) {
        super(cnn, new CategoriaDAO(cnn));
    }
    
}
