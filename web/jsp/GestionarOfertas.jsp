<%-- 
    Document   : GestionarOfertas
    Created on : Mar 18, 2019, 4:40:59 PM
    Author     : JAVIER
--%>

<%@page import="app.modelo.vo.DetalleProducto_Tiene_Imagen"%>
<%@page import="app.modelo.vo.DetalleProducto"%>
<%@page import="app.modelo.vo.Imagen"%>
<%@page import="app.control.ControlDetalleProducto_Tiene_Imagen"%>
<%@page import="app.control.ControlDetalleProducto_Tiene_Imagen"%>
<%@page import="app.control.ControlDetalleProducto"%>
<%@page import="app.control.ControlImagen"%>
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
        <title>Gestión de Ofertas</title>
        <meta charset="UTF-8">
        <meta name="titulo" content="Proyecto BuscaOfertas">
        <meta name="descripcion" content="Entrega Proyecto BuscaOfertas">
        <meta name="viewport" content="width=device-width" user-scalable=no, initial-scale=1.0, maximum-scale=1.0, 
              maximum-scalable=1.0>
        <link rel="shortcut icon" type="image/x-icon" href="../_img/LETRERO-BUSCAOFERTAS-Y-nombre-técnico.png">
        <meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">


    </head>
    <body>
        <header>
            <%@include file="/jsp/Barra.jsp" %>
        </header>
        <div>
            <%                System.out.println("linea 26 GestionarOfertas");
                HttpSession sesion1 = request.getSession();
                System.out.println("linea 28 GestionarOfertas");
                Object usu = sesion1.getAttribute("usuario");
                if (usu == null) {
                    System.out.println("objeto nulo usu: " + usu);
                    response.sendRedirect("/BuscaOfertas/jsp/PaginaPrincipal.jsp");
                    return;
                }
                Usuario usuario = (Usuario) usu;
                System.out.println("linea 35 GestionarOfertas usuario: " + usuario);
                Connection cnn = Conectar.getCnn();
                System.out.println("linea 37 GestionarOfertas después de conexión");

                System.out.println("linea 39 GestionarOfertas pasó el if");
                ControlUsuario controlUsuario = new ControlUsuario(cnn);

                Usuario usuarioValidado = controlUsuario.ObtenerId(usuario);
                ArrayList<Oferta> ofertas = new ArrayList();
                ControlOferta controlOferta = new ControlOferta(cnn);
                sesion1.setAttribute("usuario", usuarioValidado);
                
            %>

            <div class="container">

                <div class="form-group "id="listado">
                    <form action="" method="POST">
                        <div class="row">
                            &nbsp;
                        </div>
                        <div class="row">
                            <h1 class="h1 d-block mx-auto font-italic">Gestión de Ofertas</h1>
                        </div>
                        <div class="row">
                            &nbsp;
                        </div>
                        <div>
                            &nbsp;
                        </div>
                        <div>
                            &nbsp;
                        </div>
                        <div class="row">

                            <h2 class="col-md-6 h2">Listado:</h2>

                            <input class="btn-danger col-md-5 form-control" type="button" value="Agregar Oferta" name="btnAgregar" id="btnAgregar" />

                        </div>
                        <div>
                            &nbsp;
                        </div>
                        <div>
                            &nbsp;
                        </div>
                        <ol>
                            <%
                                ofertas = controlOferta.consultarPorIdUsuario(usuarioValidado.getIdUsuario());
                                ControlImagen controlImagen = new ControlImagen(cnn);
                                ControlDetalleProducto ControlDetalleProducto = new ControlDetalleProducto(cnn);
                                ControlDetalleProducto_Tiene_Imagen controlDetalleProducto_Tiene_Imagen = new ControlDetalleProducto_Tiene_Imagen(cnn);
                                Imagen imagen = new Imagen();
                                DetalleProducto detalleProducto = new DetalleProducto();
                                DetalleProducto_Tiene_Imagen dpti = new DetalleProducto_Tiene_Imagen();
                                for (Oferta oferta : ofertas) {
                                    System.out.println("oferta: " + oferta);
                                    detalleProducto.setOferta_idOferta(oferta.getIdOferta());
                                    detalleProducto = ControlDetalleProducto.ObtenerId(detalleProducto);
                                    System.out.println("detalleProducto: " + detalleProducto);
                                    dpti.setDetalleProducto_Oferta_idOferta(oferta.getIdOferta());
                                    dpti.setDetalleProducto_Producto_idProducto(detalleProducto.getProducto_idProducto());
                                    System.out.println("dpti ingresado: " + dpti);
                                    dpti = controlDetalleProducto_Tiene_Imagen.ObtenerId(dpti);
                                    System.out.println("dpti: " + dpti);
                                    imagen.setIdImagen(dpti.getImagen_idImagen());
                                    imagen = controlImagen.ObtenerId(imagen);
                                    System.out.println("imagen: " + imagen);
                                    
                            %>

                            <div class="articulo col-md-11 row">
                                <div  class="visorImagen col-md-5">
                                    <div class="col-md-12">
                                        <img class='col-md-12' width='160' height='160' alt="<%=oferta.getNombreOferta()%>" src="${pageContext.request.contextPath}/ServicioImagen/<%= imagen.getIdImagen()%>">
                                    </div>
                                </div>
                                <div class="informacion col-md-7">
                                    <h2 class="h2 col-md-12 row">
                                        <%= oferta.getNombreOferta()%>
                                    </h2>
                                    <div>
                                        &nbsp;
                                    </div>
                                    <div class="row">
                                        <div class="col-md-8">
                                            <h3>Fecha de Inicio: <%= oferta.getFechaInicio()%></h3>
                                        </div>
                                        <div class="col-md-4">
                                            <input class="btn btn-outline-danger btnModificar" idOferta="<%= String.valueOf(oferta.getIdOferta())%>" type="button"  name="btnModificar" value="Modificar">
                                        </div>
                                    </div>
                                    <div>
                                        &nbsp;
                                    </div>
                                    <div class="row">
                                        <div class="col-md-8">

                                            <h3>Fecha de Límite: <%= oferta.getFechaFin()%></h3>
                                        </div>
                                        <div class="col-md-4">
                                        
                                            <!--<button name="btnEliminar" class="btn btn-outline-dark btnEliminar" type="button" onclick='eliminarOfertaId("<%= oferta.getIdOferta()%>","<%= usuarioValidado%>")'>Eliminar</button>-->
                                            <input name="btnEliminar" class="btn btn-outline-dark btnEliminar" idOferta="<%= String.valueOf(oferta.getIdOferta())%>" type="button" value="Eliminar">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            

                            <%
                                }
                            %>
                        </ol>
                        <div>
                            &nbsp;
                        </div>
                        <div>
                            &nbsp;
                        </div>
<!--                        <div class="row col-md-12">
                            <input class="btn-dark col-md-3 offset-1 form-control" type="button" value="Modificar" name="btnModificar" id="btnModificar"/>
                            <input class="btn-dark col-md-3 offset-1 form-control" type="button" value="Eliminar" name="btnEliminar" id="btnEliminar"/>

                        </div>-->

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


<!--        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <link href="../_css/styles.css" rel="stylesheet" type="text/css" />
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>-->

                <script type="text/javascript" src="../_js/jquery-3.3.1.js"></script>
                <script type="text/javascript" src="../_js/bootstrap.min.js"></script>
                <script type="text/javascript" src="../_js/popper.min.js"></script>
                <link rel="stylesheet" href="../_css/bootstrap.min.css">
        <link href="../_css/styles.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="../_js/gestionarOfertasLogica.js"></script>
        <script type="text/javascript" src="../_js/eliminarOfertaLogica.js"></script>
    </body>
</html>
