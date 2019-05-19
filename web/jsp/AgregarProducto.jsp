<%-- 
    Document   : AgregarProducto
    Created on : May 4, 2019, 10:52:07 PM
    Author     : JAVIER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
        <link rel="shortcut icon" type="image/x-icon" href="../_img/LETRERO-BUSCAOFERTAS-Y-nombre-técnico.png">
        <title>Agregar Producto</title>
    </head>
    <body onload="cargarComboBoxCategorias()">
        <header>  
            <%@include file="/jsp/Barra.jsp" %>
        </header>
        <div class="container">
            <form class="form-check" autocomplete="on"  >
                <div class="row">
                    &nbsp;
                </div>
                <div class="row">
                    <h1 class="h1 d-block mx-auto font-italic">Agregar Producto</h1>
                </div>
                <div class="row">
                    &nbsp;
                </div>
                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="control-label" for="txtNombreProducto">Nombre:</label>
                        <input autofocus="on" class="form-control "id="txtNombreProducto" type="text" value="" maxlength="45" placeholder="Introduzca nombre del producto " oninput="validarNombreProducto()" required>
                        <label id="errorNombre" class="error" for="txtNombreProducto"></label>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="control-label" for="cbCategoria" >Categoria:</label>
                        <select class="form-control" id="cbCategoria" onchange="validarCategoria()" required>
                            <option value="0">Seleccione Categoría</option>
                        </select>
                        <label id="errorCategoria" class="error" for="cbCategoria"></label>
                    </div>
                </div>
                <div class="row">

                    <div class="form-group col-md-12">
                        <label class="control-label ">Marca:</label>
                        <input class="form-control" id="txtMarca" type="text" value="" maxlength="20" placeholder="Introduzca marca del producto" oninput="validarMarca()" required>
                        <label id="errorMarca" class="error" for="txtMarca"></label>
                    </div>
                </div>

                <div class="row">
                    &nbsp;
                </div>
                <div class="row">
                    <div  class="form-group col-md-6">
                        <input class="form-control  btn btn-dark  col-md-6 offset-3" type="button" value="Cancelar" href="PaginaPrincipal.jsp" /><!--id="botonCancelar"--> 
                    </div>
                    <div  class="form-group col-md-6">
                        <input  class="form-control  btn btn-danger  col-md-6 offset-3" type="button" value="Agregar" id="botonAgregar"/><!---->
                    </div>
                </div>
                <div class="row">
                    &nbsp;
                </div>
            </form>
        </div>
        <div class="row">
            &nbsp;
        </div>



        <script type="text/javascript" src="../_js/insertarProductoLogica.js"></script>
        <script type="text/javascript" src="../_js/jquery-3.3.1.js"></script>
        <script type="text/javascript" src="../_js/bootstrap.min.js"></script>
        <script type="text/javascript" src="../_js/popper.min.js"></script>
        <link rel="stylesheet" href="../_css/bootstrap.min.css">
        <link href="../_css/styles.css" rel="stylesheet" type="text/css" />
        <script src="../_js/categoriaLogica.js" type="text/javascript"></script>
        <script src="../_js/validacionProducto.js" type="text/javascript"></script>
        
        
        
        
        
        
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
