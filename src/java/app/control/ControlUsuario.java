/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.control;

import app.modelo.dao.UsuarioDAO;
import app.modelo.vo.Usuario;

import app.utils.AppException;
import app.utils.interfaces.IDao;
import java.sql.Connection;

/**
 *
 * @author JAVIER
 */
public class ControlUsuario extends ControlGenerico<UsuarioDAO,Usuario>{

    public ControlUsuario(Connection cnn) {
        super(cnn, new UsuarioDAO());
    }
    public Usuario validarUsuario(Usuario vo) throws AppException {
        return this.getDao().validarUsuario(vo);
    }
    public Usuario obtenerPorId(Usuario vo) throws AppException {
        return this.getDao().ObtenerPorId(vo);
    }
}
