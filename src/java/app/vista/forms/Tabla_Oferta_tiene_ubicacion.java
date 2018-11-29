package app.vista.forms;

import app.modelo.dao.Oferta_Tiene_UbicacionDAO;
import app.modelo.vo.Oferta_Tiene_Ubicacion;
import app.utils.AppException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Tabla_Oferta_tiene_ubicacion{

   Oferta_Tiene_UbicacionDAO dao = null;


    public void visualizar_Oferta_tiene_ubicacion(JTable tabla){
        DefaultTableModel dt = new DefaultTableModel();
        dt.addColumn("Id_Oferta_tiene_Ubicacion");
        dt.addColumn("Oferta_idOferta");
        dt.addColumn("Ubicacion_idUbicacion");

        dao = new Oferta_Tiene_UbicacionDAO();
        Oferta_Tiene_Ubicacion vo = new Oferta_Tiene_Ubicacion();
        ArrayList<Oferta_Tiene_Ubicacion> list = null;
       try {
           list = dao.Consultar();
       } catch (AppException ex) {
           Logger.getLogger(Tabla_Oferta_tiene_ubicacion.class.getName()).log(Level.SEVERE, null, ex);
       }

        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[3];
                vo = list.get(i);
                fila[0] = vo.getId_Oferta_tiene_Ubicacion();
                fila[1] = vo.getOferta_idOferta();
                fila[2] = vo.getUbicacion_idUbicacion();
                dt.addRow(fila);
            }
            tabla.setModel(dt);
        }
    }
}


