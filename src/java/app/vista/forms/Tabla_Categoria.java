package app.vista.forms;

import app.modelo.dao.CategoriaDAO;
import app.modelo.vo.Categoria;
import app.utils.AppException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Tabla_Categoria{

   CategoriaDAO dao = null;


    public void visualizar_Categoria(JTable tabla){
        DefaultTableModel dt = new DefaultTableModel();
        dt.addColumn("idCategoria");
        dt.addColumn("nombreCategoria");

        dao = new CategoriaDAO();
        Categoria vo = new Categoria();
        ArrayList<Categoria> list = null;
       try {
           list = dao.Consultar();
       } catch (AppException ex) {
           Logger.getLogger(Tabla_Categoria.class.getName()).log(Level.SEVERE, null, ex);
       }

        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[2];
                vo = list.get(i);
                fila[0] = vo.getIdCategoria();
                fila[1] = vo.getNombreCategoria();
                dt.addRow(fila);
            }
            tabla.setModel(dt);
        }
    }
}


