package app.modelo.dao;

import app.modelo.Conectar;
import app.modelo.vo.Oferta;
import app.modelo.vo.OfertaCompleta;
import app.utils.AppException;
import app.utils.interfaces.IDao;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OfertaCompletaDAO implements IDao<Oferta> {

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
    
    
    
    public ArrayList<OfertaCompleta> ConsultarOfertaCompleta(String consulta) throws AppException {
        ArrayList<OfertaCompleta> list = new ArrayList<>();
        
        String sql = "{CALL buscaofertas.consultarOfertaCompleta(?)}";
        ResultSet rs = null;
        CallableStatement cst = null;
        try {
            cst = Conectar.getCnn().prepareCall(sql);
            cst.setString(1, consulta);
            rs = cst.executeQuery();
            while (rs.next()) {
                OfertaCompleta vo = new OfertaCompleta();
                vo.setIdUsuario(rs.getInt("Usuario_idUsuario"));
                vo.setIdOferta(rs.getInt("idOferta"));
                vo.setNombreOferta(rs.getString("nombreOferta"));
                vo.setFechaCreacion(rs.getDate("fechaCreacion"));
                vo.setFechaInicio(rs.getDate("fechaInicio"));
                vo.setFechaFin(rs.getDate("fechaFin"));
                vo.setVecesCompartida(rs.getInt("vecesCompartida"));
                vo.setId_Oferta_tiene_Ubicacion(rs.getInt("Id_Oferta_tiene_Ubicacion"));
                vo.setIdUbicacion(rs.getInt("idUbicacion"));
                vo.setNombreTienda(rs.getString("nombreTienda"));
                vo.setDireccion(rs.getString("direccion"));
                vo.setCiudad(rs.getString("ciudad"));
                vo.setIdProducto(rs.getInt("idProducto"));
                vo.setNombreProducto(rs.getString("nombreProducto"));
                vo.setPrecio(rs.getInt("precio"));
                vo.setIdCategoria(rs.getInt("idCategoria"));
                vo.setNombreCategoria(rs.getString("nombreCategoria"));
                vo.setIdMarca(rs.getInt("Marca_idMarca"));
                vo.setCategoriaPrincipal(rs.getString("categoriaPrincipal"));
                vo.setId_DetalleProducto_tiene_Imagen(rs.getInt("Id_DetalleProducto_tiene_Imagen"));
                vo.setIdImagen(rs.getInt("idImagen"));
                vo.setLinkImagen(rs.getString("linkImagen"));
                vo.setFoto(rs.getBytes("foto"));
                
                list.add(vo);
            }
        } catch (SQLException ex) {
            throw new AppException(-2, "error al acceder a Oferta Completa"+ex.getMessage());
        } catch (Exception ex) {
            throw new AppException(-2, "error al acceder a Oferta Completa"+ex.getMessage());
        } finally {
            try {
                cst.close();
                rs.close();
                
            } catch (Exception ex) {
            }
        }
        return list;
    }

    
    
    
    
public static void main(String[] args){
OfertaCompletaDAO ofertaDAO = new OfertaCompletaDAO();
Oferta oferta = new Oferta();
oferta.setIdOferta(57);
        try {
            oferta = ofertaDAO.consultarPorIdOferta(oferta.getIdOferta());
        } catch (AppException ex) {
            Logger.getLogger(OfertaCompletaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("oferta: "+ oferta);
}
}
