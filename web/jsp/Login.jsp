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
    <link href="https://fonts.googleapis.com/css?family=Krub" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Michroma" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=PT+Mono" rel="stylesheet">
</head>

<body >
    <header>
        
        <div class="topnav">
            <a class="active" href="#home">Home</a>
            <a href="#news">Acerca de nosotros</a>
            <a href="#news">Contáctanos</a>
            <a href="#contact">Siguenos en Redes Sociales</a>
            <a href="#about">Ayuda</a>
            <a href="#about">Inicia Sesión</a>
            <a href="#about">Regístrate</a>
        </div>
    </header>

        <figure>
            <img class="letrero" src="../_img/LETRERO-BUSCAOFERTAS-sin-nombre-tecnico.png" alt="BuscaOfertas.jpg" width="500">
            
        </figure>

    <div>

        <form class="login" action="">
            <input id="txtUsuario" type="text" name="usuario" placeholder="ingrese nombre de usuario" oninput="validarUsuario()"><br/>
            <input id="txtPassword" type="password" name="clave" value="" oninput="validarPasswd()"><br/><br/>
            <input id="botonCancelar"type="reset" value="Cancelar">
            <input id="botonIngresar"type="submit" value="Ingresar"><br/><br/>
            <a href="">recuperar contraseña</a>
        </form>
    </div>
    <script src="../_js/validacion.js"></script>
    <script src="../_js/loginLogica.js"></script>
    <script src="../_js/jquery-3.3.1.js"></script>
    <link href="../_css/styles.css" rel="stylesheet" type="text/css" />
</body>

</html>