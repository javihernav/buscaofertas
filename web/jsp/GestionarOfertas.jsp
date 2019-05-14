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
    </head>
    <body>
        <header>
            <%@include file="/jsp/Barra.jsp" %>
        </header>
        <div>
            <%                
                System.out.println("linea 26 GestionarOfertas");
                HttpSession sesion1 = request.getSession();
                System.out.println("linea 28 GestionarOfertas");
                Object usu = sesion1.getAttribute("usuario");
                if (usu == null) {
                    System.out.println("objeto nulo usu: "+usu);
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
            %>

            <div class="container">

                <div class="form-group "id="listado">
                    <form action="">
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
                                    System.out.println("oferta: "+oferta);
                                    detalleProducto.setOferta_idOferta(oferta.getIdOferta());
                                    detalleProducto = ControlDetalleProducto.ObtenerId(detalleProducto);
                                    dpti.setDetalleProducto_Oferta_idOferta(oferta.getIdOferta());
                                    dpti.setDetalleProducto_Producto_idProducto(detalleProducto.getProducto_idProducto());
                                    dpti = controlDetalleProducto_Tiene_Imagen.ObtenerId(dpti);
                                    imagen.setIdImagen(dpti.getImagen_idImagen());
                                    imagen = controlImagen.ObtenerId(imagen);
                            %>

                     

                            <div class="articulo col-md-11 row">
                                <div  class="visorImagen col-md-5">
                                    <div class="col-md-12">
                                        <!--<img class='col-md-12' width='160' height='160' alt='Bicicleta Roadmaster Storm 29 F.disco Shimano + Luces+ Malet' src='https://http2.mlstatic.com/bicicleta-roadmaster-storm-29-fdisco-shimano-luces-malet-D_NP_868612-MCO29687500840_032019-X.webp' srcset='https://http2.mlstatic.com/bicicleta-roadmaster-storm-29-fdisco-shimano-luces-malet-D_NP_868612-MCO29687500840_032019-X.webp 1x, https://http2.mlstatic.com/bicicleta-roadmaster-storm-29-fdisco-shimano-luces-malet-D_NQ_NP_868612-MCO29687500840_032019-V.webp 2x' />--> 
                                        <!--<img class='col-md-12' width='160' height='160' alt="<%=oferta.getNombreOferta()%>" src="${pageContext.request.contextPath}/ServicioImagen/<%= imagen.getNombreImagen() %>">-->
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
                                            <input class="btn btn-outline-danger" type="submit" value="Modificar" name="btnModificar" />
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
                                            <input class="btn btn-outline-dark" type="submit" value="Eliminar" name="btnModificar" />
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!--                            <li class="results-item highlighted article stack "style="border: #000 solid 2px;"> 
                                                            <div class="rowItem item highlighted item--stack item--has-row-logo new to-item " id="MCO492858474">
                                                                <div class="item__image item__image--stack"> 
                                                                    <div class="images-viewer" item-url="https://articulo.mercadolibre.com.co/MCO-492858474-bicicleta-roadmaster-storm-29-fdisco-shimano-luces-malet-_JM" item-id="MCO492858474"> <div class="image-content"> <a href="https://articulo.mercadolibre.com.co/MCO-492858474-bicicleta-roadmaster-storm-29-fdisco-shimano-luces-malet-_JM" class="figure item-image item__js-link"> 
                                                                                <img class='lazy-load' width='160' height='160' alt='Bicicleta Roadmaster Storm 29 F.disco Shimano + Luces+ Malet' src='https://http2.mlstatic.com/bicicleta-roadmaster-storm-29-fdisco-shimano-luces-malet-D_NP_868612-MCO29687500840_032019-X.webp' srcset='https://http2.mlstatic.com/bicicleta-roadmaster-storm-29-fdisco-shimano-luces-malet-D_NP_868612-MCO29687500840_032019-X.webp 1x, https://http2.mlstatic.com/bicicleta-roadmaster-storm-29-fdisco-shimano-luces-malet-D_NQ_NP_868612-MCO29687500840_032019-V.webp 2x' /> 
                                                                            </a> 
                                                                        </div> 
                                                                    </div>
                                                                </div>
                                                                <div class="item__info-container highlighted "> 
                                                                    <div class="item__info item--hide-right-col ">
                                                                        <h2 class="item__title list-view-item-title"> <a href="https://articulo.mercadolibre.com.co/MCO-492858474-bicicleta-roadmaster-storm-29-fdisco-shimano-luces-malet-_JM" class="item__info-title">
                                                                                <span class="main-title"> Bicicleta Roadmaster Storm 29 F.disco Shimano + Luces+ Malet </span> 
                                                                            </a> 
                                                                            <div class="item__brand"> 
                                                                                <a class="item__brand-link" href="https://tienda.mercadolibre.com.co/roadmaster"> 
                                                                                    <span class="item__brand-title-tos"> por Roadmaster </span> 
                                                                                </a> 
                                                                            </div>
                                                                        </h2> <div class="price__container"> 
                                                                            <span class="price-old" itemprop="price-old"> 
                                                                                <del> $&nbsp;799.900 </del> 
                                                                            </span><div class="item__price item__price-discount"> 
                                                                                <span class="price__symbol">$</span> 
                                                                                <span class="price__fraction">571.900</span>
                                                                            </div> <div class="item__discount ">28% OFF</div> 
                                                                        </div> <div class="item__stack_column highlighted"> 
                                                                            <div class="item__stack_column__info"> 
                                                                                <div class="stack_column_item installments highlighted">
                                                                                    <span class="item-installments showInterest"> 
                                                                                        <span class="item-installments-multiplier"> 36x </span> 
                                                                                        <span class="item-installments-price"> $ 15.886 </span>
                            
                                                                                    </span> 
                                                                                </div> 
                                                                                <div class="stack_column_item shipping highlighted"> 
                                                                                    <div class="item__shipping free-shipping highlighted"> 
                                                                                        <p class="stack-item-info "> Env&iacute;o gratis</p> 
                                                                                    </div> 
                                                                                </div> 
                                                                                <div class="stack_column_item status">
                                                                                    <div class="item__status">
                                                                                        <div class="item__condition"> 169 vendidos 
                                                                                        </div>
                            
                                                                                    </div> 
                                                                                </div> 
                                                                            </div> 
                                                                        </div> 
                                                                        <div class="stack_colum_right without-attributes without-reviews"> 
                                                                            <div class="stack_column_right__bottom "> 
                                                                            </div> 
                                                                        </div> 
                                                                    </div>
                            
                                                                </div>
                                                                <form class="item__bookmark-form" action="/search/bookmarks/MCO492858474/make" method="post" id="bookmarkForm" class="bookmark-form"> 
                                                                    <button type="submit" class="bookmarks favorite " data-id="MCO492858474"> 
                                                                        <div class="item__bookmark"> 
                                                                            <div class="icon">
                            
                                                                            </div>
                                                                        </div> 
                                                                    </button> 
                                                                    <input type="hidden" name="method" value='add'/> 
                                                                    <input type="hidden" name="itemId" value='MCO492858474'>
                                                                </form> 
                                                            </div>
                                                        </li>-->

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
                        <div class="row col-md-12">
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
