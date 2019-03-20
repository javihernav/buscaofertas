package app.modelo.dao;

import app.modelo.Conectar;
import app.modelo.vo.DetalleProducto_Tiene_Imagen;
import app.utils.AppException;
import app.utils.interfaces.IDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DetalleProducto_Tiene_ImagenDAO implements IDao<DetalleProducto_Tiene_Imagen> {

    public ArrayList<DetalleProducto_Tiene_Imagen> Consultar() throws AppException {
        ArrayList<DetalleProducto_Tiene_Imagen> list = new ArrayList<DetalleProducto_Tiene_Imagen>();
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM detalleproducto_tiene_imagen;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = conec.getCnn().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                DetalleProducto_Tiene_Imagen vo = new DetalleProducto_Tiene_Imagen();
                vo.setId_DetalleProducto_tiene_Imagen(rs.getInt(1));
                vo.setImagen_idImagen(rs.getInt(2));
                vo.setDetalleProducto_Oferta_idOferta(rs.getInt(3));
                vo.setDetalleProducto_Producto_idProducto(rs.getInt(4));
                list.add(vo);
            }
        } catch (SQLException ex) {
            throw new AppException(-2, "error al acceder a DetalleProducto_Tiene_Imagen");
        } catch (Exception ex) {
            throw new AppException(-2, "error al acceder a DetalleProducto_Tiene_Imagen");
        } finally {
            try {
                ps.close();
                rs.close();
                conec.desconectar();
            } catch (Exception ex) {
            }
        }
        return list;
    }

    public int Insertar(DetalleProducto_Tiene_Imagen vo) throws AppException {
        Conectar conec = new Conectar();
        String sql = "INSERT INTO detalleproducto_tiene_imagen (Imagen_idImagen, DetalleProducto_Oferta_idOferta, DetalleProducto_Producto_idProducto) VALUES(?, ?, ?);";
        PreparedStatement ps = null;
        try {
            ps = conec.getCnn().prepareStatement(sql);
            //ps.setString(1, vo.getId_DetalleProducto_tiene_Imagen());
            ps.setInt(1, vo.getImagen_idImagen());
            ps.setInt(2, vo.getDetalleProducto_Oferta_idOferta());
            ps.setInt(3, vo.getDetalleProducto_Producto_idProducto());
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
            throw new AppException(-2, "error al acceder a DetalleProducto_Tiene_Imagen");
        } catch (Exception ex) {
            throw new AppException(-2, "error al acceder a DetalleProducto_Tiene_Imagen");
        } finally {
            try {
                ps.close();
                conec.desconectar();
            } catch (Exception ex) {
            }
        }
    }

    public void Modificar(DetalleProducto_Tiene_Imagen vo) throws AppException {
        Conectar conec = new Conectar();
        String sql = "UPDATE detalleproducto_tiene_imagen SET Imagen_idImagen = ?, DetalleProducto_Oferta_idOferta = ?, DetalleProducto_Producto_idProducto = ? WHERE Id_DetalleProducto_tiene_Imagen = ?;";
        PreparedStatement ps = null;
        try {
            ps = conec.getCnn().prepareStatement(sql);
            ps.setInt(1, vo.getImagen_idImagen());
            ps.setInt(2, vo.getDetalleProducto_Oferta_idOferta());
            ps.setInt(3, vo.getDetalleProducto_Producto_idProducto());
            ps.setInt(4, vo.getId_DetalleProducto_tiene_Imagen());
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new AppException(-2, "error al acceder a DetalleProducto_Tiene_Imagen");
        } catch (Exception ex) {
            throw new AppException(-2, "error al acceder a DetalleProducto_Tiene_Imagen");
        } finally {
            try {
                ps.close();
                conec.desconectar();
            } catch (Exception ex) {
            }
        }
    }

    public void Eliminar(DetalleProducto_Tiene_Imagen vo) throws AppException {
        Conectar conec = new Conectar();
        String sql = "DELETE FROM detalleproducto_tiene_imagen WHERE Id_DetalleProducto_tiene_Imagen = ?;";
        PreparedStatement ps = null;
        try {
            ps = conec.getCnn().prepareStatement(sql);
            ps.setInt(1, vo.getId_DetalleProducto_tiene_Imagen());
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new AppException(-2, "error al acceder a DetalleProducto_Tiene_Imagen");
        } catch (Exception ex) {
            throw new AppException(-2, "error al acceder a DetalleProducto_Tiene_Imagen");
        } finally {
            try {
                ps.close();
                conec.desconectar();
            } catch (Exception ex) {
            }
        }
    }

    @Override
    public DetalleProducto_Tiene_Imagen ObtenerId(DetalleProducto_Tiene_Imagen vo) throws AppException {
        ArrayList<DetalleProducto_Tiene_Imagen> list = new ArrayList<DetalleProducto_Tiene_Imagen>();
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM detalleproducto_tiene_imagen where DetalleProducto_Oferta_idOferta = ? and DetalleProducto_Producto_idProducto = ?;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = conec.getCnn().prepareStatement(sql);
            ps.setInt(1, vo.getDetalleProducto_Oferta_idOferta());
            ps.setInt(2, vo.getDetalleProducto_Producto_idProducto());
            rs = ps.executeQuery();
            DetalleProducto_Tiene_Imagen voTemp = null;
            if (rs.next()) {
                voTemp = new DetalleProducto_Tiene_Imagen();
                voTemp.setId_DetalleProducto_tiene_Imagen(rs.getInt(1));
                voTemp.setImagen_idImagen(rs.getInt(2));
                voTemp.setDetalleProducto_Oferta_idOferta(rs.getInt(3));
                voTemp.setDetalleProducto_Producto_idProducto(rs.getInt(4));
                list.add(voTemp);
            }
        } catch (SQLException ex) {
            throw new AppException(-2, "error al acceder a DetalleProducto_Tiene_Imagen");
        } catch (Exception ex) {
            throw new AppException(-2, "error al acceder a DetalleProducto_Tiene_Imagen");
        } finally {
            try {
                ps.close();
                rs.close();
                conec.desconectar();
            } catch (Exception ex) {
            }
        }
        return list.get(0);
    }

}
