package app.vista.forms;

import app.modelo.dao.CiudadDAO;
import app.modelo.vo.Ciudad;
import app.utils.AppException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Tabla_Ciudad{

   CiudadDAO dao = null;


    public void visualizar_Ciudad(JTable tabla){
        DefaultTableModel dt = new DefaultTableModel();
        dt.addColumn("idCiudad");
        dt.addColumn("nombreCiudad");
        dt.addColumn("departamentoCiudad");

        dao = new CiudadDAO();
        Ciudad vo = new Ciudad();
        ArrayList<Ciudad> list=null;
       try {
           list = dao.Consultar();
       } catch (AppException ex) {
           Logger.getLogger(Tabla_Ciudad.class.getName()).log(Level.SEVERE, null, ex);
       }

        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[3];
                vo = list.get(i);
                fila[0] = vo.getIdCiudad();
                fila[1] = vo.getNombreCiudad();
                fila[2] = vo.getDepartamentoCiudad();
                dt.addRow(fila);
            }
            tabla.setModel(dt);
        }
    }
}


