package app.modelo.dao;

import app.modelo.Conectar;
import app.modelo.vo.Tipo;
import app.utils.AppException;
import app.utils.interfaces.IDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class TipoDAO implements IDao<Tipo>{


    public ArrayList<Tipo> Consultar() throws AppException{
        ArrayList<Tipo> list = new ArrayList<Tipo>();
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM tipo;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Tipo vo = new Tipo();
                vo.setIdTipo(rs.getInt(1));
                vo.setCategoria_idCategoria(rs.getInt(2));
                vo.setNombreTipo(rs.getString(3));
                list.add(vo);
            }
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a Tipo");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a Tipo");
        }finally{
            try{
                ps.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return list;
    }



    public int Insertar(Tipo vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "INSERT INTO tipo (Categoria_idCategoria, nombreTipo) VALUES( ?, ?);";
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            
            ps.setInt(1, vo.getCategoria_idCategoria());
            ps.setString(2, vo.getNombreTipo());
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
            throw new AppException(-2,"error al acceder a Tipo");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a Tipo");
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }



    public void Modificar(Tipo vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "UPDATE tipo SET Categoria_idCategoria = ?, nombreTipo = ? WHERE idTipo = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            ps.setInt(1, vo.getCategoria_idCategoria());
            ps.setString(2, vo.getNombreTipo());
            ps.setInt(3, vo.getIdTipo());
            ps.executeUpdate();
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a Tipo");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a Tipo");
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }



    public void Eliminar(Tipo vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "DELETE FROM tipo WHERE idTipo = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            ps.setInt(1, vo.getIdTipo());
            ps.executeUpdate();
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a Tipo");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a Tipo");
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }

    @Override
    public Tipo ObtenerId(Tipo vo) throws AppException {
        ArrayList<Tipo> list = new ArrayList<Tipo>();
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM tipo where idTipo = ?;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            ps.setInt(1, vo.getIdTipo());
            rs = ps.executeQuery();
            if(rs.next()){
                Tipo voTemp = new Tipo();
                voTemp.setIdTipo(rs.getInt(1));
                voTemp.setCategoria_idCategoria(rs.getInt(2));
                voTemp.setNombreTipo(rs.getString(3));
                list.add(voTemp);
            }
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a Tipo");
        
        }finally{
            try{
                ps.close();
                rs.close();
                conec.desconectar();
            }catch(SQLException ex){throw new AppException(-2,"error al cerrar conexion a bd");}
        }
        return list.get(0);
    }


}
