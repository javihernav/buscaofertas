package app.modelo.dao;

import app.modelo.Conectar;
import app.modelo.vo.Oferta;
import app.utils.AppException;
import app.utils.interfaces.IDao;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OfertaDAO implements IDao<Oferta> {

    public ArrayList<Oferta> Consultar() throws AppException {
        ArrayList<Oferta> list = new ArrayList<Oferta>();
        
        String sql = "{CALL buscaofertas.consultarOfertas()}";
        ResultSet rs = null;
        CallableStatement cst = null;
        try {
            cst = Conectar.getCnn().prepareCall(sql);
            rs = cst.executeQuery();
            while (rs.next()) {
                Oferta vo = new Oferta();
                vo.setIdOferta(rs.getInt(1));
                vo.setUsuario_idUsuario(rs.getInt(2));
                vo.setNombreOferta(rs.getString(3));
                vo.setFechaCreacion(rs.getDate(4));
                vo.setFechaInicio(rs.getDate(5));
                vo.setFechaFin(rs.getDate(6));
                vo.setVecesCompartida(rs.getInt(7));
                list.add(vo);
            }
        } catch (SQLException ex) {
            throw new AppException(-2, "error al acceder a Oferta"+ex.getMessage());
        } catch (Exception ex) {
            throw new AppException(-2, "error al acceder a Oferta"+ex.getMessage());
        } finally {
            try {
                cst.close();
                rs.close();
                
            } catch (Exception ex) {
            }
        }
        return list;
    }

    public ArrayList<Oferta> consultarPorIdUsuario(int idUsuario) throws AppException {
        ArrayList<Oferta> list = new ArrayList<Oferta>();
        
        String sql = "{CALL buscaofertas.consultarOfertasPorIdUsuario(?)}";
        ResultSet rs = null;
        CallableStatement cst = null;

        try {
            cst = Conectar.getCnn().prepareCall(sql);
            cst.setInt(1, idUsuario);
            rs = cst.executeQuery();
            while (rs.next()) {
                Oferta vo = new Oferta();
                vo.setIdOferta(rs.getInt(1));
                vo.setUsuario_idUsuario(rs.getInt(2));
                vo.setNombreOferta(rs.getString(3));
                vo.setFechaCreacion(rs.getDate(4));
                vo.setFechaInicio(rs.getDate(5));
                vo.setFechaFin(rs.getDate(6));
                vo.setVecesCompartida(rs.getInt(7));
                list.add(vo);
            }
        } catch (SQLException ex) {
            throw new AppException(-2, "error al acceder a Oferta"+ex.getMessage());
        } catch (Exception ex) {
            throw new AppException(-2, "error al acceder a Oferta"+ex.getMessage());
        } finally {
            try {
                cst.close();
                rs.close();
                
            } catch (Exception ex) {
            }
        }
        return list;
    }

    public Oferta consultarPorIdOferta(int idOferta) throws AppException {

        
        String sql = "CALL buscaofertas.consultarOfertasPorIdOferta(?)";
        ResultSet rs = null;
        CallableStatement cst = null;

        try {
            cst = Conectar.getCnn().prepareCall(sql);
            cst.setInt(1, idOferta);
            rs = cst.executeQuery();
            Oferta vo = null;
            if (rs.next()) {
                vo = new Oferta();
                vo.setIdOferta(rs.getInt(1));
                vo.setUsuario_idUsuario(rs.getInt(2));
                vo.setNombreOferta(rs.getString(3));
                vo.setFechaCreacion(rs.getDate(4));
                vo.setFechaInicio(rs.getDate(5));
                vo.setFechaFin(rs.getDate(6));
                vo.setVecesCompartida(rs.getInt(7));

            }
            if(vo==null)System.out.println("No se encontro la oferta con id = "+idOferta);
            return vo;
        } catch (SQLException ex) {
            throw new AppException(-2, "error al acceder a Oferta"+ex.getMessage());
        } catch (Exception ex) {
            throw new AppException(-2, "error al acceder a Oferta"+ex.getMessage());
        } finally {
            try {
                cst.close();
                rs.close();
                
            } catch (Exception ex) {
            }
        }
    }

    public int Insertar(Oferta vo) throws AppException {
        
        String sql = "{CALL buscaofertas.insertOferta(?,?,?,?,?,?)}";
        CallableStatement cst = null;
        try {
            cst = Conectar.getCnn().prepareCall(sql);
            int i = 1;
            cst.setInt(i++, vo.getUsuario_idUsuario());
            cst.setString(i++, vo.getNombreOferta());
            cst.setDate(i++, new java.sql.Date(vo.getFechaCreacion().getTime()));
            cst.setDate(i++, new java.sql.Date(vo.getFechaInicio().getTime()));
            cst.setDate(i++, new java.sql.Date(vo.getFechaFin().getTime()));
            cst.setInt(i++, vo.getVecesCompartida());
            cst.executeUpdate();
            ResultSet rs = cst.executeQuery();
            int id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
            }
            return id;
        } catch (SQLException ex) {
            throw new AppException(-2, "error al acceder a Oferta"+ex.getMessage());
        } catch (Exception ex) {
            throw new AppException(-2, "error al acceder a Oferta"+ex.getMessage());
        } finally {
            try {
                cst.close();
                
            } catch (Exception ex) {
            }
        }
    }

    public void Modificar(Oferta vo) throws AppException {
        
        String sql = "{CALL modificarOferta(?,?,?,?,?,?,?)}";
        CallableStatement cst = null;
        try {
            cst = Conectar.getCnn().prepareCall(sql);
            int i = 1;
            cst.setInt(i++, vo.getUsuario_idUsuario());
            cst.setString(i++, vo.getNombreOferta());
            cst.setDate(i++, new java.sql.Date(vo.getFechaCreacion().getTime()));
            cst.setDate(i++, new java.sql.Date(vo.getFechaInicio().getTime()));
            cst.setDate(i++, new java.sql.Date(vo.getFechaFin().getTime()));
            cst.setInt(i++, vo.getVecesCompartida());
            cst.setInt(i++, vo.getIdOferta());
            cst.executeUpdate();
        } catch (SQLException ex) {
            throw new AppException(-2, "error al acceder a Oferta"+ex.getMessage());
        } catch (Exception ex) {
            throw new AppException(-2, "error al acceder a Oferta"+ex.getMessage());
        } finally {
            try {
                cst.close();
                
            } catch (Exception ex) {
            }
        }
    }

    public void Eliminar(Oferta vo) throws AppException {
        
        String sql = "{CALL buscaofertas.eliminarOferta(?)}";
        CallableStatement cst = null;
        try {
            cst = Conectar.getCnn().prepareCall(sql);
            cst.setInt(1, vo.getIdOferta());
            cst.executeUpdate();
        } catch (SQLException ex) {
            throw new AppException(-2, "error al acceder a Oferta"+ex.getMessage());
        } catch (Exception ex) {
            throw new AppException(-2, "error al acceder a Oferta"+ex.getMessage());
        } finally {
            try {
                cst.close();
                
            } catch (Exception ex) {
            }
        }
    }

    @Override
    public Oferta ObtenerId(Oferta vo) throws AppException {
        
        
        String sql = "{CALL buscaofertas.obtenerIdOferta(?)}";
        ResultSet rs = null;
        CallableStatement cst = null;
        try {
            cst = Conectar.getCnn().prepareCall(sql);
            cst.setInt(1, vo.getIdOferta());
            rs = cst.executeQuery();
            while (rs.next()) {
                Oferta voTemp = new Oferta();
                voTemp.setIdOferta(rs.getInt(1));
                voTemp.setUsuario_idUsuario(rs.getInt(2));
                voTemp.setNombreOferta(rs.getString(3));
                voTemp.setFechaCreacion(rs.getDate(4));
                voTemp.setFechaInicio(rs.getDate(5));
                voTemp.setFechaFin(rs.getDate(6));
                voTemp.setVecesCompartida(rs.getInt(7));
                return(voTemp);
            }
            return null;
        } catch (SQLException ex) {
            throw new AppException(-2, "error al acceder a Oferta"+ex.getMessage());
        } catch (Exception ex) {
            throw new AppException(-2, "error al acceder a Oferta"+ex.getMessage());
        } finally {
            try {
                cst.close();
                rs.close();
                
            } catch (Exception ex) {
            }
        }
    }

}
