package app.modelo.dao;

import app.modelo.Conectar;
import app.modelo.vo.DetalleProducto;
import app.utils.AppException;
import app.utils.interfaces.IDao;
import java.sql.Connection;
import java.sql.CallableStatement;
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
        
        String sql = "{CALL buscaofertas.consultarDetalleProducto()}";
        ResultSet rs = null;
        CallableStatement cst = null;
        try {
            cst = Conectar.getCnn().prepareCall(sql);
            rs = cst.executeQuery();
            while (rs.next()) {
                DetalleProducto vo = new DetalleProducto();
                vo.setOferta_idOferta(rs.getInt(1));
                vo.setProducto_idProducto(rs.getInt(2));
                vo.setPrecio(rs.getInt(3));
                list.add(vo);
            }
        } catch (SQLException ex) {
            throw new AppException(-2, "error al acceder a DetalleProducto"+ex.getMessage());
        } catch (Exception ex) {
            throw new AppException(-2, "error al acceder a DetalleProducto"+ex.getMessage());
        } finally {
            try {
                cst.close();
                rs.close();
                
            } catch (Exception ex) {
            }
        }
        return list;
    }

    public int Insertar(DetalleProducto vo) throws AppException {
        
        String sql = "{CALL buscaofertas.insertDetalleProducto(?,?,?)}";
        CallableStatement cst = null;
        try {
            cst = Conectar.getCnn().prepareCall(sql);
            cst.setInt(1, vo.getOferta_idOferta());
            cst.setInt(2, vo.getProducto_idProducto());
            cst.setInt(3, vo.getPrecio());

            ResultSet rs = cst.executeQuery();
            int id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
            }
            return id;
        } catch (SQLException ex) {
            throw new AppException(-2, "error al acceder a DetalleProducto"+ex.getMessage());
        } catch (Exception ex) {
            throw new AppException(-2, "error al acceder a DetalleProducto"+ex.getMessage());
        } finally {
            try {
                cst.close();
                
            } catch (Exception ex) {
            }
        }
    }

    public void Modificar(DetalleProducto vo) throws AppException {
        
        String sql = "{CALL buscaofertas.modificarDetalleProducto(?,?,?)}";
        CallableStatement cst = null;
        try {
            cst = Conectar.getCnn().prepareCall(sql);
            cst.setInt(1, vo.getOferta_idOferta());
            cst.setInt(2, vo.getProducto_idProducto());
            cst.setInt(3, vo.getPrecio());

            cst.executeUpdate();
        } catch (SQLException ex) {
            throw new AppException(-2, "error al modificar a DetalleProducto"+ex.getMessage());
        } catch (Exception ex) {
            throw new AppException(-2, "error al modificar a DetalleProducto"+ex.getMessage());
        } finally {
            try {
                cst.close();
                
            } catch (Exception ex) {
            }
        }
    }

    public void Eliminar(DetalleProducto vo) throws AppException {
        
        String sql = "{CALL buscaofertas.eliminarDetalleProducto(?,?)}";
        CallableStatement cst = null;
        try {
            cst = Conectar.getCnn().prepareCall(sql);
            cst.setInt(1, vo.getOferta_idOferta());
            cst.setInt(2, vo.getProducto_idProducto());
            cst.executeUpdate();
        } catch (SQLException ex) {
            throw new AppException(-2, "error al acceder a DetalleProducto"+ex.getMessage());
        } catch (Exception ex) {
            throw new AppException(-2, "error al acceder a DetalleProducto"+ex.getMessage());
        } finally {
            try {
                cst.close();
                
            } catch (Exception ex) {
            }
        }
    }

    @Override
    public DetalleProducto ObtenerId(DetalleProducto vo) throws AppException {

        //obitiene el detalleproducto con idOferta

        String sql = "{CALL buscaofertas.obtenerIdDetalleProducto(?)}";
        ResultSet rs = null;
        CallableStatement cst = null;
        try {

            cst = Conectar.getCnn().prepareCall(sql);
            cst.setInt(1, vo.getOferta_idOferta());
            rs = cst.executeQuery();
            DetalleProducto voTemp = null;
            while (rs.next()) {
                voTemp = new DetalleProducto();
                voTemp.setOferta_idOferta(rs.getInt("Oferta_idOferta"));
                voTemp.setProducto_idProducto(rs.getInt("Producto_idProducto"));//Producto_idProducto
                voTemp.setPrecio(rs.getInt("precio"));
                System.out.println("Oferta_idOferta " + rs.getInt("Oferta_idOferta") + " Producto_idProducto " + rs.getInt("Producto_idProducto") + " precio " + rs.getInt("precio") + " en detalle producto");
                return (voTemp);
            }
            return null;
        } catch (SQLException ex) {
            throw new AppException(-2, "error al acceder a DetalleProducto"+ex.getMessage());
        } catch (Exception ex) {
            throw new AppException(-2, "error al acceder a DetalleProducto"+ex.getMessage());
        } finally {
            try {
                cst.close();
                rs.close();
                
            } catch (Exception ex) {
            }
        }

    }

}
