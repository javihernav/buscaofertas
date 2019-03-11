/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.control;

import app.utils.AppException;
import app.utils.interfaces.IDao;
import app.utils.interfaces.IVo;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JAVIER
 */
public class ControlGenerico<T extends IDao, V extends IVo> {
    
    Connection cnn;
    private T dao;

    public ControlGenerico(Connection cnn, T dao) {
        this.cnn = cnn;
        this.dao = dao;
    }
    public int insertar(V vo) throws AppException{
        return getDao().Insertar(vo);
    }
    public void modificar(V vo) throws AppException{
        getDao().Modificar(vo);
    }
    public void eliminar(V vo) throws AppException{
        getDao().Eliminar(vo);
    }
    public List<V> consultar() throws AppException{
        return getDao().Consultar();
    }
    public V ObtenerId(V vo)throws AppException{
        return (V) getDao().ObtenerId(vo);
    }

    /**
     * @return the dao
     */
    public T getDao() {
        return dao;
    }

    /**
     * @param dao the dao to set
     */
    public void setDao(T dao) {
        this.dao = dao;
    }
}
