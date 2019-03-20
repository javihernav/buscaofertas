<%-- 
    Document   : GestionarOfertas
    Created on : Mar 18, 2019, 4:40:59 PM
    Author     : JAVIER
--%>

<%@page import="app.control.ControlOferta"%>
<%@page import="app.modelo.vo.Oferta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="app.modelo.vo.Usuario"%>
<%@page import="java.sql.Connection"%>
<%@page import="app.control.ControlUsuario"%>
<%@page import="app.modelo.Conectar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <%@include file="/jsp/Barra.jsp" %>
        </header>
        <div>
            <%                
                HttpSession sesion1 = request.getSession();
                Usuario usuario = (Usuario) sesion1.getAttribute("usuario");
                Connection cnn = Conectar.getCnn();
                ControlUsuario controlUsuario = new ControlUsuario(cnn);

                Usuario usuarioValidado = controlUsuario.ObtenerId(usuario);
                ArrayList<Oferta> ofertas = new ArrayList();
                ControlOferta controlOferta = new ControlOferta(cnn);
            %>
            <center>

                <h1 clas="h1">Administración de Ofertas</h1>
            </center>
            <div>
                &nbsp;
            </div>
            <div>
                &nbsp;
            </div>
            <div class="container">
                <div>
                    &nbsp;
                </div>
                <div>
                    &nbsp;
                </div>
                Listado:
                <div>
                    &nbsp;
                </div>
                <div>
                    &nbsp;
                </div>
                <div class="form-group "id="listado">
                    <form action="">

                        <%
                            ofertas = controlOferta.consultarPorIdUsuario(usuarioValidado.getIdUsuario());
                            for (Oferta oferta : ofertas) {
                        %>

                        <div class="radio btn-outline-danger form-control">
                            <input type="radio" name="oferta" value=<%= oferta.getIdOferta()%>><%= oferta.toString()%><br>
                        </div>
                        <div>
                            &nbsp;
                        </div>


                        <%
                            }
                        %>
                        <div>
                            &nbsp;
                        </div>
                        <div>
                            &nbsp;
                        </div>
                        <div class="row col-md-12">
                            <input class="btn-dark col-md-3 offset-1 form-control" type="button" value="Agregar" name="btnAgregar" id="btnAgregar" />
                            <input class="btn-dark col-md-3 offset-1 form-control" type="button" value="Modificar" name="btnModificar" id="btnModificar"/>
                            <input class="btn-dark col-md-3 offset-1 form-control" type="button" value="Eliminar" name="btnEliminar" id="btnEliminar"/>

                        </div>

                        <div>
                            &nbsp;
                        </div>
                        <div>
                            &nbsp;
                        </div>
                    </form>
                </div>




            </div>
        </div>



        <script type="text/javascript" src="../_js/jquery-3.3.1.js"></script>
        <script type="text/javascript" src="../_js/bootstrap.min.js"></script>
        <script type="text/javascript" src="../_js/popper.min.js"></script>
        <link rel="stylesheet" href="../_css/bootstrap.min.css">
        <link href="../_css/styles.css" rel="stylesheet" type="text/css" />S
        <script type="text/javascript" src="../_js/gestionarOfertasLogica.js"></script>
    </body>
</html>
