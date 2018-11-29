package app.vista.forms;

import app.modelo.dao.OfertaDAO;
import app.modelo.vo.Oferta;
import app.utils.AppException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Tabla_Oferta{

   OfertaDAO dao = null;


    public void visualizar_Oferta(JTable tabla){
        DefaultTableModel dt = new DefaultTableModel();
        dt.addColumn("idOferta");
        dt.addColumn("Usuario_idUsuario");
        dt.addColumn("nombreOferta");
        dt.addColumn("fechaCreacion");
        dt.addColumn("fechaInicio");
        dt.addColumn("fechaFin");
        dt.addColumn("vecesCompartida");

        dao = new OfertaDAO();
        Oferta vo = new Oferta();
        ArrayList<Oferta> list = null;
       try {
           list = dao.Consultar();
       } catch (AppException ex) {
           Logger.getLogger(Tabla_Oferta.class.getName()).log(Level.SEVERE, null, ex);
       }

        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[7];
                vo = list.get(i);
                fila[0] = vo.getIdOferta();
                fila[1] = vo.getUsuario_idUsuario();
                fila[2] = vo.getNombreOferta();
                fila[3] = vo.getFechaCreacion();
                fila[4] = vo.getFechaInicio();
                fila[5] = vo.getFechaFin();
                fila[6] = vo.getVecesCompartida();
                dt.addRow(fila);
            }
            tabla.setModel(dt);
        }
    }
}


