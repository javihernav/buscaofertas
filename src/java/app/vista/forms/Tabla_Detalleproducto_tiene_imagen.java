package app.vista.forms;

import app.modelo.dao.DetalleProducto_Tiene_ImagenDAO;
import app.modelo.vo.DetalleProducto_Tiene_Imagen;
import app.utils.AppException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Tabla_Detalleproducto_tiene_imagen{

   DetalleProducto_Tiene_ImagenDAO dao = null;


    public void visualizar_Detalleproducto_tiene_imagen(JTable tabla){
        DefaultTableModel dt = new DefaultTableModel();
        dt.addColumn("Id_DetalleProducto_tiene_Imagen");
        dt.addColumn("Imagen_idImagen");
        dt.addColumn("DetalleProducto_Oferta_idOferta");
        dt.addColumn("DetalleProducto_Producto_idProducto");

        dao = new DetalleProducto_Tiene_ImagenDAO();
        DetalleProducto_Tiene_Imagen vo = new DetalleProducto_Tiene_Imagen();
        ArrayList<DetalleProducto_Tiene_Imagen> list = null;
       try {
           list = dao.Consultar();
       } catch (AppException ex) {
           Logger.getLogger(Tabla_Detalleproducto_tiene_imagen.class.getName()).log(Level.SEVERE, null, ex);
       }

        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[4];
                vo = list.get(i);
                fila[0] = vo.getId_DetalleProducto_tiene_Imagen();
                fila[1] = vo.getImagen_idImagen();
                fila[2] = vo.getDetalleProducto_Oferta_idOferta();
                fila[3] = vo.getDetalleProducto_Producto_idProducto();
                dt.addRow(fila);
            }
            tabla.setModel(dt);
        }
    }
}


