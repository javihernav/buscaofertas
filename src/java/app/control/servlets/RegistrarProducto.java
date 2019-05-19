/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.control.servlets;

import app.control.ControlMarca;
import app.control.ControlProducto;
import app.control.ControlUsuario;
import app.modelo.Conectar;
import app.modelo.vo.Marca;
import app.modelo.vo.Producto;
import app.modelo.vo.Usuario;
import app.utils.AppException;
import app.utils.RespuestaServer;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JAVIER
 */
@WebServlet(name = "RegistrarProducto", urlPatterns = {"/RegistrarProducto"})
public class RegistrarProducto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String nombreProducto = request.getParameter("nombreProducto");
            String marcaProducto = request.getParameter("marcaProducto");
            int categoriaProducto = Integer.parseInt(request.getParameter("categoriaProducto"));
       
            String mensaje;
            mensaje = "";
            if (nombreProducto != null
                    && marcaProducto != null
                    && categoriaProducto != 0
                    ) {
                Connection cnn;
                cnn = Conectar.getCnn();
                ControlProducto control = new ControlProducto(cnn);
                ControlMarca controlMarca = new ControlMarca(cnn);
                Marca marcaVo= new Marca();
                marcaVo.setNombreMarca(marcaProducto);
                Marca marca = controlMarca.buscarMarcaPorNombre(marcaVo);//verificar si la marca existe
                int idMarca;
                if (marca == null) {
                    idMarca = controlMarca.insertar(marcaVo);//si no existe la marca, la crea
                }else{
                    idMarca = marca.getIdMarca();//si la marca existe, devuelve el id
                }
                Producto vo = new Producto();
                vo.setNombreProducto(nombreProducto);
                vo.setMarca_idMarca(idMarca);
                vo.setCategoria_idCategoria(categoriaProducto);
                int id=0;
                try {
                    id=control.insertar(vo);

                } catch (AppException ex) {
                    RespuestaServer resp = new RespuestaServer();
                    resp.setCodigo(0);
                    resp.setMensaje("Fallo al insertar Datos" + ex.getMensaje());
                    out.println(id+""+new Gson().toJson(resp));
                }
                System.out.println("OK");
              
                RespuestaServer resp = new RespuestaServer();
                resp.setCodigo(1);
                resp.setMensaje("Producto creado satisfactoriamente");
                out.println(new Gson().toJson(resp));

            }
        } catch (AppException ex) {
            Logger.getLogger(RegistrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
