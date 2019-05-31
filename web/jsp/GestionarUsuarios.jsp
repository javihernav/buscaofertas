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
        <title>Gestión de Usuarios</title>
    </head>
    <body style="margin-top: 30px">      
        <header>  
            <%@include file="/jsp/Barra.jsp" %>
        </header>
    <center><h1 class="h1">Gestión de Usuarios</h1></center>


    <%            HttpSession sesion3 = request.getSession();
        Object usuarioObject = sesion3.getAttribute("usuario");
        Usuario usuario = new Usuario();
        if (usuarioObject == null) {
            response.sendRedirect("./PaginaPrincipal.jsp");
            return;
        }else{
            usuario=(Usuario)usuarioObject;
            if (!usuario.getRol().equals("admin")) {
                response.sendRedirect("./PaginaPrincipal.jsp");
                return;
            }
        }  

        List<Usuario> usuarios = new ArrayList();
        Connection cnn = Conectar.getCnn();
        ControlUsuario controlUsuario = new ControlUsuario(cnn);
        usuarios = controlUsuario.consultar();
    %>






    <br>
    <div class="container">               
        <!--<a  class="btn btn-success" href="Agregar.jsp">Nuevo Registro</a> Esto es Cuando se Crea un nuevo Archivo Agregar.jsp -->         
        <table class="table table-borderless"  id="tablaDatos">

            <tbody id="tbodys">
                <%
                    for (Usuario usu : usuarios) {
                %>
                <tr>
                    <td class="text-center"><%= usu.getIdUsuario()%></td>
                    <td class="text-center"><%= usu.getNombreUsuario()%></td>
                    <td class="text-center">
                        <!-- <input type="hidden" value="<//%= rs.getInt("Id_Usuario")%>" id="Editar"/>
                        <input type="submit" class="btn btn-warning" data-toggle="modal" data-target="#myModal1" value="Editar"/>  -->
                        <a href="../editarusuario_usu.jsp?id=<%= usu.getIdUsuario()%>" class="btn btn-primary">Editar</a>
                        <!--<a href="../usuario_eliminarusuario?id=<%= usu.getIdUsuario()%>" class="btn btn-danger">Eliminar</a>-->
                        <button class="btn btn-danger" onclick=alertaeliminar(<%= usu.getIdUsuario()%>)>Eliminar</button>
                       
                    </td>
                </tr>
                <%}%>
        </table>
    </div>        

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
    <script src="../_js/eliminar_usuariologica.js" type="text/javascript"></script>
</body>
</html>
