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

    <body >
        <header>  
            <%@include file="/jsp/Barra.jsp" %>
        </header>

        <!--<figure>
            <img class="img-fluid mx-auto d-block" src="../_img/LETRERO-BUSCAOFERTAS-sin-nombre-tecnico.png" alt="BuscaOfertas.jpg" >

        </figure>-->

        <div class="container">
            <form id="formulario" class="form-check" autocomplete="on"  >
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
                    <div class="form-group col-md-6">
                        <label class="control-label " for="txtNombres">Nombres:</label>
                        <input autofocus="on" class="form-control required"id="txtNombres" type="text" value="" maxlength="45" placeholder="Introduzca sus nombres " oninput="validarNombres()" tabindex="1" required>
                        <label id="errorNombres" class="error" for="txtNombres"></label>
                    </div>
                    <div class="form-group col-md-6">
                        <label class="control-label " for="txtApellidos">Apellidos:</label>                        
                        <input class="form-control required"id="txtApellidos" type="text" value="" maxlength="45" placeholder="Introduzca sus apellidos " oninput="validarApellidos()" tabindex="2"  required>
                        <label id="errorApellidos" class="error " for="txtApellidos"></label>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-6">
                        <label class="control-label ">Email:</label>
                        <input class="form-control required" id="txtCorreo" type="email" value="" maxlength="45" placeholder="Introduzca su e-mail " oninput="validarCorreo()" tabindex="3"  required>
                        <label id="errorCorreo" class="error " for="txtCorreo"></label>
                    </div>
                    <div class="form-group col-md-6">
                        <label class="control-label ">Confirmar:</label>
                        <input class="form-control required" id="txtConfirmarCorreo" type="email" value="" maxlength="45" placeholder="Introduzca su e-mail " oninput="validarCorreoConf()" tabindex="4"  required>
                        <label id="errorCorreoConf" class="error " for="txtConfirmarCorreo"></label>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-3">
                        <label class="control-label ">Teléfono:</label>
                        <input class="form-control required" id="txtTelefono" type="text" value="" maxlength="20" placeholder="Introduzca su teléfono " oninput="validarTelefono()" tabindex="5"  required>
                        <label id="errorTelefono" class="error " for="txtTelefono"></label>
                    </div>
                    <div class="form-group col-md-3">
                        <label class="control-label ">Fecha de Nacimiento:</label>
                        <input class="form-control required" id="txtFechaDeNacimiento" type="date" value="" max="2001-05-07"  oninput="validarFecha()" tabindex="6"  required>
                        <label id="errorFecha" class="error " for="txtFechaDeNacimiento"></label>
                    </div>
                    <div class="form-group col-md-6">
                        <label class="control-label ">Ciudad:</label>
                        <select class="form-control required"id="cbCiudadUsuario" type="text" onchange="validarCiudad()" tabindex="7"  required>
                            <option style="color: #000; background: #fff;"value="0">Seleccione Ciudad</option>
                        </select>
                        <label id="errorCiudad" class="error " for="cbCiudadUsuario"></label>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-6">
                        <label class="control-label ">Usuario:</label>
                        <input class="form-control required"id="txtUsuario" type="text" value="" maxlength="20" placeholder="Nombre de usuario para su cuenta" oninput="validarNombreUsuario()" tabindex="8"  required>
                        <label id="errorUsuario" class="error " for="txtUsuairo"></label>
                    </div>
                    <div class="form-group col-md-6">
                        <label class="control-label ">Género:</label>
                        <select class="form-control required"id="cbGenero" type="text" onchange="validarGenero()" tabindex="9"  required>
                            <option value="0">Género</option>
                            <option value="m">Masculino</option>
                            <option value="f">Femenino</option></select>
                        <label id="errorGenero" class="error " for="cbGenero"></label>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-6">
                        <label class="control-label ">Password:</label>
                        <input class="form-control required"id="txtPassword" type="password" value="" maxlength="20" placeholder="Introduzca su contraseña" oninput="validarPassword()" tabindex="10"  required>
                        <label id="errorPassword" class="error " for="txtPassword"></label>
                    </div>
                    <div class="form-group col-md-6">
                        <label class="control-label ">Confirmar Password:</label>
                        <input class="form-control required"id="txtPasswordConfirmacion" type="password" value="" maxlength="20" placeholder="Confirme su contraseña"  oninput="validarPassword()" tabindex="11"  required>
                        <label id="errorPassword2" class="error " for="txtPasswordConfirmacion"></label>
                    </div>
                </div>
                <div class="row">
                    &nbsp;
                </div>
                <div class="row">
                    <div  class="form-group col-md-6">
                        <input class="form-control  btn btn-dark  col-md-6 offset-3" type="button" value="Cancelar" href="PaginaPrincipal.jsp" onclick = "location = 'PaginaPrincipal.jsp'" tabindex="12" /><!--id="botonCancelar"--> 
                    </div>
                    <div  class="form-group col-md-6">
                        <input  class="form-control  btn btn-danger  col-md-6 offset-3" type="button" value="Registrar" id="botonRegistrar" tabindex="13" ><!---->
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
        <!--<script type="text/javascript" src="../_js/ciudadLogica.js"></script>-->
        <script type="text/javascript" src="../_js/validacion.js"></script>
        <script type="text/javascript" src="../_js/insertarUsuarioLogica.js"></script>
        <script type="text/javascript" src="../_js/jquery-3.3.1.js"></script>
        <script type="text/javascript" src="../_js/bootstrap.min.js"></script>
        <script type="text/javascript" src="../_js/popper.min.js"></script>
        <link rel="stylesheet" href="../_css/bootstrap.min.css">
        <link href="../_css/styles.css" rel="stylesheet" type="text/css" />
        <script src="../_js/registrarPerfilFechaLogica.js" type="text/javascript"></script>
        <!--<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js" type="text/javascript"></script>-->
       
    </body>
</html>