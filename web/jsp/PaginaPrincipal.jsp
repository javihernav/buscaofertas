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
        <meta name="viewport" content="width=device-width" user-scalable=no, initial-scale=1.0, maximum-scale=1.0, 
              maximum-scalable=1.0>

        <link rel="shortcut icon" type="image/x-icon" href="../_img/LETRERO-BUSCAOFERTAS-Y-nombre-técnico.png">
        
        <meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">

    </head>

    <body onload="">
        <header>  
            <%@include file="/jsp/Barra.jsp" %>
        </header>


        <div class="container col-md-8">

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

        <!-- <script type="text/javascript" src="../_js/jquery-3.3.1.js"></script>
          <script type="text/javascript" src="../_js/bootstrap.min.js"></script>
         <script type="text/javascript" src="../_js/popper.min.js"></script>
         <link rel="stylesheet" href="../_css/bootstrap.min.css">
        <link href="../_css/styles.css" rel="stylesheet" type="text/css" />-->
         
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
         <link href="../_css/styles.css" rel="stylesheet" type="text/css" />
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    </body>

</html>