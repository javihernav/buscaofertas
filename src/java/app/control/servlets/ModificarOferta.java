/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.control.servlets;

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
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author JAVIER
 */
@WebServlet(name = "ModificarOferta", urlPatterns = {"/ModificarOferta"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 5, // 5 MB The file size in bytes 
                                                //after which the file will be 
                                                //temporarily stored on disk.
                                                // The default size is 0 bytes.
        maxFileSize = 1024 * 1024 * 5, // 5 MB
        //The maximum size allowed for uploaded files, in bytes. If the size of
        //any uploaded file is greater than this size, the web container will 
        //throw an exception (IllegalStateException). The default size is unlimited.
        maxRequestSize = 1024 * 1024 * 10, // 10 MB
                                            //The maximum size allowed for a 
                                            //multipart/form-data request, in bytes. 
                                            //The web container will throw an exception 
                                            //if the overall size of all uploaded files 
                                            //exceeds this threshold. 
                                            //The default size is unlimited.
        location = "./temp"
)
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
            Oferta ofertaVo = (Oferta)sesion.getAttribute("oferta");
            Ubicacion ubicacionVo = new Ubicacion();
            System.out.println("linea 97 recibidos: usuarioVo: " + usuarioVo + "\nofertaVo: " + ofertaVo + "\nubicacionVo: recién creada sin datos " + ubicacionVo);

            Categoria categoriaVo = new Categoria();
            Imagen imagenVo = new Imagen();
            DetalleProducto detalleProductoVo = new DetalleProducto();
            Producto productoVo = new Producto();
            Marca marcaVo = new Marca();

            String idProductoString = request.getParameter("cbProducto");
            System.out.println("linea 106 servlet RegistrarOfertas idProducto: " + idProductoString);

            String idCategoriaProductoString = request.getParameter("cbCategoria");
            System.out.println("linea 109 servlet RegistrarOfertas cbCategoria: " + idCategoriaProductoString);
            String marcaProducto = request.getParameter("txtMarca");
            String nombreOferta = request.getParameter("txtNombreOferta");
            String idCiudadOfertaString = request.getParameter("cbCiudadOferta");
            String nombreTienda = request.getParameter("txtNombreTienda");
            Part imagenProductoPart = request.getPart("selectorImagen");
            String direccionTienda = request.getParameter("txtDireccionTienda");
            String precioOfertaString = request.getParameter("txtPrecio");

            Calendar fechaCreacion = Calendar.getInstance();
            String fechaInicio = request.getParameter("txtFechaDeInicio");
            String fechaFinalizacion = request.getParameter("txtFechaDeFinalizacion");
            String mensaje;
            mensaje = "";
            System.out.println("linea 123 servlet ModificarOferta antes del if: recibidos por json del form");
            System.out.println("usuarioVo = " + usuarioVo + "\n"
                    + "idCategoriaProducto = " + idCategoriaProductoString + "\n"
                    + "marcaProducto = " + marcaProducto + "\n"
                    + "nombreOferta = " + nombreOferta + "\n"
                    + "idCiudadOferta = " + idCiudadOfertaString + "\n"
                    + "nombreTienda = " + nombreTienda + "\n"
                    + "imagenProducto = " + imagenProductoPart + "\n"
                    + "direccionTienda = " + direccionTienda + "\n"
                    + "precioOferta = " + precioOfertaString + "\n"
                    + "fechaInicio = " + fechaInicio + "\n"
                    + "fechaFinalizacion = " + fechaFinalizacion + "\n");
            if (idProductoString != null
                    && nombreOferta != null
                    && idCiudadOfertaString != null
                    && imagenProductoPart != null
                    && direccionTienda != null
                    && precioOfertaString != null
                    && fechaInicio != null
                    && fechaFinalizacion != null) {
                Connection cnn;
                cnn = Conectar.getCnn();
                ControlUsuario controlUsuario = new ControlUsuario(cnn);
                ControlUbicacion controlUbicacion = new ControlUbicacion(cnn);
                ControlCiudad controlCiudad = new ControlCiudad(cnn);

                ControlImagen controlImagen = new ControlImagen(cnn);
                ControlOferta controlOferta = new ControlOferta(cnn);
                //ControlOferta_Tiene_Ubicacion controlOferta_Tiene_Ubicacion = new ControlOferta_Tiene_Ubicacion(cnn);
                ControlProducto controlProducto = new ControlProducto(cnn);

                ControlCategoria controlCategoria = new ControlCategoria(cnn);
                ControlMarca controlMarca = new ControlMarca(cnn);

                ControlDetalleProducto controlDetalleProducto = new ControlDetalleProducto(cnn);
                ControlDetalleProducto_Tiene_Imagen controlDetalleProducto_Tiene_Imagen = new ControlDetalleProducto_Tiene_Imagen(cnn);

                int idUsuario = 0;
                int idOferta = 0;
                int idUbicacion = 0;
                int idProducto = 0;
                int idImagen = 0;
                Ciudad city = new Ciudad();
                city.setIdCiudad(Integer.parseInt(idCiudadOfertaString));
                String nombreCiudad = controlCiudad.ObtenerId(city).getNombreCiudad();
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
                    
                    detalleProductoVo.setOferta_idOferta(ofertaVo.getIdOferta());
                    detalleProductoVo = controlDetalleProducto.ObtenerId(detalleProductoVo);//obtiene detalleProducto de la bd
                    
                    DetalleProducto_Tiene_Imagen dptiVo = new DetalleProducto_Tiene_Imagen();
                    dptiVo.setDetalleProducto_Oferta_idOferta(ofertaVo.getIdOferta());
                    dptiVo.setDetalleProducto_Producto_idProducto(detalleProductoVo.getProducto_idProducto());
                    dptiVo = controlDetalleProducto_Tiene_Imagen.ObtenerId(dptiVo); //con detalle producto antes de ser modificado, obtenemos detalleproductotieneimagen
                    
                    idImagen = dptiVo.getImagen_idImagen();//rescata la imagen del producto
                    detalleProductoVo.setPrecio(Integer.parseInt(precioOfertaString));
                    detalleProductoVo.setProducto_idProducto(Integer.parseInt(idProductoString));
                    
                    dptiVo.setDetalleProducto_Producto_idProducto(detalleProductoVo.getProducto_idProducto());
                    
                    controlDetalleProducto.modificar(detalleProductoVo);System.out.println("linea 192 servlet ModificarOferta detalleProductoVo: " + detalleProductoVo);
                    controlDetalleProducto_Tiene_Imagen.modificar(dptiVo);

                    ubicacionVo.setNombreTienda(nombreTienda);
                    ubicacionVo.setDireccion(direccionTienda);
                    ubicacionVo.setCiudad(nombreCiudad);
                    controlUbicacion.modificar(ubicacionVo);

                    marcaVo.setNombreMarca(marcaProducto);
                    controlMarca.modificar(marcaVo);

//                    categoriaVo.setNombreCategoria(categoriaProducto);
//                    controlCategoria.modificar(categoriaVo);

//                    productoVo.setNombreProducto(nombreProducto);
//                    controlProducto.modificar(productoVo);

//                    detalleProductoVo.setPrecio(Double.parseDouble(precioOfertaString));
//                    controlDetalleProducto.modificar(detalleProductoVo);
                    
                    InputStream imgInputStream = imagenProductoPart.getInputStream();
                    imagenVo.setIdImagen(idImagen);
                    imagenVo.setFotoInputStream(imgInputStream);
                    imagenVo.setNombreImagen(imagenProductoPart.getSubmittedFileName());
                    System.out.println("linea 214 servlet ModificarOferta modificando con imagenVo: " + imagenVo);
                    controlImagen.modificar(imagenVo);

                } catch (AppException ex) {
                    RespuestaServer resp = new RespuestaServer();
                    resp.setCodigo(0);
                    resp.setMensaje("Fallo al actualizar Datos" + ex.getMensaje());
                    System.out.println("linea 221 servlet ModificarOferta Fallo al actualizar: ");
                    out.println(new Gson().toJson(resp));
                }
                System.out.println("OK");
                System.out.println("linea 225 servlet ModificarOferta usuario: "+usuarioVo);

                sesion.setAttribute("usuario", usuarioVo);
                RespuestaServer resp = new RespuestaServer();
                resp.setCodigo(1);
                resp.setMensaje("Actualizacion de datos correcta");
                out.println(new Gson().toJson(resp));

            }
        } catch (AppException ex) {
            Logger.getLogger(ModificarOferta.class.getName()).log(Level.SEVERE, null, ex);
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
