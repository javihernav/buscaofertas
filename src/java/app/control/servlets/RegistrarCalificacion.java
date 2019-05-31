/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.control.servlets;

import app.control.ControlCalificacion;
import app.control.ControlOferta;
import app.control.ControlUsuario;
import app.modelo.Conectar;
import app.modelo.vo.Calificacion;
import app.modelo.vo.Oferta;
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
@WebServlet(name = "RegistrarCalificacion", urlPatterns = {"/RegistrarCalificacion"})
public class RegistrarCalificacion extends HttpServlet {

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
            HttpSession sesion6 = request.getSession();
            Object usuarioObject = sesion6.getAttribute("usuario");
            int idOferta = Integer.parseInt(request.getParameter("idOferta"));
            RespuestaServer rs = new RespuestaServer();
            if (usuarioObject == null) {
                rs.setCodigo(0);
                rs.setMensaje("Debes iniciar sesión para calificar ofertas!");
                out.println(new Gson().toJson(rs));
            } else {
                Usuario usuario = null;
                Oferta oferta = new Oferta();
                usuario = (Usuario) usuarioObject;
                Connection cnn = Conectar.getCnn();
                ControlCalificacion controlCalificacion = new ControlCalificacion(cnn);
                ControlUsuario controlUsuario = new ControlUsuario(cnn);
                ControlOferta controlOferta = new ControlOferta(cnn);
                oferta.setIdOferta(idOferta);
                oferta = controlOferta.ObtenerId(oferta);
                Calificacion calificacion = new Calificacion();
                calificacion.setIdUsuario(usuario.getIdUsuario());
                calificacion.setIdOferta(oferta.getIdOferta());
                String opinion = (String) request.getParameter("opinion");
                String resumen = (String) request.getParameter("resumen");
                int puntosPrecio = Integer.parseInt((String) request.getParameter("puntosPrecio"));
                int puntosCalidad = Integer.parseInt((String) request.getParameter("puntosCalidad"));
                calificacion.setOpinion(opinion);
                calificacion.setResumen(resumen);
                calificacion.setPuntosPrecio(puntosPrecio);
                calificacion.setPuntosCalidad(puntosCalidad);
                controlCalificacion.insertar(calificacion);
                rs.setCodigo(1);
                rs.setMensaje("Calificación registrada con éxito!");
                out.println(new Gson().toJson(rs));
            }

        } catch (Exception ex) {
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
