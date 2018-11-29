/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.utils.interfaces;

import app.utils.AppException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author JAVIER
 */
public interface IDao<T extends IVo> {
    
    public void Insertar(T vo)throws AppException;
    public void Modificar(T vo)throws AppException;
    public void Eliminar(T vo)throws AppException;
    public List<T> Consultar()throws AppException;
    public T ObtenerId(T vo)throws AppException;
}
