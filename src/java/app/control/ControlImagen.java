/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.control;

import app.modelo.dao.ImagenDAO;
import app.modelo.vo.Imagen;
import app.utils.AppException;
import java.sql.Connection;

/**
 *
 * @author JAVIER
 */
public class ControlImagen extends ControlGenerico<ImagenDAO,Imagen>{

    public ControlImagen(Connection cnn) {
        super(cnn, new ImagenDAO());
    }
    public Imagen ObtenerConNombre(Imagen vo) throws AppException{
        return this.getDao().ObtenerConNombre(vo);
    }
    
}
