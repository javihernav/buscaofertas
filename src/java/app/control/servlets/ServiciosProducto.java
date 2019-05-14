/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.control.servlets;

import app.control.ControlProducto;
import app.control.ControlUsuario;
import app.modelo.Conectar;
import app.modelo.vo.Producto;
import app.modelo.vo.Usuario;
import app.utils.AppException;
import app.utils.RespuestaServer;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JAVIER
 */
@WebServlet(name = "ServiciosProducto", urlPatterns = {"/usus/consultarProductos"}) //urlPatterns = {"/ServiciosUsuario"}
public class ServiciosProducto extends HttpServlet {

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
            Connection cnn=Conectar.getCnn();
            ControlProducto control=new ControlProducto(cnn);
                List<Producto> listaProductos = null;
            try {
                listaProductos = control.consultar();
            } catch (AppException ex) {
                Logger.getLogger(ServiciosProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
            RespuestaServer respuesta = new RespuestaServer();
            if(listaProductos==null||listaProductos.isEmpty()){
                respuesta.setCodigo(0);
                respuesta.setMensaje("no hay datos de productos");
                respuesta.setData(null);
            }else{
            respuesta.setCodigo(1);
                respuesta.setMensaje("datos consultados");
                respuesta.setData(listaProductos);
            }
            out.print(new Gson().toJson(respuesta));
        } catch (AppException ex) {
            Logger.getLogger(ServiciosProducto.class.getName()).log(Level.SEVERE, null, ex);
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
