package app.modelo.dao;

import app.modelo.Conectar;
import app.modelo.vo.Usuario;
import app.utils.AppException;
import app.utils.EncriptacionAES;
import app.utils.interfaces.IDao;
import app.utils.interfaces.IVo;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import org.apache.commons.codec.digest.DigestUtils;

public class UsuarioDAO implements IDao<Usuario> {

    public ArrayList<Usuario> Consultar() throws AppException {
        ArrayList<Usuario> list = new ArrayList<>();
        Conectar conec = new Conectar();
        String sql = "{CALL buscaofertas.consultarUsuarios()}";
        ResultSet rs = null;

        CallableStatement cst = null;
        try {
            cst = conec.getCnn().prepareCall(sql);
            rs = cst.executeQuery();
        } catch (SQLException ex) {
            throw new AppException(-2, "error al ejecutar el procedimiento almacenado consultarUsuarios:" + ex.getMessage());
        }
        try {

            while (rs.next()) {
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
        } catch (SQLException ex) {
            throw new AppException(-2, "error al consultar datos:" + ex.getMessage());
        } finally {
            try {
                cst.close();
                rs.close();
                conec.desconectar();
            } catch (Exception ex) {
            }
        }
        return list;
    }

    public int Insertar(Usuario vo) throws AppException {
        Conectar conec = new Conectar();
        //String sql = "INSERT INTO usuario (Ciudad_idCiudad, nombreUsuario, contrasena, nombre, apellido, telefono, correo, fechaNacimiento, genero, rol) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        // Llamada al procedimiento almacenado
        CallableStatement cst;
        try {

            cst = conec.getCnn().prepareCall("{CALL buscaofertas.insertUsuario (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
        } catch (SQLException ex) {
            throw new AppException(-2, "error al preparar el procedimiento almacenado insertUsuario:" + ex.getMessage());
        }
        try {
            //int i = 1;
            //cst = conec.prepareStatement(sql);
            // cst.setInt(1, vo.getIdUsuario());
            cst.setInt(1, vo.getCiudad_idCiudad());
            cst.setString(2, vo.getNombreUsuario());
            //cst.setString(3, DigestUtils.sha1Hex(vo.getContrasena()));//encriptación de la clave con sha1
            cst.setString(3, EncriptacionAES.encriptar("buscaofertas1234","1234567890abcdef",vo.getContrasena()));//encriptación de la clave con AES
            System.out.println("clave sin encriptar: " + vo.getContrasena() + " longitud: " + vo.getContrasena().length());
            String clave = EncriptacionAES.encriptar("buscaofertas1234","1234567890abcdef",vo.getContrasena());
            System.out.println("clave encriptada: " + clave + " longitud: " + clave.length());

            cst.setString(4, vo.getNombre());
            cst.setString(5, vo.getApellido());
            cst.setString(6, vo.getTelefono());
            cst.setString(7, vo.getCorreo());
            cst.setString(8, vo.getFechaNacimiento());
            cst.setString(9, String.valueOf(vo.getGenero()));
            cst.setString(10, "usuario");/*vo.getRol()*/
            cst.registerOutParameter(11, java.sql.Types.INTEGER);

            // Ejecuta el procedimiento almacenado
            cst.execute();

            // Se obtiene la salida del procedimineto almacenado
            int id = 0;
            id = cst.getInt(11);
            System.out.println("id del usuario: " + id);

            return id;
        } catch (SQLException ex) {
            throw new AppException(-2, "error al insertar datos:" + ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                cst.close();
                conec.getCnn().close();
            } catch (Exception ex) {
            }
        }
        return 0;
    }

    /*
    public int Insertar(Usuario vo) throws AppException {
        Conectar conec = new Conectar();
        String sql = "INSERT INTO usuario (Ciudad_idCiudad, nombreUsuario, contrasena, nombre, apellido, telefono, correo, fechaNacimiento, genero, rol) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement ps = null;
        try {
            int i = 1;
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
            sql = "SELECT LAST_INSERT_ID();";
            ps = conec.getCnn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
            }
            return id;
        } catch (SQLException ex) {
            throw new AppException(-2, "error al insertar datos:" + ex.getMessage());
        } finally {
            try {
                ps.close();
                conec.desconectar();
            } catch (Exception ex) {
            }
        }
    }
     */
    public void Modificar(Usuario vo) throws AppException {
        Conectar conec = new Conectar();
        String sql = "CALL buscaofertas.modificarUsuario(?,?,?,?,?,?,?,?,?,?,?)";
        CallableStatement cst = null;
        try {
            int i = 1;
            cst = conec.getCnn().prepareCall(sql);
            cst.setInt(i++, vo.getCiudad_idCiudad());
            cst.setString(i++, vo.getNombreUsuario());
            cst.setString(i++, EncriptacionAES.encriptar("buscaofertas1234","1234567890abcdef",vo.getContrasena()));
            cst.setString(i++, vo.getNombre());
            cst.setString(i++, vo.getApellido());
            cst.setString(i++, vo.getTelefono());
            cst.setString(i++, vo.getCorreo());
            cst.setString(i++, vo.getFechaNacimiento());
            cst.setString(i++, String.valueOf(vo.getGenero()));
            cst.setString(i++, vo.getRol());
            cst.setInt(i++, vo.getIdUsuario());
            cst.executeUpdate();
        } catch (SQLException ex) {
            throw new AppException(-2, "error al modificar datos:" + ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                cst.close();
                conec.desconectar();
            } catch (Exception ex) {
            }
        }
    }

    public void Eliminar(Usuario vo) throws AppException {
        Conectar conec = new Conectar();
        String sql = "{CALL buscaofertas.eliminarUsuario(?)}";
        CallableStatement cst = null;
        try {
            cst = conec.getCnn().prepareCall(sql);
            cst.setInt(1, vo.getIdUsuario());
            cst.executeUpdate();
        } catch (SQLException ex) {
            throw new AppException(-2, "error al eliminar datos:" + ex.getMessage());
        } finally {
            try {
                cst.close();
                conec.desconectar();
            } catch (Exception ex) {
                throw new AppException(-2, "error al eliminar datos:" + ex.getMessage());
            }
        }
    }

    @Override
    public Usuario ObtenerId(Usuario vo) throws AppException {
//vo es un usuario que solo tiene nombreUsuario
        Conectar conec = new Conectar();
        String sql = "{CALL buscaofertas.obtenerIdUsuario(?)}";
        ResultSet rs = null;
        CallableStatement cst = null;
        try {
            cst = conec.getCnn().prepareCall(sql);
            cst.setString(1, vo.getNombreUsuario());
            rs = cst.executeQuery();
            Usuario voTemp = null;
            if (rs.next()) {
                voTemp = new Usuario();
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
                return (voTemp);
            }
            return null;
        } catch (SQLException ex) {
            throw new AppException(-2, "error al consultar datos:" + ex.getMessage());
        } finally {
            try {
                cst.close();
                rs.close();
                conec.desconectar();
            } catch (Exception ex) {
                throw new AppException(-2, "error al cerrar conexión:" + ex.getMessage());
            }
        }

    }

    public Usuario validarUsuario(Usuario vo) throws AppException {
        //usuario vo solo trae el nombreUsuario y la contraseña sin encriptar
        Conectar conec = new Conectar();

        CallableStatement cst;
        try {

            cst = conec.getCnn().prepareCall("{CALL buscaofertas.validarUsuario (?, ?)}");
        } catch (SQLException ex) {
            throw new AppException(-2, "error al preparar el procedimiento almacenado insertUsuario:" + ex.getMessage());
        }

        try {
            //int i = 1;
            cst.setString(1, vo.getNombreUsuario());
            cst.setString(2, EncriptacionAES.encriptar("buscaofertas1234","1234567890abcdef",vo.getContrasena()));//envía clave encriptada al procedimiento almacenado
            System.out.println("usuario enviado: " + vo.getNombreUsuario());
            System.out.println("clave enviada: " + EncriptacionAES.encriptar("buscaofertas1234","1234567890abcdef",vo.getContrasena()));

            ResultSet rs = cst.executeQuery();//cst.getResultSet();
            Usuario voTemp = null;
            if (rs.next()) {
                //String sql = "SELECT idUsuario, Ciudad_idCiudad, nombreUsuario, contrasena, nombre, apellido, telefono, correo, fechaNacimiento, genero, rol FROM usuario where nombreUsuario = ? and contrasena = ?;";
                voTemp = new Usuario();
                voTemp.setIdUsuario(rs.getInt("idUsuario"));
                voTemp.setCiudad_idCiudad(rs.getInt("Ciudad_idCiudad"));
                voTemp.setNombreUsuario(rs.getString("nombreUsuario"));
                voTemp.setContrasena(rs.getString("contrasena"));
                
                System.out.println("Usuario encontrado, usuario: " + voTemp.getNombreUsuario() + " clave: " + voTemp.getContrasena());
                voTemp.setNombre(rs.getString("nombre"));
                voTemp.setApellido(rs.getString("apellido"));
                voTemp.setTelefono(rs.getString("telefono"));
                voTemp.setCorreo(rs.getString("correo"));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                voTemp.setFechaNacimiento(sdf.format(rs.getDate("fechaNacimiento")));
                voTemp.setGenero(rs.getString("genero").charAt(0));
                voTemp.setRol(rs.getString("rol"));
                System.out.println(" usuvalidado " + voTemp.toString());
            }

            return voTemp;
        } catch (SQLException ex) {
            throw new AppException(-2, "error al consultar datos:" + ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                cst.close();

                conec.desconectar();
            } catch (Exception ex) {
            }
        }
        return null;
    }

}
