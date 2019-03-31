package app.modelo.dao;

import app.modelo.Conectar;
import app.modelo.vo.DetalleProducto;
import app.utils.AppException;
import app.utils.interfaces.IDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DetalleProductoDAO implements IDao<DetalleProducto> {

    Connection cnn;

    public DetalleProductoDAO(Connection cnn) {
        this.cnn = cnn;
    }

    public ArrayList<DetalleProducto> Consultar() throws AppException {
        ArrayList<DetalleProducto> list = new ArrayList<DetalleProducto>();
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM detalleproducto;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = conec.getCnn().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                DetalleProducto vo = new DetalleProducto();
                vo.setOferta_idOferta(rs.getInt(1));
                vo.setProducto_idProducto(rs.getInt(2));
                vo.setPrecio(rs.getDouble(3));
                list.add(vo);
            }
        } catch (SQLException ex) {
            throw new AppException(-2, "error al acceder a DetalleProducto");
        } catch (Exception ex) {
            throw new AppException(-2, "error al acceder a DetalleProducto");
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

    public int Insertar(DetalleProducto vo) throws AppException {
        Conectar conec = new Conectar();
        String sql = "INSERT INTO detalleproducto (Oferta_idOferta, Producto_idProducto, precio) VALUES(?, ?, ?);";
        PreparedStatement ps = null;
        try {
            ps = conec.getCnn().prepareStatement(sql);
            ps.setInt(1, vo.getOferta_idOferta());
            ps.setInt(2, vo.getProducto_idProducto());
            ps.setDouble(3, vo.getPrecio());

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
            throw new AppException(-2, "error al acceder a DetalleProducto");
        } catch (Exception ex) {
            throw new AppException(-2, "error al acceder a DetalleProducto");
        } finally {
            try {
                ps.close();
                conec.desconectar();
            } catch (Exception ex) {
            }
        }
    }

    public void Modificar(DetalleProducto vo) throws AppException {
        Conectar conec = new Conectar();
        String sql = "UPDATE detalleproducto SET precio = ? WHERE Oferta_idOferta = ? and Producto_idProducto = ?;";
        PreparedStatement ps = null;
        try {
            ps = conec.getCnn().prepareStatement(sql);
            ps.setInt(2, vo.getOferta_idOferta());
            ps.setInt(3, vo.getProducto_idProducto());
            ps.setDouble(1, vo.getPrecio());

            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new AppException(-2, "error al acceder a DetalleProducto");
        } catch (Exception ex) {
            throw new AppException(-2, "error al acceder a DetalleProducto");
        } finally {
            try {
                ps.close();
                conec.desconectar();
            } catch (Exception ex) {
            }
        }
    }

    public void Eliminar(DetalleProducto vo) throws AppException {
        Conectar conec = new Conectar();
        String sql = "DELETE FROM detalleproducto WHERE Oferta_idOferta = ? and Producto_idProducto = ?;";
        PreparedStatement ps = null;
        try {
            ps = conec.getCnn().prepareStatement(sql);
            ps.setInt(1, vo.getOferta_idOferta());
            ps.setInt(2, vo.getProducto_idProducto());
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new AppException(-2, "error al acceder a DetalleProducto");
        } catch (Exception ex) {
            throw new AppException(-2, "error al acceder a DetalleProducto");
        } finally {
            try {
                ps.close();
                conec.desconectar();
            } catch (Exception ex) {
            }
        }
    }

    @Override
    public DetalleProducto ObtenerId(DetalleProducto vo) throws AppException {
        ArrayList<DetalleProducto> list = new ArrayList<DetalleProducto>();
        Conectar conec = new Conectar();
                                                            
        String sql = "SELECT * FROM detalleproducto where Oferta_idOferta = ?;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {

            ps = conec.getCnn().prepareStatement(sql);
            ps.setInt(1, vo.getOferta_idOferta());
            rs = ps.executeQuery();
            DetalleProducto voTemp = null;
            while (rs.next()) {
                voTemp = new DetalleProducto();
                voTemp.setOferta_idOferta(rs.getInt("Oferta_idOferta"));
                voTemp.setProducto_idProducto(rs.getInt("Producto_idProducto"));//Producto_idProducto
                voTemp.setPrecio(rs.getDouble("precio"));
                System.out.println("Oferta_idOferta "+rs.getInt("Oferta_idOferta")+" Producto_idProducto "+rs.getInt("Producto_idProducto")+" precio "+rs.getDouble("precio")+" en detalle producto");
                list.add(voTemp);
            }
        } catch (SQLException ex) {
            throw new AppException(-2, "error al acceder a DetalleProducto");
        } catch (Exception ex) {
            throw new AppException(-2, "error al acceder a DetalleProducto");
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
