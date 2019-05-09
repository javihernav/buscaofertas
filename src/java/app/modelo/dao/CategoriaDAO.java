package app.modelo.dao;

import app.modelo.Conectar;
import app.modelo.vo.Categoria;
import app.utils.AppException;
import app.utils.interfaces.IDao;
import java.sql.Connection;
import java.sql.CallableStatement;
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
       
        String sql = "{CALL consultarCategorias()}";
        ResultSet rs = null;
        CallableStatement cst = null;
        try{
            cst = Conectar.getCnn().prepareCall(sql);
            rs = cst.executeQuery();
            while(rs.next()){
                Categoria vo = new Categoria();
                vo.setIdCategoria(rs.getInt("idCategoria"));
                vo.setNombreCategoria(rs.getString("nombreCategoria"));
                vo.setCategoriaPrincipal(rs.getString("categoriaPrincipal"));
                list.add(vo);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                cst.close();
                rs.close();
                
            }catch(Exception ex){}
        }
        return list;
    }



    public int Insertar(Categoria vo) throws AppException{
        
        String sql = "{CALL buscaofertas.insertCategoria(?,?)}";
        CallableStatement cst = null;
        try{
            cst = Conectar.getCnn().prepareCall(sql);
      
            cst.setString(1, vo.getNombreCategoria());
            cst.setString(2, vo.getCategoriaPrincipal());
            
            ResultSet rs= cst.executeQuery();
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
                cst.close();
                
            }catch(Exception ex){}
        }
        return 0;
    }



    public void Modificar(Categoria vo) throws AppException{
        
        String sql = "{CALL buscaofertas.modificarCategoria(?,?.?)}";
        CallableStatement cst = null;
        try{
            cst = Conectar.getCnn().prepareCall(sql);
            cst.setString(1, vo.getNombreCategoria());
            cst.setString(2, vo.getCategoriaPrincipal());
            cst.setInt(3, vo.getIdCategoria());
            cst.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                cst.close();
                
            }catch(Exception ex){}
        }
    }



    public void Eliminar(Categoria vo) throws AppException{
        
        String sql = "CALL buscaofertas.eliminarCategoria(?)";
        CallableStatement cst = null;
        try{
            cst = Conectar.getCnn().prepareCall(sql);
            cst.setInt(1, vo.getIdCategoria());
            cst.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                cst.close();
                
            }catch(Exception ex){}
        }
    }

    @Override
    public Categoria ObtenerId(Categoria vo) throws AppException {
        
        
        String sql = "{CALL buscaofertas.obtenerIdCategoria(?)}";
        ResultSet rs = null;
        CallableStatement cst = null;
        try{
            cst = Conectar.getCnn().prepareCall(sql);
            cst.setInt(1, vo.getIdCategoria());
            rs = cst.executeQuery();
            if(rs.next()){
                Categoria vo1 = new Categoria();
                vo1.setIdCategoria(rs.getInt("idCategoria"));
                vo1.setNombreCategoria(rs.getString("nombreCategoria"));
                vo1.setCategoriaPrincipal(rs.getString("categoriaPrincipal"));
                return(vo1);
            }
        }catch(SQLException ex){
            throw new AppException(-2,"error al consultar categoría"+ex.getMessage());
        }finally{
            try{
                cst.close();
                rs.close();
                
            }catch(Exception ex){}
        }
        return null;
    }


}
