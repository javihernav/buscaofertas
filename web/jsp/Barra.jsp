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
        <title>Barra</title>




        <meta name="viewport" content="width=device-width, initial-scale=1">

    </head>
    <body>
        <figure>
            <img class="img-fluid mx-auto d-block" src="../_img/LETRERO-BUSCAOFERTAS-sin-nombre-tecnico.png" alt="BuscaOfertas.jpg" width="25%vw">

        </figure>
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">


            <!-- Brand -->
            <a class="navbar-brand" href="#">Logo</a>

            <!-- Links -->
            <ul class="navbar-nav">
                <li class="nav-item">

                    <a class="active" href="./PaginaPrincipal.jsp">Inicio</a>
                </li>
                <li class="nav-item">
                    <a href="./AcercaDeNosotros.jsp">Acerca de nosotros</a>
                </li>
                <li>                    
                    <a href="./Contactanos.jsp">Contáctanos</a>
                </li>
                <li>                    
                    <a href="SiguenosEnRedes.jsp">Siguenos en Redes Sociales</a>
                </li>
                <li>                    
                    <a href="Ayuda.jsp">Ayuda</a>
                </li>

                <%  HttpSession sesion = request.getSession();
                    Usuario user = null;
                    try {
                        user = (Usuario) sesion.getAttribute("usuario");
                    } catch (ClassCastException ce) {
                    }
                    if (user == null) {
                %>
                <li> <a href="./Login.jsp">Inicia Sesión</a></li>

                <li><a href="./RegistrarPerfil.jsp">Regístrate</a></li>
                    <%} else {
                    %>


                <!-- Dropdown -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                        <%= user.getNombreUsuario()%>
                    </a>
                    <div class="dropdown-menu">

                        <a class="dropdown-item" href="#">Resumen</a>
                        <a  class="dropdown-item" href="./GestionarOfertas.jsp">Mis Ofertas</a>
                        <a  class="dropdown-item" href="./ActualizarDatosPersonales.jsp">Mis Datos</a>
                        <% if (user.getRol().equals("admin")) {%>
                        <a  class="dropdown-item" href="./AgregarProducto.jsp">Agregar Productos</a>
                        <% }%>
                        <a  class="dropdown-item" href="../CerrarSesion" >Cerrar Sesión</a>
                    </div>
                </li>
            </ul>
        </nav>
        <br>

        <%
            }
        %>










        <!--
                
                <script type="text/javascript" src="../_js/jquery-3.3.1.js"></script>
                <script type="text/javascript" src="../_js/popper.min.js"></script>
                <link rel="stylesheet" href="../_css/bootstrap.min.css">
                <script type="text/javascript" src="../_js/bootstrap.min.js"></script>
        <link href="../_css/styles.css" rel="stylesheet" type="text/css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>-->

        <style>
            option{
                background: white;
                color: black;
            }
        </style>
    </body>
</html>