/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.control.servlets;

import app.control.ControlCategoria;
import app.control.ControlDetalleProducto;
import app.control.ControlDetalleProducto_Tiene_Imagen;
import app.control.ControlImagen;
import app.control.ControlMarca;
import app.control.ControlOferta;
import app.control.ControlOferta_Tiene_Ubicacion;
import app.control.ControlProducto;
import app.control.ControlTipo;
import app.control.ControlUbicacion;
import app.control.ControlUsuario;
import app.modelo.Conectar;
import app.modelo.vo.Categoria;
import app.modelo.vo.DetalleProducto;
import app.modelo.vo.DetalleProducto_Tiene_Imagen;
import app.modelo.vo.Imagen;
import app.modelo.vo.Marca;
import app.modelo.vo.Oferta;
import app.modelo.vo.Oferta_Tiene_Ubicacion;
import app.modelo.vo.Producto;
import app.modelo.vo.Tipo;
import app.modelo.vo.Ubicacion;
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
@WebServlet(name = "EliminarOferta", urlPatterns = {"/EliminarOferta"})
public class EliminarOferta extends HttpServlet {

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
            throws ServletException, IOException, AppException {
//        response.setContentType("application/json;charset=UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            HttpSession sesion = request.getSession();
            Object idOfertaObject = request.getParameter("idOferta");
            Object usuarioObject = sesion.getAttribute("usuario");
            Usuario usuarioVo = null;
            Oferta ofertaAEliminar = null;
            Ubicacion ubicacionAEliminar = null;
      
            Imagen imagenAEliminar = null;
            DetalleProducto detalleProductoAEliminar = null;
            Producto productoVo = null;
            Marca marcaVo = null;

            String mensaje;
            mensaje = "";
//            if (idOfertaObject != null && usuarioObject != null) {
            if (idOfertaObject != null) {
                String idOfertaString = (String) idOfertaObject;
                usuarioVo = (Usuario)usuarioObject;
                System.out.println("linea 69 de Servlet EliminarOferta id de la oferta recibido: " + idOfertaString+" usuario:"+usuarioVo);
                int idOferta = 0;
                try {
                    idOferta = Integer.parseInt(idOfertaString);
                } catch (NumberFormatException e) {
                    System.out.println("error al convertir el numero de oferta");
                }
                Connection cnn;
                cnn = Conectar.getCnn();

                ControlOferta controlOferta = new ControlOferta(cnn);
                ControlOferta_Tiene_Ubicacion controlOferta_Tiene_Ubicacion = new ControlOferta_Tiene_Ubicacion(cnn);
                ControlUbicacion controlUbicacion = new ControlUbicacion(cnn);
                ControlDetalleProducto controlDetalleProducto = new ControlDetalleProducto(cnn);
                ControlDetalleProducto_Tiene_Imagen controlDetalleProducto_Tiene_Imagen = new ControlDetalleProducto_Tiene_Imagen(cnn);
                ControlImagen controlImagen = new ControlImagen(cnn);
                ControlProducto controlProducto = new ControlProducto(cnn);
                ControlMarca controlMarca = new ControlMarca(cnn);

                Oferta offer = new Oferta();
                offer.setIdOferta(idOferta);
                ofertaAEliminar = controlOferta.ObtenerId(offer);

                Oferta_Tiene_Ubicacion offerTieneUbicacion = new Oferta_Tiene_Ubicacion();
                offerTieneUbicacion.setOferta_idOferta(ofertaAEliminar.getIdOferta());
                Oferta_Tiene_Ubicacion ofertaTUAEliminar = controlOferta_Tiene_Ubicacion.ObtenerId(offerTieneUbicacion); System.out.println("línea 111 offerTieneUbicacion: " + offerTieneUbicacion);
                System.out.println("línea 112 ofertaTUAEliminar: " + ofertaTUAEliminar);

                Ubicacion ubicacion = new Ubicacion();
                ubicacion.setIdUbicacion(ofertaTUAEliminar.getUbicacion_idUbicacion());
                ubicacionAEliminar = controlUbicacion.ObtenerId(ubicacion);

                System.out.println("línea 116 Eliminación ofertaTUAEliminar: " + ofertaTUAEliminar);
                controlOferta_Tiene_Ubicacion.eliminar(ofertaTUAEliminar);//elimina otu
                System.out.println("línea 118 Eliminación ubicacionAEliminar: " + ubicacionAEliminar);
                controlUbicacion.eliminar(ubicacionAEliminar);

                DetalleProducto detalleProducto = new DetalleProducto();
                detalleProducto.setOferta_idOferta(idOferta);
                detalleProductoAEliminar = controlDetalleProducto.ObtenerId(detalleProducto);

                DetalleProducto_Tiene_Imagen detalleProducto_Tiene_Imagen = new DetalleProducto_Tiene_Imagen();
                detalleProducto_Tiene_Imagen.setDetalleProducto_Oferta_idOferta(idOferta);
                detalleProducto_Tiene_Imagen.setDetalleProducto_Producto_idProducto(detalleProductoAEliminar.getProducto_idProducto());
                DetalleProducto_Tiene_Imagen DPTIAEliminar = controlDetalleProducto_Tiene_Imagen.ObtenerId(detalleProducto_Tiene_Imagen);

                Imagen Imagen = new Imagen();
                Imagen.setIdImagen(DPTIAEliminar.getImagen_idImagen());
                imagenAEliminar = controlImagen.ObtenerId(Imagen);

                productoVo = new Producto();
                productoVo.setIdProducto(detalleProductoAEliminar.getProducto_idProducto());
                productoVo = controlProducto.ObtenerId(productoVo);
                
                Marca marca = new Marca();
                marca.setIdMarca(productoVo.getMarca_idMarca());
                marcaVo = controlMarca.ObtenerId(marca);

                try {
                    System.out.println("línea 136 Eliminación DPTIAEliminar: " + DPTIAEliminar);
                    controlDetalleProducto_Tiene_Imagen.eliminar(DPTIAEliminar);
                    System.out.println("línea 138 Eliminación imagenAEliminar: " + imagenAEliminar);
                    controlImagen.eliminar(imagenAEliminar);
                    System.out.println("línea 140 Eliminación detalleProductoAEliminar: " + detalleProductoAEliminar);
                    controlDetalleProducto.eliminar(detalleProductoAEliminar);
                    System.out.println("línea 142 Eliminación ofertaTUAEliminar: " + ofertaTUAEliminar);
                    controlOferta_Tiene_Ubicacion.eliminar(ofertaTUAEliminar);
                    System.out.println("línea 144 Eliminación ofertaAEliminar: " + ofertaAEliminar);
                    controlOferta.eliminar(ofertaAEliminar);
                    System.out.println("línea 146 Eliminación ubicacionAEliminar: " + ubicacionAEliminar);
                    controlUbicacion.eliminar(ubicacionAEliminar);
                    System.out.println("línea 148 Final del proceso");

                } catch (AppException ex) {
                    RespuestaServer resp = new RespuestaServer();
                    resp.setCodigo(0);
                    resp.setMensaje("Fallo al eliminar datos de la oferta" + ex.getMensaje());
                    System.out.println("línea 154 error respuestaServer: " + resp);
                    out.println(new Gson().toJson(resp));
                }
                System.out.println("OK");

                sesion.setAttribute("usuario", usuarioVo);
                RespuestaServer resp = new RespuestaServer();
                resp.setCodigo(1);
                resp.setMensaje("Eliminacion de datos correcta");
                System.out.println("línea 163 supero el proceso de eliminación respuestaServer: " + resp);
                out.println(new Gson().toJson(resp));
//            response.sendRedirect("./jsp/GestionarOfertas.jsp");
//            return;

            }
            else{
                
                System.out.println("línea 171 error en usuario o número de oferta nulo! ");
                
//            response.sendRedirect("./jsp/GestionarOfertas.jsp");
//            return;
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
        } catch (AppException ex) {
            Logger.getLogger(EliminarOferta.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (AppException ex) {
            Logger.getLogger(EliminarOferta.class.getName()).log(Level.SEVERE, null, ex);
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
