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

    <body onload="cargarComboBoxCiudad()">
        <header>

            <div class="topnav">
                <a class="active" href="./PaginaPrincipal.jsp">Home</a>
                <a href="#news">Acerca de nosotros</a>
                <a href="#news">Contáctanos</a>
                <a href="#contact">Siguenos en Redes Sociales</a>
                <a href="#about">Ayuda</a>
                <a href="./Login.jsp">Inicia Sesión</a>
                <a href="./RegistrarPerfil.jsp">Regístrate</a>
            </div>
        </header>

        <figure>
            <img class="mx-auto d-block img-fluid" src="../_img/LETRERO-BUSCAOFERTAS-sin-nombre-tecnico.png" alt="BuscaOfertas.jpg" width="500">

        </figure>

        <div class="container">

            <form class="form-check" autocomplete="on" method="post" action="" enctype="multipart/form-data" >

                <div class="container">

                    <div class="row">
                        &nbsp;
                    </div>
                    <center><h1 class="mx-auto d-block">Registro de Ofertas</h1></center>
                    <div class="row">
                        <div class="form-group col-md-12"><label  class="custom-control-label">Nombre del producto:</label><input class="form-control" id="txtNombreProducto" type="text" value="" maxlength="45" placeholder="Introduzca nombre del producto " oninput="validarNombreProducto()" required></div><br />

                    </div>
                    <div class="row col-md-12">
                        <div class="row col-md-7">

                            <div class="row col-md-12">
                                <div class="form-group col-md-12">
                                    <label class="custom-control-label" for="cbCiudadOferta">Ciudad de la oferta:</label>
                                    <select class="custom-select" id="cbCiudadOferta"  oninput="validarCiudadOferta()" required><option selected="0">Seleccione Ciudad</option>
                                    </select>

                                </div><br />
                            </div>
                            <div class="row col-md-12">
                                <div class="form-group col-md-12"><label class="custom-control-label">Nombre de la tienda:</label><input class="form-control"  id="txtNombreTienda" type="text" value="" maxlength="20" placeholder="Introduzca nombre de la tienda " oninput="validarNombreTienda()" required></div><br />
                            </div>
                            <div class="row col-md-12">
                                <div class="form-group col-md-12"><label class="custom-control-label">Dirección de la tienda:</label><input class="form-control"  id="txtDireccionTienda" type="text" placeholder="Dirección de la tienda" oninput="validarDireccionTienda()" required></input></div><br />
                            </div>
                        </div>
                        <div class="form-group mx-auto d-block img-fluid  col-md-4">
                            <label class="custom-control-label mx-auto d-block" for="imgProducto">Imagen del producto:</label>
                            <div class="row">
                                &nbsp;
                            </div>
                            <img class="mx-auto d-block img-fluid" id="imgProducto"  src="../_img/lupa.png" alt="Imagen del producto" oninput="validarImagen()" width="200px" height="200px" required>
                            <div class="row">
                                &nbsp;
                            </div>
                            <div class="custom-file col-md-12 mx-auto d-block">
                                <input type="file" class="custom-file-input " id="selectorImagen" onchange="mostrarImagen()">
                                <label class="custom-file-label" for="selectorImagen">Seleccione Imagen</label>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-6"><label  class="custom-control-label">Nombre de la Oferta:</label><input class="form-control"  id="txtNombreOferta" type="text" value="" maxlength="45" placeholder="Introduzca nombre de oferta " oninput="validarNombreOferta()" required></div><br />
                        <div class="form-group col-md-6"><label class="custom-control-label">Precio:</label><input class="form-control"  id="txtPrecio" type="number" min="1" value="1" maxlength="20" placeholder="Precio de oferta" oninput="validarPrecioDeOferta()" required></div><br />

                    </div>


                    <div class="row">




                        <div class="form-group col-md-6"><label class="custom-control-label">Fecha de Inicio:</label><input class="form-control"  id="txtFechaDeInicio" type="date" value="" maxlength="45"  oninput="validarFechaInicio()" required></div><br />

                        <div class="form-group col-md-6"><label class="custom-control-label">Fecha de Finalización:</label><input class="form-control"  id="txtFechaDeFinalizacion" type="date" value="2000-12-10" maxlength="45"  oninput="validarFechaFinalizacion()" required></div><br />



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
                            <input class="btn btn-danger offset-1 col-md-4"  id="botonRegistrar" type="button" value="Publicar Oferta">
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
        <!--<script type="text/javascript" src="../_js/registrarOferta.js"></script>-->

    </body>

</html>