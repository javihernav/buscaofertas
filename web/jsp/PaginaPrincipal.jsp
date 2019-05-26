<%-- 
    Document   : Consultas
    Created on : Nov 22, 2018, 3:56:00 PM
    Author     : JAVIER
--%>

<%@page import="app.control.ControlOfertaCompleta"%>
<%@page import="app.modelo.vo.OfertaCompleta"%>
<%@page import="app.modelo.vo.DetalleProducto_Tiene_Imagen"%>
<%@page import="app.modelo.vo.DetalleProducto"%>
<%@page import="app.modelo.vo.Imagen"%>
<%@page import="app.modelo.vo.Imagen"%>
<%@page import="app.control.ControlDetalleProducto_Tiene_Imagen"%>
<%@page import="app.control.ControlDetalleProducto_Tiene_Imagen"%>
<%@page import="app.control.ControlDetalleProducto"%>
<%@page import="app.control.ControlImagen"%>
<%@page import="app.control.ControlOferta"%>
<%@page import="app.modelo.vo.Oferta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="app.control.ControlUsuario"%>
<%@page import="app.modelo.Conectar"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <title>Entrega Proyecto BuscaOfertas</title>
        <meta charset="UTF-8">
        <meta name="titulo" content="Proyecto BuscaOfertas">
        <meta name="descripcion" content="Entrega Proyecto BuscaOfertas">
        <meta name="viewport" content="width=device-width" user-scalable=no, initial-scale=1.0, maximum-scale=1.0, 
              maximum-scalable=1.0>

        <link rel="shortcut icon" type="image/x-icon" href="../_img/LETRERO-BUSCAOFERTAS-Y-nombre-técnico.png">

        <meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">

    </head>

    <body onload="">
        <header>  
            <%@include file="/jsp/Barra.jsp" %>
        </header>

        <%                //System.out.println("linea 26 GestionarOfertas");
            HttpSession sesion1 = request.getSession();
            //System.out.println("linea 28 GestionarOfertas");
            String busqueda = request.getParameter("cuadroBusqueda");
            Object usu = sesion1.getAttribute("usuario");
                Connection cnn = Conectar.getCnn();
            if (usu == null) {
                //System.out.println("objeto nulo usu: " + usu);
//                    response.sendRedirect("/BuscaOfertas/jsp/Login.jsp");
//                    return;
            } else {
                Usuario usuario = (Usuario) usu;
                //System.out.println("linea 35 GestionarOfertas usuario: " + usuario);
                //System.out.println("linea 37 GestionarOfertas después de conexión");

                //System.out.println("linea 39 GestionarOfertas pasó el if");
                ControlUsuario controlUsuario = new ControlUsuario(cnn);
                Usuario usuarioValidado = controlUsuario.ObtenerId(usuario);
                sesion1.setAttribute("usuario", usuarioValidado);
            }
                ArrayList<OfertaCompleta> ofertas = new ArrayList();
                ControlOfertaCompleta controlOfertaCompleta = new ControlOfertaCompleta(cnn);

        %>


        <div class="main">
            <div class="content">
                <div class="content_top">
                    <div class="wrap">
                        <h3>Productos Más Buscados</h3>
                    </div>
                    <div class="line"> </div>
                    <div class="wrap">
                        <div class="ocarousel_slider">  
                            <div class="ocarousel example_photos" data-ocarousel-perscroll="3">
                                <div class="ocarousel_window">
                                    <a href="#" title="img1"> <img src="../images/latest-product-img1.jpg" alt="" /><p></p></a>
                                    <a href="#" title="img2"> <img src="../images/latest-product-img2.jpg" alt="" /><p>Soplador</p></a>
                                    <a href="#" title="img3"> <img src="../images/latest-product-img3.jpg" alt="" /><p>Impresora</p></a>
                                    <a href="#" title="img4"> <img src="../images/latest-product-img4.jpg" alt="" /><p>Mesa elegante</p></a>
                                    <a href="#" title="img5"> <img src="../images/latest-product-img5.jpg" alt="" /><p>Taladro</p></a>
                                    <a href="#" title="img6"> <img src="../images/latest-product-img6.jpg" alt="" /><p>Coche</p></a>
                                    <a href="#" title="img2"> <img src="../images/latest-product-img2.jpg" alt="" /><p>Aspiradora</p></a>
                                    <a href="#" title="img3"> <img src="../images/latest-product-img3.jpg" alt="" /><p>Impresora hp</p></a>
                                    <a href="#" title="img4"> <img src="../images/latest-product-img4.jpg" alt="" /><p>Mesa de trabajo</p></a>
                                    <a href="#" title="img5"> <img src="../images/latest-product-img5.jpg" alt="" /><p>Atornillador eléctrico</p></a>
                                    <a href="#" title="img6"> <img src="../images/latest-product-img6.jpg" alt="" /><p>Coche semiautomático</p></a>
                                </div>
                                <span>           
                                    <a href="#" data-ocarousel-link="left" style="float: left;" class="prev"> </a>
                                    <a href="#" data-ocarousel-link="right" style="float: right;" class="next"> </a>
                                </span>
                            </div>
                        </div>  
                    </div>    		
                </div>
                <div class="content_bottom">
                    <div class="wrap">
                        <div class="content-bottom-left">
                            <div class="categories">
                                <h3>Todas Las Categorías</h3>
                                <ul>
                                    <li><a href="#">Tecnología</a></li>
                                    <li><a href="#">Electrodomésticos</a></li>
                                    <li><a href="#">Computadoras</a></li>
                                    <li><a href="#">Hogar</a></li>
                                    <li><a href="#">Vehículos</a></li>
                                    <li><a href="#">Salud y Belleza</a></li>
                                    <li><a href="#">Herramientas de Trabajo</a></li>
                                    <li><a href="#">Instrumentos Musicales</a></li>
                                    <li><a href="#">Deportes</a></li>
                                </ul>
                            </div>		
                            <div class="buters-guide">
                                <h3>Otros anuncios</h3>
                                <p><span>Cámara con el 50% de descuento.</span></p>	
                                <p>Oferta disponible en almacenes éxito. </p>
                            </div>	
                            <div class="add-banner">
                                <img src="../images/camera.png" alt="" />
                                <div class="banner-desc">
                                    <h4>Cámara </h4>
                                    <a href="#">Más información</a>
                                </div>
                                <div class="clear"></div>
                            </div>
                            <div class="add-banner add-banner2">
                                <img src="../images/computer.png" alt="" />
                                <div class="banner-desc">
                                    <h4></h4>

                                </div>
                                <div class="clear"></div>
                            </div>
                        </div>

                        <div class="content-bottom-right">
                            <h3>Resultados de búsqueda: <%=busqueda%></h3>
                            <div class="section group">
                                <%
                                    if (busqueda == null) {
                                        ofertas = null;
                                    }else if (busqueda.equals("")) {
                                        ofertas = null;
                                    }else{
                                    ofertas = controlOfertaCompleta.ConsultarOfertaCompleta(busqueda);
                                    
                                    for (OfertaCompleta oferta : ofertas) {
                                        //System.out.println("imagen: " + imagen);

                                %>
                                <div class="grid_1_of_4 images_1_of_4">
                                    <h4><a href="preview.html"><%= oferta.getNombreOferta()%> </a></h4>
                                    <a href="preview.html"><img src="${pageContext.request.contextPath}/ServicioImagen/<%= oferta.getIdImagen()%>" alt="" /></a>
                                    <div class="price-details">
                                        <div class="price-number">
                                            <p><span class="rupees">$ <%=oferta.getPrecio()%></span></p>
                                        </div>
                                        <div class="add-cart">								
                                            <h4><a href="preview.html">Más información</a></h4>
                                        </div>
                                        <div class="clear"></div>
                                    </div>					 
                                </div>
                                <% }
} %>
                                <!--                                <div class="grid_1_of_4 images_1_of_4">
                                                                    <h4><a href="preview.html">Whirlpool LTE5243D 3.4 CuFt.... </a></h4>
                                                                    <a href="preview.html"><img src="../images/product-img2.jpg" alt="" /></a>
                                                                    <div class="price-details">
                                                                        <div class="price-number">
                                                                            <p><span class="rupees">$839.93 </span></p>
                                                                        </div>
                                                                        <div class="add-cart">								
                                                                            <h4><a href="preview.html">Más información</a></h4>
                                                                        </div>
                                                                        <div class="clear"></div>
                                                                    </div>
                                
                                                                </div>
                                                                <div class="grid_1_of_4 images_1_of_4">
                                                                    <h4><a href="preview.html">Whirlpool LTE5243D 3.4 CuFt.... </a></h4>
                                                                    <a href="preview.html"><img src="../images/product-img3.jpg" alt="" /></a>
                                                                    <div class="price-details">
                                                                        <div class="price-number">
                                                                            <p><span class="rupees">$839.93 </span></p>
                                                                        </div>
                                                                        <div class="add-cart">								
                                                                            <h4><a href="preview.html">Más información</a></h4>
                                                                        </div>
                                                                        <div class="clear"></div>
                                                                    </div>
                                
                                                                </div>
                                                                <div class="grid_1_of_4 images_1_of_4">
                                                                    <h4><a href="preview.html">Whirlpool LTE5243D 3.4 CuFt.... </a></h4>
                                                                    <a href="preview.html"><img src="../images/product-img4.jpg" alt="" /></a>
                                                                    <div class="price-details">
                                                                        <div class="price-number">
                                                                            <p><span class="rupees">$839.93 </span></p>
                                                                        </div>
                                                                        <div class="add-cart">								
                                                                            <h4><a href="preview.html">Más información</a></h4>
                                                                        </div>
                                                                        <div class="clear"></div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="section group">
                                                                <div class="grid_1_of_4 images_1_of_4">
                                                                    <h4><a href="preview.html">Whirlpool LTE5243D 3.4 CuFt.... </a></h4>
                                                                    <a href="preview.html"><img src="../images/product-img1.jpg" alt="" /></a>
                                                                    <div class="price-details">
                                                                        <div class="price-number">
                                                                            <p><span class="rupees">$839.93 </span></p>
                                                                        </div>
                                                                        <div class="add-cart">								
                                                                            <h4><a href="preview.html">Más información</a></h4>
                                                                        </div>
                                                                        <div class="clear"></div>
                                                                    </div>					 
                                                                </div>
                                                                <div class="grid_1_of_4 images_1_of_4">
                                                                    <h4><a href="preview.html">Whirlpool LTE5243D 3.4 CuFt.... </a></h4>
                                                                    <a href="preview.html"><img src="../images/product-img2.jpg" alt="" /></a>
                                                                    <div class="price-details">
                                                                        <div class="price-number">
                                                                            <p><span class="rupees">$839.93 </span></p>
                                                                        </div>
                                                                        <div class="add-cart">								
                                                                            <h4><a href="preview.html">Más información</a></h4>
                                                                        </div>
                                                                        <div class="clear"></div>
                                                                    </div>
                                
                                                                </div>
                                                                <div class="grid_1_of_4 images_1_of_4">
                                                                    <h4><a href="preview.html">Whirlpool LTE5243D 3.4 CuFt.... </a></h4>
                                                                    <a href="preview.html"><img src="../images/product-img3.jpg" alt="" /></a>
                                                                    <div class="price-details">
                                                                        <div class="price-number">
                                                                            <p><span class="rupees">$839.93 </span></p>
                                                                        </div>
                                                                        <div class="add-cart">								
                                                                            <h4><a href="preview.html">Más información</a></h4>
                                                                        </div>
                                                                        <div class="clear"></div>
                                                                    </div>
                                
                                                                </div>
                                                                <div class="grid_1_of_4 images_1_of_4">
                                                                    <h4><a href="preview.html">Whirlpool LTE5243D 3.4 CuFt.... </a></h4>
                                                                    <a href="preview.html"><img src="../images/product-img4.jpg" alt="" /></a>
                                                                    <div class="price-details">
                                                                        <div class="price-number">
                                                                            <p><span class="rupees">$839.93 </span></p>
                                                                        </div>
                                                                        <div class="add-cart">								
                                                                            <h4><a href="preview.html">Más información</a></h4>
                                                                        </div>
                                                                        <div class="clear"></div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="section group">
                                                                <div class="grid_1_of_4 images_1_of_4">
                                                                    <h4><a href="preview.html">Whirlpool LTE5243D 3.4 CuFt.... </a></h4>
                                                                    <a href="preview.html"><img src="../images/product-img1.jpg" alt="" /></a>
                                                                    <div class="price-details">
                                                                        <div class="price-number">
                                                                            <p><span class="rupees">$839.93 </span></p>
                                                                        </div>
                                                                        <div class="add-cart">								
                                                                            <h4><a href="preview.html">Más información</a></h4>
                                                                        </div>
                                                                        <div class="clear"></div>
                                                                    </div>					 
                                                                </div>
                                                                <div class="grid_1_of_4 images_1_of_4">
                                                                    <h4><a href="preview.html">Whirlpool LTE5243D 3.4 CuFt.... </a></h4>
                                                                    <a href="preview.html"><img src="../images/product-img2.jpg" alt="" /></a>
                                                                    <div class="price-details">
                                                                        <div class="price-number">
                                                                            <p><span class="rupees">$839.93 </span></p>
                                                                        </div>
                                                                        <div class="add-cart">								
                                                                            <h4><a href="preview.html">Más información</a></h4>
                                                                        </div>
                                                                        <div class="clear"></div>
                                                                    </div>
                                
                                                                </div>
                                                                <div class="grid_1_of_4 images_1_of_4">
                                                                    <h4><a href="preview.html">Whirlpool LTE5243D 3.4 CuFt.... </a></h4>
                                                                    <a href="preview.html"><img src="../images/product-img3.jpg" alt="" /></a>
                                                                    <div class="price-details">
                                                                        <div class="price-number">
                                                                            <p><span class="rupees">$839.93 </span></p>
                                                                        </div>
                                                                        <div class="add-cart">								
                                                                            <h4><a href="preview.html">Más información</a></h4>
                                                                        </div>
                                                                        <div class="clear"></div>
                                                                    </div>
                                
                                                                </div>
                                                                <div class="grid_1_of_4 images_1_of_4">
                                                                    <h4><a href="preview.html">Whirlpool LTE5243D 3.4 CuFt.... </a></h4>
                                                                    <a href="preview.html"><img src="../images/product-img4.jpg" alt="" /></a>
                                                                    <div class="price-details">
                                                                        <div class="price-number">
                                                                            <p><span class="rupees">$839.93 </span></p>
                                                                        </div>
                                                                        <div class="add-cart">								
                                                                            <h4><a href="preview.html">Más información</a></h4>
                                                                        </div>
                                                                        <div class="clear"></div>
                                                                    </div>
                                                                </div>-->
                            </div>
                            <div class="product-articles">
                                <h3>Articulos</h3>
                                <ul>
                                    <li>
                                        <div class="article">
                                            <p><span>Impresoras HP OfficeJet Pro 6900</span></p>
                                            <p>Potencie la oficina con color económico e impresión veloz a doble cara. Ahorre papel con impresión automática a doble cara y haga más cosas sin perder tiempo. Tenga una serie de opciones de impresión móvil y configuración móvil sencilla.1,2
                                                Impresora apta para seguridad dinámica. Destinada solo al uso con cartuchos que usen un chip original HP. Los cartuchos que usan un chip de otro fabricante podrían no funcionar y los que funcionen, podrían no hacerlo en el futuro.</p>
                                            <p><a href="#">Mas información aqui.</a></p>
                                        </div>
                                    </li>
                                    <li>

                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="clear"></div>
                    </div>
                </div>
            </div>
        </div>
        <!--
                <div class="container col-md-8">
        
                    <form class="form-inline" action="" autocomplete="on">
                        <div class="row col-md-12">
                            <div class="form-group">
                                &nbsp;
                            </div>
                        </div>
                        <div class="row col-md-12">
                            <div class="form-group col-md-12">
                                <input class="form-control col-md-10" id="txtNombreProducto" type="text" name="nombreProducto" placeholder="ingrese nombre del producto">
                                <input class='form-control col-md-2 btn btn-danger' id="btnBuscar"type="submit" value="Buscar">
        
                            </div>
                        </div>
                        <div class="row col-md-12">
                            <div class="form-group">
                                &nbsp;
                            </div>
                        </div>
                    </form>
                </div>
        -->

        <%@include file="./Footer.jsp" %>
        <script type="text/javascript" src="../_js/jquery-3.3.1.js"></script>
        <script type="text/javascript" src="../_js/bootstrap.min.js"></script>
        <script type="text/javascript" src="../_js/popper.min.js"></script>
        <link rel="stylesheet" href="../_css/bootstrap.min.css">
        <link href="../_css/styles.css" rel="stylesheet" type="text/css" />

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <link href="../_css/styles.css" rel="stylesheet" type="text/css" />
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js">
< script type = "text/javascript" >
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
    </body>

</html>