package app.modelo.dao;

import app.modelo.Conectar;
import app.modelo.vo.Ciudad;
import app.utils.AppException;
import app.utils.interfaces.IDao;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CiudadDAO implements IDao<Ciudad>{

Connection cnn;

    public CiudadDAO(Connection cnn) {
        this.cnn = cnn;
    }

    public ArrayList<Ciudad> Consultar() throws AppException{
        ArrayList<Ciudad> list = new ArrayList<Ciudad>();
        
        String sql = "{CALL buscaofertas.consultarCiudad()}";
        ResultSet rs = null;
        CallableStatement cst = null;
        try{
            cst = Conectar.getCnn().prepareCall(sql);
            rs = cst.executeQuery();
            while(rs.next()){
                Ciudad vo = new Ciudad();
                vo.setIdCiudad(rs.getInt(1));
                vo.setNombreCiudad(rs.getString(2));
                vo.setDepartamentoCiudad(rs.getString(3));
                list.add(vo);
            }
        }catch(SQLException ex){
            throw new AppException(-2,"error al Consultar datos:"+ex.getMessage());
        }catch(Exception ex){
            throw new AppException(-2,"error al Consultar datos:"+ex.getMessage());
        }finally{
            try{
                cst.close();
                rs.close();
                
            }catch(Exception ex){throw new AppException(-2,"error al Consultar datos:"+ex.getMessage());}
        }
        return list;
    }



    public int Insertar(Ciudad vo) throws AppException{
        
        String sql = "CALL buscaofertas.insertCiudad(?,?,?)";
        CallableStatement cst = null;
        try{
            cst = Conectar.getCnn().prepareCall(sql);
           
            cst.setInt(1, vo.getIdCiudad());
            cst.setString(2, vo.getNombreCiudad());
            cst.setString(3, vo.getDepartamentoCiudad());
            
            ResultSet rs= cst.executeQuery();
            int id=0;
            if(rs.next()){
                id=rs.getInt(1);
            }
            return id;
        }catch(SQLException ex){
            throw new AppException(-2,"error al Insertar datos:"+ex.getMessage());
        }catch(Exception ex){
            throw new AppException(-2,"error al Insertar datos:"+ex.getMessage());
        }finally{
            try{
                cst.close();
                
            }catch(Exception ex){throw new AppException(-2,"error al Insertar datos:"+ex.getMessage());}
        }
    }



    public void Modificar(Ciudad vo) throws AppException{
        
        String sql = "{CALL buscaofertas.modificarCiudad(?,?,?)}";
        CallableStatement cst = null;
        try{
            cst = Conectar.getCnn().prepareCall(sql);
            cst.setInt(1, vo.getIdCiudad());
            cst.setString(2, vo.getNombreCiudad());
            cst.setString(3, vo.getDepartamentoCiudad());
            cst.executeUpdate();
        }catch(SQLException ex){
            throw new AppException(-2,"error al Modificar datos:"+ex.getMessage());
        }catch(Exception ex){
           throw new AppException(-2,"error al Modificar datos:"+ex.getMessage());
        }finally{
            try{
                cst.close();
                
            }catch(Exception ex){throw new AppException(-2,"error al Modificar datos:"+ex.getMessage());}
        }
    }



    public void Eliminar(Ciudad vo) throws AppException{
        
        String sql = "CALL buscaofertas.eliminarCiudad(?)";
        CallableStatement cst = null;
        try{
            cst = Conectar.getCnn().prepareCall(sql);
            cst.setInt(1, vo.getIdCiudad());
            cst.executeUpdate();
        }catch(SQLException ex){
            throw new AppException(-2,"error al eliminar datos:"+ex.getMessage());
        }catch(Exception ex){
            throw new AppException(-2,"error al eliminar datos:"+ex.getMessage());
        }finally{
            try{
                cst.close();
                
            }catch(Exception ex){throw new AppException(-2,"error al eliminar datos:"+ex.getMessage());}
        }
    }

    @Override
    public Ciudad ObtenerId(Ciudad vo) throws AppException {
        
        
        String sql = "{CALL buscaofertas.obtenerIdCiudad(?)}";
        ResultSet rs = null;
        CallableStatement cst = null;
        try{
            cst = Conectar.getCnn().prepareCall(sql);
            cst.setInt(1, vo.getIdCiudad());
            rs = cst.executeQuery();
            if(rs.next()){
                Ciudad ciudadVo = new Ciudad();
                ciudadVo.setIdCiudad(rs.getInt(1));
                ciudadVo.setNombreCiudad(rs.getString(2));
                ciudadVo.setDepartamentoCiudad(rs.getString(3));
                return ciudadVo;
            }
            return null;
        }catch(SQLException ex){
            throw new AppException(-2,"error al Consultar datos:"+ex.getMessage());
        }catch(Exception ex){
            throw new AppException(-2,"error al Consultar datos:"+ex.getMessage());
        }finally{
            try{
                cst.close();
                rs.close();
                
            }catch(Exception ex){throw new AppException(-2,"error al Consultar datos:"+ex.getMessage());}
        }
    }
}
