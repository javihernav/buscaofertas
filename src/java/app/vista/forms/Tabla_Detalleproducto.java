package app.vista.forms;

import app.modelo.Conectar;
import app.modelo.dao.DetalleProductoDAO;
import app.modelo.vo.DetalleProducto;
import app.utils.AppException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Tabla_Detalleproducto{

   DetalleProductoDAO dao = null;


    public void visualizar_Detalleproducto(JTable tabla){
        DefaultTableModel dt = new DefaultTableModel();
        dt.addColumn("Oferta_idOferta");
        dt.addColumn("Producto_idProducto");
        dt.addColumn("precio");
        dt.addColumn("Producto_idProducto1");
        dt.addColumn("Oferta_idOferta1");

       try {
           dao = new DetalleProductoDAO(Conectar.getCnn());
       } catch (AppException ex) {
           Logger.getLogger(Tabla_Detalleproducto.class.getName()).log(Level.SEVERE, null, ex);
       }
        DetalleProducto vo = new DetalleProducto();
        ArrayList<DetalleProducto> list = null;
       try {
           list = dao.Consultar();
       } catch (AppException ex) {
           Logger.getLogger(Tabla_Detalleproducto.class.getName()).log(Level.SEVERE, null, ex);
       }

        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[5];
                vo = list.get(i);
                fila[0] = vo.getOferta_idOferta();
                fila[1] = vo.getProducto_idProducto();
                fila[2] = vo.getPrecio();
                dt.addRow(fila);
            }
            tabla.setModel(dt);
        }
    }
}


