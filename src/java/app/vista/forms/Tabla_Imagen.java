package app.vista.forms;

import app.modelo.dao.ImagenDAO;
import app.modelo.vo.Imagen;
import app.utils.AppException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Tabla_Imagen{

   ImagenDAO dao = null;


    public void visualizar_Imagen(JTable tabla){
        DefaultTableModel dt = new DefaultTableModel();
        dt.addColumn("idImagen");
        dt.addColumn("linkImagen");

        dao = new ImagenDAO();
        Imagen vo = new Imagen();
        ArrayList<Imagen> list = null;
       try {
           list = dao.Consultar();
       } catch (AppException ex) {
           Logger.getLogger(Tabla_Imagen.class.getName()).log(Level.SEVERE, null, ex);
       }

        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[2];
                vo = list.get(i);
                fila[0] = vo.getIdImagen();
                fila[1] = vo.getLinkImagen();
                dt.addRow(fila);
            }
            tabla.setModel(dt);
        }
    }
}


