package app.vista.forms;

import app.modelo.dao.UsuarioDAO;
import app.modelo.vo.Usuario;
import app.utils.AppException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Tabla_Usuario{

   UsuarioDAO dao = null;


    public void verUsuarios(JTable tabla){
        DefaultTableModel dt = new DefaultTableModel();
        dt.addColumn("idUsuario");
        dt.addColumn("Ciudad_idCiudad");
        dt.addColumn("nombreUsuario");
        dt.addColumn("contraseña");
        dt.addColumn("nombre");
        dt.addColumn("apellido");
        dt.addColumn("telefono");
        dt.addColumn("correo");
        dt.addColumn("fechaNacimiento");
        dt.addColumn("genero");
        dt.addColumn("rol");

        dao = new UsuarioDAO();
        Usuario vo = new Usuario();
        ArrayList<Usuario> list;
        list=null;
       try {
           list = dao.Consultar();
       } catch (AppException ex) {
           Logger.getLogger(Tabla_Usuario.class.getName()).log(Level.SEVERE, null, ex);
       }

        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[11];
                vo = list.get(i);
                fila[0] = vo.getIdUsuario();
                fila[1] = vo.getCiudad_idCiudad();
                fila[2] = vo.getNombreUsuario();
                fila[3] = vo.getContrasena();
                fila[4] = vo.getNombre();
                fila[5] = vo.getApellido();
                fila[6] = vo.getTelefono();
                fila[7] = vo.getCorreo();
                fila[8] = vo.getFechaNacimiento();
                fila[9] = vo.getGenero();
                fila[10] = vo.getRol();
                dt.addRow(fila);
            }
            tabla.setModel(dt);
        }
    }
}


