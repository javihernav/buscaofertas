<%-- 
    Document   : Consultas
    Created on : Nov 22, 2018, 3:56:00 PM
    Author     : JAVIER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contenido</title>
        <meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
    </head>
    <body>
        <header>  
            <%@include file="/jsp/Barra.jsp" %>
        </header>
        <div id="contenido">
            <div id="tablaDatos">

            </div>
        </div>
        <script src="../_js/jquery-3.3.1.js"></script>
        <script src="../_js/consultasUsuarioLogica.js"></script>
        
        
        
        
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
    </body>
</html>
