package app.modelo.dao;

import app.modelo.Conectar;
import app.modelo.vo.Calificacion;
import app.modelo.vo.Promedio;
import app.utils.AppException;
import app.utils.interfaces.IDao;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CalificacionDAO implements IDao<Calificacion> {

    Connection cnn;

    public CalificacionDAO(Connection cnn) {
        this.cnn = cnn;
    }

    public ArrayList<Calificacion> Consultar() throws AppException {
        ArrayList<Calificacion> list = new ArrayList<Calificacion>();

        String sql = "{CALL buscaofertas.consultarCalificaciones()}";
        ResultSet rs = null;
        CallableStatement cst = null;
        try {
            cst = Conectar.getCnn().prepareCall(sql);
            rs = cst.executeQuery();
            while (rs.next()) {
                Calificacion vo = new Calificacion();
                vo.setIdCalificacion(rs.getInt("idCalificacion"));
                vo.setIdUsuario(rs.getInt("idUsuario"));
                vo.setIdOferta(rs.getInt("idOferta"));
                vo.setPuntosPrecio(rs.getInt("puntosPrecio"));
                vo.setPuntosCalidad(rs.getInt("puntosCalidad"));
                vo.setResumen(rs.getString("resumen"));
                vo.setOpinion(rs.getString("opinion"));
                list.add(vo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                cst.close();
                rs.close();

            } catch (Exception ex) {
            }
        }
        return list;
    }
    public ArrayList<Calificacion> consultarCalificacionesOferta(int idOferta) throws AppException {
        ArrayList<Calificacion> list = new ArrayList<Calificacion>();

        String sql = "{CALL buscaofertas.consultarCalificaciones(?)}";
        ResultSet rs = null;
        CallableStatement cst = null;
        try {
            cst = Conectar.getCnn().prepareCall(sql);
            cst.setInt(1, idOferta);
            rs = cst.executeQuery();
            while (rs.next()) {
                Calificacion vo = new Calificacion();
                vo.setIdCalificacion(rs.getInt("idCalificacion"));
                vo.setIdUsuario(rs.getInt("idUsuario"));
                vo.setIdOferta(rs.getInt("idOferta"));
                vo.setPuntosPrecio(rs.getInt("puntosPrecio"));
                vo.setPuntosCalidad(rs.getInt("puntosCalidad"));
                vo.setResumen(rs.getString("resumen"));
                vo.setOpinion(rs.getString("opinion"));
                list.add(vo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                cst.close();
                rs.close();

            } catch (Exception ex) {
            }
        }
        return list;
    }
    public Promedio obtenerCalificacionPromedio(int idOferta) throws AppException {
        Promedio prom = new Promedio();

        String sql = "{CALL buscaofertas.obtenerCalificacionPromedio(?)}";
        ResultSet rs = null;
        CallableStatement cst = null;
        try {
            cst = Conectar.getCnn().prepareCall(sql);
            cst.setInt(1, idOferta);
            rs = cst.executeQuery();
            if (rs.next()) {
                prom.setPuntosCalidad(rs.getDouble("promedioCalidad"));
                prom.setPuntosPrecio(rs.getDouble("promedioPrecio"));
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                cst.close();
                rs.close();

            } catch (Exception ex) {
            }
        }
        return prom;
    }

    public int Insertar(Calificacion vo) throws AppException {

        String sql = "{CALL buscaofertas.insertCalificacion(?,?,?,?,?,?)}";
        CallableStatement cst = null;
        try {
            cst = Conectar.getCnn().prepareCall(sql);
            int i = 1;
            cst.setInt(i++, vo.getIdUsuario());
            cst.setInt(i++, vo.getIdOferta());
            cst.setInt(i++, vo.getPuntosPrecio());
            cst.setInt(i++, vo.getPuntosCalidad());
            cst.setString(i++, vo.getResumen());
            cst.setString(i++, vo.getOpinion());

            ResultSet rs = cst.executeQuery();
            int id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
            }
            return id;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                cst.close();

            } catch (Exception ex) {
            }
        }
        return 0;
    }

    public void Modificar(Calificacion vo) throws AppException {

        String sql = "{CALL buscaofertas.modificarCalificacion(?,?.?)}";
        CallableStatement cst = null;
        try {
            int i = 1;

            cst = Conectar.getCnn().prepareCall(sql);
            cst.setInt(i++, vo.getIdUsuario());
            cst.setInt(i++, vo.getIdOferta());
            cst.setInt(i++, vo.getPuntosPrecio());
            cst.setInt(i++, vo.getPuntosCalidad());
            cst.setString(i++, vo.getResumen());
            cst.setString(i++, vo.getOpinion());

            cst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                cst.close();

            } catch (Exception ex) {
            }
        }
    }

    public void Eliminar(Calificacion vo) throws AppException {

        String sql = "CALL buscaofertas.eliminarCalificacion(?)";
        CallableStatement cst = null;
        try {
            cst = Conectar.getCnn().prepareCall(sql);
            cst.setInt(1, vo.getIdCalificacion());
            cst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                cst.close();

            } catch (Exception ex) {
            }
        }
    }

    @Override
    public Calificacion ObtenerId(Calificacion vo) throws AppException {

        String sql = "{CALL buscaofertas.obtenerIdCalificacion(?,?)}";
        ResultSet rs = null;
        CallableStatement cst = null;
        try {
            cst = Conectar.getCnn().prepareCall(sql);
            cst.setInt(1, vo.getIdUsuario());
            cst.setInt(2, vo.getIdOferta());
            rs = cst.executeQuery();
            if (rs.next()) {
                Calificacion vo1 = new Calificacion();
                vo1.setIdCalificacion(rs.getInt("idCalificacion"));
                vo1.setIdUsuario(rs.getInt("idUsuario"));
                vo1.setIdOferta(rs.getInt("idOferta"));
                vo1.setPuntosPrecio(rs.getInt("puntosPrecio"));
                vo1.setPuntosCalidad(rs.getInt("puntosCalidad"));
                vo1.setResumen(rs.getString("resumen"));
                vo1.setOpinion(rs.getString("opinion"));
                return (vo1);
            }
        } catch (SQLException ex) {
            throw new AppException(-2, "error al consultar categoría" + ex.getMessage());
        } finally {
            try {
                cst.close();
                rs.close();

            } catch (Exception ex) {
            }
        }
        return null;
    }

}
