<%@page import="app.control.ControlOfertaCompleta"%>
<%@page import="java.sql.Connection"%>
<%@page import="app.modelo.Conectar"%>
<%@page import="app.modelo.vo.OfertaCompleta"%>
<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<head>
    <title>BuscaOfertas</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href='http://fonts.googleapis.com/css?family=Ubuntu+Condensed' rel='stylesheet' type='text/css'>
    <link href="../_css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <script type="text/javascript" src="../_js/jquery-1.9.0.min.js"></script> 
    <script src="../_js/jquery.openCarousel.js" type="text/javascript"></script>
    <script type="text/javascript" src="../_js/easing.js"></script>
    <script type="text/javascript" src="../_js/move-top.js"></script>
    <script src="../_js/easyResponsiveTabs.js" type="text/javascript"></script>
    <link href="../_css/easy-responsive-tabs.css" rel="stylesheet" type="text/css" media="all"/>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#horizontalTab').easyResponsiveTabs({
                type: 'default', //Types: default, vertical, accordion           
                width: 'auto', //auto or any width like 600px
                fit: true   // 100% fit in a container
            });
        });
    </script>		
    <link rel="stylesheet" href="../_css/etalage.css">
    <script src="../_js/jquery.etalage.min.js"></script>
    <script>
        jQuery(document).ready(function ($) {

            $('#etalage').etalage({
                thumb_image_width: 300,
                thumb_image_height: 400,
                source_image_width: 900,
                source_image_height: 1200,
                show_hint: true,
                click_callback: function (image_anchor, instance_id) {
                    alert('Callback example:\nYou clicked on an image with the anchor: "' + image_anchor + '"\n(in Etalage instance: "' + instance_id + '")');
                }
            });

        });
    </script>
    <script src="../_js/star-rating.js" type="text/javascript"></script>
