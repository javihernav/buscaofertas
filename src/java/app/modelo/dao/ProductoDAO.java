package app.modelo.dao;

import app.modelo.Conectar;
import app.modelo.vo.Producto;
import app.utils.AppException;
import app.utils.interfaces.IDao;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductoDAO implements IDao<Producto> {

    public ArrayList<Producto> Consultar() throws AppException {
        ArrayList<Producto> list = new ArrayList<Producto>();
        Conectar conec = new Conectar();
        String sql = "{CALL buscaofertas.consultarProductos()}";
        ResultSet rs = null;
        CallableStatement cst = null;
        try {
            cst = conec.getCnn().prepareCall(sql);
            rs = cst.executeQuery();
            while (rs.next()) {
                Producto vo = new Producto();
                vo.setIdProducto(rs.getInt(1));
                vo.setCategoria_idCategoria(rs.getInt(2));
                vo.setMarca_idMarca(rs.getInt(3));
                vo.setNombreProducto(rs.getString(4));

                list.add(vo);
            }
        } catch (SQLException ex) {
            throw new AppException(-2, "error al acceder aProducto"+ex.getMessage());
        } catch (Exception ex) {
            throw new AppException(-2, "error al acceder aProducto"+ex.getMessage());
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

    public int Insertar(Producto vo) throws AppException {
        Conectar conec = new Conectar();
        String sql = "{CALL buscaofertas.insertProducto(?,?,?)}";
        CallableStatement cst = null;
        try {
            cst = conec.getCnn().prepareCall(sql);
            int i = 1;
            cst.setInt(i++, vo.getCategoria_idCategoria());
            cst.setInt(i++, vo.getMarca_idMarca());
            cst.setString(i++, vo.getNombreProducto());

            ResultSet rs = cst.executeQuery();
            int id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
            }
            return id;
        } catch (SQLException ex) {
            throw new AppException(-2, "error al acceder aProducto"+ex.getMessage());
        } catch (Exception ex) {
            throw new AppException(-2, "error al acceder aProducto"+ex.getMessage());
        } finally {
            try {
                cst.close();
                conec.desconectar();
            } catch (Exception ex) {
            }
        }
    }

    public void Modificar(Producto vo) throws AppException {
        Conectar conec = new Conectar();
        String sql = "{CALL buscaofertas.modificarProducto(?,?,?,?)}";
        CallableStatement cst = null;
        try {
            cst = conec.getCnn().prepareCall(sql);
            int i = 1;
            cst.setInt(i++, vo.getCategoria_idCategoria());
            cst.setInt(i++, vo.getMarca_idMarca());
            cst.setString(i++, vo.getNombreProducto());
            cst.setInt(i++, vo.getIdProducto());
            cst.executeUpdate();
        } catch (SQLException ex) {
            throw new AppException(-2, "error al acceder aProducto"+ex.getMessage());
        } catch (Exception ex) {
            throw new AppException(-2, "error al acceder aProducto"+ex.getMessage());
        } finally {
            try {
                cst.close();
                conec.desconectar();
            } catch (Exception ex) {
            }
        }
    }

    public void Eliminar(Producto vo) throws AppException {
        Conectar conec = new Conectar();
        String sql = "{CALL buscaofertas.eliminarProducto(?)}";
        CallableStatement cst = null;
        try {
            cst = conec.getCnn().prepareCall(sql);
            cst.setInt(1, vo.getIdProducto());
            cst.executeUpdate();
        } catch (SQLException ex) {
            throw new AppException(-2, "error al acceder aProducto"+ex.getMessage());
        } catch (Exception ex) {
            throw new AppException(-2, "error al acceder aProducto"+ex.getMessage());
        } finally {
            try {
                cst.close();
                conec.desconectar();
            } catch (Exception ex) {
            }
        }
    }

    @Override
    public Producto ObtenerId(Producto vo) throws AppException {

        Conectar conec = new Conectar();

        String sql = "{CALL buscaofertas.obtenerIdProducto(?)}";
        ResultSet rs = null;
        CallableStatement cst = null;
        try {
            cst = conec.getCnn().prepareCall(sql);
            cst.setInt(1, vo.getIdProducto());
            System.out.println("id de producto ingresado: " + vo.getIdProducto());
            rs = cst.executeQuery();
            if (rs.next()) {
                Producto voTemp = new Producto();
                voTemp.setIdProducto(rs.getInt(1));
                voTemp.setCategoria_idCategoria(rs.getInt(2));
                voTemp.setMarca_idMarca(rs.getInt(3));
                voTemp.setNombreProducto(rs.getString(4));

                return (voTemp);
            }
            return null;
        } catch (SQLException ex) {
            throw new AppException(-2, "error al acceder aProducto"+ex.getMessage());
        } catch (Exception ex) {
            throw new AppException(-2, "error al acceder aProducto"+ex.getMessage());
        } finally {
            try {
                cst.close();
                rs.close();
                conec.desconectar();
            } catch (Exception ex) {
            }
        }

    }

    public Producto ObtenerIdConNombre(Producto vo) throws AppException {

        Conectar conec = new Conectar();
        String sql = "{CALL buscaofertas.obtenerIdConNombreProducto(?)}";
        ResultSet rs = null;
        CallableStatement cst = null;
        try {
            cst = conec.getCnn().prepareCall(sql);
            cst.setString(1, vo.getNombreProducto());
            rs = cst.executeQuery();
            if (rs.next()) {
                Producto voTemp = new Producto();
                voTemp.setIdProducto(rs.getInt(1));
                voTemp.setCategoria_idCategoria(rs.getInt(2));
                voTemp.setMarca_idMarca(rs.getInt(3));
                voTemp.setNombreProducto(rs.getString(4));

                return (voTemp);
            }
            return null;
        } catch (SQLException ex) {
            throw new AppException(-2, "error al acceder aProducto"+ex.getMessage());
        } catch (Exception ex) {
            throw new AppException(-2, "error al acceder aProducto"+ex.getMessage());
        } finally {
            try {
                cst.close();
                rs.close();
                conec.desconectar();
            } catch (Exception ex) {
            }
        }
    }

}
