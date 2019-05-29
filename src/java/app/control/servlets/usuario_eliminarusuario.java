/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.control.servlets;

import app.control.ControlDetalleProducto;
import app.control.ControlDetalleProducto_Tiene_Imagen;
import app.control.ControlImagen;
import app.control.ControlMarca;
import app.control.ControlOferta;
import app.control.ControlOferta_Tiene_Ubicacion;
import app.control.ControlProducto;
import app.control.ControlUbicacion;
import app.control.ControlUsuario;
import app.modelo.Conectar;
import app.modelo.vo.DetalleProducto;
import app.modelo.vo.DetalleProducto_Tiene_Imagen;
import app.modelo.vo.Imagen;
import app.modelo.vo.Marca;
import app.modelo.vo.Oferta;
import app.modelo.vo.Oferta_Tiene_Ubicacion;
import app.modelo.vo.Producto;
import app.modelo.vo.Ubicacion;
import app.modelo.vo.Usuario;
import app.utils.AppException;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author elrin
 */
@WebServlet(name = "usuario_eliminarusuario", urlPatterns = {"/usuario_eliminarusuario"})
public class usuario_eliminarusuario extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            HttpSession sesion4 = request.getSession();
            Object usuarioObject = sesion4.getAttribute("usuario");
            Usuario usuario = new Usuario();
            int id = Integer.parseInt(request.getParameter("id"));
            if (usuarioObject == null) {
                System.out.println("No se permite eliminación de usuarios sin estas logueado");
                response.sendRedirect("./jsp/PaginaPrincipal.jsp");
                return;
            } else {
                usuario = (Usuario) usuarioObject;System.out.println("Usuario: "+usuario);
                if (!usuario.getRol().equals("admin") && usuario.getIdUsuario() != id) {
                    System.out.println("El usuario logueado no es administrador o no esta eliminando su propia cuenta!");
                    response.sendRedirect("./jsp/PaginaPrincipal.jsp");
                    return;
                }
            }
            Connection cnn = Conectar.getCnn();
            ControlUsuario control = new ControlUsuario(cnn);
            Usuario usuarioEliminado = new Usuario();
            usuarioEliminado.setIdUsuario(id);
            System.out.println("usuario eliminado: " + usuarioEliminado);

//código para eliminar las ofertas del usuario
            ControlOferta controlOferta = new ControlOferta(cnn);
            List<Oferta> ofertas = controlOferta.consultarPorIdUsuario(id);

            for (Oferta ofertaAEliminar : ofertas) {

                ControlOferta_Tiene_Ubicacion controlOferta_Tiene_Ubicacion = new ControlOferta_Tiene_Ubicacion(cnn);
                ControlUbicacion controlUbicacion = new ControlUbicacion(cnn);
                ControlDetalleProducto controlDetalleProducto = new ControlDetalleProducto(cnn);
                ControlDetalleProducto_Tiene_Imagen controlDetalleProducto_Tiene_Imagen = new ControlDetalleProducto_Tiene_Imagen(cnn);
                ControlImagen controlImagen = new ControlImagen(cnn);
                ControlProducto controlProducto = new ControlProducto(cnn);
                ControlMarca controlMarca = new ControlMarca(cnn);

//                Oferta offer = new Oferta();
//                offer.setIdOferta(idOferta);
//                ofertaAEliminar = controlOferta.ObtenerId(offer);
                Oferta_Tiene_Ubicacion offerTieneUbicacion = new Oferta_Tiene_Ubicacion();
                offerTieneUbicacion.setOferta_idOferta(ofertaAEliminar.getIdOferta());
                Oferta_Tiene_Ubicacion ofertaTUAEliminar = controlOferta_Tiene_Ubicacion.ObtenerId(offerTieneUbicacion);
                System.out.println("línea 111 offerTieneUbicacion: " + offerTieneUbicacion);
                System.out.println("línea 112 ofertaTUAEliminar: " + ofertaTUAEliminar);

                Ubicacion ubicacionAEliminar = new Ubicacion();
                ubicacionAEliminar.setIdUbicacion(ofertaTUAEliminar.getUbicacion_idUbicacion());
                ubicacionAEliminar = controlUbicacion.ObtenerId(ubicacionAEliminar);

                System.out.println("línea 116 Eliminación ofertaTUAEliminar: " + ofertaTUAEliminar);
                controlOferta_Tiene_Ubicacion.eliminar(ofertaTUAEliminar);//elimina otu
                System.out.println("línea 118 Eliminación ubicacionAEliminar: " + ubicacionAEliminar);
                controlUbicacion.eliminar(ubicacionAEliminar);

                DetalleProducto detalleProductoAEliminar = new DetalleProducto();
                detalleProductoAEliminar.setOferta_idOferta(ofertaAEliminar.getIdOferta());
                detalleProductoAEliminar = controlDetalleProducto.ObtenerId(detalleProductoAEliminar);

                DetalleProducto_Tiene_Imagen DPTIAEliminar = new DetalleProducto_Tiene_Imagen();
                DPTIAEliminar.setDetalleProducto_Oferta_idOferta(ofertaAEliminar.getIdOferta());
                DPTIAEliminar.setDetalleProducto_Producto_idProducto(detalleProductoAEliminar.getProducto_idProducto());
                DPTIAEliminar = controlDetalleProducto_Tiene_Imagen.ObtenerId(DPTIAEliminar);

                Imagen imagenAEliminar = new Imagen();
                imagenAEliminar.setIdImagen(DPTIAEliminar.getImagen_idImagen());
                imagenAEliminar = controlImagen.ObtenerId(imagenAEliminar);

                Producto productoVo = new Producto();
                productoVo.setIdProducto(detalleProductoAEliminar.getProducto_idProducto());
                productoVo = controlProducto.ObtenerId(productoVo);

                Marca marca = new Marca();
                marca.setIdMarca(productoVo.getMarca_idMarca());
                marca = controlMarca.ObtenerId(marca);

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

            }

            //código para eliminar las ofertas del usuario
            control.eliminar(usuarioEliminado);
            if (usuario.getIdUsuario() == id) {//retorna a la página principal luego de eliminar la cuenta propia
                response.sendRedirect("./jsp/PaginaPrincipal.jsp");
                return;
            }
            response.sendRedirect("./jsp/GestionarUsuarios.jsp");
            return;

        } catch (AppException ex) {
            Logger.getLogger(usuario_eliminarusuario.class.getName()).log(Level.SEVERE, null, ex);

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
