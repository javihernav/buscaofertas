package app.modelo.dao;

import app.modelo.Conectar;
import app.modelo.vo.Imagen;
import app.utils.AppException;
import app.utils.interfaces.IDao;
import java.io.ByteArrayInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ImagenDAO implements IDao<Imagen>{


    public ArrayList<Imagen> Consultar() throws AppException{
        ArrayList<Imagen> list = new ArrayList<Imagen>();
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM imagen;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Imagen vo = new Imagen();
                vo.setIdImagen(rs.getInt(1));
                vo.setLinkImagen(rs.getString(2));
                vo.setFoto(rs.getBytes(3));
                list.add(vo);
            }
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a Imagen");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a Imagen");
        }finally{
            try{
                ps.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return list;
    }



    public int Insertar(Imagen vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "INSERT INTO imagen (linkImagen,foto) VALUES(?,?);";
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            int i=1;
            ps.setString(i++, vo.getLinkImagen());
            ps.setBinaryStream(i++, new ByteArrayInputStream(vo.getFoto()));
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
            throw new AppException(-2,"error al acceder a Imagen");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a Imagen");
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }



    public void Modificar(Imagen vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "UPDATE imagen SET linkImagen = ? , foto = ? WHERE idImagen = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            int i=1;
            ps.setString(i++, vo.getLinkImagen());
            ps.setBinaryStream(i++, new ByteArrayInputStream(vo.getFoto()));
            ps.setInt(i++, vo.getIdImagen());
            ps.executeUpdate();
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a Imagen");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a Imagen");
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }



    public void Eliminar(Imagen vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "DELETE FROM imagen WHERE idImagen = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            ps.setInt(1, vo.getIdImagen());
            ps.executeUpdate();
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a Imagen");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a Imagen");
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }

    @Override
    public Imagen ObtenerId(Imagen vo) throws AppException {
        ArrayList<Imagen> list = new ArrayList<Imagen>();
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM imagen where foto = ?;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            ps.setBytes(1, vo.getFoto());
            rs = ps.executeQuery();
            while(rs.next()){
                Imagen voTemp = new Imagen();
                voTemp.setIdImagen(rs.getInt(1));
                voTemp.setLinkImagen(rs.getString(2));
                voTemp.setFoto(rs.getBytes(3));
                list.add(voTemp);
            }
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a Imagen");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a Imagen");
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
