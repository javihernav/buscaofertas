package app.modelo.dao;

import app.modelo.Conectar;
import app.modelo.vo.Oferta_Tiene_Ubicacion;
import app.utils.AppException;
import app.utils.interfaces.IDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Oferta_Tiene_UbicacionDAO implements IDao<Oferta_Tiene_Ubicacion>{


    public ArrayList<Oferta_Tiene_Ubicacion> Consultar() throws AppException{
        ArrayList<Oferta_Tiene_Ubicacion> list = new ArrayList<Oferta_Tiene_Ubicacion>();
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM oferta_tiene_ubicacion;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Oferta_Tiene_Ubicacion vo = new Oferta_Tiene_Ubicacion();
                vo.setId_Oferta_tiene_Ubicacion(rs.getInt(1));
                vo.setOferta_idOferta(rs.getInt(2));
                vo.setUbicacion_idUbicacion(rs.getInt(3));
                list.add(vo);
            }
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a OTubicación");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a OTubicación");
        }finally{
            try{
                ps.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return list;
    }



    public int Insertar(Oferta_Tiene_Ubicacion vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "INSERT INTO oferta_tiene_ubicacion (Oferta_idOferta, Ubicacion_idUbicacion) VALUES( ?, ?);";
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
           
            ps.setInt(1, vo.getOferta_idOferta());
            ps.setInt(2, vo.getUbicacion_idUbicacion());
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
            throw new AppException(-2,"error al acceder a OTubicación");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a OTubicación");
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }



    public void Modificar(Oferta_Tiene_Ubicacion vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "UPDATE oferta_tiene_ubicacion SET Oferta_idOferta = ?, Ubicacion_idUbicacion = ? WHERE Id_Oferta_tiene_Ubicacion = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            ps.setInt(1, vo.getOferta_idOferta());
            ps.setInt(2, vo.getUbicacion_idUbicacion());
            ps.setInt(3, vo.getId_Oferta_tiene_Ubicacion());
            ps.executeUpdate();
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a OTubicación");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a OTubicación");
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }



    public void Eliminar(Oferta_Tiene_Ubicacion vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "DELETE FROM oferta_tiene_ubicacion WHERE Id_Oferta_tiene_Ubicacion = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            ps.setInt(1, vo.getId_Oferta_tiene_Ubicacion());
            ps.executeUpdate();
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a OTubicación");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a OTubicación");
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }

    @Override
    public Oferta_Tiene_Ubicacion ObtenerId(Oferta_Tiene_Ubicacion vo) throws AppException {
        ArrayList<Oferta_Tiene_Ubicacion> list = new ArrayList<Oferta_Tiene_Ubicacion>();
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM oferta_tiene_ubicacion where Oferta_idOferta = ? and Ubicacion_idUbicacion = ?;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            ps.setInt(1, vo.getOferta_idOferta());
            ps.setInt(2, vo.getUbicacion_idUbicacion());
            rs = ps.executeQuery();
            while(rs.next()){
                Oferta_Tiene_Ubicacion voTemp = new Oferta_Tiene_Ubicacion();
                voTemp.setId_Oferta_tiene_Ubicacion(rs.getInt(1));
                voTemp.setOferta_idOferta(rs.getInt(2));
                voTemp.setUbicacion_idUbicacion(rs.getInt(3));
                list.add(voTemp);
            }
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a OTubicación");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a OTubicación");
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
