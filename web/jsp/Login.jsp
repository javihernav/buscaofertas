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
            <img class="img-fluid mx-auto d-block " src="../_img/LETRERO-BUSCAOFERTAS-sin-nombre-tecnico.png" alt="BuscaOfertas.jpg" >

        </figure>

        <div class="container col-md-6">

            <form class="form-inline" action="">
                <div class="row  col-md-12">
                    <h1 class="mx-auto d-block ">Ingreso de Usuarios</h1>
                </div>
                <div class="row  col-md-12">
                    <div class="form-group col-md-12">
                        &nbsp;
                    </div>
                </div>
                <div class="row  col-md-12">
                    <div class="form-group col-md-12">
                        <input class="form-control col-md-8 offset-3" id="txtUsuario" type="text" name="usuario" placeholder="ingrese nombre de usuario" oninput="validarUsuario()"><br/>
                    </div>
                </div>
                <div class="row col-md-12">
                    <div class="form-group col-md-12">
                        <input class="form-control col-md-8 offset-3" id="txtPassword" type="password" name="clave" placeholder="ingrese password"value="" oninput="validarPasswd()"><br/><br/>
                    </div>
                </div>
                <div class="row  col-md-12">
                    <div class="form-group col-md-12">
                        &nbsp;
                    </div>
                </div>
                <div class="row col-md-12">
                    <div class="form-group col-md-12">
                        <input class="form-control col-md-4 offset-3 btn btn-dark" id="botonCancelar"type="reset" value="Cancelar" onclick = "location = 'PaginaPrincipal.jsp'">
                        <input class="form-control col-md-4 btn btn-danger"id="botonIngresar"type="button" value="Ingresar"><br/><br/>
                    </div>
                </div>

                <a class="form-text offset-3" href="">recuperar contraseña</a>
                <div class="row  col-md-12">
                    <div class="form-group col-md-12">
                        &nbsp;
                    </div>
                </div>
            </form>
        </div>
        <script src="../_js/validacion.js"></script>
        <script src="../_js/loginLogica.js"></script>
        <script src="../_js/jquery-3.3.1.js"></script>
        <link href="../_css/styles.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="../_js/bootstrap.min.js"></script>
        <script type="text/javascript" src="../_js/popper.min.js"></script>
        <link rel="stylesheet" href="../_css/bootstrap.min.css">
        <link href="../_css/styles.css" rel="stylesheet" type="text/css" />
    </body>

</html>