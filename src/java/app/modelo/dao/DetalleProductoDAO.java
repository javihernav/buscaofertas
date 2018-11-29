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


public class DetalleProductoDAO implements IDao<DetalleProducto>{
Connection cnn;

    public DetalleProductoDAO(Connection cnn) {
        this.cnn = cnn;
    }

    public ArrayList<DetalleProducto> Consultar() throws AppException{
        ArrayList<DetalleProducto> list = new ArrayList<DetalleProducto>();
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM detalleproducto;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                DetalleProducto vo = new DetalleProducto();
                vo.setOferta_idOferta(rs.getInt(1));
                vo.setProducto_idProducto(rs.getInt(2));
                vo.setPrecio(rs.getDouble(3));
                list.add(vo);
            }
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a DetalleProducto");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a DetalleProducto");
        }finally{
            try{
                ps.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return list;
    }



    public void Insertar(DetalleProducto vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "INSERT INTO detalleproducto (Oferta_idOferta, Producto_idProducto, precio) VALUES(?, ?, ?);";
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            ps.setInt(1, vo.getOferta_idOferta());
            ps.setInt(2, vo.getProducto_idProducto());
            ps.setDouble(3, vo.getPrecio());
         
            ps.executeUpdate();
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a DetalleProducto");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a DetalleProducto");
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }



    public void Modificar(DetalleProducto vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "UPDATE detalleproducto SET precio = ? WHERE Oferta_idOferta = ? and Producto_idProducto = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            ps.setInt(2, vo.getOferta_idOferta());
            ps.setInt(3, vo.getProducto_idProducto());
            ps.setDouble(1, vo.getPrecio());
           
            ps.executeUpdate();
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a DetalleProducto");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a DetalleProducto");
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }



    public void Eliminar(DetalleProducto vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "DELETE FROM detalleproducto WHERE Oferta_idOferta = ? and Producto_idProducto = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            ps.setInt(1, vo.getOferta_idOferta());
            ps.setInt(2, vo.getProducto_idProducto());
            ps.executeUpdate();
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a DetalleProducto");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a DetalleProducto");
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }

    @Override
    public DetalleProducto ObtenerId(DetalleProducto vo) throws AppException {
        ArrayList<DetalleProducto> list = new ArrayList<DetalleProducto>();
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM detalleproducto where Oferta_idOferta = ?;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            ps.setInt(1, vo.getOferta_idOferta());
            rs = ps.executeQuery();
            while(rs.next()){
                DetalleProducto voTemp = new DetalleProducto();
                voTemp.setOferta_idOferta(rs.getInt(1));
                voTemp.setProducto_idProducto(rs.getInt(2));
                voTemp.setPrecio(rs.getDouble(3));
                list.add(voTemp);
            }
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a DetalleProducto");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a DetalleProducto");
        }finally{
            try{
                ps.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return list.get(0);
    }


}
