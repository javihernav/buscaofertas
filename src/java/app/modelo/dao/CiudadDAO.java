package app.modelo.dao;

import app.modelo.Conectar;
import app.modelo.vo.Ciudad;
import app.utils.AppException;
import app.utils.interfaces.IDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM ciudad;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            rs = ps.executeQuery();
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
                ps.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){throw new AppException(-2,"error al Consultar datos:"+ex.getMessage());}
        }
        return list;
    }



    public int Insertar(Ciudad vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "INSERT INTO ciudad ( nombreCiudad, departamentoCiudad) VALUES(?, ?);";
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
           
            ps.setString(1, vo.getNombreCiudad());
            ps.setString(2, vo.getDepartamentoCiudad());
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
            throw new AppException(-2,"error al Insertar datos:"+ex.getMessage());
        }catch(Exception ex){
            throw new AppException(-2,"error al Insertar datos:"+ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){throw new AppException(-2,"error al Insertar datos:"+ex.getMessage());}
        }
    }



    public void Modificar(Ciudad vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "UPDATE ciudad SET nombreCiudad = ?, departamentoCiudad = ? WHERE idCiudad = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            ps.setString(1, vo.getNombreCiudad());
            ps.setString(2, vo.getDepartamentoCiudad());
            ps.setInt(3, vo.getIdCiudad());
            ps.executeUpdate();
        }catch(SQLException ex){
            throw new AppException(-2,"error al Modificar datos:"+ex.getMessage());
        }catch(Exception ex){
           throw new AppException(-2,"error al Modificar datos:"+ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){throw new AppException(-2,"error al Modificar datos:"+ex.getMessage());}
        }
    }



    public void Eliminar(Ciudad vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "DELETE FROM ciudad WHERE idCiudad = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            ps.setInt(1, vo.getIdCiudad());
            ps.executeUpdate();
        }catch(SQLException ex){
            throw new AppException(-2,"error al eliminar datos:"+ex.getMessage());
        }catch(Exception ex){
            throw new AppException(-2,"error al eliminar datos:"+ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){throw new AppException(-2,"error al eliminar datos:"+ex.getMessage());}
        }
    }

    @Override
    public Ciudad ObtenerId(Ciudad vo) throws AppException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
