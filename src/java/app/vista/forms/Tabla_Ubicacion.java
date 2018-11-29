package app.vista.forms;

import app.modelo.dao.UbicacionDAO;
import app.modelo.vo.Ubicacion;
import app.utils.AppException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Tabla_Ubicacion{

   UbicacionDAO dao = null;


    public void visualizar_Ubicacion(JTable tabla){
        DefaultTableModel dt = new DefaultTableModel();
        dt.addColumn("idUbicacion");
        dt.addColumn("nombreTienda");
        dt.addColumn("direccion");
        dt.addColumn("ciudad");

        dao = new UbicacionDAO();
        Ubicacion vo = new Ubicacion();
        ArrayList<Ubicacion> list=null;
       try {
           list = dao.Consultar();
       } catch (AppException ex) {
           Logger.getLogger(Tabla_Ubicacion.class.getName()).log(Level.SEVERE, null, ex);
       }

        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[4];
                vo = list.get(i);
                fila[0] = vo.getIdUbicacion();
                fila[1] = vo.getNombreTienda();
                fila[2] = vo.getDireccion();
                fila[3] = vo.getCiudad();
                dt.addRow(fila);
            }
            tabla.setModel(dt);
        }
    }
}


