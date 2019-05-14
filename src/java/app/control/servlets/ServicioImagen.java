/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.control.servlets;

import app.control.ControlImagen;
import app.modelo.Conectar;
import app.modelo.vo.Imagen;
import app.utils.AppException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
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
@WebServlet(name = "ServicioImagen", urlPatterns = {"/ServicioImagen/*"})
public class ServicioImagen extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
        
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
        try {
            String idImagenString = request.getPathInfo().substring(1); // Returns "foo.png".
            Connection cnn=null;
            try {
                cnn = Conectar.getCnn();
            } catch (AppException ex) {
                Logger.getLogger(ServicioImagen.class.getName()).log(Level.SEVERE, null, ex);
            }
            Imagen vo = new Imagen();
            vo.setIdImagen(Integer.parseInt(idImagenString));
            ControlImagen controlImagen = new ControlImagen(cnn);
            byte[] content = controlImagen.ObtenerId(vo).getFotoByteArray();
            
            
            // byte[] content = resultSet.getBytes("content");
            response.setContentType(getServletContext().getMimeType(idImagenString));
            response.setContentLength(content.length);
            response.getOutputStream().write(content);
            
            
            
            processRequest(request, response);
        } catch (AppException ex) {
            Logger.getLogger(ServicioImagen.class.getName()).log(Level.SEVERE, null, ex);
        }
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
