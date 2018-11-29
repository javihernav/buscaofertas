package app.vista.forms;

import app.modelo.dao.ProductoDAO;
import app.modelo.vo.Producto;
import app.utils.AppException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Tabla_Producto{

   ProductoDAO dao = null;


    public void visualizar_Producto(JTable tabla){
        DefaultTableModel dt = new DefaultTableModel();
        dt.addColumn("idProducto");
        dt.addColumn("Tipo_idTipo");
        dt.addColumn("Marca_idMarca");
        dt.addColumn("nombreProducto");
        dt.addColumn("fabricanteProducto");
        dt.addColumn("modeloProducto");
        dt.addColumn("presentacionProducto");

        dao = new ProductoDAO();
        Producto vo = new Producto();
        ArrayList<Producto> list = null;
       try {
           list = dao.Consultar();
       } catch (AppException ex) {
           Logger.getLogger(Tabla_Producto.class.getName()).log(Level.SEVERE, null, ex);
       }

        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[7];
                vo = list.get(i);
                fila[0] = vo.getIdProducto();
                fila[1] = vo.getTipo_idTipo();
                fila[2] = vo.getMarca_idMarca();
                fila[3] = vo.getNombreProducto();
                fila[4] = vo.getFabricanteProducto();
                fila[5] = vo.getModeloProducto();
                fila[6] = vo.getPresentacionProducto();
                dt.addRow(fila);
            }
            tabla.setModel(dt);
        }
    }
}


