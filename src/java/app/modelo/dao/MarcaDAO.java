package app.modelo.dao;

import app.modelo.Conectar;
import app.modelo.vo.Marca;
import app.utils.AppException;
import app.utils.interfaces.IDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class MarcaDAO implements IDao<Marca>{


    public ArrayList<Marca> Consultar() throws AppException{
        ArrayList<Marca> list = new ArrayList<Marca>();
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM marca;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Marca vo = new Marca();
                vo.setIdMarca(rs.getInt(1));
                vo.setNombreMarca(rs.getString(2));
                list.add(vo);
            }
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a Marca");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a Marca");
        }finally{
            try{
                ps.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return list;
    }



    public int Insertar(Marca vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "INSERT INTO marca ( nombreMarca) VALUES(?);";
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            //ps.setInt(1, vo.getIdMarca());
            ps.setString(1, vo.getNombreMarca());
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
            throw new AppException(-2,"error al acceder a Marca");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a Marca");
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }



    public void Modificar(Marca vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "UPDATE marca SET nombreMarca = ? WHERE idMarca = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            ps.setString(1, vo.getNombreMarca());
            ps.setInt(2, vo.getIdMarca());
            ps.executeUpdate();
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a Marca");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a Marca");
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }



    public void Eliminar(Marca vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "DELETE FROM marca WHERE idMarca = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            ps.setInt(1, vo.getIdMarca());
            ps.executeUpdate();
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a Marca");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a Marca");
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }

    @Override
    public Marca ObtenerId(Marca vo) throws AppException {
        ArrayList<Marca> list = new ArrayList<Marca>();
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM marca where idMarca = ?;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getCnn().prepareStatement(sql);
            ps.setInt(1, vo.getIdMarca());
            rs = ps.executeQuery();
            while(rs.next()){
                Marca voTemp = new Marca();
                voTemp.setIdMarca(rs.getInt(1));
                voTemp.setNombreMarca(rs.getString(2));
                list.add(voTemp);
            }
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a Marca");
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a Marca");
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
