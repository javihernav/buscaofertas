package app.vista.forms;

import app.modelo.dao.MarcaDAO;
import app.modelo.vo.Marca;
import app.utils.AppException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Tabla_Marca{

   MarcaDAO dao = null;


    public void visualizar_Marca(JTable tabla){
        DefaultTableModel dt = new DefaultTableModel();
        dt.addColumn("idMarca");
        dt.addColumn("nombreMarca");

        dao = new MarcaDAO();
        Marca vo = new Marca();
        ArrayList<Marca> list = null;
       try {
           list = dao.Consultar();
       } catch (AppException ex) {
           Logger.getLogger(Tabla_Marca.class.getName()).log(Level.SEVERE, null, ex);
       }

        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[2];
                vo = list.get(i);
                fila[0] = vo.getIdMarca();
                fila[1] = vo.getNombreMarca();
                dt.addRow(fila);
            }
            tabla.setModel(dt);
        }
    }
}


