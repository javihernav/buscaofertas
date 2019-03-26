/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.vista;

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
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession sesion = request.getSession();
            String idOfertaString = (String)sesion.getAttribute("idOferta");
            System.out.println("id de la oferta recibido en el servlet: "+idOfertaString);
            Usuario usuarioVo = null;
            Oferta ofertaVo = null;
            Ubicacion ubicacionVo = null;
            Tipo tipoVo = null;
            Categoria categoriaVo = null;
            Imagen imagenVo = null;
            DetalleProducto detalleProductoVo = null;
            Producto productoVo = null;
            Marca marcaVo = null;

            
            String mensaje;
            mensaje = "";
            if (idOfertaString != null) {
                int idOferta=0;
                try {
                    idOferta = Integer.parseInt(idOfertaString);
            } catch (NumberFormatException e) {
                System.out.println("error al convertir el numero de oferta");
            }
                Connection cnn;
                cnn = Conectar.getCnn();
                
                ControlUsuario controlUsuario = new ControlUsuario(cnn);
                ControlUbicacion controlUbicacion = new ControlUbicacion(cnn);
                ControlDetalleProducto controlDetalleProducto = new ControlDetalleProducto(cnn);
                
                ControlImagen controlImagen = new ControlImagen(cnn);
                ControlOferta controlOferta = new ControlOferta(cnn);
                ControlOferta_Tiene_Ubicacion controlOferta_Tiene_Ubicacion = new ControlOferta_Tiene_Ubicacion(cnn);
                ControlDetalleProducto_Tiene_Imagen controlDetalleProducto_Tiene_Imagen = new ControlDetalleProducto_Tiene_Imagen(cnn);
                ControlProducto controlProducto = new ControlProducto(cnn);
                ControlTipo controlTipo = new ControlTipo(cnn);
                ControlCategoria controlCategoria = new ControlCategoria(cnn);
                ControlMarca controlMarca = new ControlMarca(cnn);

                Oferta offer= new Oferta();
                offer.setIdOferta(idOferta);
                ofertaVo=controlOferta.ObtenerId(offer);
                
                Oferta_Tiene_Ubicacion offerTieneUbicacion= new Oferta_Tiene_Ubicacion();
                offerTieneUbicacion.setOferta_idOferta(idOferta);
                Oferta_Tiene_Ubicacion oferta_Tiene_UbicacionVo=controlOferta_Tiene_Ubicacion.ObtenerId(offerTieneUbicacion);
                
                Ubicacion ubicacion= new Ubicacion();
                ubicacion.setIdUbicacion(oferta_Tiene_UbicacionVo.getUbicacion_idUbicacion());
                ubicacionVo=controlUbicacion.ObtenerId(ubicacion);
                
                DetalleProducto detalleProducto= new DetalleProducto();
                detalleProducto.setOferta_idOferta(idOferta);
                detalleProductoVo = controlDetalleProducto.ObtenerId(detalleProducto);
                
                DetalleProducto_Tiene_Imagen detalleProducto_Tiene_Imagen= new DetalleProducto_Tiene_Imagen();
                detalleProducto_Tiene_Imagen.setDetalleProducto_Oferta_idOferta(idOferta);
                detalleProducto_Tiene_Imagen.setDetalleProducto_Producto_idProducto(detalleProductoVo.getProducto_idProducto());
                DetalleProducto_Tiene_Imagen detalleProducto_Tiene_ImagenVo = controlDetalleProducto_Tiene_Imagen.ObtenerId(detalleProducto_Tiene_Imagen);
                
                Imagen Imagen= new Imagen();
                Imagen.setIdImagen(detalleProducto_Tiene_ImagenVo.getImagen_idImagen());
                imagenVo = controlImagen.ObtenerId(Imagen);
                
                Producto producto= new Producto();
                producto.setIdProducto(detalleProducto.getProducto_idProducto());
                productoVo = controlProducto.ObtenerId(producto);
                
                Marca marca= new Marca();
                marca.setIdMarca(productoVo.getMarca_idMarca());
                marcaVo = controlMarca.ObtenerId(marca);
                
                Tipo Tipo= new Tipo();
                Tipo.setIdTipo(productoVo.getTipo_idTipo());
                tipoVo = controlTipo.ObtenerId(Tipo);
                
                Categoria categoria= new Categoria();
                categoria.setIdCategoria(tipoVo.getCategoria_idCategoria());
                categoriaVo = controlCategoria.ObtenerId(categoria);
                
                
                try {
                    controlOferta_Tiene_Ubicacion.eliminar(oferta_Tiene_UbicacionVo);
                    controlOferta.eliminar(ofertaVo);
                    controlUbicacion.eliminar(ubicacionVo);
                    controlDetalleProducto_Tiene_Imagen.eliminar(detalleProducto_Tiene_ImagenVo);
                    controlImagen.eliminar(imagenVo);
                    controlDetalleProducto.eliminar(detalleProductoVo);
                    controlProducto.eliminar(productoVo);
                    controlMarca.eliminar(marcaVo);
                    controlTipo.eliminar(tipoVo);
                    controlCategoria.eliminar(categoriaVo);

                } catch (AppException ex) {
                    RespuestaServer resp = new RespuestaServer();
                    resp.setCodigo(0);
                    resp.setMensaje("Fallo al eliminar datos de la oferta" + ex.getMensaje());
                    out.println(new Gson().toJson(resp));
                }
                System.out.println("OK");

                sesion.setAttribute("usuario", usuarioVo);
                RespuestaServer resp = new RespuestaServer();
                resp.setCodigo(1);
                resp.setMensaje("Eliminacion de datos correcta");
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
