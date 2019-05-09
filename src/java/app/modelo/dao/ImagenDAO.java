package app.modelo.dao;

import app.modelo.Conectar;
import app.modelo.vo.Imagen;
import app.utils.AppException;
import app.utils.interfaces.IDao;
import java.io.ByteArrayInputStream;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ImagenDAO implements IDao<Imagen>{


    public ArrayList<Imagen> Consultar() throws AppException{
        ArrayList<Imagen> list = new ArrayList<Imagen>();
        
        String sql = "{CALL buscaofertas.consultarImagenes}";
        ResultSet rs = null;
        CallableStatement cst = null;
        try{
            cst = Conectar.getCnn().prepareCall(sql);
            rs = cst.executeQuery();
            while(rs.next()){
                Imagen vo = new Imagen();
                vo.setIdImagen(rs.getInt(1));
                vo.setLinkImagen(rs.getString(2));
                vo.setFoto(rs.getBytes(3));
                list.add(vo);
            }
        }catch(SQLException ex){
            throw new AppException(-2,"error al consultar Imagen"+ex.getMessage());
        }catch(Exception ex){
            throw new AppException(-2,"error al consultar a Imagen"+ex.getMessage());
        }finally{
            try{
                cst.close();
                rs.close();
                
            }catch(Exception ex){}
        }
        return list;
    }



    public int Insertar(Imagen vo) throws AppException{
        
                                             	
        String sql = "{CALL buscaofertas.insertImagen(?,?)}";
        CallableStatement cst = null;
        try{
            cst = Conectar.getCnn().prepareCall(sql);
            int i=1;
            cst.setString(i++, vo.getLinkImagen());
//            cst.setBlob(i++, new ByteArrayInputStream(vo.getFoto()));
            cst.setBlob(i++, (vo.getFoto2()));
            
            ResultSet rs= cst.executeQuery();
            int id=0;
            if(rs.next()){
                id=rs.getInt(1);
            }
            return id;
        }catch(SQLException ex){
            throw new AppException(-2,"error al insertar a Imagen"+ex.getMessage());
        }finally{
            try{
                cst.close();
                
            }catch(Exception ex){}
        }
    }



    public void Modificar(Imagen vo) throws AppException{
        
        String sql = "{CALL buscaofertas.modificarImagen(?,?,?)}";
        CallableStatement cst = null;
        try{
            cst = Conectar.getCnn().prepareCall(sql);
            int i=1;
            cst.setString(i++, vo.getLinkImagen());
//            cst.setBinaryStream(i++, new ByteArrayInputStream(vo.getFoto()));
            cst.setBlob(i++, (vo.getFoto2()));
            cst.setInt(i++, vo.getIdImagen());
            cst.executeUpdate();
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a Imagen"+ex.getMessage());
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a Imagen"+ex.getMessage());
        }finally{
            try{
                cst.close();
                
            }catch(Exception ex){}
        }
    }

    public void Eliminar(Imagen vo) throws AppException{
        
        String sql = "{CALL buscaofertas.eliminarImagen(?)}";
        CallableStatement cst = null;
        try{
            cst = Conectar.getCnn().prepareCall(sql);
            cst.setInt(1, vo.getIdImagen());
            cst.executeUpdate();
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a Imagen"+ex.getMessage());
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a Imagen"+ex.getMessage());
        }finally{
            try{
                cst.close();
                
            }catch(Exception ex){}
        }
    }

    @Override
    public Imagen ObtenerId(Imagen vo) throws AppException {
        
        
        String sql = "{CALL buscaofertas.obtenerIdImagen(?)}";
        ResultSet rs = null;
        CallableStatement cst = null;
        try{
            cst = Conectar.getCnn().prepareCall(sql);
            cst.setInt(1, vo.getIdImagen());
            rs = cst.executeQuery();
            if(rs.next()){
                Imagen voTemp = new Imagen();
                voTemp.setIdImagen(rs.getInt(1));
                voTemp.setLinkImagen(rs.getString(2));
                voTemp.setFoto(rs.getBytes(3));
                return(voTemp);
            }
            return null;
        }catch(SQLException ex){
            throw new AppException(-2,"error al obtenerid a Imagen"+ex.getMessage());
        }catch(Exception ex){
            throw new AppException(-2,"error al obtenerid a Imagen"+ex.getMessage());
        }finally{
            try{
                cst.close();
                rs.close();
                
            }catch(Exception ex){}
        }
    }


}
