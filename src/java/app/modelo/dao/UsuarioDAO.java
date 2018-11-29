package app.modelo.dao;

import app.modelo.Conectar;
import app.modelo.vo.Usuario;
import app.utils.AppException;
import app.utils.interfaces.IDao;
import app.utils.interfaces.IVo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class UsuarioDAO implements IDao<Usuario>{


    public ArrayList<Usuario> Consultar() throws AppException {
        ArrayList<Usuario> list = new ArrayList<Usuario>();
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM usuario;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Usuario vo = new Usuario();
                vo.setIdUsuario(rs.getInt(1));
                vo.setCiudad_idCiudad(rs.getInt(2));
                vo.setNombreUsuario(rs.getString(3));
                vo.setContrasena(rs.getString(4));
                vo.setNombre(rs.getString(5));
                vo.setApellido(rs.getString(6));
                vo.setTelefono(rs.getString(7));
                vo.setCorreo(rs.getString(8));
                vo.setFechaNacimiento(rs.getString(9));
                vo.setGenero(rs.getString(10).charAt(0));
                vo.setRol(rs.getString(11));
                list.add(vo);
            }
        }catch(SQLException ex){
            throw new AppException(-2,"error al consultar datos:"+ex.getMessage());
        }finally{
            try{
                ps.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return list;
    }



    public void Insertar(Usuario vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "INSERT INTO usuario (Ciudad_idCiudad, nombreUsuario, contrasena, nombre, apellido, telefono, correo, fechaNacimiento, genero, rol) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement ps = null;
        try{
            int i=1;
            ps = conec.getCnn().prepareStatement(sql);
           // ps.setInt(1, vo.getIdUsuario());
            ps.setInt(i++, vo.getCiudad_idCiudad());
            ps.setString(i++, vo.getNombreUsuario());
            ps.setString(i++, vo.getContrasena());
            ps.setString(i++, vo.getNombre());
            ps.setString(i++, vo.getApellido());
            ps.setString(i++, vo.getTelefono());
            ps.setString(i++, vo.getCorreo());
            ps.setString(i++, vo.getFechaNacimiento());
            ps.setString(i++, String.valueOf(vo.getGenero()));
            ps.setString(i++, vo.getRol());
            ps.executeUpdate();
        }catch(SQLException ex){
            throw new AppException(-2,"error al insertar datos:"+ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }



    public void Modificar(Usuario vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "UPDATE usuario SET Ciudad_idCiudad = ?, nombreUsuario = ?, contrasena = ?, nombre = ?, apellido = ?, telefono = ?, correo = ?, fechaNacimiento = ?, genero = ?, rol = ? WHERE idUsuario = ?;";
        PreparedStatement ps = null;
        try{
            int i=1;
            ps = conec.getCnn().prepareStatement(sql);
            ps.setInt(i++, vo.getCiudad_idCiudad());
            ps.setString(i++, vo.getNombreUsuario());
            ps.setString(i++, vo.getContrasena());
            ps.setString(i++, vo.getNombre());
            ps.setString(i++, vo.getApellido());
            ps.setString(i++, vo.getTelefono());
            ps.setString(i++, vo.getCorreo());
            ps.setString(i++, vo.getFechaNacimiento());
            ps.setString(i++, String.valueOf(vo.getGenero()));
            ps.setString(i++, vo.getRol());
            ps.setInt(i++, vo.getIdUsuario());
            ps.executeUpdate();
        }catch(SQLException ex){
            throw new AppException(-2,"error al modificar datos:"+ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }



    public void Eliminar(Usuario vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "DELETE FROM usuario WHERE idUsuario = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            ps.setInt(1, vo.getIdUsuario());
            ps.executeUpdate();
        }catch(SQLException ex){
            throw new AppException(-2,"error al eliminar datos:"+ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){throw new AppException(-2,"error al eliminar datos:"+ex.getMessage());}
        }
    }

    @Override
    public Usuario ObtenerId(Usuario vo) throws AppException {
        ArrayList<Usuario> list = new ArrayList<Usuario>();
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM usuario where nombreUsuario = ?;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            ps.setString(1, vo.getNombreUsuario());
            rs = ps.executeQuery();
            while(rs.next()){
                Usuario voTemp = new Usuario();
                voTemp.setIdUsuario(rs.getInt(1));
                voTemp.setCiudad_idCiudad(rs.getInt(2));
                voTemp.setNombreUsuario(rs.getString(3));
                voTemp.setContrasena(rs.getString(4));
                voTemp.setNombre(rs.getString(5));
                voTemp.setApellido(rs.getString(6));
                voTemp.setTelefono(rs.getString(7));
                voTemp.setCorreo(rs.getString(8));
                voTemp.setFechaNacimiento(rs.getString(9));
                voTemp.setGenero(rs.getString(10).charAt(0));
                voTemp.setRol(rs.getString(11));
                list.add(voTemp);
            }
        }catch(SQLException ex){
            throw new AppException(-2,"error al consultar datos:"+ex.getMessage());
        }finally{
            try{
                ps.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return list.get(0);
    }
    public Usuario validarUsuario(Usuario vo) throws AppException {
        ArrayList<Usuario> list = new ArrayList<Usuario>();
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM usuario where nombreUsuario = ? and contrasena = ?;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            ps.setString(1, vo.getNombreUsuario());
            ps.setString(2, vo.getContrasena());
            rs = ps.executeQuery();
            while(rs.next()){
                Usuario voTemp = new Usuario();
                voTemp.setIdUsuario(rs.getInt(1));
                voTemp.setCiudad_idCiudad(rs.getInt(2));
                voTemp.setNombreUsuario(rs.getString(3));
                voTemp.setContrasena(rs.getString(4));
                voTemp.setNombre(rs.getString(5));
                voTemp.setApellido(rs.getString(6));
                voTemp.setTelefono(rs.getString(7));
                voTemp.setCorreo(rs.getString(8));
                voTemp.setFechaNacimiento(rs.getString(9));
                voTemp.setGenero(rs.getString(10).charAt(0));
                voTemp.setRol(rs.getString(11));
                list.add(voTemp);
                
            }
        }catch(SQLException ex){
            throw new AppException(-2,"error al consultar datos:"+ex.getMessage());
        }finally{
            try{
                ps.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return list.get(0);
    }



}
