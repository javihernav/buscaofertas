package app.modelo.dao;

import app.modelo.Conectar;
import app.modelo.vo.Producto;
import app.utils.AppException;
import app.utils.interfaces.IDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProductoDAO implements IDao<Producto>{


    public ArrayList<Producto> Consultar() throws AppException{
        ArrayList<Producto> list = new ArrayList<Producto>();
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM producto;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Producto vo = new Producto();
                vo.setIdProducto(rs.getInt(1));
                vo.setCategoria_idCategoria(rs.getInt(2));
                vo.setMarca_idMarca(rs.getInt(3));
                vo.setNombreProducto(rs.getString(4));
           
                list.add(vo);
            }
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder aProducto");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder aProducto");
        }finally{
            try{
                ps.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return list;
    }



    public int Insertar(Producto vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "INSERT INTO producto (Categoria_idCategoria, Marca_idMarca, nombreProducto) VALUES(?, ?, ?);";
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            int i=1;
            ps.setInt(i++, vo.getCategoria_idCategoria());
            ps.setInt(i++, vo.getMarca_idMarca());
            ps.setString(i++, vo.getNombreProducto());
            
            ps.executeUpdate();
            sql = "SELECT LAST_INSERT_ID();";
            ps = conec.getCnn().prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            int id=0;
            if(rs.next()){
                id=rs.getInt(1);
            }
            return id;
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder aProducto");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder aProducto");
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }



    public void Modificar(Producto vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "UPDATE producto SET Categoria_idCategoria = ?, Marca_idMarca = ?, nombreProducto = ? WHERE idProducto = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            int i=1;
            ps.setInt(i++, vo.getCategoria_idCategoria());
            ps.setInt(i++, vo.getMarca_idMarca());
            ps.setString(i++, vo.getNombreProducto());
            ps.setInt(i++, vo.getIdProducto());
            ps.executeUpdate();
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder aProducto");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder aProducto");
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }



    public void Eliminar(Producto vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "DELETE FROM producto WHERE idProducto = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            ps.setInt(1, vo.getIdProducto());
            ps.executeUpdate();
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder aProducto");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder aProducto");
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }

    @Override
    public Producto ObtenerId(Producto vo) throws AppException {
        ArrayList<Producto> list = new ArrayList<Producto>();
        Conectar conec = new Conectar();
        
                                                   
        String sql = "SELECT * FROM producto where idProducto = ?;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            ps.setInt(1, vo.getIdProducto());
            System.out.println("id de producto ingresado: "+vo.getIdProducto());
            rs = ps.executeQuery();
            if(rs.next()){
                Producto voTemp = new Producto();
                voTemp.setIdProducto(rs.getInt(1));
                voTemp.setCategoria_idCategoria(rs.getInt(2));
                voTemp.setMarca_idMarca(rs.getInt(3));
                voTemp.setNombreProducto(rs.getString(4));
       
                list.add(voTemp);
            }
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder aProducto");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder aProducto");
        }finally{
            try{
                ps.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return list.get(0);
    }
    
    public Producto ObtenerIdConNombre(Producto vo) throws AppException {
        ArrayList<Producto> list = new ArrayList<Producto>();
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM producto where idProducto = ?;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            ps.setInt(1, vo.getIdProducto());
            rs = ps.executeQuery();
            while(rs.next()){
                Producto voTemp = new Producto();
                voTemp.setIdProducto(rs.getInt(1));
                voTemp.setCategoria_idCategoria(rs.getInt(2));
                voTemp.setMarca_idMarca(rs.getInt(3));
                voTemp.setNombreProducto(rs.getString(4));
              
                list.add(voTemp);
            }
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder aProducto");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder aProducto");
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
