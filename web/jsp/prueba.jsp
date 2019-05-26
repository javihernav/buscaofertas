<%-- 
    Document   : newjsp1
    Created on : May 6, 2019, 10:31:05 PM
    Author     : JAVIER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form name="formulario" id="formulario" method="POST" action="../prueba">
            <input type="text" id="numeroentrada" name="nombreentrada" class="required">
            <select id="numeroequipo" name="nombreequipo" required="true">
                <option value="5">
                nacional
                </option>
                <option value="6">
                america
                </option>
            </select>
            <input id="botonEnviar" type="submit" value="enviar">
        </form>
        <script type="text/javascript" src="../_js/jquery-3.3.1.js"></script>
        <!--        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js" type="text/javascript"></script>-->
        <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js" type="text/javascript"></script>
      
    </body>
</html>
