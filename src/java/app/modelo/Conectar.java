package app.modelo;

import app.utils.AppException;
//import com.sun.appserv.jdbc.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import org.apache.commons.dbcp.BasicDataSource;
public final class Conectar {

//    @Resource(mappedName = "jdbc/buscaofertasPool")
//    private static DataSource ds;
    static String baseDeDatos = "buscaofertas";
    static String usuario = "usuario";
    static String clave = "123456";
    static String url = "jdbc:mysql://localhost/" + baseDeDatos;
    private static Connection cnn = null;
    
    private Conectar() throws AppException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnn = DriverManager.getConnection(url, usuario, clave);
            //cnn.setAutoCommit(false);
//            if (cnn != null) {
//                System.out.println("Conexión a base de datos " + cnn + " OK\n");
//            }
        } catch (SQLException ex) {
            throw new AppException(-2, "Base de datos no disponible" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            
            throw new AppException(-2, "Driver de Base de datos no encontrado" + ex.getMessage());
            
        }
    }

    public static Connection getCnn() throws AppException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnn = DriverManager.getConnection(url, usuario, clave);
            
//            if (cnn != null) {
//                System.out.println("Conexión a base de datos " + cnn + " OK\n");
//            }
        } catch (SQLException ex) {
            throw new AppException(-2, "Base de datos no disponible" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            
            
            
        }
        return cnn;
    }
    
    public static void desconectar() throws AppException {
        try {
            cnn.close();
        } catch (SQLException ex) {
            throw new AppException(-2, "Problema al cerrar la conexión: " + ex.getMessage());
        }
        cnn = null;
    }
    
    public static void main(String[] args) throws AppException{
        try {
            
            Connection conexion = Conectar.getCnn();
            System.out.println("Conexión correcta");
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("error de pool: " + ex.getMessage());
            
        }
    }
}
