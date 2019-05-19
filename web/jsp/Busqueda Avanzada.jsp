<%-- 
    Document   : Consultas
    Created on : Nov 22, 2018, 3:56:00 PM
    Author     : JAVIER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <title>Entrega Proyecto BuscaOfertas</title>
        <meta charset="UTF-8">
        <meta name="titulo" content="Proyecto BuscaOfertas">
        <meta name="descripcion" content="Entrega Proyecto BuscaOfertas">
        <meta name="viewport" content="width=device-width" , user-scalable=no, initial-scale=1.0, maximum-scale=1.0,
              maximum-scalable=1.0>
        <link rel="shortcut icon" type="image/x-icon" href="_img/LETRERO-BUSCAOFERTAS-Y-nombre-técnico.png">
        <link href="_css/styles.css" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Krub" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Michroma" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=PT+Mono" rel="stylesheet">
        <meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
        <script src="_js/scripts.js"></script>
    </head>

    <body onload="acordeon(), mostrarVariablesEjercicio1()">
        <header>  
            <%@include file="/jsp/Barra.jsp" %>
        </header>

        <figure>
            <img class="letreroCA" src="_img/LETRERO-BUSCAOFERTAS-sin-nombre-tecnico.png" alt="BuscaOfertas.jpg" width="500">

        </figure>

        <div>

            <form class="busquedaAvanzada" action="" autocomplete="on">
                <div><label>Nombre:</label><input id="txtNombreProducto" type="text" value="nombre del producto"></div><br/>
                <div><label>Ciudad:</label><input id="txtCiudadProducto" type="text" value="ciudad"></div><br/>
                <label>Precio:</label>
                <div><label>desde:</label><input id="txtPrecioProductoDesde" type="number" value="precio mínimo"></div><br/>
                <div><label>hasta:</label><input id="txtPrecioProductoHasta" type="number" value="precio máximo"></div><br/>
                <label>Fecha:</label>
                <div><label>desde:</label><input id="txtFechaDesdeProducto" type="date" value="ingrese nombre del producto"></div><br/>
                <div><label>hasta:</label><input id="txtNombreProducto" type="date" value="ingrese nombre del producto"><input id="botonBuscar" type="submit" value=""></div>

            </form>
        </div>
        
        
        
        
        
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