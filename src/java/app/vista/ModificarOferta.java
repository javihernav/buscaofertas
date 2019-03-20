/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.vista;

import app.control.ControlCategoria;
import app.control.ControlCiudad;
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
import app.modelo.vo.Ciudad;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
@WebServlet(name = "ModificarOferta", urlPatterns = {"/ModificarOferta"})
public class ModificarOferta extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            HttpSession sesion = request.getSession();
            Usuario usuarioVo = (Usuario) sesion.getAttribute("usuario");
            Oferta ofertaVo = (Oferta) sesion.getAttribute("oferta");
            Ubicacion ubicacionVo = (Ubicacion) sesion.getAttribute("ubicacion");
            Tipo tipoVo = (Tipo) sesion.getAttribute("tipo");
            Categoria categoriaVo = (Categoria) sesion.getAttribute("categoria");
            Imagen imagenVo = (Imagen) sesion.getAttribute("imagen");
            DetalleProducto detalleProductoVo = (DetalleProducto) sesion.getAttribute("detalleProducto");
            Producto productoVo = (Producto) sesion.getAttribute("producto");
            Marca marcaVo = (Marca) sesion.getAttribute("marca");

            String nombreProducto = request.getParameter("nombreProducto");
            String tipoProducto = request.getParameter("tipoProducto");
            String categoriaProducto = request.getParameter("categoriaProducto");
            String marcaProducto = request.getParameter("marcaProducto");
            String nombreOferta = request.getParameter("nombreOferta");
            String ciudadOferta = request.getParameter("ciudadOferta");
            String nombreTienda = request.getParameter("nombreTienda");
            String imagenProducto = request.getParameter("imagenProducto");
            String direccionTienda = request.getParameter("direccionTienda");
            String precioOferta = request.getParameter("precioOferta");

            Calendar fechaCreacion = Calendar.getInstance();
            String fechaInicio = request.getParameter("fechaInicio");
            String fechaFinalizacion = request.getParameter("fechaFinalizacion");
            String mensaje;
            mensaje = "";
            if (ofertaVo != null
                    && detalleProductoVo != null
                    && ubicacionVo != null
                    && tipoVo != null
                    && categoriaVo != null
                    && imagenVo != null
                    && productoVo != null
                    && marcaVo != null) {
                Connection cnn;
                cnn = Conectar.getCnn();
                ControlUsuario controlUsuario = new ControlUsuario(cnn);
                ControlUbicacion controlUbicacion = new ControlUbicacion(cnn);
                ControlCiudad controlCiudad = new ControlCiudad(cnn);
                ControlImagen controlImagen = new ControlImagen(cnn);
                ControlOferta controlOferta = new ControlOferta(cnn);
                //ControlOferta_Tiene_Ubicacion controlOferta_Tiene_Ubicacion = new ControlOferta_Tiene_Ubicacion(cnn);
                ControlProducto controlProducto = new ControlProducto(cnn);
                ControlTipo controlTipo = new ControlTipo(cnn);
                ControlCategoria controlCategoria = new ControlCategoria(cnn);
                ControlMarca controlMarca = new ControlMarca(cnn);

                ControlDetalleProducto controlDetalleProducto = new ControlDetalleProducto(cnn);
                //ControlDetalleProducto_Tiene_Imagen controlDetalleProducto_Tiene_Imagen = new ControlDetalleProducto_Tiene_Imagen(cnn);

                int idUsuario = 0;
                int idOferta = 0;
                int idUbicacion = 0;
                int idProducto = 0;
                int idImagen = 0;
                String nombreCiudad = "";
                try {
                    idUsuario = controlUsuario.ObtenerId(usuarioVo).getIdUsuario();

                    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

                    ofertaVo.setNombreOferta(nombreOferta);
                    try {
                        ofertaVo.setFechaInicio(formatoFecha.parse(fechaInicio));
                        ofertaVo.setFechaFin(formatoFecha.parse(fechaFinalizacion));
                    } catch (ParseException ex) {
                        throw new AppException(-3, "error al convertir fechas");
                    }
                    controlOferta.modificar(ofertaVo);

                    detalleProductoVo.setPrecio(Integer.parseInt(precioOferta));
                    controlDetalleProducto.modificar(detalleProductoVo);

                    ubicacionVo.setNombreTienda(nombreTienda);
                    ubicacionVo.setDireccion(direccionTienda);
                    ubicacionVo.setCiudad(nombreCiudad);
                    controlUbicacion.modificar(ubicacionVo);

                    marcaVo.setNombreMarca(marcaProducto);
                    controlMarca.modificar(marcaVo);

                    categoriaVo.setNombreCategoria(categoriaProducto);
                    controlCategoria.modificar(categoriaVo);

                    tipoVo.setNombreTipo(tipoProducto);
                    controlTipo.modificar(tipoVo);

                    productoVo.setNombreProducto(nombreProducto);
                    controlProducto.modificar(productoVo);

                    detalleProductoVo.setPrecio(Double.parseDouble(precioOferta));
                    controlDetalleProducto.modificar(detalleProductoVo);

                    imagenVo.setLinkImagen(imagenProducto);
                    controlImagen.modificar(imagenVo);

                } catch (AppException ex) {
                    RespuestaServer resp = new RespuestaServer();
                    resp.setCodigo(0);
                    resp.setMensaje("Fallo al actualizar Datos" + ex.getMensaje());
                    out.println(new Gson().toJson(resp));
                }
                System.out.println("OK");

                sesion.setAttribute("usuario", usuarioVo);
                RespuestaServer resp = new RespuestaServer();
                resp.setCodigo(1);
                resp.setMensaje("Actualizacion de datos correcta");
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
