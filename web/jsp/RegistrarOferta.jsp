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
        <meta name="viewport" content="width=device-width" , user-scalable=no, initial-scale=1.0, maximum-scale=1.0,
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
            <img class="letreroCA" src="../_img/LETRERO-BUSCAOFERTAS-sin-nombre-tecnico.png" alt="BuscaOfertas.jpg" width="500">

        </figure>

        <div>
          
            <form class="registrarOferta" autocomplete="on" method="post" action="" enctype="multipart/form-data" >
                <table style="width:100% ">
                    <tr>
                        <th>
                    <div><label>Nombre del producto:</label><input id="txtNombreProducto" type="text" value="" maxlength="45" placeholder="Introduzca nombre del producto " oninput="validarNombreProducto()" required></div><br />
                    </th>
                    <th>
                    <div><label>Nombre de la Oferta:</label><input id="txtNombreOferta" type="text" value="" maxlength="45" placeholder="Introduzca nombre de oferta " oninput="validarNombreOferta()" required></div><br />
                    </th>
                    <th>
                    <div><label>Imagen del producto:</label></div><br />
                    </th>
                    </tr>
                    <tr>
                        <th>
                    <div><label>Ciudad de la oferta:</label><select id="cbCiudadOferta"  oninput="validarCiudadOferta()" required><option>Seleccione Ciudad</option></select></div><br />
                    </th>
                    <th>
                    <div><label>Nombre de la tienda:</label><input id="txtNombreTienda" type="text" value="" maxlength="20" placeholder="Introduzca nombre de la tienda " oninput="validarNombreTienda()" required></div><br />
                    </th>
                    <th>
                        <img id="imgProducto"  src="../_img/lupa.png" alt="Imagen del producto" oninput="validarImagen()" width="200px" height="200px" required>
                        <input type="file" onchange="mostrarImagen()">
                    </th>
                    </tr>
                    <tr>
                        <th>
                    <div><label>Dirección de la tienda:</label><input id="txtDireccionTienda" type="text" placeholder="Dirección de la tienda" oninput="validarDireccionTienda()" required></input></div><br />
                    </th>
                    <th>
                    <div><label>Precio:</label><input id="txtPrecio" type="text" value="" maxlength="20" placeholder="Precio de oferta" oninput="validarPrecioDeOferta()" required></div><br />
                    </th>
                    </tr>
                    <tr>
                        <th>
                    <div><label>Fecha de Inicio:</label><input id="txtFechaDeInicio" type="date" value="" maxlength="45"  oninput="validarFechaInicio()" required></div><br />
                    </th>
                    <th>     
                    <div><label>Fecha de Finalización:</label><input id="txtFechaDeFinalizacion" type="date" value="" maxlength="45"  oninput="validarFechaFinalizacion()" required></div><br />
                    </th>                
                    </tr>
                    <tr>
                        <th></th>
                        <th> <input id="botonCancelar" type="button" value="Cancelar"></th>
                        <th><input id="botonRegistrar" type="submit" value="Publicar Oferta"></th>
                    </tr>
                </table>



            </form>
        </div>
        <link href="../_css/styles.css" rel="stylesheet" type="text/css" />

        <script type="text/javascript" src="../_js/jquery-3.3.1.js"></script>
        <script type="text/javascript" src="../_js/consultasCiudadLogica.js"></script>
        <script type="text/javascript" src="../_js/tratamientoImagenes.js"></script>
     
        <script type="text/javascript" src="../_js/validacion.js"></script>
        <script type="text/javascript" src="../_js/insertarOfertaLogica.js"></script>
        <script type="text/javascript" src="../_js/ciudadLogica.js"></script>
    </body>

</html>