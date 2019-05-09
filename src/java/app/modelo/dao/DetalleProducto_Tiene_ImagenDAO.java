package app.modelo.dao;

import app.modelo.Conectar;
import app.modelo.vo.DetalleProducto_Tiene_Imagen;
import app.utils.AppException;
import app.utils.interfaces.IDao;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DetalleProducto_Tiene_ImagenDAO implements IDao<DetalleProducto_Tiene_Imagen> {

    public ArrayList<DetalleProducto_Tiene_Imagen> Consultar() throws AppException {
        ArrayList<DetalleProducto_Tiene_Imagen> list = new ArrayList<DetalleProducto_Tiene_Imagen>();
        
        String sql = "{CALL buscaofertas.consultarDetalleProductoTieneImagen}";
        ResultSet rs = null;
        CallableStatement cst = null;
        try {
            cst = Conectar.getCnn().prepareCall(sql);
            rs = cst.executeQuery();
            while (rs.next()) {
                DetalleProducto_Tiene_Imagen vo = new DetalleProducto_Tiene_Imagen();
                vo.setId_DetalleProducto_tiene_Imagen(rs.getInt(1));
                vo.setImagen_idImagen(rs.getInt(2));
                vo.setDetalleProducto_Oferta_idOferta(rs.getInt(3));
                vo.setDetalleProducto_Producto_idProducto(rs.getInt(4));
                list.add(vo);
            }
        } catch (SQLException ex) {
            throw new AppException(-2, "error al consultar a DetalleProducto_Tiene_Imagen"+ex.getMessage());
        } catch (Exception ex) {
            throw new AppException(-2, "error al consultar a DetalleProducto_Tiene_Imagen"+ex.getMessage());
        } finally {
            try {
                cst.close();
                rs.close();
                
            } catch (Exception ex) {
            }
        }
        return list;
    }

    public int Insertar(DetalleProducto_Tiene_Imagen vo) throws AppException {
        
        String sql = "{CALL buscaofertas.insertDetalleProductoTieneImagen(?,?,?)}";
        CallableStatement cst = null;
        try {
            cst = Conectar.getCnn().prepareCall(sql);
            cst.setInt(1, vo.getImagen_idImagen());
            cst.setInt(2, vo.getDetalleProducto_Oferta_idOferta());
            cst.setInt(3, vo.getDetalleProducto_Producto_idProducto());
 
            ResultSet rs = cst.executeQuery();
            int id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
            }
            return id;
        } catch (SQLException ex) {
            throw new AppException(-2, "error al insertar a DetalleProducto_Tiene_Imagen SQLException"+ex.getMessage());
        } catch (Exception ex) {
            throw new AppException(-2, "error al insertar a DetalleProducto_Tiene_Imagen"+ex.getMessage());
        } finally {
            try {
                cst.close();
                
            } catch (Exception ex) {
            }
        }
    }

    public void Modificar(DetalleProducto_Tiene_Imagen vo) throws AppException {
        
        String sql = "{CALL buscaofertas.modificarDetalleProductoTieneImagen(?,?,?,?)}";
        CallableStatement cst = null;
        try {
            cst = Conectar.getCnn().prepareCall(sql);
            cst.setInt(1, vo.getImagen_idImagen());
            cst.setInt(2, vo.getDetalleProducto_Oferta_idOferta());
            cst.setInt(3, vo.getDetalleProducto_Producto_idProducto());
            cst.setInt(4, vo.getId_DetalleProducto_tiene_Imagen());
            cst.executeUpdate();
        } catch (SQLException ex) {
            throw new AppException(-2, "error al actualizar a DetalleProducto_Tiene_Imagen"+ex.getMessage());
        } catch (Exception ex) {
            throw new AppException(-2, "error al actualizar a DetalleProducto_Tiene_Imagen"+ex.getMessage());
        } finally {
            try {
                cst.close();
                
            } catch (Exception ex) {
            }
        }
    }

    public void Eliminar(DetalleProducto_Tiene_Imagen vo) throws AppException {
        
        String sql = "{CALL buscaofertas.eliminarDetalleProductoTieneImagen(?)}";
        CallableStatement cst = null;
        try {
            cst = Conectar.getCnn().prepareCall(sql);
            cst.setInt(1, vo.getId_DetalleProducto_tiene_Imagen());
            cst.executeUpdate();
        } catch (SQLException ex) {
            throw new AppException(-2, "error al eliminar a DetalleProducto_Tiene_Imagen"+ex.getMessage());
        } catch (Exception ex) {
            throw new AppException(-2, "error al eliminar a DetalleProducto_Tiene_Imagen"+ex.getMessage());
        } finally {
            try {
                cst.close();
                
            } catch (Exception ex) {
            }
        }
    }

    @Override
    public DetalleProducto_Tiene_Imagen ObtenerId(DetalleProducto_Tiene_Imagen vo) throws AppException {
        
        
        String sql = "{CALL buscaofertas.obtenerIdDetalleProductoTieneImagen(?,?)}";
        ResultSet rs = null;
        CallableStatement cst = null;
        try {
            cst = Conectar.getCnn().prepareCall(sql);
            cst.setInt(1, vo.getDetalleProducto_Oferta_idOferta());
            cst.setInt(2, vo.getDetalleProducto_Producto_idProducto());
            rs = cst.executeQuery();
            DetalleProducto_Tiene_Imagen voTemp = null;
            if (rs.next()) {
                voTemp = new DetalleProducto_Tiene_Imagen();
                voTemp.setId_DetalleProducto_tiene_Imagen(rs.getInt(1));
                voTemp.setImagen_idImagen(rs.getInt(2));
                voTemp.setDetalleProducto_Oferta_idOferta(rs.getInt(3));
                voTemp.setDetalleProducto_Producto_idProducto(rs.getInt(4));
                return(voTemp);
            }
        } catch (SQLException ex) {
            throw new AppException(-2, "error al obtenerid a DetalleProducto_Tiene_Imagen"+ex.getMessage());
        } catch (Exception ex) {
            throw new AppException(-2, "error al obtenerid a DetalleProducto_Tiene_Imagen"+ex.getMessage());
        } finally {
            try {
                cst.close();
                rs.close();
                
            } catch (Exception ex) {
            }
        }
        return null;
    }

    public DetalleProducto_Tiene_ImagenDAO() {
    }

}
