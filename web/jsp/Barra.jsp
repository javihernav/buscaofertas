<%-- 
    Document   : Barra
    Created on : Mar 17, 2019, 3:53:56 PM
    Author     : JAVIER
--%>

<%@page import="app.modelo.vo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--
<!DOCTYPE html>
<html>
    <head>
        <title>Barra</title>

        <meta name="viewport" content="width=device-width, initial-scale=1">

    </head>
    <body>
-->
        <div class="header">
            <div class="wrap">
                <div class="header_top">
                    <div class="logo">
                        <a href="index.html"><img src="../images/logo.png" alt="" /></a>
                    </div>
                    <div class="header_top_right row">
                        <div class="search_box row">
                            <span>Buscar producto</span>
                            <form id="Cuadro" action="./PaginaPrincipal.jsp">
                                <div class="row">
                                <input id="cuadroBusqueda" name="cuadroBusqueda" type="text" value="" placeholder="Buscar producto">
                                <input id="btnBusqueda" type="submit" value="">
                                </div>
                            </form>
                            <!--<a id="btnInicarSesion" href="contact.html">Iniciar Sesión</a>-->
                            <div class="clear"></div>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>     
                <div class="navigation">
                    <a class="toggleMenu" href="#">Menú</a>
                    <ul class="nav">
                        <li>
                            <a href="./PaginaPrincipal.jsp">Inicio</a>
                        </li>
                        <li  class="test">
                            <a href="#">Vehículos</a>
                            <ul>
                                <li>
                                    <a href="#">Vehículos particulares</a>
                                    <ul>
                                        <li><a href="#">Consolas</a></li>
                                        <li><a href="#">Juegos</a></li>
                                    </ul>
                                </li>
                                <li>
                                    <a href="#"></a>
                                    <ul>
                                        <li><a href="#">Bottles & Sippers</a></li>
                                        <li><a href="#">Containers & Jars</a></li>
                                    </ul>
                                </li>
                                <li>
                                    <a href="#">Vehículos pesados</a>
                                    <ul>
                                        <li><a href="#">Busetas</a></li>
                                        <li><a href="#"></a>Tractocamión</li>
                                    </ul>	
                                </li>
                                <li>
                                    <a href="#">Motocicletas</a>
                                    <ul>
                                        <li><a href="#">Alto cilindraje</a></li>
                                        <li><a href="#">Bajo cilindraje</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="#">Computadoras</a>
                            <ul>
                                <li>
                                    <a href="#">Portatiles</a>
                                    <ul>
                                        <li><a href="#">HP</a></li>
                                        <li><a href="#">Lenova</a></li>
                                        <li><a href="#">Dell</a></li>
                                        <li><a href="#">Otro</a></li>
                                    </ul>
                                </li>
                                <li>
                                    <a href="#">Accesorios</a>
                                    <ul>
                                        <li><a href="#">Parlantes</a></li>
                                        <li><a href="#">Cargadores</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <li>

                        <li>
                            <a href="#">Relojes y Joyas</a>
                            <ul>
                                <li>
                                    <a href="#">Reloj de Pulso</a>
                                    <ul>
                                        <li><a href="#">Hombre</a></li>
                                        <li><a href="#">Mujer</a></li>

                                    </ul>
                                </li>
                                <li>
                                    <a href="#">Anillos</a>
                                    <ul>
                                        <li><a href="#">Oro</a></li>
                                        <li><a href="#">Plata</a></li>

                                    </ul>
                                </li>
                                <li>
                                    <a href="#">Dijes</a>
                                    <ul>
                                        <li><a href="#">Plata</a></li>
                                        <li><a href="#">Oro</a></li>
                                    </ul>
                                </li>
                                <li>
                                    <a href="#">Aretes</a>
                                    <ul>
                                        <li><a href="#">Plata</a></li>
                                        <li><a href="#">Oro</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="#">Hogar</a>
                            <ul>
                                <li>
                                    <a href="#">Electrodomésticos</a>
                                    <ul>
                                        <li><a href="#">Electrodomésticos de cocina</a></li>
                                        <li><a href="#">Refrigeración</a></li>
                                        <li><a href="#">Climatización</a></li>
                                    </ul>
                                </li>
                                <li>
                                    <a href="#">Alcoba</a>
                                    <ul>
                                        <li><a href="#">Camas y bases</a></li>
                                        <li><a href="#">Ropa de cama</a></li>
                                        <li><a href="#">Colchones</a></li>
                                        <li><a href="#">Closeths y Armarios</a></li>

                                    </ul>
                                </li>

                            </ul>
                        </li>
                        <li>
                            <a href="#">Deporte</a>
                            <ul>

                                <li>
                                    <a href="#">Ropa kit deportivo</a>
                                    <ul>
                                        <li><a href="#">Futbol</a></li>
                                        <li><a href="#">Natación</a></li>
                                        <li><a href="#">Baloncesto</a></li>
                                        <li><a href="#">Boleybol</a></li>
                                    </ul>
                                </li>
                                <li>
                                    <a href="#">Fútbol</a>
                                    <ul>
                                        <li><a href="#">Guayos</a></li>
                                        <li><a href="#">Camisetas</a></li>
                                        <li><a href="#">Medias</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <%  HttpSession sesion = request.getSession();
                            Usuario user = null;
                            try {
                                user = (Usuario) sesion.getAttribute("usuario");
                            } catch (ClassCastException ce) {
                            }
                            if (user == null) {
                        %>
                        <li> 
                            <a href="./Login.jsp">Inicia Sesión</a>
                        </li>

                        <li>
                            <a href="./RegistrarPerfil.jsp">Regístrate</a>
                        </li>
                        <%} else {
                        %>


                        <!-- Dropdown -->
                        <li >
                            <a href="#">
                                <%= user.getNombreUsuario()%>
                            </a>
                            <ul>
                                <li>
                                    <a  class="dropdown-item" href="./GestionarOfertas.jsp">Mis Ofertas</a>
                                </li>
                                <li>
                                    <a  class="dropdown-item" href="./ActualizarDatosPersonales.jsp">Mis Datos</a>
                                </li>
                                <% if (user.getRol() != null) {%>
                                <% if (user.getRol().equals("admin")) {%>
                                <li>
                                    <a  class="dropdown-item" href="./AgregarProducto.jsp">Agregar Productos</a>
                                </li>
                                    <li>
                                        <a class="dropdown-item" href="./GestionarUsuarios.jsp">Gestionar Usuarios</a>
                                    </li>
                                <% }%>
                                <% }%>
                                <li>
                                    <a  class="dropdown-item" href="../CerrarSesion" >Cerrar Sesión</a>
                                </li>
                            </ul>
                        </li>
                        <%
                            }
                        %>

                    </ul>

                    <span class="left-ribbon"> </span> 
                    <span class="right-ribbon"> </span>    
                </div>
<!--                <div class="header_bottom">
                    <div class="slider-text">
                        <h2>Portátil Hp pavilion <br/>el poder a tu alcance</h2>
                        <p>Intel Core i7 octava generación.<br> Disco duro 1 tera <br> Memoria RAM de 16 GB <br> Tarjeta gráfica Nvidia Geforce 940mx 4Gb</p>
                        <a href="#">Clic aquí para comprar</a>
                    </div>
                    <div class="slider-img">
                        <img src="../images/slider-img.png" alt="" />
                    </div>
                    <div class="clear"></div>
                </div>-->
            </div>
        </div>

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

<!--
    </body>
</html>-->