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
        fileSizeThreshold   = 1024 * 1024 * 1,  // 1 MB
        maxFileSize         = 1024 * 1024 * 10, // 10 MB
        maxRequestSize      = 1024 * 1024 * 15, // 15 MB
        location            = "./temp"
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

            String nombreProducto = request.getParameter("txtNombreProducto");

            String categoriaProducto = request.getParameter("cbCategoria");
            String marcaProducto = request.getParameter("txtMarca");
            String nombreOferta = request.getParameter("txtNombreOferta");
            String ciudadOferta = request.getParameter("cbCiudadOferta");
            String nombreTienda = request.getParameter("txtNombreTienda");
            Part imagenProducto = request.getPart("selectorImagen");
            String direccionTienda = request.getParameter("txtDireccionTienda");
            String precioOferta = request.getParameter("txtPrecio");

            Calendar fechaCreacion = Calendar.getInstance();
            String fechaInicio = request.getParameter("txtFechaDeInicio");
            String fechaFinalizacion = request.getParameter("txtFechaDeFinalizacion");
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

                ControlImagen controlImagen = new ControlImagen(cnn);
                ControlOferta controlOferta = new ControlOferta(cnn);
                ControlOferta_Tiene_Ubicacion controlOferta_Tiene_Ubicacion = new ControlOferta_Tiene_Ubicacion(cnn);
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
                String nombreCiudad = "";
                try {
                    idUsuario = controlUsuario.ObtenerId(usuarioVo).getIdUsuario();
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                    Oferta ofertaVo = new Oferta(0, idUsuario, nombreOferta, formatoFecha.parse(fechaCreacion.get(Calendar.YEAR) + "-" + (fechaCreacion.get(Calendar.MONTH) + 1) + "-" + fechaCreacion.get(Calendar.DAY_OF_MONTH) + "-"), formatoFecha.parse(fechaInicio), formatoFecha.parse(fechaFinalizacion), 0);
                    System.out.println("linea 135 servlet RegistrarOfertas" + ofertaVo);
                    idOferta = controlOferta.insertar(ofertaVo);
                    Ciudad ciudadVo = new Ciudad();
                    ciudadVo.setNombreCiudad(ciudadOferta);
                    //nombreCiudad = controlCiudad.ObtenerId(ciudadVo).getNombreCiudad();
                    Ubicacion ubicacionVo = new Ubicacion(nombreTienda, direccionTienda, ciudadOferta);
                    System.out.println("linea 133 servlet RegistrarOfertas" + ubicacionVo);
                    idUbicacion = controlUbicacion.insertar(ubicacionVo);
                    Oferta_Tiene_Ubicacion otu = new Oferta_Tiene_Ubicacion(idOferta, idUbicacion);
                    System.out.println("linea 144 servlet RegistrarOfertas" + otu);
                    controlOferta_Tiene_Ubicacion.insertar(otu);

                    Marca marca = new Marca();
                    marca.setNombreMarca(marcaProducto);
                    int idMarca = controlMarca.insertar(marca);
                    System.out.println("linea 150 servlet RegistrarOfertas" + idMarca);

                    Categoria categoria = new Categoria();
                    Categoria categoriaVo=controlCategoria.ObtenerId(categoria);
                    int idCategoria = Integer.parseInt(categoriaProducto);
                    System.out.println("linea 155 servlet RegistrarOfertas" + categoriaVo);

                    Producto productoVo = new Producto();
                    productoVo.setNombreProducto(nombreProducto);
                    productoVo.setCategoria_idCategoria(idCategoria);
                    productoVo.setMarca_idMarca(idMarca);
                    idProducto = controlProducto.insertar(productoVo);
                    System.out.println("linea 162 servlet RegistrarOfertas" + productoVo);

                    DetalleProducto detalleProductoVo = new DetalleProducto(idOferta, idProducto, Double.parseDouble(precioOferta));

                    controlDetalleProducto.insertar(detalleProductoVo);
                    System.out.println("linea 167 servlet RegistrarOfertas" + detalleProductoVo);
                    Imagen imgVo = new Imagen();

                    InputStream imgInputStream = imagenProducto.getInputStream();
                    imgVo.setFoto2(imgInputStream);

                    imgVo.setLinkImagen(imagenProducto.getSubmittedFileName());
                    //byte[] foto = {00000101};
                    //imgVo.setFoto(foto);
                    System.out.println("linea 176 servlet RegistrarOfertas" + imgVo);

                    idImagen = controlImagen.insertar(imgVo);
                    System.out.println("linea 179 servlet RegistrarOfertas idImagen,idOferta,idProducto " + idImagen + ", " + idOferta + ", " + idProducto);
                    DetalleProducto_Tiene_Imagen dPTIVo = new DetalleProducto_Tiene_Imagen(idImagen, idOferta, idProducto);
                    controlDetalleProducto_Tiene_Imagen.insertar(dPTIVo);
                    System.out.println("linea 182 servlet RegistrarOfertas" + dPTIVo);

                } catch (AppException ex) {
                    RespuestaServer resp = new RespuestaServer();
                    resp.setCodigo(0);
                    resp.setMensaje("Fallo al insertar Datos" + ex.getMensaje());
                    out.println(new Gson().toJson(resp));
                }
                System.out.println("OK");

                sesion.setAttribute("usuario", usuarioVo);
                System.out.println("linea 193 servlet RegistrarOfertas" + usuarioVo);
                RespuestaServer resp = new RespuestaServer();
                resp.setCodigo(1);
                resp.setMensaje("Datos Correctos");
                out.println(new Gson().toJson(resp));

            }
        } catch (AppException ex) {
            System.out.println("excepcion en servlet RegistrarOfertas:"+ex.getMensaje()+ex.getMessage());
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
            System.out.println("excepcion en servlet RegistrarOfertas:"+ex.getMessage());
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
            System.out.println("excepcion en servlet RegistrarOfertas:"+ex.getMessage());
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
