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
        <meta name="viewport" content="width=device-width"  user-scalable=no initial-scale=1.0 maximum-scale=1.0
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
        <!--
                <figure>
                    <img class="img-fluid mx-auto d-block " src="../_img/LETRERO-BUSCAOFERTAS-sin-nombre-tecnico.png" alt="BuscaOfertas.jpg" >
        
                </figure>-->

        <div class="container col-md-6">

            <form class="form-inline" autocomplete="off" action="">
                <div class="row  col-md-12">
                    <div class="form-group col-md-12">
                        &nbsp;
                    </div>
                </div>
                <div class="row  col-md-12">
                    <h1 class="mx-auto d-block h3 offset-2">Ingreso de Usuarios</h1>
                </div>
                <div class="row  col-md-12">
                    <div class="form-group col-md-12">
                        &nbsp;
                    </div>
                </div>
                <div class="row  col-md-12">
                    <div class="form-group col-md-12">
                        &nbsp;
                    </div>
                </div>
                <div class="row  col-md-12">
                    <div class="form-group col-md-12">


                        <label for="txtUsuario" class=" col-md-8">Usuario:</label>
                        <div class="row  col-md-12">
                            <div class="form-group col-md-12">
                                &nbsp;
                            </div>
                        </div>
                        <input autofocus="on" class="form-control col-md-8 offset-3" id="txtUsuario" type="text" name="usuario" placeholder="ingrese nombre de usuario" oninput="validarUsuario()"><br/>
                        <label id="errorUsuario" for="txtUsuario" class=" col-md-8 error"></label>

                    </div>
                </div>
                <div class="row col-md-12">
                    <div class="form-group col-md-12">
                        <div class="row  col-md-12">
                            <div class="form-group col-md-12">
                                &nbsp;
                            </div>
                        </div>

                        <label for="txtPassword" class=" col-md-8">Password:</label>
                        <div class="row  col-md-12">
                            <div class="form-group col-md-12">
                                &nbsp;
                            </div>
                        </div>
                        <input class="form-control col-md-8 offset-3" id="txtPassword" type="password" name="clave" placeholder="ingrese password"value="" oninput="validarPasswd()"><br/><br/>
                        <label id="errorPassword" for="txtPassword" class=" col-md-8 error"></label>

                    </div>
                </div>
                <div class="row  col-md-12">
                    <div class="form-group col-md-12">
                        &nbsp;
                    </div>
                </div>
                <div class="row col-md-12">
                    <div class="form-group col-md-12">
                        <input class="form-control col-md-4 offset-3 btn btn-dark" id="botonCancelar"type="button" value="Cancelar" onclick = "location = 'PaginaPrincipal.jsp'">
                        <input class="form-control col-md-4 btn btn-danger"id="botonIngresar"type="button" value="Ingresar"><br/><br/>
                    </div>
                </div>

                <a class="form-text offset-3" href="">Recuperar password</a>
                <div class="row  col-md-12">
                    <div class="form-group col-md-12">
                        &nbsp;
                    </div>
                </div>
            </form>
        </div>
        <div class="container">
            <br>
            <!--se saca con a.btn y enter
            <a href="#ventana1" class="btn btn-primary btn-lg" data-toggle="modal">Boton 1</a>
            <a href="#ventana2" class="btn btn-success btn-lg" data-toggle="modal">Boton 2</a>-->
            <!--se saca con .modal.fade y enter-->
            <div class="modal fade" id="ventana1">
                <!--se saca con .modal-dialog y enter-->
                <div class="modal-dialog">
                    <div class="modal-content">
                        <!--header de la ventana-->
                        <div class="modal-header">
                            <!--&times es para que salga la x de cerrar la ventana como botón-->
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title">
                                Bienvenido a BuscaOfertas
                            </h4>
                        </div>
                        <!--Contenido de la ventana-->
                        <!--se saca con .modal-body y enter-->
                        <div class="modal-body">
                            <p>El lugar para encontrar las mejores ofertas</p>

                        </div>
                        <!--Footer de la ventana-->
                        <!--se saca con .modal-footer y enter-->
                        <div class="modal-footer">
                            <!--con data-dismiss le damos la funcionalidad de cerrar-->
                            <button type="button" class="btn btn-default" data-dismiss="modal" onclick="redireccionar()">Aceptar</button>

                        </div>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="ventana2">
                <!--se saca con .modal-dialog y enter-->
                <div class="modal-dialog">
                    <div class="modal-content">
                        <!--header de la ventana-->
                        <div class="modal-header">
                            <!--&times es para que salga la x de cerrar la ventana como botón-->
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title">
                                Error de autenticación
                            </h4>
                        </div>
                        <!--Contenido de la ventana-->
                        <!--se saca con .modal-body y enter-->
                        <div class="modal-body">
                            <p>Usted ha ingresado nombre de usuario o contraseña incorrectos.
                            </p>

                        </div>
                        <!--Footer de la ventana-->
                        <!--se saca con .modal-footer y enter-->
                        <div class="modal-footer">
                            <!--con data-dismiss le damos la funcionalidad de cerrar-->
                            <button type="button" class="btn btn-default" data-dismiss="modal">Aceptar</button>

                        </div>
                    </div>
                </div>
            </div>
        </div><!--        


        -->



        <script type="text/javascript" src="../_js/loginLogica.js"></script>
              <script type="text/javascript" src="../_js/validacion.js"></script>

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
        <!--<script type="text/javascript" src="../_js/jquery-1.9.0.min.js"></script>--> 
        <script src="../_js/jquery.openCarousel.js" type="text/javascript"></script>
        <script type="text/javascript" src="../_js/easing.js"></script>
        <script type="text/javascript" src="../_js/move-top.js"></script>
        <link href='http://fonts.googleapis.com/css?family=Ubuntu+Condensed' rel='stylesheet' type='text/css'>
        
        
        <link href="../_css/styles.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="../_js/bootstrap.min.js"></script>
        <script type="text/javascript" src="../_js/popper.min.js"></script>
        <link rel="stylesheet" href="../_css/bootstrap.min.css">
    </body>

</html>