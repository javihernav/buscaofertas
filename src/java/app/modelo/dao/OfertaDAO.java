package app.modelo.dao;

import app.modelo.Conectar;
import app.modelo.vo.Oferta;
import app.utils.AppException;
import app.utils.interfaces.IDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class OfertaDAO implements IDao<Oferta>{


    public ArrayList<Oferta> Consultar() throws AppException{
        ArrayList<Oferta> list = new ArrayList<Oferta>();
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM oferta;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Oferta vo = new Oferta();
                vo.setIdOferta(rs.getInt(1));
                vo.setUsuario_idUsuario(rs.getInt(2));
                vo.setNombreOferta(rs.getString(3));
                vo.setFechaCreacion(rs.getDate(4));
                vo.setFechaInicio(rs.getDate(5));
                vo.setFechaFin(rs.getDate(6));
                vo.setVecesCompartida(rs.getInt(7));
                list.add(vo);
            }
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a Oferta");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a Oferta");
        }finally{
            try{
                ps.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return list;
    }
    public ArrayList<Oferta> consultarPorIdUsuario(int idUsuario) throws AppException{
        ArrayList<Oferta> list = new ArrayList<Oferta>();
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM oferta where Usuario_idUsuario = ?;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        
        try{
            ps = conec.getCnn().prepareStatement(sql);
            ps.setInt(1, idUsuario);
            rs = ps.executeQuery();
            while(rs.next()){
                Oferta vo = new Oferta();
                vo.setIdOferta(rs.getInt(1));
                vo.setUsuario_idUsuario(rs.getInt(2));
                vo.setNombreOferta(rs.getString(3));
                vo.setFechaCreacion(rs.getDate(4));
                vo.setFechaInicio(rs.getDate(5));
                vo.setFechaFin(rs.getDate(6));
                vo.setVecesCompartida(rs.getInt(7));
                list.add(vo);
            }
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a Oferta");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a Oferta");
        }finally{
            try{
                ps.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return list;
    }
    public Oferta consultarPorIdOferta(int idOferta) throws AppException{
        ArrayList<Oferta> list = new ArrayList<Oferta>();
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM oferta where idOferta = ?;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        
        try{
            ps = conec.getCnn().prepareStatement(sql);
            ps.setInt(1, idOferta);
            rs = ps.executeQuery();
            if(rs.next()){
                Oferta vo = new Oferta();
                vo.setIdOferta(rs.getInt(1));
                vo.setUsuario_idUsuario(rs.getInt(2));
                vo.setNombreOferta(rs.getString(3));
                vo.setFechaCreacion(rs.getDate(4));
                vo.setFechaInicio(rs.getDate(5));
                vo.setFechaFin(rs.getDate(6));
                vo.setVecesCompartida(rs.getInt(7));
                list.add(vo);
            }
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a Oferta");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a Oferta");
        }finally{
            try{
                ps.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return list.get(0);
    }



    public int Insertar(Oferta vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "INSERT INTO oferta (Usuario_idUsuario, nombreOferta, fechaCreacion, fechaInicio, fechaFin, vecesCompartida) VALUES( ?, ?, ?, ?, ?, ?);";
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            int i=1;
            ps.setInt(i++, vo.getUsuario_idUsuario());
            ps.setString(i++, vo.getNombreOferta());
            ps.setDate(i++, new java.sql.Date(vo.getFechaCreacion().getTime()));
            ps.setDate(i++, new java.sql.Date(vo.getFechaInicio().getTime()));
            ps.setDate(i++, new java.sql.Date(vo.getFechaFin().getTime()));
            ps.setInt(i++, vo.getVecesCompartida());
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
            throw new AppException(-2,"error al acceder a Oferta");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a Oferta");
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }



    public void Modificar(Oferta vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "UPDATE oferta SET Usuario_idUsuario = ?, nombreOferta = ?, fechaCreacion = ?, fechaInicio = ?, fechaFin = ?, vecesCompartida = ? WHERE idOferta = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            int i=1;
            ps.setInt(i++, vo.getUsuario_idUsuario());
            ps.setString(i++, vo.getNombreOferta());
            ps.setDate(i++, new java.sql.Date(vo.getFechaCreacion().getTime()));
            ps.setDate(i++, new java.sql.Date(vo.getFechaInicio().getTime()));
            ps.setDate(i++, new java.sql.Date(vo.getFechaFin().getTime()));
            ps.setInt(i++, vo.getVecesCompartida());
            ps.setInt(i++, vo.getIdOferta());
            ps.executeUpdate();
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a Oferta");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a Oferta");
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }



    public void Eliminar(Oferta vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "DELETE FROM oferta WHERE idOferta = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            ps.setInt(1, vo.getIdOferta());
            ps.executeUpdate();
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a Oferta");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a Oferta");
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }

    @Override
    public Oferta ObtenerId(Oferta vo) throws AppException {
        ArrayList<Oferta> list = new ArrayList<Oferta>();
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM oferta where Usuario_idUsuario = ? and nombreOferta = ?;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            ps.setInt(1, vo.getUsuario_idUsuario());
            ps.setString(2, vo.getNombreOferta());
            rs = ps.executeQuery();
            while(rs.next()){
                Oferta voTemp = new Oferta();
                voTemp.setIdOferta(rs.getInt(1));
                voTemp.setUsuario_idUsuario(rs.getInt(2));
                voTemp.setNombreOferta(rs.getString(3));
                voTemp.setFechaCreacion(rs.getDate(4));
                voTemp.setFechaInicio(rs.getDate(5));
                voTemp.setFechaFin(rs.getDate(6));
                voTemp.setVecesCompartida(rs.getInt(7));
                list.add(voTemp);
            }
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a Oferta");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a Oferta");
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