</head>
<body>
    <header>  
        <%@include file="./Barra.jsp" %>
    </header>
    <%     int idOferta;
        OfertaCompleta ofertaCompleta = new OfertaCompleta();
        Connection cnn = Conectar.getCnn();
        ControlOfertaCompleta coc = new ControlOfertaCompleta(cnn);
        try {
            idOferta = Integer.parseInt(request.getParameter("idOferta"));

            ofertaCompleta = coc.consultarOfertaCompletaPorIdOferta(idOferta);
        } catch (Exception e) {
        }
    %>
    <!------------End Header ------------>
    <div class="main">
        <div class="wrap">
            <div class="preview-page">
                <div class="section group">
                    <div class="cont-desc span_1_of_2">
                        <ul class="back-links">
                            <li><a href="#">Inicio</a> ::</li>
                            <li><a href="#">Productos</a> ::</li>
                            <li><%=ofertaCompleta.getNombreOferta()%></li>
                            <div class="clear"> </div>
                        </ul>
                        <div class="product-details">	
                            <div class="grid images_3_of_2">
                                <ul id="etalage">
                                    <li>
                                        <a href="optionallink.html">
                                            <!--<img class="etalage_thumb_image" src="../images/preview-small-img1.png" />
                                            <img class="etalage_source_image" src="../images/preview-large-img1.jpg" title="" />-->
                                            <img class="etalage_thumb_image" src="${pageContext.request.contextPath}/ServicioImagen/<%= ofertaCompleta.getIdImagen()%>" />
                                            <img class="etalage_source_image" src="${pageContext.request.contextPath}/ServicioImagen/<%= ofertaCompleta.getIdImagen()%>" title="" />
                                        </a>
                                    </li>
                                    <!--                                    <li>
                                                                            <img class="etalage_thumb_image" src="../images/preview-small-img2.png"  />
                                                                            <img class="etalage_source_image" src="../images/preview-large-img2.jpg" title="" />
                                                                        </li>
                                                                        <li>
                                                                            <img class="etalage_thumb_image" src="../images/preview-small-img3.png"  />
                                                                            <img class="etalage_source_image" src="../images/preview-large-img3.jpg" />
                                                                        </li>
                                                                        <li>
                                                                            <img class="etalage_thumb_image" src="../images/preview-small-img4.png" />
                                                                            <img class="etalage_source_image" src="../images/preview-large-img4.jpg" />
                                                                        </li>-->
                                </ul>
                            </div>
                            <div class="desc span_3_of_2">
                                <h2><%=ofertaCompleta.getNombreProducto()%></h2>
                                <!--<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>-->					
                                <div class="price">
                                    <p>Precio: <span>$<%=ofertaCompleta.getPrecio()%></span></p>
                                </div>
                                <div id="idOferta" data-val="<%=ofertaCompleta.getIdOferta()%>" class="price">
                                    <p>IdOferta: <span><%=ofertaCompleta.getIdOferta()%></span></p>
                                </div>
                                <!--                                <div class="available">
                                                                    <ul>
                                                                        <li><span>Model:</span> &nbsp; Model 1</li>
                                                                        <li><span>Shipping Weight:</span>&nbsp; 75.58 kg</li>
                                                                        <li><span>Units in Stock:</span>&nbsp; 566</li>
                                                                    </ul>
                                                                </div>-->
                                <!--                                <div class="share-desc">
                                                                    <div class="share">
                                                                        <p>Number of units :</p><input type="number" class="text_box" type="text" value="1" min="1" />				
                                                                    </div>
                                                                    <div class="button"><span><a href="#">Add to Cart</a></span></div>					
                                                                    <div class="clear"></div>
                                                                </div>-->
                                <!--                                <div class="wish-list">
                                                                    <ul>
                                                                        <li class="wish"><a href="#">Add to Wishlist</a></li>
                                                                        <li class="compare"><a href="#">Add to Compare</a></li>
                                                                    </ul>
                                                                </div>-->
                                <div class="colors-share">
                                    <!--                                    <div class="color-types">
                                                                            <h4>Available Colors</h4>
                                                                            <form class="checkbox-buttons">
                                                                                <ul>
                                                                                    <li><input id="r1" name="r1" type="radio"><label for="r1" class="grey"> </label></li>
                                                                                    <li><input id="r2" name="r1" type="radio"><label for="r2" class="blue"> </label></li>
                                                                                    <li><input id="r3" name="r1" type="radio"><label class="white" for="r3"> </label></li>
                                                                                    <li><input id="r4" name="r1" type="radio"><label class="black" for="r4"> </label></li>
                                                                                </ul>
                                                                            </form>
                                                                        </div>-->
                                    <div class="social-share">
                                        <h4>Compartir Oferta</h4>
                                        <ul>
                                            <li><a class="share-face" href="#"> </a></li>
                                            <li><a class="share-twitter" href="#"> </a></li>
                                            <li><a class="share-google" href="#"> </a></li>
                                            <li><a class="share-rss" href="#"> </a></li>
                                            <div class="clear"> </div>
                                        </ul>
                                    </div>
                                    <div class="clear"></div>
                                </div>
                            </div>
                            <div class="clear"></div>
                        </div>
                        <div class="product_desc">	
                            <div id="horizontalTab">
                                <ul class="resp-tabs-list">
                                    <li>Datos de la Oferta</li>
                                    <!--                                    <li>product Tags</li>-->
                                    <li>Calificar Oferta</li>
                                    <div class="clear"></div>
                                </ul>
                                <div class="resp-tabs-container">
                                    <div class="product-specifications">
                                        <ul>
                                            <li><span class="specification-heading">Nombre del Producto</span> <span><%=ofertaCompleta.getNombreProducto()%></span><div class="clear"></div></li>
                                            <li><span class="specification-heading">Categoría</span> <span><%=ofertaCompleta.getNombreCategoria()%></span><div class="clear"></div></li>
                                            <li><span class="specification-heading">Marca</span> <span><%=ofertaCompleta.getNombreMarca()%></span><div class="clear"></div></li>
                                            <li><span class="specification-heading">Ciudad de la Oferta</span> <span><%=ofertaCompleta.getNombreCiudad()%></span><div class="clear"></div></li>
                                            <li><span class="specification-heading">Departamento de la Oferta</span> <span><%=ofertaCompleta.getDepartamentoCiudad()%></span><div class="clear"></div></li>
                                            <li><span class="specification-heading">Dirección de la Tienda</span> <span><%=ofertaCompleta.getDireccion()%></span><div class="clear"></div></li>
                                            <li><span class="specification-heading">Nombre de la Tienda</span> <span><%=ofertaCompleta.getNombreTienda()%></span><div class="clear"></div></li>
                                            <li><span class="specification-heading">Precio</span> <span><%=ofertaCompleta.getPrecio()%></span><div class="clear"></div></li>
                                            <li><span class="specification-heading">Fecha de Inicio</span> <span><%=ofertaCompleta.getFechaInicio()%></span><div class="clear"></div></li>
                                            <li><span class="specification-heading">Fecha de Finalización</span> <span><%=ofertaCompleta.getFechaFin()%></span><div class="clear"></div></li>
                                            <!--                                            <li><span class="specification-heading">Adjustable Feet</span> <span>4 </span><div class="clear"></div></li>-->
                                        </ul>
                                    </div>

                                    <!--                                    <div class="product-tags">
                                                                            <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
                                                                            <h4>Add Your Tags:</h4>
                                                                            <div class="input-box">
                                                                                <input type="text" value="">
                                                                            </div>
                                                                            <div class="button"><span><a href="#">Add Tags</a></span></div>
                                                                        </div>	-->

                                    <div class="review">
                                        <h4>Calificación de la oferta</a></h4>
                                        <ul>
                                            <li>Precio : <div class="rating-stars"><div id="puntosPrecio" class="rating" data-rating-max="5"> </div> </div>
                                            </li>
                                            <!--<li>Valor : <div class="rating-stars"><div class="rating" data-rating-max="5"> </div> </div></li>-->
                                            <li>Calidad : <div class="rating-stars"><div id="puntosCalidad" class="rating" data-rating-max="5"> </div> </div></li>
                                        </ul>
                                        <p>Tu opinión sobre cada oferta que visites es importante para nosotros y para los demás usuarios, ya que les permite hallar más facilmente las ofertas mas apropiadas para su bolsillo en cuanto a calidad y precio de los productos que se ofrecen.</p>
                                        <p>Te invitamos a expresar tu opinión sobre esta oferta.</p>
                                        <div class="your-review">
                                            <h4>Cómo calificas esta oferta?</h4>
                                            <p>Deseas escribir tu propia opinión al respecto?</p>
                                            <form>
                                                <div>
                                                    <span><label>Nombre de Usuario<span class="red">*</span></label></span>
                                                    <span><input id="nombreUsuario" type="text" value=""></span>
                                                </div>
                                                <div><span><label>Resumen de la Calificación<span class="red">*</span></label></span>
                                                    <span><input id="resumen" type="text" value=""></span>
                                                </div>						
                                                <div>
                                                    <span><label>Opinión<span class="red">*</span></label></span>
                                                    <span><textarea id="opinion"> </textarea></span>
                                                </div>
                                                <div>
                                                    <span><input id="btnEnviar" type="button" value="ENVIAR CALIFICACIÓN" class="btn btn-dangers"></span>
                                                </div>
                                            </form>
                                        </div>			
                                        <script type="text/javascript">
        /* place inside document ready function */
        $(".rating").starRating({
            minus: true // step minus button
        });
                                        </script>	
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="rightsidebar span_3_of_1 sidebar">
                        <h3>Ofertas Populares</h3>
                        <ul class="popular-products">
                            <li>
                                <h4><a href="preview.html">Whirlpool LTE5243D 3.4 CuFt.... </a></h4>
                                <a href="preview.html"><img src="../images/product-img2.jpg" alt="" /></a>
                                <div class="price-details">
                                    <div class="price-number">
                                        <p><span class="rupees line-through">$899.95 </span> &nbsp; <span class="rupees">$839.93 </span></p>
                                    </div>
                                    <div class="add-cart">								
                                        <h4><a href="preview.html">Más Información</a></h4>
                                    </div>
                                    <div class="clear"></div>
                                </div>					 
                            </li>
                            <li>
                                <h4><a href="preview.html">Whirlpool LTE5243D 3.4 CuFt.... </a></h4>
                                <a href="preview.html"><img src="../images/product-img3.jpg" alt="" /></a>
                                <div class="price-details">
                                    <div class="price-number">
                                        <p><span class="rupees line-through">$899.95 </span> &nbsp; <span class="rupees">$839.93 </span></p>
                                    </div>
                                    <div class="add-cart">								
                                        <h4><a href="preview.html">Más Información</a></h4>
                                    </div>
                                    <div class="clear"></div>
                                </div>					 
                            </li>
                            <li>
                                <h4><a href="preview.html">Whirlpool LTE5243D 3.4 CuFt.... </a></h4>
                                <a href="preview.html"><img src="../images/product-img4.jpg" alt="" /></a>
                                <div class="price-details">
                                    <div class="price-number">
                                        <p><span class="rupees line-through">$899.95 </span> &nbsp; <span class="rupees">$839.93 </span></p>
                                    </div>
                                    <div class="add-cart">								
                                        <h4><a href="preview.html">Más Información</a></h4>
                                    </div>
                                    <div class="clear"></div>
                                </div>					 
                            </li>
                        </ul>

                        <!--                        <div class="community-poll">
                                                    <h3>Community POll</h3>
                                                    <p>What is the main reason for you to purchase products online?</p>
                                                    <div class="poll">
                                                        <form>
                                                            <ul>
                                                                <li>
                                                                    <input type="radio" name="vote" class="radio" value="1">
                                                                    <span class="label"><label>More convenient shipping and delivery </label></span>
                                                                </li>
                                                                <li>
                                                                    <input type="radio" name="vote" class="radio" value="2">
                                                                    <span class="label"><label for="vote_2">Lower price</label></span>
                                                                </li>
                                                                <li>
                                                                    <input type="radio" name="vote" class="radio" value="3">
                                                                    <span class="label"><label for="vote_3">Bigger choice</label></span>
                                                                </li>
                                                                <li>
                                                                    <input type="radio" name="vote" class="radio" value="5">
                                                                    <span class="label"><label for="vote_5">Payments security </label></span>
                                                                </li>
                                                                <li>
                                                                    <input type="radio" name="vote" class="radio" value="6">
                                                                    <span class="label"><label for="vote_6">30-day Money Back Guarantee </label></span>
                                                                </li>
                                                                <li>
                                                                    <input type="radio" name="vote" class="radio" value="7">
                                                                    <span class="label"><label for="vote_7">Other.</label></span>
                                                                </li>
                                                            </ul>
                                                        </form>
                                                    </div>
                                                </div>-->
                    </div>
                </div>
            </div>
        </div>
        <div class="content_top">
            <div class="wrap">
                <h3>Vistas Recientemente</h3>
            </div>
            <div class="line"> </div>
            <div class="wrap">
                <div class="ocarousel_slider">  
                    <div class="ocarousel example_photos" data-ocarousel-perscroll="3">
                        <div class="ocarousel_window">
                            <a href="#" title="img1"> <img src="../images/latest-product-img1.jpg" alt="" /><p>Nuncvitae</p></a>
                            <a href="#" title="img2"> <img src="../images/latest-product-img2.jpg" alt="" /><p>Suspendiss</p></a>
                            <a href="#" title="img3"> <img src="../images/latest-product-img3.jpg" alt="" /><p>Phasellus ferm</p></a>
                            <a href="#" title="img4"> <img src="../images/latest-product-img4.jpg" alt="" /><p>Veldignissim</p></a>
                            <a href="#" title="img5"> <img src="../images/latest-product-img5.jpg" alt="" /><p>Aliquam interd</p></a>
                            <a href="#" title="img6"> <img src="../images/latest-product-img6.jpg" alt="" /><p>Sapien lectus</p></a>
                            <a href="#" title="img1"> <img src="../images/latest-product-img1.jpg" alt="" /><p>Nuncvitae</p></a>
                            <a href="#" title="img2"> <img src="../images/latest-product-img2.jpg" alt="" /><p>Suspendiss</p></a>
                            <a href="#" title="img3"> <img src="../images/latest-product-img3.jpg" alt="" /><p>Phasellus ferm</p></a>
                            <a href="#" title="img4"> <img src="../images/latest-product-img4.jpg" alt="" /><p>Veldignissim</p></a>
                            <a href="#" title="img5"> <img src="../images/latest-product-img5.jpg" alt="" /><p>Aliquam interd</p></a>
                            <a href="#" title="img6"> <img src="../images/latest-product-img6.jpg" alt="" /><p>Sapien lectus</p></a>
                        </div>
                        <span>           
                            <a href="#" data-ocarousel-link="left" style="float: left;" class="prev"> </a>
                            <a href="#" data-ocarousel-link="right" style="float: right;" class="next"> </a>
                        </span>
                    </div>
                </div>  
            </div>    		
        </div>
    </div>

    <!--    <div class="footer">
            <div class="wrap">	
                <div class="copy_right">
                    <p>Copy rights (c). All rights Reseverd | Template by  <a href="http://w3layouts.com" target="_blank">W3Layouts</a> </p>
                </div>	
                <div class="footer-nav">
                    <ul>
                        <li><a href="#">Terms of Use</a> : </li>
                        <li><a href="#">Privacy Policy</a> : </li>
                        <li><a href="contact.html">Contact Us</a> : </li>
                        <li><a href="#">Sitemap</a></li>
                    </ul>
                </div>		
            </div>
        </div>-->
    <script type="text/javascript">
        $(document).ready(function () {
            $().UItoTop({easingType: 'easeOutQuart'});

        });
    </script>
    <a href="#" id="toTop"> </a>
    <script type="text/javascript" src="../_js/navigation.js"></script>
    <footer>
        <%@include file="./Footer.jsp" %>
    </footer>
    <script type="text/javascript">

        window.onload = function () {
         
            $('#btnEnviar').on('click', enviarCalificacion);
         
        };


        function enviarCalificacion() {
            if (true) {


                var objDatos = {
                    idOferta: $('#idOferta').attr("data-val"),
                    nombreUsuario: $('#nombreUsuario').val(),
                    puntosPrecio: $('#puntosPrecio').attr("data-val"),
                    puntosCalidad: $('#puntosCalidad').attr("data-val"),
                    marcaProducto: $('#txtMarca').val(),
                    resumen: $('#resumen').val(),
                    opinion: $('#opinion').val()

                };

                console.log(objDatos);

                $.ajax({
                    type: 'POST',
                    url: '/BuscaOfertas/RegistrarCalificacion',
                    //contentType:'application/json',
                    data: (objDatos),
                    //dataType: 'html',
                    //cache: false,
                    //contentType: false,
                    //processData: false,
                    success: function (data, textStatus, jqXHR) {
                        alert(data.mensaje);
                        if (data.codigo !== 0) {
//                            $(location).attr('href', '/BuscaOfertas/jsp/PaginaPrincipal.jsp');
                        }
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
//                        alert('No fue posible registrar la calificación! ' + JSON.stringify(jqXHR));
                        alert('No fue posible registrar la calificación! ');
                    }


                });
            } else {
                alert("Los datos ingresados tienen errores o están incompletos!!!");
            }
        }

    </script>

</body>
</html>