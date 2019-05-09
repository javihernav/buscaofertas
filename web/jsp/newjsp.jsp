<%-- 
    Document   : newjsp
    Created on : Apr 20, 2019, 5:45:08 AM
    Author     : JAVIER
--%>


<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--En el cuerpo del mensaje se definirá la conexión haciendo referencia al nombre del recurso JDBC.-->

<%
    InitialContext ctx = new InitialContext();
    DataSource ds = (DataSource) ctx.lookup("jdbc/buscaofertasPool");
    Connection connection = ds.getConnection();%>
<!--Después habrá que verificar que el objeto connection es igual a null. Dicha verificación se hace con el fin de determinar que no hay una conexión establecida con el servidor de bases de datos.-->
<%
    if (connection == null) {
        throw new SQLException("Error establishing connection!");
    }%>
<!--Para realizar una consulta se crea un objeto PreparedStatement el cual será ejecutado con el método executeQuery.-->
<%
    String query = "SELECT * FROM usuario";
    PreparedStatement statement = connection.prepareStatement(query);
    ResultSet rs = statement.executeQuery();%>
<!--Por último, se recorren todos los registros del ResultSet.-->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            while (rs.next()) {
                out.print(rs.getString("nombreUsuario") + "<br>");
            }
        %>
    </body>
</html>
