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
        
        <link rel="shortcut icon" type="image/x-icon" href="../_img/LETRERO-BUSCAOFERTAS-Y-nombre-técnico.png">
        <link href="https://fonts.googleapis.com/css?family=Krub" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Michroma" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=PT+Mono" rel="stylesheet">
        <meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">

    </head>

    <body onload="acordeon()">
        <header>

            <div class="topnav">
                <a class="active" href="./PaginaPrincipal.jsp">Home</a>
                <a href="#news">Acerca de nosotros</a>
                <a href="#news">Contáctanos</a>
                <a href="#contact">Siguenos en Redes Sociales</a>
                <a href="#about">Ayuda</a>
                <a href="./Login.jsp">Inicia Sesión</a>
                <a href="./RegistrarPerfil.jsp">Regístrate</a>
                <!--  a href = ". / otherPage.jsp? param1 = Hellold" -->
            </div>
        </header>

        <figure>
            <img class="img-fluid mx-auto d-block" src="../_img/LETRERO-BUSCAOFERTAS-sin-nombre-tecnico.png" alt="BuscaOfertas.jpg" width="500">

        </figure>

        <div class="container col-md-12">

            <form class="form-inline" action="" autocomplete="on">
                <div class="row col-md-12">
                    <div class="form-group">
                    &nbsp;
                    </div>
                </div>
                <div class="row col-md-12">
                    <div class="form-group col-md-12">
                        <input class="form-control col-md-10" id="txtNombreProducto" type="text" name="nombreProducto" placeholder="ingrese nombre del producto">
                        <input class='form-control col-md-2 btn btn-danger' id="btnBuscar"type="submit" value="Buscar">
                        
                    </div>
                </div>
                <div class="row col-md-12">
                    <div class="form-group">
                    &nbsp;
                    </div>
                </div>
            </form>
        </div>
        <script type="text/javascript" src="../_js/jquery-3.3.1.js"></script>
        <script type="text/javascript" src="../_js/bootstrap.min.js"></script>
        <script type="text/javascript" src="../_js/popper.min.js"></script>
        <link rel="stylesheet" href="../_css/bootstrap.min.css">
        <link href="../_css/styles.css" rel="stylesheet" type="text/css" />
    </body>

</html>