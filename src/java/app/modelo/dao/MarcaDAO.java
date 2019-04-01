package app.modelo.dao;

import app.modelo.Conectar;
import app.modelo.vo.Marca;
import app.utils.AppException;
import app.utils.interfaces.IDao;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class MarcaDAO implements IDao<Marca>{


    public ArrayList<Marca> Consultar() throws AppException{
        ArrayList<Marca> list = new ArrayList<Marca>();
        Conectar conec = new Conectar();
        String sql = "{CALL buscaofertas.consultarMarcas()}";
        ResultSet rs = null;
        CallableStatement cst = null;
        try{
            cst = conec.getCnn().prepareCall(sql);
            rs = cst.executeQuery();
            while(rs.next()){
                Marca vo = new Marca();
                vo.setIdMarca(rs.getInt(1));
                vo.setNombreMarca(rs.getString(2));
                list.add(vo);
            }
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a Marca"+ex.getMessage());
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a Marca"+ex.getMessage());
        }finally{
            try{
                cst.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return list;
    }



    public int Insertar(Marca vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "{CALL buscaofertas.insertMarca(?)}";
        CallableStatement cst = null;
        try{
            cst = conec.getCnn().prepareCall(sql);
           
            cst.setString(1, vo.getNombreMarca());
            cst.executeUpdate();
            ResultSet rs= cst.executeQuery();
            int id=0;
            if(rs.next()){
                id=rs.getInt(1);
            }
            return id;
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a Marca"+ex.getMessage());
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a Marca"+ex.getMessage());
        }finally{
            try{
                cst.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }



    public void Modificar(Marca vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "{CALL buscaofertas.modificarMarca(?,?)}";
        CallableStatement cst = null;
        try{
            cst = conec.getCnn().prepareCall(sql);
            cst.setString(1, vo.getNombreMarca());
            cst.setInt(2, vo.getIdMarca());
            cst.executeUpdate();
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a Marca"+ex.getMessage());
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a Marca"+ex.getMessage());
        }finally{
            try{
                cst.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }



    public void Eliminar(Marca vo) throws AppException{
        Conectar conec = new Conectar();
        String sql = "{call buscaofertas.eliminarMarca(?)}";
        CallableStatement cst = null;
        try{
            cst = conec.getCnn().prepareCall(sql);
            cst.setInt(1, vo.getIdMarca());
            cst.executeUpdate();
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a Marca"+ex.getMessage());
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a Marca"+ex.getMessage());
        }finally{
            try{
                cst.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }

    @Override
    public Marca ObtenerId(Marca vo) throws AppException {
        
        Conectar conec = new Conectar();
        String sql = "{CALL buscaofertas.obtenerIdMarca(?)}";
        ResultSet rs = null;
        CallableStatement cst = null;
        try{
            cst = conec.getCnn().prepareCall(sql);
            cst.setInt(1, vo.getIdMarca());
            rs = cst.executeQuery();
            while(rs.next()){
                Marca voTemp = new Marca();
                voTemp.setIdMarca(rs.getInt(1));
                voTemp.setNombreMarca(rs.getString(2));
                return(voTemp);
            }
            return null;
        }catch(SQLException ex){
            throw new AppException(-2,"error al acceder a Marca"+ex.getMessage());
        }catch(Exception ex){
            throw new AppException(-2,"error al acceder a Marca"+ex.getMessage());
        }finally{
            try{
                cst.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        
    }


}
