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
        <meta name="viewport" content="width=device-width" user-scalable=no  initial-scale=1.0  maximum-scale=1.0
              maximum-scalable=1.0>
        <link rel="shortcut icon" type="image/x-icon" href="../_img/LETRERO-BUSCAOFERTAS-Y-nombre-técnico.png">
        <link href="https://fonts.googleapis.com/css?family=Krub" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Michroma" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=PT+Mono" rel="stylesheet">
        <meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
    </head>

    <body onload="cargarComboBoxDatos()">
        <header>  
            <%@include file="/jsp/Barra.jsp" %>
        </header>

        <!--<figure>
            <img class="img-fluid mx-auto d-block" src="../_img/LETRERO-BUSCAOFERTAS-sin-nombre-tecnico.png" alt="BuscaOfertas.jpg" >

        </figure>-->

        <div class="container">
            <form class="form-check" autocomplete="on"  >
                <div class="row">
                    &nbsp;
                </div>
                <div class="row">
                    <h1 class="h1 d-block mx-auto font-italic">Registro de Usuarios</h1>
                </div>
                <div class="row">
                    &nbsp;
                </div>
                <div class="row">
                    <div class="form-group col-md-6"><label class="control-label ">Nombres:</label><input autofocus="on" class="form-control "id="txtNombres" type="text" value="" maxlength="45" placeholder="Introduzca sus nombres " oninput="validarNombres()" required></div>
                    <div class="form-group col-md-6"><label class="control-label ">Apellidos:</label><input class="form-control "id="txtApellidos" type="text" value="" maxlength="45" placeholder="Introduzca sus apellidos " oninput="validarApellidos()" required></div>
                </div>
                <div class="row">
                    <div class="form-group col-md-6"><label class="control-label ">Email:</label><input class="form-control "id="txtCorreo" type="email" value="" maxlength="45" placeholder="Introduzca su e-mail " oninput="validarCorreo()" required></div>
                    <div class="form-group col-md-6"><label class="control-label ">Teléfono:</label><input class="form-control "id="txtTelefono" type="text" value="" maxlength="20" placeholder="Introduzca su teléfono " oninput="validarTelefono()" required></div>
                </div>
                <div class="row">
                    <div class="form-group col-md-6"><label class="control-label ">Ciudad:</label><select class="form-control "id="cbCiudadUsuario" type="text" required><option value="0">Seleccione Ciudad</option></select></div>
                    <div class="form-group col-md-6"><label class="control-label ">Fecha de Nacimiento:</label><input class="form-control "id="txtFechaDeNacimiento" type="date" value="" maxlength="45"  oninput="validarFecha()" required></div>
                </div>
                <div class="row">
                    <div class="form-group col-md-6"><label class="control-label ">Usuario:</label><input class="form-control "id="txtUsuario" type="text" value="" maxlength="20" placeholder="Nombre de usuario para su cuenta" oninput="validarNombreUsuario()" required></div>
                    <div class="form-group col-md-6"><label class="control-label ">Género:</label><select class="form-control "id="cbGenero" type="text" onchange="validarGenero()" required><option value="0">Género</option><option value="m">Masculino</option><option value="f">Femenino</option></select></div>
                </div>
                <div class="row">
                    <div class="form-group col-md-6"><label class="control-label ">Password:</label><input class="form-control "id="txtPassword" type="password" value="" maxlength="20" placeholder="Introduzca su contraseña" oninput="validarPassword()" required></div>
                    <div class="form-group col-md-6"><label class="control-label ">Confirmar Password:</label><input class="form-control "id="txtPasswordConfirmacion" type="password" value="" maxlength="20" placeholder="Confirme su contraseña"  oninput="validarPassword()" required></div>
                </div>
                <div class="row">
                    &nbsp;
                </div>
                <div class="row">
                    <div  class="form-group col-md-6">
                        <input class="form-control  btn btn-dark  col-md-6 offset-3" type="button" value="Cancelar" href="PaginaPrincipal.jsp" onclick = "location = 'PaginaPrincipal.jsp'"/><!--id="botonCancelar"--> 
                    </div>
                    <div  class="form-group col-md-6">
                        <input  class="form-control  btn btn-danger  col-md-6 offset-3" type="button" value="Registrar" id="botonRegistrar"><!---->
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

        <script type="text/javascript" src="../_js/consultasCiudadLogica.js"></script>
        <script type="text/javascript" src="../_js/validacion.js"></script>
        <script type="text/javascript" src="../_js/insertarUsuarioLogica.js"></script>
        <script type="text/javascript" src="../_js/jquery-3.3.1.js"></script>
        <script type="text/javascript" src="../_js/bootstrap.min.js"></script>
        <script type="text/javascript" src="../_js/popper.min.js"></script>
        <link rel="stylesheet" href="../_css/bootstrap.min.css">
        <link href="../_css/styles.css" rel="stylesheet" type="text/css" />
    </body>
</html>