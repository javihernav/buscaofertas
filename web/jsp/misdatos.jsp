<%@page import="java.util.List"%>
<%@page import="app.modelo.Conectar"%>
<%@page import="app.control.ControlUsuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../_css/bootstrap.min.css" rel="stylesheet" type="text/css"/>     
        <title>Mis datos</title>
    </head>
    <body style="margin-top: 30px">      
        <header>  
            <%@include file="/jsp/Barra.jsp" %>
        </header>

        <div class="header">
            <div class="wrap">
                <div class="header_top">
                    <div class="logo">
                        <a href="index.html"><img src="../_img/logo.png" alt="" /></a>
                    </div>
                    <div class="header_top_right row">
                        <div class="search_box row">
                            <span id="Buscarproducto" type="text" name="Buscarproducto" </span>
                            <form id="Cuadro">
                                <input type="text" value=""placeholder="Buscar producto">

                            </form>

                            <div class="clear"></div>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>     
                <div class="navigation">
                    <a class="toggleMenu" href="#">Menú</a>
                    <ul class="nav">
                        <li>
                            <a href="PaginaPrincipal.jsp">Inicio</a>
                        </li>
                        <li  class="test">
                            <a href="#">Productos</a>
                            <ul>
                                <li>
                                    <a href="#">Vehículos </a>
                                    <ul>
                                        <li><a href="#">Vehículos particulares</a></li>
                                        <li><a href="#">Vehículos pesados</a></li>
                                        <li><a href="#">Motocicletas</a></li>
                                        <li><a href="#">Bicicletas</a></li>
                                    </ul>
                                </li>

                                <li>
                                    <a href="#">Tecnologia</a>
                                    <ul>
                                        <li><a href="#">Computadores portatiles</a></li>
                                        <li><a href="#">Telefonos</a></li>
                                        <li><a href="#">Consolas de video juegos</a></li>
                                    </ul>
                                </li>
                                <li>
                                    <a href="#">Relojes y Joyas</a>
                                    <ul>
                                        <li><a href="#">Reloj de Pulso</a></li>
                                        <li><a href="#">Anillos</a></li>
                                        <li><a href="#">Dijes</a></li>
                                        <li><a href="#">Aretes</a></li>

                                    </ul>
                                </li>
                                <li>
                                    <a href="#">Hogar</a>
                                    <ul>
                                        <li><a href="#">Electrodomesticos</a></li>
                                        <li><a href="#">Ceramica</a></li>
                                        <li><a href="#">Purtas y ventanas</a></li>
                                    </ul>
                                </li>
                                <li>
                                    <a href="#">Deporte</a>
                                    <ul>
                                        <li><a href="#">Ropa deportiva</a></li>
                                        <li><a href="#">Guayos</a></li>
                                        <li><a href="#">Balones</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="#">Acerca de nosotros</a>
                            <ul>
                                <li>
                                    <a href="#">Misión</a>

                                </li>
                                <li>
                                    <a href="#">Visión</a>

                                </li>
                            </ul>
                        </li>

                        <li>
                            <a href="#">Contáctanos</a>

                        </li>

                        <li>
                            <a href="#">Siguenos en redes sociales</a>
                            <ul>
                                <li>
                                    <a href="#">Facebook</a>

                                </li>
                                <li>
                                    <a href="#">Twitter</a>

                                </li>
                            </ul>
                        </li>

                        <li>
                        <li>
                            <a href="#">Ayuda</a>
                            <ul>
                                <li>
                                    <a href="#">Condiciones de uso</a>

                                </li>
                                <li>
                                    <a href="#">Preguntas frecuentes</a>

                                </li>
                            </ul>
                        </li>
                    </ul>

                    <%            //CONECTANOD A LA BASE DE DATOS:
                        Connection con;
                        String url = "jdbc:mysql://localhost:3306/buscaofertas";
                        String Driver = "com.mysql.jdbc.Driver";
                        String user1 = "usuario";
                        String clave = "123456";
                        Class.forName(Driver);
                        con = DriverManager.getConnection(url, user1, clave);
                        PreparedStatement ps;
                        //Emnpezamos Listando los Datos de la Tabla Usuario
                        Statement smt;
                        ResultSet rs;
                        smt = con.createStatement();
                        rs = smt.executeQuery("select * from usuario");
                        //Creamo la Tabla:     

                        List<Usuario> usuarios = new ArrayList();
                        Connection cnn = Conectar.getCnn();
                        ControlUsuario controlUsuario = new ControlUsuario(cnn);
                        usuarios = controlUsuario.consultar();
                    %>




                </div>  

                <br>
                <div class="container">               
                    <!--<a  class="btn btn-success" href="Agregar.jsp">Nuevo Registro</a> Esto es Cuando se Crea un nuevo Archivo Agregar.jsp -->         
                    <table class="table table-bordered"  id="tablaDatos">

                        <tbody id="tbodys">
                            <%
                                for (Usuario usu: usuarios) {
                            %>
                            <tr>
                                <td class="text-center"><%= usu.getIdUsuario()%></td>
                                <td class="text-center"><%= usu.getNombreUsuario() %></td>
                                <td class="text-center">

                                    <!-- <input type="hidden" value="<//%= rs.getInt("Id_Usuario")%>" id="Editar"/>
                                    <input type="submit" class="btn btn-warning" data-toggle="modal" data-target="#myModal1" value="Editar"/>  -->
                                    <a href="../editarusuario_usu.jsp?id=<%= usu.getIdUsuario()%>" class="btn btn-primary">Editar</a>
                                    <a href="../usuario_eliminarusuario?id=<%= usu.getIdUsuario()%>" class="btn btn-danger">Eliminar</a>
                                </td>
                            </tr>
                            <%}%>
                    </table>
                </div>        


                </body>
                </html>
