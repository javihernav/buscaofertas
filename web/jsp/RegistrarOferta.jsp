<%-- 
    Document   : Consultas
    Created on : Nov 22, 2018, 3:56:00 PM
    Author     : JAVIER
--%>

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

    <body>
        <header>  
            <%@include file="/jsp/Barra.jsp" %>
        </header>


        <div class="container">

            <form id="formOferta" class="form-check" autocomplete="on" method="post" action="" enctype="multipart/form-data" >

                <div class="container">

                    <div class="row">
                        &nbsp;
                    </div>
                    <center><h1 class="mx-auto d-block">Registro de Ofertas</h1></center>
                    <div class="row">
                        <div class="form-group col-md-4">
                            <label  class="custom-control-label" for="cbProducto">Nombre del producto:</label>
                            <select class="form-control" name="cbProducto" id="cbProducto" placeholder="Nombre del producto " onchange="validarProducto()" tabindex="1" required="true">
                                <option value="0">Seleccione Producto</option>
                            </select>
                            <label id="errorNombreProducto"  class="error" for="cbProducto"></label>
                        </div><br />
                        <div class="form-group col-md-4">
                            <label  class="custom-control-label" for="cbCategoria">Categoría:</label>
                            <select class="form-control" name="cbCategoria" id="cbCategoria" tabindex="2" onchange="validarCategoria()" required>
                                <option value="0">Seleccionar categoría</option>       
                            </select>
                            <label id="errorCategoria" class="error" for="cbCategoria"></label>
                        </div><br />
                        <div class="form-group col-md-4">
                            <label  class="custom-control-label">Marca:</label>
                            <input class="form-control" name="txtMarca" id="txtMarca" type="text" value="" maxlength="45" placeholder="Marca del Producto" tabindex="3" oninput="validarMarca()" required="true">
                            <label id="errorMarca" class="error" for="txtMarca"></label>
                        </div><br />

                    </div>
                    <div class="row col-md-12">
                        <div class="row col-md-6">

                            <div class="row col-md-12">
                                <div class="form-group col-md-12">
                                    <label class="custom-control-label" for="cbCiudadOferta">Ciudad de la oferta:</label>
                                    <select class="form-control custom-select" id="cbCiudadOferta"  name="cbCiudadOferta"  oninput="validarCiudadOferta()" tabindex="4" required>
                                        <option value="0" selected="0">Seleccione Ciudad</option>
                                    </select>
                                    <label id="errorCiudadOferta" class="error" for="cbCiudadOferta"></label>

                                </div><br />
                            </div>
                            <div class="row col-md-12">
                                <div class="form-group col-md-12">
                                    <label class="custom-control-label">Nombre de la tienda:</label>
                                    <input class="form-control"  name="txtNombreTienda" id="txtNombreTienda" type="text" value="" maxlength="20" placeholder="Introduzca nombre de la tienda " oninput="validarNombreTienda()" tabindex="6" required>
                                    <label id="errorNombreTienda" class="error" for="txtNombreTienda"></label>
                                </div><br />
                            </div>
                        </div>
                        <div class="form-group mx-auto d-block img-fluid  col-md-6">
                            <div class="row col-md-12">
                                <div class="form-group col-md-12">
                                    <label class="custom-control-label">Dirección de la tienda:</label>
                                    <input class="form-control"  name="txtDireccionTienda" id="txtDireccionTienda" type="text" placeholder="Dirección de la tienda" oninput="validarDireccionTienda()" tabindex="5" required></input></div><br />
                                <label id="errorDireccion" class="error" for="txtDireccionTienda"></label>
                            </div>
                            <label class="custom-control-label mx-auto d-block" for="imgProducto">Imagen del producto:</label>
                            <div class="row">
                                &nbsp;
                            </div>
                            <img class="mx-auto d-block img-fluid" name="imgProducto" id="imgProducto"  src="../_img/lupa.png" alt="Imagen del producto" width="200px" height="200px" required>
                            <div class="row">
                                &nbsp;
                            </div>
                            <div class="custom-file col-md-12 mx-auto d-block">
                                <label class="custom-file-label" for="selectorImagen">Seleccione Imagen</label>
                                <input type="file" accept="image/*" class="custom-file-input " name="selectorImagen" id="selectorImagen" onchange="mostrarImagen();validarImagen();" oninput="validarImagen" tabindex="7" >
                                <label id="errorImagen" class="error" for="selectorImagen"></label>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-6">
                            <label  class="custom-control-label">Nombre de la Oferta:</label>
                            <input class="form-control"  name="txtNombreOferta" id="txtNombreOferta" type="text" value="" maxlength="45" placeholder="Introduzca nombre de oferta " oninput="validarNombreOferta()" tabindex="8" required>
                            <label id="errorNombreOferta" class="error" for="txtNombreOferta"></label>
                        </div><br />
                        <div class="form-group col-md-6">
                            <label class="custom-control-label">Precio:</label>
                            <input class="form-control"  name="txtPrecio" id="txtPrecio" type="text" min="1" value="1" maxlength="20" placeholder="Precio de oferta" oninput="validarPrecioDeOferta()" tabindex="9" required>
                            <label id="errorPrecio" class="error" for="txtPrecio"></label>
                        </div><br />

                    </div>
                    <div class="row">

                        <div class="form-group col-md-6">
                            <label class="custom-control-label">Fecha de Inicio:</label>
                            <input class="form-control"  name="txtFechaDeInicio" id="txtFechaDeInicio" type="date" value="" maxlength="45"  oninput="validarFechaInicio()" tabindex="10" required>
                            <label id="errorFechaInicio" class="error" for="txtFechaInicio"></label>
                        </div><br />

                        <div class="form-group col-md-6">
                            <label class="custom-control-label">Fecha de Finalización:</label>
                            <input class="form-control"  name="txtFechaDeFinalizacion" id="txtFechaDeFinalizacion" type="date" value="2000-12-10" maxlength="45"  oninput="validarFechaFinalizacion()" tabindex="11" required>
                            <label id="errorFechaFinalizacion" class="error" for="txtFechaFinalizacion"></label>
                        </div><br />

                    </div>
                    <div class="row">
                        &nbsp;
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            &nbsp;
                        </div>
                        <div class="row col-md-6">
                            <input class="btn btn-dark offset-1 col-md-4"  id="botonCancelar" type="button" value="Cancelar" tabindex="12" >
                            <input class="btn btn-danger offset-1 col-md-4"  id="botonRegistrar" type="button" value="Publicar" tabindex="13" >
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
        <script type="text/javascript" src="../_js/insertarOfertaLogica.js"></script>
        <script type="text/javascript" src="../_js/ciudadLogica.js"></script>
        <script type="text/javascript" src="../_js/bootstrap.min.js"></script>
        <script type="text/javascript" src="../_js/popper.min.js"></script>
        <script type="text/javascript" src="../_js/registrarOfertaFechasLogica.js"></script>
        <script src="../_js/categoriaLogica.js" type="text/javascript"></script>
        <script src="../_js/productoLogica.js" type="text/javascript"></script>
        
        
        
        
        
        
                <%@include file="./Footer.jsp" %>
        <script type="text/javascript">
            $(document).ready(function () {
                $().UItoTop({easingType: 'easeOutQuart'});

            });
        </script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


        <a href="#" id="toTop"> </a>
        <script type="text/javascript" src="../_js/navigation.js"></script>
        <link href="../_css/style.css" rel="stylesheet" type="text/css" media="all"/>
        <script type="text/javascript" src="../_js/jquery-1.9.0.min.js"></script> 
        <script src="../_js/jquery.openCarousel.js" type="text/javascript"></script>
        <script type="text/javascript" src="../_js/easing.js"></script>
        <script type="text/javascript" src="../_js/move-top.js"></script>
        <link href='http://fonts.googleapis.com/css?family=Ubuntu+Condensed' rel='stylesheet' type='text/css'>
    </body>

</html>