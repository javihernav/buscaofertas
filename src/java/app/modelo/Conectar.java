package app.modelo;

import app.utils.AppException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.sql.DataSource;

public class Conectar {

    @Resource(mappedName = "jdbc/senaPool")
    private static DataSource dspool;

    static String baseDeDatos = "buscaofertas";
    static String usuario = "usuario";
    static String clave = "123456";
    static String url = "jdbc:mysql://localhost/" + baseDeDatos;
    public static Connection cnn = null;

    public Conectar() throws AppException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnn = DriverManager.getConnection(url, usuario, clave);
            if (cnn != null) {
                System.out.println("Conexión a base de datos " + baseDeDatos + " OK\n");
            }
        } catch (SQLException ex) {
            throw new AppException(-2, "Base de datos no disponible" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new AppException(-2, "Driver de Base de datos no encontrado" + ex.getMessage());

        }
    }

    public static Connection getCnn() {
        return cnn;
    }

    public static void desconectar() {
        cnn = null;
    }

    public static void main(String[] args) {
        //Conectar con = new Conectar();
        try {
            Connection conexion = dspool.getConnection("usuario", "123456");
            System.out.println("Conexión correcta");
            conexion.close();
        } catch (SQLException ex) {
           System.out.println("error de pool: "+ex.getMessage());
        }
    }

    public DataSource getDspool() {
        return dspool;
    }

    public void setDspool(DataSource dspool) {
        this.dspool = dspool;
    }
}
