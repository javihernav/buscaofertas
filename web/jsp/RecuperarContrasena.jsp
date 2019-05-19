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
        <h2 id="mensajeRecuperacion">Ingrese su correo o nombre de Usuario para recuperar la contraseña de su cuenta</h2>
        <figure>
            <img class="letreroCA" src="_img/LETRERO-BUSCAOFERTAS-sin-nombre-tecnico.png" alt="BuscaOfertas.jpg" width="500">

        </figure>

        <div>

            <form class="consultaAvanzada" action="" autocomplete="on">
                <div><label>Email:</label><input id="txtCorreo" type="email" value="Email"></div><br/>
                <div><label>Usuario:</label><input id="txtUsuario" type="text" value="nombre de usuario"></div><br/>

                <div><input id="botonCancelar" type="button" value="Cancelar">
                    <input id="botonRecuperar" type="submit" value="Recuperar"></div>

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