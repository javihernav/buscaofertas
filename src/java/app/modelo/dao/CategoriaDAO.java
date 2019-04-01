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
        Conectar conec = new Conectar();
        String sql = "{CALL consultarCategorias()}";
        ResultSet rs = null;
        CallableStatement cst = null;
        try{
            cst = conec.getCnn().prepareCall(sql);
            rs = cst.executeQuery();
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
                cst.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return list;
    }



    public int Insertar(Categoria vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "{CALL buscaofertas.insertCategoria(?)}";
        CallableStatement cst = null;
        try{
            cst = conec.getCnn().prepareCall(sql);
      
            cst.setString(1, vo.getNombreCategoria());
            
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
                conec.desconectar();
            }catch(Exception ex){}
        }
        return 0;
    }



    public void Modificar(Categoria vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "{CALL buscaofertas.modificarCategoria(?,?)}";
        CallableStatement cst = null;
        try{
            cst = conec.getCnn().prepareCall(sql);
            cst.setString(1, vo.getNombreCategoria());
            cst.setInt(2, vo.getIdCategoria());
            cst.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                cst.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }



    public void Eliminar(Categoria vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "CALL buscaofertas.eliminarCategoria(?)";
        CallableStatement cst = null;
        try{
            cst = conec.getCnn().prepareCall(sql);
            cst.setInt(1, vo.getIdCategoria());
            cst.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                cst.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }

    @Override
    public Categoria ObtenerId(Categoria vo) throws AppException {
        
        Conectar conec = new Conectar();
        String sql = "{CALL buscaofertas.obtenerIdCategoria(?)}";
        ResultSet rs = null;
        CallableStatement cst = null;
        try{
            cst = conec.getCnn().prepareCall(sql);
            cst.setInt(1, vo.getIdCategoria());
            rs = cst.executeQuery();
            if(rs.next()){
                Categoria vo1 = new Categoria();
                vo1.setIdCategoria(rs.getInt(1));
                vo1.setNombreCategoria(rs.getString(2));
                return(vo1);
            }
        }catch(SQLException ex){
            throw new AppException(-2,"error al consultar categoría"+ex.getMessage());
        }finally{
            try{
                cst.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return null;
    }


}
