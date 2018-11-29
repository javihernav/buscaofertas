package app.modelo.dao;

import app.modelo.Conectar;
import app.modelo.vo.Ubicacion;
import app.utils.AppException;
import app.utils.interfaces.IDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class UbicacionDAO implements IDao<Ubicacion>{


    public ArrayList<Ubicacion> Consultar() throws AppException{
        ArrayList<Ubicacion> list = new ArrayList<Ubicacion>();
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM ubicacion;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Ubicacion vo = new Ubicacion();
                vo.setIdUbicacion(rs.getInt(1));
                vo.setNombreTienda(rs.getString(2));
                vo.setDireccion(rs.getString(3));
                vo.setCiudad(rs.getString(4));
                list.add(vo);
            }
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a ubicación");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a ubicación");
        }finally{
            try{
                ps.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return list;
    }



    public void Insertar(Ubicacion vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "INSERT INTO ubicacion ( nombreTienda, direccion, ciudad) VALUES( ?, ?, ?);";
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            int i=1;
            ps.setString(i++, vo.getNombreTienda());
            ps.setString(i++, vo.getDireccion());
            ps.setString(i++, vo.getCiudad());
            ps.executeUpdate();
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a ubicación");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a ubicación");
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }



    public void Modificar(Ubicacion vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "UPDATE ubicacion SET nombreTienda = ?, direccion = ?, ciudad = ? WHERE idUbicacion = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            int i=1;
            ps.setString(i++, vo.getNombreTienda());
            ps.setString(i++, vo.getDireccion());
            ps.setString(i++, vo.getCiudad());
            ps.setInt(i++, vo.getIdUbicacion());
            ps.executeUpdate();
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a ubicación");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a ubicación");
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }



    public void Eliminar(Ubicacion vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "DELETE FROM ubicacion WHERE idUbicacion = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            ps.setInt(1, vo.getIdUbicacion());
            ps.executeUpdate();
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a ubicación");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a ubicación");
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }

    @Override
    public Ubicacion ObtenerId(Ubicacion vo) throws AppException {
        ArrayList<Ubicacion> list = new ArrayList<Ubicacion>();
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM ubicacion where nombreTienda = ? and direccion = ? and ciudad = ?;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            ps.setString(1, vo.getNombreTienda());
            ps.setString(2, vo.getDireccion());
            ps.setString(3, vo.getCiudad());
            rs = ps.executeQuery();
            if(rs.next()){
                Ubicacion voTemp = new Ubicacion();
                voTemp.setIdUbicacion(rs.getInt(1));
                voTemp.setNombreTienda(rs.getString(2));
                voTemp.setDireccion(rs.getString(3));
                voTemp.setCiudad(rs.getString(4));
                list.add(voTemp);
            }
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a ubicación");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a ubicación");
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
