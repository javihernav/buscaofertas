/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.control.servlets;

import app.control.ControlUsuario;
import app.modelo.Conectar;
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
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author JAVIER
 */
@WebServlet(name = "RegistrarUsuario", urlPatterns = {"/RegistrarUsuario"})
public class RegistrarUsuario extends HttpServlet {

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
            
            String nombres = request.getParameter("nombres");
            String apellidos = request.getParameter("apellidos");
            String correo = request.getParameter("correo");
            String telefono = request.getParameter("telefono");
            int ciudad = Integer.parseInt(request.getParameter("ciudad"));
            String fechaDeNacimiento = request.getParameter("fechaDeNacimiento");
            String usuario = request.getParameter("usuario");
            String clave = request.getParameter("clave");
            
            String genero = request.getParameter("genero");
            String mensaje;
            mensaje = "";
            if (nombres != null
                    && apellidos != null
                    && correo != null
                    && telefono != null
                    && ciudad != 0
                    && fechaDeNacimiento != null
                    && usuario != null
                    && clave != null
                    && genero != null
                    ) {
                Connection cnn;
                cnn = Conectar.getCnn();
                ControlUsuario control = new ControlUsuario(cnn);
                Usuario vo = new Usuario();
                vo.setNombre(nombres);
                vo.setApellido(apellidos);
                vo.setCorreo(correo);
                vo.setTelefono(telefono);
                vo.setCiudad_idCiudad(ciudad);
                vo.setFechaNacimiento(fechaDeNacimiento);
                vo.setNombreUsuario(usuario);
                vo.setContrasena(clave);
                vo.setGenero(genero.charAt(0));
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
                HttpSession sesion = request.getSession();
                sesion.setAttribute("usuario", usuario);
                RespuestaServer resp = new RespuestaServer();
                resp.setCodigo(1);
                resp.setMensaje("Usuario creado satisfactoriamente");
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
