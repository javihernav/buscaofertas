package app.modelo.dao;

import app.modelo.Conectar;
import app.modelo.vo.Categoria;
import app.utils.AppException;
import app.utils.interfaces.IDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CategoriaDAO implements IDao<Categoria>{


    Connection cnn;

    public CategoriaDAO(Connection cnn) {
        this.cnn = cnn;
    }
    
    public ArrayList<Categoria> Consultar() throws AppException{
        ArrayList<Categoria> list = new ArrayList<Categoria>();
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM categoria;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Categoria vo = new Categoria();
                vo.setIdCategoria(rs.getInt(1));
                vo.setNombreCategoria(rs.getString(2));
                list.add(vo);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return list;
    }



    public int Insertar(Categoria vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "INSERT INTO categoria (nombreCategoria) VALUES(?);";
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            //ps.setInt(1, vo.getIdCategoria());
            ps.setString(1, vo.getNombreCategoria());
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
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return 0;
    }



    public void Modificar(Categoria vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "UPDATE categoria SET nombreCategoria = ? WHERE idCategoria = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            ps.setString(1, vo.getNombreCategoria());
            ps.setInt(2, vo.getIdCategoria());
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }



    public void Eliminar(Categoria vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "DELETE FROM categoria WHERE idCategoria = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            ps.setInt(1, vo.getIdCategoria());
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }

    @Override
    public Categoria ObtenerId(Categoria vo) throws AppException {
        ArrayList<Categoria> list = new ArrayList<Categoria>();
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM categoria where idCategoria = ?;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            ps.setInt(1, vo.getIdCategoria());
            rs = ps.executeQuery();
            if(rs.next()){
                Categoria vo1 = new Categoria();
                vo1.setIdCategoria(rs.getInt(1));
                vo1.setNombreCategoria(rs.getString(2));
                list.add(vo1);
            }
        }catch(SQLException ex){
            throw new AppException(-2,"error al consultar categoría");
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
