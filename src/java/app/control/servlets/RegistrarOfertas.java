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
import app.control.ControlUsuario;
import app.control.ControlUbicacion;
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
import java.util.Date;
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
@WebServlet(name = "RegistrarOfertas", urlPatterns = {"/RegistrarOfertas"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 100, // 100 MB
        maxFileSize = 1024 * 1024 * 100, // 100 MB
        maxRequestSize = 1024 * 1024 * 150, // 150 MB
        location = "./temp"
)
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
            Usuario usuarioVo = (Usuario) sesion.getAttribute("usuario");

            String idProductoString = request.getParameter("cbProducto");
            System.out.println("linea 84 servlet RegistrarOfertas nombreProducto: " + idProductoString);

            String idCategoriaProductoString = request.getParameter("cbCategoria");
            System.out.println("linea 89 servlet RegistrarOfertas cbCategoria: " + idCategoriaProductoString);
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
            System.out.println("linea 101 servlet RegistrarOfertas antes del if: ");
            System.out.println("usuarioVo= " + usuarioVo + "\n"
                    + "idCategoriaProducto= " + idCategoriaProductoString + "\n"
                    + "marcaProducto= " + marcaProducto + "\n"
                    + "nombreOferta= " + nombreOferta + "\n"
                    + "idCiudadOferta= " + idCiudadOfertaString + "\n"
                    + "nombreTienda= " + nombreTienda + "\n"
                    + "imagenProducto= " + imagenProductoPart + "\n"
                    + "direccionTienda= " + direccionTienda + "\n"
                    + "precioOferta= " + precioOfertaString + "\n"
                    + "fechaInicio= " + fechaInicio + "\n"
                    + "fechaFinalizacion= " + fechaFinalizacion + "\n");
            if (idProductoString != null
                    && nombreOferta != null
                    && idCiudadOfertaString != null
                    && imagenProductoPart != null
                    && direccionTienda != null
                    && precioOfertaString != null
                    && fechaInicio != null
                    && fechaFinalizacion != null) {
                System.out.println("linea 121 servlet RegistrarOfertas entrada al if: ");

                Connection cnn;
                cnn = Conectar.getCnn();
                ControlUsuario controlUsuario = new ControlUsuario(cnn);
                ControlUbicacion controlUbicacion = new ControlUbicacion(cnn);System.out.println("linea 126 servlet RegistrarOfertas ");

                ControlImagen controlImagen = new ControlImagen(cnn);
                ControlOferta controlOferta = new ControlOferta(cnn);
                ControlOferta_Tiene_Ubicacion controlOferta_Tiene_Ubicacion = new ControlOferta_Tiene_Ubicacion(cnn);
                ControlProducto controlProducto = new ControlProducto(cnn); System.out.println("linea 131 servlet RegistrarOfertas");

                ControlCategoria controlCategoria = new ControlCategoria(cnn);
                ControlMarca controlMarca = new ControlMarca(cnn);

                ControlDetalleProducto controlDetalleProducto = new ControlDetalleProducto(cnn);
                ControlDetalleProducto_Tiene_Imagen controlDetalleProducto_Tiene_Imagen = new ControlDetalleProducto_Tiene_Imagen(cnn);System.out.println("linea 137 servlet RegistrarOfertas");

                int idUsuario = 0;
                int idOferta = 0;
                int idUbicacion = 0;
                int idProducto = Integer.parseInt(idProductoString);
                int idImagen = 0;

                try {System.out.println("linea 145 servlet RegistrarOfertas obtener usuario");
                    idUsuario = controlUsuario.ObtenerId(usuarioVo).getIdUsuario();System.out.println("linea 146 servlet RegistrarOfertas");
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                    Oferta ofertaVo = new Oferta(0, idUsuario, nombreOferta, formatoFecha.parse(fechaCreacion.get(Calendar.YEAR) + "-" + (fechaCreacion.get(Calendar.MONTH) + 1) + "-" + fechaCreacion.get(Calendar.DAY_OF_MONTH) + "-"), formatoFecha.parse(fechaInicio), formatoFecha.parse(fechaFinalizacion), 0);
                    //                    (idOferta,Usuario_idUsuario, nombreOferta, Date fechaCreacion,                                                                                                                                          Date fechaInicio,                Date fechaFin,                        vecesCompartida);
                    System.out.println("linea 150 servlet RegistrarOfertas" + ofertaVo);
                    idOferta = controlOferta.insertar(ofertaVo);
                    Ciudad ciudadVo = new Ciudad();
                    ciudadVo.setIdCiudad(Integer.parseInt(idCiudadOfertaString));
                    //nombreCiudad = controlCiudad.ObtenerId(ciudadVo).getNombreCiudad();
                    Ubicacion ubicacionVo = new Ubicacion(nombreTienda, direccionTienda, idCiudadOfertaString);
                    System.out.println("linea 156 servlet RegistrarOfertas " + ubicacionVo);
                    idUbicacion = controlUbicacion.insertar(ubicacionVo);
                    Oferta_Tiene_Ubicacion otu = new Oferta_Tiene_Ubicacion(idOferta, idUbicacion);
                    System.out.println("linea 159 servlet RegistrarOfertas Oferta_Tiene_Ubicacion: " + otu);
                    controlOferta_Tiene_Ubicacion.insertar(otu);

                    Marca marca = new Marca();
                    marca.setNombreMarca(marcaProducto);
                    int idMarca = controlMarca.insertar(marca);
                    System.out.println("linea 165 servlet RegistrarOfertas idMarca: " + idMarca);

                    Categoria categoria = new Categoria();
                    categoria.setIdCategoria(Integer.parseInt(idCategoriaProductoString));
                    Categoria categoriaVo = controlCategoria.ObtenerId(categoria);
                    int idCategoria = Integer.parseInt(idCategoriaProductoString);
                    System.out.println("linea 170 servlet RegistrarOfertas categoriaVo: " + categoriaVo);

                    Producto productoVo = new Producto();
                    productoVo.setIdProducto(idProducto);
                    productoVo.setCategoria_idCategoria(idCategoria);
                    productoVo.setMarca_idMarca(idMarca);
                    Producto productoEstraido = controlProducto.ObtenerId(productoVo);
                    System.out.println("linea 177 servlet RegistrarOfertas productoExtraido: " + productoEstraido);

                    DetalleProducto detalleProductoVo = new DetalleProducto(idOferta, idProducto, Double.parseDouble(precioOfertaString));

                    controlDetalleProducto.insertar(detalleProductoVo);
                    System.out.println("linea 183 servlet RegistrarOfertas detalleProductoVo: " + detalleProductoVo);
                    Imagen imgVo = new Imagen();

                    InputStream imgInputStream = imagenProductoPart.getInputStream();
                    imgVo.setFotoInputStream(imgInputStream);

                    imgVo.setNombreImagen(imagenProductoPart.getSubmittedFileName());
                    System.out.println("linea 190 servlet RegistrarOfertas imgVo: " + imgVo);

                    idImagen = controlImagen.insertar(imgVo);
                    System.out.println("linea 193 servlet RegistrarOfertas idImagen,idOferta,idProducto " + idImagen + ", " + idOferta + ", " + idProducto);
                    DetalleProducto_Tiene_Imagen dPTIVo = new DetalleProducto_Tiene_Imagen(idImagen, idOferta, idProducto);
                    controlDetalleProducto_Tiene_Imagen.insertar(dPTIVo);
                    System.out.println("linea 196 servlet RegistrarOfertas" + dPTIVo);

                } catch (AppException ex) {
                    RespuestaServer resp = new RespuestaServer();
                    resp.setCodigo(0);
                    resp.setMensaje("Fallo al insertar Datos" + ex.getMensaje());
                    out.println(new Gson().toJson(resp));
                    System.out.println("linea 203 servlet RegistrarOfertas respuestaServer: " + resp);
                }
                System.out.println("OK");

                sesion.setAttribute("usuario", usuarioVo);
                System.out.println("linea 208 servlet RegistrarOfertas usuarioVo: " + usuarioVo);
                RespuestaServer resp = new RespuestaServer();
                resp.setCodigo(1);
                resp.setMensaje("Datos Correctos");
                //resp.setData("data is ok");
                out.println(new Gson().toJson(resp));
                System.out.println("linea 213 servlet RegistrarOfertas respuestaServer: " + resp);

            }
        } catch (AppException ex) {
            System.out.println("excepcion en servlet RegistrarOfertas:" + ex.getMensaje() + ex.getMessage());
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
            System.out.println("excepcion en servlet RegistrarOfertas:" + ex.getMessage());
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
            System.out.println("excepcion en servlet RegistrarOfertas:" + ex.getMessage());
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
