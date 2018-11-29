package app.vista.forms;

import app.modelo.dao.TipoDAO;
import app.modelo.vo.Tipo;
import app.utils.AppException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Tabla_Tipo{

   TipoDAO dao = null;


    public void visualizar_Tipo(JTable tabla){
        DefaultTableModel dt = new DefaultTableModel();
        dt.addColumn("idTipo");
        dt.addColumn("Categoria_idCategoria");
        dt.addColumn("nombreTipo");

        dao = new TipoDAO();
        Tipo vo = new Tipo();
        ArrayList<Tipo> list = null;
       try {
           list = dao.Consultar();
       } catch (AppException ex) {
           Logger.getLogger(Tabla_Tipo.class.getName()).log(Level.SEVERE, null, ex);
       }

        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[3];
                vo = list.get(i);
                fila[0] = vo.getIdTipo();
                fila[1] = vo.getCategoria_idCategoria();
                fila[2] = vo.getNombreTipo();
                dt.addRow(fila);
            }
            tabla.setModel(dt);
        }
    }
}


