/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.vista;

import app.control.ControlCiudad;
import app.control.ControlDetalleProducto;
import app.control.ControlDetalleProducto_Tiene_Imagen;
import app.control.ControlImagen;
import app.control.ControlOferta;
import app.control.ControlOferta_Tiene_Ubicacion;
import app.control.ControlProducto;
import app.control.ControlUsuario;
import app.control.ControlUbicacion;
import app.modelo.Conectar;
import app.modelo.vo.Ciudad;
import app.modelo.vo.DetalleProducto;
import app.modelo.vo.DetalleProducto_Tiene_Imagen;
import app.modelo.vo.Imagen;
import app.modelo.vo.Oferta;
import app.modelo.vo.Oferta_Tiene_Ubicacion;
import app.modelo.vo.Producto;
import app.modelo.vo.Ubicacion;
import app.modelo.vo.Usuario;
import app.utils.AppException;
import app.utils.RespuestaServer;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "RegistrarOfertas", urlPatterns = {"/RegistrarOfertas"})
public class RegistrarOfertas extends HttpServlet {

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
            throws ServletException, IOException, ParseException {
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession sesion = request.getSession();
            String usuario = sesion.getAttribute("usuario").toString();
            Usuario usuarioVo = new Usuario();
            usuarioVo.setNombreUsuario(usuario);
            String nombreProducto = request.getParameter("nombreProducto");
            String nombreOferta = request.getParameter("nombreOferta");
            String ciudadOferta = request.getParameter("ciudadOferta");
            String nombreTienda = request.getParameter("nombreTienda");
            String imagenProducto = request.getParameter("imagenProducto");
            String direccionTienda = request.getParameter("direccionTienda");
            String precioOferta = request.getParameter("precioOferta");

            String fechaCreacion = new Date().toString();
            String fechaInicio = request.getParameter("fechaInicio");
            String fechaFinalizacion = request.getParameter("fechaFinalizacion");
            String mensaje;
            mensaje = "";
            if (nombreProducto != null
                    && nombreOferta != null
                    && ciudadOferta != null
                    && imagenProducto != null
                    && direccionTienda != null
                    && precioOferta != null
                    && fechaInicio != null
                    && fechaFinalizacion != null) {
                Connection cnn;
                cnn = Conectar.getCnn();
                ControlUsuario controlUsuario = new ControlUsuario(cnn);
                ControlUbicacion controlUbicacion = new ControlUbicacion(cnn);
                ControlCiudad controlCiudad = new ControlCiudad(cnn);
                ControlImagen controlImagen = new ControlImagen(cnn);
                ControlOferta controlOferta = new ControlOferta(cnn);
                ControlOferta_Tiene_Ubicacion controlOferta_Tiene_Ubicacion = new ControlOferta_Tiene_Ubicacion(cnn);
                ControlProducto controlProducto = new ControlProducto(cnn);
                ControlDetalleProducto controlDetalleProducto = new ControlDetalleProducto(cnn);
                ControlDetalleProducto_Tiene_Imagen controlDetalleProducto_Tiene_Imagen = new ControlDetalleProducto_Tiene_Imagen(cnn);

                int idUsuario = 0;
                int idOferta = 0;
                int idUbicacion=0;
                int idProducto=0;
                int idImagen=0;
                String nombreCiudad = "";
                try {
                    idUsuario = controlUsuario.ObtenerId(usuarioVo).getIdUsuario();
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                    Oferta ofertaVo = new Oferta(0, idUsuario, nombreOferta, formatoFecha.parse(fechaCreacion), formatoFecha.parse(fechaInicio), formatoFecha.parse(fechaFinalizacion), 0);

                    idOferta = controlOferta.insertar(ofertaVo);
                    Ciudad ciudadVo = new Ciudad();
                    ciudadVo.setNombreCiudad(ciudadOferta);
                    //nombreCiudad = controlCiudad.ObtenerId(ciudadVo).getNombreCiudad();
                    Ubicacion ubicacionVo = new Ubicacion(nombreTienda, direccionTienda, ciudadOferta);
                    idUbicacion=controlUbicacion.insertar(ubicacionVo);
                    Oferta_Tiene_Ubicacion otu=new Oferta_Tiene_Ubicacion(idOferta,idUbicacion);
                    controlOferta_Tiene_Ubicacion.insertar(otu);
                    Producto productoVo=new Producto();
                    productoVo.setNombreProducto(nombreProducto);
                    idProducto=controlProducto.insertar(productoVo);
                    DetalleProducto detalleProductoVo=new DetalleProducto(idOferta, idProducto, Double.parseDouble(precioOferta));
                    
                    controlDetalleProducto.insertar(detalleProductoVo);
                    Imagen imgVo= new Imagen(); 
                    imgVo.setLinkImagen(imagenProducto);
                    idImagen=controlImagen.insertar(imgVo);
                    DetalleProducto_Tiene_Imagen dPTIVo=new DetalleProducto_Tiene_Imagen(idImagen,idOferta,idProducto);
                    controlDetalleProducto_Tiene_Imagen.insertar(dPTIVo);
                } catch (AppException ex) {
                    RespuestaServer resp = new RespuestaServer();
                    resp.setCodigo(0);
                    resp.setMensaje("Fallo al insertar Datos" + ex.getMensaje());
                    out.println(new Gson().toJson(resp));
                }
                System.out.println("OK");
                
                sesion.setAttribute("usuario", usuario);
                RespuestaServer resp = new RespuestaServer();
                resp.setCodigo(1);
                resp.setMensaje("Datos Correctos");
                out.println(new Gson().toJson(resp));

            }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(RegistrarOfertas.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(RegistrarOfertas.class.getName()).log(Level.SEVERE, null, ex);
        }
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
