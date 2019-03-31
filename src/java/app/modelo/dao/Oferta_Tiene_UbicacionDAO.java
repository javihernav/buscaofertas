package app.modelo.dao;

import app.modelo.Conectar;
import app.modelo.vo.Oferta_Tiene_Ubicacion;
import app.utils.AppException;
import app.utils.interfaces.IDao;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Oferta_Tiene_UbicacionDAO implements IDao<Oferta_Tiene_Ubicacion>{


    public ArrayList<Oferta_Tiene_Ubicacion> Consultar() throws AppException{
        ArrayList<Oferta_Tiene_Ubicacion> list = new ArrayList<Oferta_Tiene_Ubicacion>();
        Conectar conec = new Conectar();
        String sql = "{CALL buscaofertas.consultarOfertaTieneUbicacion()}";
        ResultSet rs = null;
        CallableStatement cst = null;
        try{
            cst = conec.getCnn().prepareCall(sql);
            rs = cst.executeQuery();
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
                cst.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return list;
    }



    public int Insertar(Oferta_Tiene_Ubicacion vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "INSERT INTO oferta_tiene_ubicacion (Oferta_idOferta, Ubicacion_idUbicacion) VALUES( ?, ?);";
        CallableStatement cst = null;
        try{
            cst = conec.getCnn().prepareCall(sql);
           
            cst.setInt(1, vo.getOferta_idOferta());
            cst.setInt(2, vo.getUbicacion_idUbicacion());
            ResultSet rs= cst.executeQuery();
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
                cst.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }



    public void Modificar(Oferta_Tiene_Ubicacion vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "{CALL buscaofertas.modificarOfertaTieneUbicacion(?,?,?)}";
        CallableStatement cst = null;
        try{
            cst = conec.getCnn().prepareCall(sql);
            cst.setInt(1, vo.getOferta_idOferta());
            cst.setInt(2, vo.getUbicacion_idUbicacion());
            cst.setInt(3, vo.getId_Oferta_tiene_Ubicacion());
            cst.executeUpdate();
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a OTubicación");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a OTubicación");
        }finally{
            try{
                cst.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }



    public void Eliminar(Oferta_Tiene_Ubicacion vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "{CALL buscaofertas.eliminarOfertaTieneUbicacion(?)}";
        CallableStatement cst = null;
        try{
            cst = conec.getCnn().prepareCall(sql);
            cst.setInt(1, vo.getId_Oferta_tiene_Ubicacion());
            cst.executeUpdate();
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a OTubicación");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a OTubicación");
        }finally{
            try{
                cst.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }

    @Override
    public Oferta_Tiene_Ubicacion ObtenerId(Oferta_Tiene_Ubicacion vo) throws AppException {
        
        Conectar conec = new Conectar();
                           //  	    oferta_tiene_ubicacion       Oferta_idOferta
        String sql = "{CALL buscaofertas.obtenerIdOfertaTieneUbicacion(?)}";
        ResultSet rs = null;
        CallableStatement cst = null;
        try{
            cst = conec.getCnn().prepareCall(sql);
            cst.setInt(1, vo.getOferta_idOferta());
            System.out.println("id de oferta recibido en Oferta_Tiene_ubicacionDAO.ObtenerId: "+vo.getOferta_idOferta());
            rs = cst.executeQuery();
            if(rs.next()){
                Oferta_Tiene_Ubicacion voTemp = new Oferta_Tiene_Ubicacion();
                voTemp.setId_Oferta_tiene_Ubicacion(rs.getInt(1));
                voTemp.setOferta_idOferta(rs.getInt(2));
                voTemp.setUbicacion_idUbicacion(rs.getInt(3));
                return(voTemp);
            }
            return null;
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a OTubicación");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a OTubicación");
        }finally{
            try{
                cst.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        
    }
    public Oferta_Tiene_Ubicacion consultarPorIdOferta(Oferta_Tiene_Ubicacion vo) throws AppException {
        
        Conectar conec = new Conectar();
        String sql = "{CALL buscaofertas.consultarPorIdOfertaTieneUbicacion(?)}";
        ResultSet rs = null;
        CallableStatement cst = null;
        try{
            cst = conec.getCnn().prepareCall(sql);
            cst.setInt(1, vo.getId_Oferta_tiene_Ubicacion());
            rs = cst.executeQuery();
            if(rs.next()){
                Oferta_Tiene_Ubicacion voTemp = new Oferta_Tiene_Ubicacion();
                voTemp.setId_Oferta_tiene_Ubicacion(rs.getInt(1));
                voTemp.setOferta_idOferta(rs.getInt(2));
                voTemp.setUbicacion_idUbicacion(rs.getInt(3));
                return (voTemp);
            }
            return null;
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a OTubicación");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a OTubicación");
        }finally{
            try{
                cst.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        
    }


}
