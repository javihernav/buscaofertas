<%-- 
    Document   : Barra
    Created on : Mar 17, 2019, 3:53:56 PM
    Author     : JAVIER
--%>

<%@page import="app.modelo.vo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Bootstrap Example</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">



        <meta name="viewport" content="width=device-width, initial-scale=1">

    </head>
    <body>
        <div class="topnav">
            <a class="active" href="./PaginaPrincipal.jsp">Home</a>
            <a href="#news">Acerca de nosotros</a>
            <a href="#news">Contáctanos</a>
            <a href="#contact">Siguenos en Redes Sociales</a>
            <a href="#about">Ayuda</a>
            <%  HttpSession sesion = request.getSession();
                Usuario user = (Usuario) sesion.getAttribute("usuario");
                if (user == null) {
            %>
            <a href="./Login.jsp">Inicia Sesión</a>
            <a href="./RegistrarPerfil.jsp">Regístrate</a>
            <%} else {
            %>
            <div class="dropdown">
                <button class="dropbtn btn-dark"><%= user.getNombreUsuario()%>
                    <i class="fa fa-caret-down"></i>
                </button>
                <!--<div class="dropdown-content">-->
                    <a class="" href="#">Resumen</a>
                    <a  class="" href="./GestionarOfertas.jsp">Mis Ofertas</a>
                    <a  class="" href="#">Mis Datos</a>
                    <a  class="" href="../CerrarSesion" >Cerrar Sesión</a>
                <!--</div>-->
            </div>

   
        </div>
        <%
            }
        %>










<!---->
        <link href="../_css/styles.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="../_js/jquery-3.3.1.js"></script>
        <script type="text/javascript" src="../_js/popper.min.js"></script>
        <link rel="stylesheet" href="../_css/bootstrap.min.css">
        <script type="text/javascript" src="../_js/bootstrap.min.js"></script>
    </body>
</html>