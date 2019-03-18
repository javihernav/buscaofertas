<%-- 
    Document   : BarraGeneral
    Created on : Mar 16, 2019, 9:55:23 PM
    Author     : JAVIER
--%>

<%@page import="app.modelo.vo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
        <div class="dropdown-content">
            <a class="" href="#">Resumen</a>
            <a  class="" href="#">Mis Ofertas</a>
            <a  class="" href="#">Mis Datos</a>
            <a  class="" href="../CerrarSesion" >Cerrar Sesión</a>
        </div>
    </div>

    <div class="navbar">
        <a href="#home">Home</a>
        <a href="#news">News</a>
        <div class="dropdown">
            <button class="dropbtn">Dropdown 
                <i class="fa fa-caret-down"></i>
            </button>
            <ul class="dropdown-content">
                <li><a href="#">Link 1</a></li>
                <li><a href="#">Link 1</a></li>
                <li><a href="#">Link 1</a></li>
                
            </ul>
        </div> 
    </div>
</div>
<%
    }
%>
</head>
<body>




</body>
</html>



