package app.modelo.dao;

import app.modelo.Conectar;
import app.modelo.vo.Ubicacion;
import app.utils.AppException;
import app.utils.interfaces.IDao;
import java.sql.CallableStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UbicacionDAO implements IDao<Ubicacion> {

    public ArrayList<Ubicacion> Consultar() throws AppException {
        ArrayList<Ubicacion> list = new ArrayList<Ubicacion>();
        
        String sql = "{CALL buscaofertas.consultarUbicacion()}";
        ResultSet rs = null;
        CallableStatement cst = null;
        try {
            cst = Conectar.getCnn().prepareCall(sql);
            rs = cst.executeQuery();
            while (rs.next()) {
                Ubicacion vo = new Ubicacion();
                vo.setIdUbicacion(rs.getInt(1));
                vo.setNombreTienda(rs.getString(2));
                vo.setDireccion(rs.getString(3));
                vo.setCiudad(rs.getString(4));
                list.add(vo);
            }
        } catch (SQLException ex) {
            throw new AppException(-2, "error al acceder a ubicación"+ex.getMessage());
        } catch (Exception ex) {
            throw new AppException(-2, "error al acceder a ubicación"+ex.getMessage());
        } finally {
            try {
                cst.close();
                rs.close();
                
            } catch (Exception ex) {
            }
        }
        return list;
    }

    public int Insertar(Ubicacion vo) throws AppException {
        
        String sql = "CALL buscaofertas.insertUbicacion(?,?,?)";
        CallableStatement cst = null;
        try {
            cst = Conectar.getCnn().prepareCall(sql);
            int i = 1;
            cst.setString(i++, vo.getNombreTienda());
            cst.setString(i++, vo.getDireccion());
            cst.setString(i++, vo.getCiudad());
            ResultSet rs = cst.executeQuery();
            int id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
            }
            return id;
        } catch (SQLException ex) {
            throw new AppException(-2, "error al agregar ubicación"+ex.getMessage());
        } catch (Exception ex) {
            throw new AppException(-2, "error al agregar ubicación"+ex.getMessage());
        } finally {
            try {
                cst.close();
                
            } catch (Exception ex) {
            }
        }
    }

    public void Modificar(Ubicacion vo) throws AppException {
        
        String sql = "{CALL buscaofertas.modificarUbicacion(?,?,?,?)}";
        CallableStatement cst = null;
        try {
            cst = Conectar.getCnn().prepareCall(sql);
            int i = 1;
            cst.setString(i++, vo.getNombreTienda());
            cst.setString(i++, vo.getDireccion());
            cst.setString(i++, vo.getCiudad());
            cst.setInt(i++, vo.getIdUbicacion());
            cst.executeUpdate();
        } catch (SQLException ex) {
            throw new AppException(-2, "error al acceder a ubicación"+ex.getMessage());
        } catch (Exception ex) {
            throw new AppException(-2, "error al acceder a ubicación"+ex.getMessage());
        } finally {
            try {
                cst.close();
                
            } catch (Exception ex) {
            }
        }
    }

    public void Eliminar(Ubicacion vo) throws AppException {
        
        String sql = "{CALL buscaofertas.eliminarUbicacion(?)}";
        CallableStatement cst = null;
        try {
            cst = Conectar.getCnn().prepareCall(sql);
            cst.setInt(1, vo.getIdUbicacion());
            cst.executeUpdate();
        } catch (SQLException ex) {
            throw new AppException(-2, "error al acceder a ubicación"+ex.getMessage());
        } catch (Exception ex) {
            throw new AppException(-2, "error al acceder a ubicación"+ex.getMessage());
        } finally {
            try {
                cst.close();
                
            } catch (Exception ex) {
            }
        }
    }

    @Override
    public Ubicacion ObtenerId(Ubicacion vo) throws AppException {
        ArrayList<Ubicacion> list = new ArrayList<Ubicacion>();
        
        String sql = "{CALL buscaofertas.obtenerIdUbicacion(?)}";
        ResultSet rs = null;
        CallableStatement cst = null;
        try {
            cst = Conectar.getCnn().prepareCall(sql);
            cst.setInt(1, vo.getIdUbicacion());

            rs = cst.executeQuery();
            if (rs.next()) {
                Ubicacion voTemp = new Ubicacion();
                voTemp.setIdUbicacion(rs.getInt(1));
                voTemp.setNombreTienda(rs.getString(2));
                voTemp.setDireccion(rs.getString(3));
                voTemp.setCiudad(rs.getString(4));
                list.add(voTemp);
            }
        } catch (SQLException ex) {
            throw new AppException(-2, "error al acceder a ubicación"+ex.getMessage());
        } catch (Exception ex) {
            throw new AppException(-2, "error al acceder a ubicación"+ex.getMessage());
        } finally {
            try {
                cst.close();
                rs.close();
                
            } catch (Exception ex) {
            }
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        Ubicacion ubicacion = new Ubicacion();
        ubicacion.setCiudad("Bogotá");
        ubicacion.setDireccion("cra4 calle 22");
        ubicacion.setNombreTienda("Plaza de Paloquemao");
        ubicacion.setIdUbicacion(1234);
        UbicacionDAO dao = new UbicacionDAO();
        try {
            int id = dao.Insertar(ubicacion);
            System.out.println("id de ubicacion: " + id);
            
        } catch (AppException ex) {
            System.out.println("error: " + ex.getMessage());
        }
    }
}
