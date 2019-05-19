<%-- 
    Document   : Consultas
    Created on : Nov 22, 2018, 3:56:00 PM
    Author     : JAVIER
--%>

<%@page import="app.utils.EncriptacionAES"%>
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

    <body>
        <header>  
            <%@include file="/jsp/Barra.jsp" %>
        </header>

        <!--<figure>
            <img class="img-fluid mx-auto d-block" src="../_img/LETRERO-BUSCAOFERTAS-sin-nombre-tecnico.png" alt="BuscaOfertas.jpg" >

        </figure>-->

        <div class="container">
            <form class="form-check" autocomplete="off"  >
                <div class="row">
                    &nbsp;
                </div>
                <div class="row">
                    <h1 class="h1 d-block mx-auto font-italic">Actualizar Datos</h1>
                </div>
        <%
            //HttpSession sesion1 = request.getSession();
            Usuario vo = (Usuario) sesion.getAttribute("usuario");
        %>
                <div class="row">
                    &nbsp;
                </div>
                <div class="row">
                    <div class="form-group col-md-6">
                        <label class="control-label " for="txtNombres">Nombres:</label>
                        <input autofocus="on" class="form-control "id="txtNombres" type="text" value="<%=vo.getNombre() %>" maxlength="45" placeholder="Introduzca sus nombres " oninput="validarNombres()" required>
                        <label id="errorNombres" class="error " for="txtNombres"></label>
                    </div>
                    <div class="form-group col-md-6">
                        <label class="control-label " for="txtApellidos">Apellidos:</label>
                        <input class="form-control "id="txtApellidos" type="text" value="<%= vo.getApellido() %>" maxlength="45" placeholder="Introduzca sus apellidos " oninput="validarApellidos()" required>
                        <label id="errorApellidos" class="error " for="txtApellidos"></label>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-4">
                        <label class="control-label " for="txtCorreo">Email:</label>
                        <input class="form-control "id="txtCorreo" type="email" value="<%= vo.getCorreo() %>" maxlength="45" placeholder="Introduzca su e-mail " oninput="validarCorreo()" required>
                        <label id="errorCorreo" class="error " for="txtCorreo"></label>
                    </div>
                    <div class="form-group col-md-4">
                        <label class="control-label " for="txtConfirmarCorreo">Confirmar Email:</label>
                        <input class="form-control "id="txtConfirmarCorreo" type="email" value="<%= vo.getCorreo() %>" maxlength="45" placeholder="Introduzca su e-mail " oninput="validarCorreo()" required>
                        <label id="errorCorreoConf" class="error" for="txtConfirmarCorreo"></label>
                    </div>
                    <div class="form-group col-md-4">
                        <label class="control-label " for="txtTelefono">Teléfono:</label>
                        <input class="form-control "id="txtTelefono" type="text" value="<%= vo.getTelefono() %>" maxlength="20" placeholder="Introduzca su teléfono " oninput="validarTelefono()" required>
                        <label id="errorTelefono" class="error" for="txtTelefono"></label>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-6">
                        <label class="control-label " for="cbCiudadUsuario">Ciudad:</label>
                        <select class="form-control "id="cbCiudadUsuario" type="text" onchange="validarCiudad()" selectedIndex="<%=vo.getCiudad_idCiudad() %>" default="<%=vo.getCiudad_idCiudad() %>" required>
                            <option value="0" label="Seleccione Ciudad" selected hidden>Seleccione una ciudad</option>
                        </select>
                        <label id="errorCiudad" class="error" for="cbCiudadUsuario"></label>
                        <!--<input class="form-control error"id="txtCity" type="text" value="<%=vo.getCiudad_idCiudad() %>" maxlength="45"   required>-->
                    </div>
                    <%
                    
                    %>
                    <div class="form-group col-md-6">
                        <label class="control-label " for="txtFechaDeNacimiento">Fecha de Nacimiento:</label>
                        <input class="form-control"id="txtFechaDeNacimiento" type="date" value="<%= vo.getFechaNacimiento() %>" maxlength="45"  oninput="validarFecha()" required>
                        <label id="errorFecha" class="error" for="txtFechaDeNacimiento"></label>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-6">
                        <label class="control-label " for="txtUsuario">Usuario:</label>
                        <input class="form-control "id="txtUsuario" type="text" value="<%= vo.getNombreUsuario() %>" maxlength="20" placeholder="Nombre de usuario para su cuenta" oninput="validarNombreUsuario()" required>
                        <label id="errorUsuario" class="error" for="txtUsuario"></label>
                    </div>
                    <div class="form-group col-md-6">
                        <label class="control-label " for="cbGenero">Género:</label>
                        <select class="form-control "id="cbGenero" type="text" onchange="validarGenero()" selectedIndex="<%= vo.getGenero() %>" required>
<!--                            <option value="">Seleccione género</option>-->
                            <option value="m">Masculino</option>
                            <option value="f">Femenino</option>
                        </select>
                            <label id="errorGenero" class="error" for="cbGenero"></label>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-6">
                        <label class="control-label " for="txtPassword">Password:</label>
                        <input class="form-control "id="txtPassword" type="password" value="<%= EncriptacionAES.desencriptar("buscaofertas1234", "1234567890abcdef", vo.getContrasena()) %>" maxlength="20" placeholder="Introduzca su contraseña" oninput="validarPassword()" required>
                        <label id="errorPassword" class="error" for="txtPassword"></label>
                    </div>
                    <div class="form-group col-md-6">
                        <label class="control-label ">Confirmar Password:</label>
                        <input class="form-control "id="txtPasswordConfirmacion" type="password" value="<%= EncriptacionAES.desencriptar("buscaofertas1234", "1234567890abcdef", vo.getContrasena()) %>" maxlength="20" placeholder="Confirme su contraseña"  oninput="validarPassword()" required>
                        <label id="errorPassword2" class="error" for="txtPasswordConfirmacion"></label>
                    </div>
                </div>
                <div class="row">
                    &nbsp;
                </div>
                <div class="row">
                    <div  class="form-group col-md-6">
                        <input class="form-control  btn btn-dark  col-md-6 offset-3" type="button" value="Cancelar" href="PaginaPrincipal.jsp" onclick = "location = 'PaginaPrincipal.jsp'"/><!--id="botonCancelar"--> 
                    </div>
                    <div  class="form-group col-md-6">
                        <input  class="form-control  btn btn-danger  col-md-6 offset-3" type="button" value="Actualizar" id="botonRegistrar"><!---->
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
        <script type="text/javascript" src="../_js/actualizarUsuarioLogica.js"></script>
        <script type="text/javascript" src="../_js/jquery-3.3.1.js"></script>
        <script type="text/javascript" src="../_js/bootstrap.min.js"></script>
        <script type="text/javascript" src="../_js/popper.min.js"></script>
        <link rel="stylesheet" href="../_css/bootstrap.min.css">
        <link href="../_css/styles.css" rel="stylesheet" type="text/css" />
        
        
        
        
        
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