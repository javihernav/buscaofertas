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
    <script src="_js/scripts.js"></script>
</head>

<body onload="acordeon(),mostrarVariablesEjercicio1()">

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
</body>

</html>