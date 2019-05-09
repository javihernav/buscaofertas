<%-- 
    Document   : Consultas
    Created on : Nov 22, 2018, 3:56:00 PM
    Author     : JAVIER
--%>

<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="app.control.ControlImagen"%>
<%@page import="app.modelo.vo.Imagen"%>
<%@page import="app.control.ControlDetalleProducto_Tiene_Imagen"%>
<%@page import="app.modelo.vo.DetalleProducto_Tiene_Imagen"%>
<%@page import="app.control.ControlCategoria"%>
<%@page import="app.modelo.vo.Categoria"%>
<%@page import="app.control.ControlMarca"%>
<%@page import="app.modelo.vo.Marca"%>
<%@page import="app.control.ControlProducto"%>
<%@page import="app.modelo.vo.Producto"%>
<%@page import="app.modelo.vo.DetalleProducto"%>
<%@page import="app.control.ControlDetalleProducto"%>
<%@page import="app.modelo.vo.Ubicacion"%>
<%@page import="app.control.ControlOferta_Tiene_Ubicacion"%>
<%@page import="app.control.ControlUbicacion"%>
<%@page import="app.modelo.vo.Oferta_Tiene_Ubicacion"%>
<%@page import="app.modelo.vo.Oferta"%>
<%@page import="app.control.ControlOferta"%>
<%@page import="java.sql.Connection"%>
<%@page import="app.modelo.Conectar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <title>Proyecto BuscaOfertas</title>
        <meta charset="UTF-8">
        <meta name="titulo" content="Proyecto BuscaOfertas">
        <meta name="descripcion" content="Proyecto BuscaOfertas">
        <meta name="viewport" content="width=device-width"  user-scalable=no, initial-scale=1.0, maximum-scale=1.0,
              maximum-scalable=1.0>
        <link rel="shortcut icon" type="image/x-icon" href="../_img/LETRERO-BUSCAOFERTAS-Y-nombre-técnico.png">
        <link href="https://fonts.googleapis.com/css?family=Krub" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Michroma" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=PT+Mono" rel="stylesheet">
        <meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
    </head>

    <body onload="cargarComboBoxCiudad()">
        <%

            String idOfertaString = null;
            HttpSession sesion2 = request.getSession();
            try {
                idOfertaString = (String) sesion2.getAttribute("idOferta");

            } catch (Exception e) {
                response.sendRedirect("./PaginaPrincipal.jsp");
            }
            if (idOfertaString == null || idOfertaString.isEmpty()) {
                response.sendRedirect("./PaginaPrincipal.jsp");
            }

            int idOferta = 1;

            try {
                idOferta = Integer.parseInt(idOfertaString);
                System.out.println("\nnúmero de oferta recibida en el jsp ModificarOferta.jsp: " + idOferta);
            } catch (NumberFormatException e) {
                System.out.println("error al convertir el numero de oferta");
            }

            Connection cnn = Conectar.getCnn();
            ControlOferta controlOferta = new ControlOferta(cnn);
            Oferta oferta = controlOferta.consultarPorIdOferta(idOferta);
            request.setAttribute("oferta", oferta);
            System.out.println("oferta "+oferta+" asignada como atributo de request en modificarOferta.jsp");

            Oferta_Tiene_Ubicacion otu = new Oferta_Tiene_Ubicacion();
            otu.setOferta_idOferta(oferta.getIdOferta());System.out.println("linea: "+78+otu);
            ControlOferta_Tiene_Ubicacion controlOferta_Tiene_Ubicacion = new ControlOferta_Tiene_Ubicacion(cnn);
            Oferta_Tiene_Ubicacion oferta_Tiene_Ubicacion = controlOferta_Tiene_Ubicacion.consultarPorIdOferta(otu);
            System.out.println("linea: "+81+oferta);
            System.out.println("linea: "+82+oferta_Tiene_Ubicacion);

            ControlUbicacion controlUbicacion = new ControlUbicacion(cnn);
            Ubicacion ubicacionVo = new Ubicacion();
            ubicacionVo.setIdUbicacion(oferta_Tiene_Ubicacion.getUbicacion_idUbicacion());
            Ubicacion ubicacion = controlUbicacion.ObtenerId(ubicacionVo);
            request.setAttribute("ubicacion", ubicacion);
            System.out.println("linea: "+88+ubicacion);

            ControlDetalleProducto controlDetalleProducto = new ControlDetalleProducto(cnn);
            DetalleProducto detalleProductoVo = new DetalleProducto();
            detalleProductoVo.setOferta_idOferta(oferta.getIdOferta());
            DetalleProducto detalleProductoExtraido = controlDetalleProducto.ObtenerId(detalleProductoVo);
            request.setAttribute("detalleProducto", detalleProductoExtraido);
            System.out.println("linea: "+95+detalleProductoExtraido);

            Producto productoVo = new Producto();
            productoVo.setIdProducto(detalleProductoExtraido.getProducto_idProducto());
            ControlProducto controlProducto = new ControlProducto(cnn);
            Producto productoExtraido = controlProducto.ObtenerId(productoVo);
            System.out.println("\nId de producto: " + productoExtraido.getIdProducto());
            request.setAttribute("producto", productoExtraido);
            System.out.println("linea: "+103+productoExtraido);

            Marca marcaVo = new Marca();
            marcaVo.setIdMarca(productoExtraido.getMarca_idMarca());
            ControlMarca controlMarca = new ControlMarca(cnn);
            Marca marcaExtraida = controlMarca.ObtenerId(marcaVo);
            request.setAttribute("marca", marcaExtraida);
            System.out.println("linea: "+110+marcaExtraida);

            Categoria CategoriaVo = new Categoria();
            CategoriaVo.setIdCategoria(productoExtraido.getCategoria_idCategoria());
            ControlCategoria controlCategoria = new ControlCategoria(cnn);
            Categoria categoriaExtraido = controlCategoria.ObtenerId(CategoriaVo);
            request.setAttribute("categoria", categoriaExtraido);
            System.out.println("linea: "+117+categoriaExtraido);

            DetalleProducto_Tiene_Imagen detalleProducto_Tiene_ImagenVo = new DetalleProducto_Tiene_Imagen();
            detalleProducto_Tiene_ImagenVo.setDetalleProducto_Oferta_idOferta(oferta.getIdOferta());
            detalleProducto_Tiene_ImagenVo.setDetalleProducto_Producto_idProducto(productoExtraido.getIdProducto());
            ControlDetalleProducto_Tiene_Imagen controlDetalleProducto_Tiene_Imagen = new ControlDetalleProducto_Tiene_Imagen(cnn);
            DetalleProducto_Tiene_Imagen detalleProducto_Tiene_ImagenExtraido = controlDetalleProducto_Tiene_Imagen.ObtenerId(detalleProducto_Tiene_ImagenVo);
            System.out.println("\nId de imagen buscada: " + detalleProducto_Tiene_ImagenExtraido.getImagen_idImagen());
            System.out.println("linea: "+126+detalleProducto_Tiene_ImagenExtraido);

            Imagen imagenVo = new Imagen();
            imagenVo.setIdImagen(detalleProducto_Tiene_ImagenExtraido.getImagen_idImagen());
            ControlImagen controlImagen = new ControlImagen(cnn);
            Imagen imagenExtraida = controlImagen.ObtenerId(imagenVo);
            System.out.println("\nId de imagen: " + imagenExtraida.getIdImagen());
            request.setAttribute("imagen", imagenExtraida);
            System.out.println("linea: "+134+imagenExtraida+" ModificarOferta.jsp");
            

        %>

        <header>  
            <%@include file="/jsp/Barra.jsp" %>
        </header>
        <!--
                <figure>
                    <img class="mx-auto d-block img-fluid" src="../_img/LETRERO-BUSCAOFERTAS-sin-nombre-tecnico.png" alt="BuscaOfertas.jpg" width="500">
        
                </figure>-->

        <div class="container">

            <form id="formOferta" class="form-check" autocomplete="on" method="post" action="" enctype="multipart/form-data" >

                <div class="container">

                    <div class="row">
                        &nbsp;
                    </div>
                    <center><h1 class="mx-auto d-block">Modificar Ofertas</h1></center>
                    <div class="row">
                        <div class="form-group col-md-4"><label  class="custom-control-label">Nombre del producto:</label><input class="form-control" id="txtNombreProducto" type="text" value="<%= productoExtraido.getNombreProducto()%>" maxlength="45" placeholder="Nombre del producto " oninput="validarNombreProducto()" required></div><br />
                        <div class="form-group col-md-4"><label  class="custom-control-label">Categoría:</label><input class="form-control"  id="txtCategoria" type="text" value=""<%= categoriaExtraido.getNombreCategoria()%> maxlength="45" placeholder="Categoría del Producto" oninput="" required></div><br />
                        <div class="form-group col-md-4"><label  class="custom-control-label">Marca:</label><input class="form-control"  id="txtMarca" type="text" value="<%= marcaExtraida.getNombreMarca()%>" maxlength="45" placeholder="Marca del Producto" oninput="" required></div><br />
                        <div class="form-group col-md-12"><label class="custom-control-label">Nombre de la tienda:</label><input class="form-control"  id="txtNombreTienda" type="text" value="<%= ubicacion.getNombreTienda()%>" maxlength="20" placeholder="Introduzca nombre de la tienda " oninput="validarNombreTienda()" required></div><br />


                        <div class="form-group col-md-12"><label class="custom-control-label">Dirección de la tienda:</label><input class="form-control"  id="txtDireccionTienda" type="text" value="<%= ubicacion.getDireccion()%>" placeholder="Dirección de la tienda" oninput="validarDireccionTienda()" required></input></div><br />
                        <div class="form-group col-md-12">
                            <label class="custom-control-label" for="cbCiudadOferta">Ciudad de la oferta:</label>
                            <select class="custom-select" id="cbCiudadOferta"  oninput="validarCiudadOferta()" required><option selected="0">Seleccione Ciudad</option>
                            </select>

                        </div>


                        <label class="mx-auto d-block img-fluid custom-control-label" for="">Imagen del producto:</label>
                        <div class="mx-auto form-group col-md-12 row conjuntoImagen">
                            <div class="col-md-6 row">

                                <label class="custom-file-label" for="selectorImagen">Seleccione Imagen</label>
                                <input type="file" class="custom-file-input " value="<%= imagenExtraida.getLinkImagen()%>" id="selectorImagen" onchange="mostrarImagen()">
                            </div>
                            <div class="col-md-6">
                                <img class="" id="imgProducto"  src="../_img/lupa.png" alt="Imagen del producto" oninput="validarImagen()" height="35 vw" required>
                            </div>
                        </div>
                        <div class="row col-md-12">
                            &nbsp;
                        </div>
                        <div class="row">
                            &nbsp;
                        </div>
                        <div class="form-group col-md-6"><label  class="custom-control-label">Nombre de la Oferta:</label><input class="form-control"  id="txtNombreOferta" type="text" value="<%= oferta.getNombreOferta()%>" maxlength="45" placeholder="Introduzca nombre de oferta " oninput="validarNombreOferta()" required></div><br />
                        <div class="form-group col-md-6"><label class="custom-control-label">Precio:</label><input class="form-control"  id="txtPrecio" type="number" min="1" value="<%= detalleProductoExtraido.getPrecio()%>" maxlength="20" placeholder="Precio de oferta" oninput="validarPrecioDeOferta()" required></div><br />
                        <div class="form-group col-md-6"><label class="custom-control-label">Fecha de Inicio:</label><input class="form-control"  id="txtFechaDeInicio" type="date" value="<%= new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(oferta.getFechaInicio())%>" maxlength="45"  oninput="validarFechaInicio()" required></div><br />

                        <div class="form-group col-md-6"><label class="custom-control-label">Fecha de Finalización:</label><input class="form-control"  id="txtFechaDeFinalizacion" type="date" value="<%= new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(oferta.getFechaFin())%>" maxlength="45"  oninput="validarFechaFinalizacion()" required></div><br />
                    </div>


                    <div class="row">
                        &nbsp;
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            &nbsp;
                        </div>
                        <div class="row col-md-6">
                            <input class="btn btn-dark offset-1 col-md-4"  id="botonCancelar" type="button" value="Cancelar">
                            <input class="btn btn-danger offset-1 col-md-4"  id="botonActualizar" type="button" value="Actualizar">
                        </div>
                    </div>

                    <div class="row">
                        &nbsp;
                    </div>
                </div>
            </form>
        </div>
        <link href="../_css/styles.css" rel="stylesheet" type="text/css" />

        <script type="text/javascript" src="../_js/jquery-3.3.1.js"></script>
        <script type="text/javascript" src="../_js/consultasCiudadLogica.js"></script>
        <script type="text/javascript" src="../_js/tratamientoImagenes.js"></script>
        <link rel="stylesheet" href="../_css/bootstrap.min.css">
        <script type="text/javascript" src="../_js/validacion.js"></script>
        <script type="text/javascript" src="../_js/modificarOfertaLogica.js"></script>
        <script type="text/javascript" src="../_js/ciudadLogica.js"></script>
        <script type="text/javascript" src="../_js/bootstrap.min.js"></script>
        <script type="text/javascript" src="../_js/popper.min.js"></script>
        <script type="text/javascript" src="../_js/registrarOfertaFechasLogica.js"></script>
        <!--<script type="text/javascript" src="../_js/registrarOferta.js"></script>-->

    </body>

</html>