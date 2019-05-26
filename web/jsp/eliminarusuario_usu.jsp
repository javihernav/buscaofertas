<%@page import="app.modelo.vo.Usuario"%>
<%@page import="app.control.ControlUsuario"%>
<%@page import="app.modelo.Conectar"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <form name="eliminar" action="alertaeliminar()" method="POST">
        <button type="submit" id="Botoneliminar">Desactivar mi usuario</button>
    </form>
    
    
        
    </head>
    <body>
        <%
            
            
            int idUsuario=Integer.parseInt(request.getParameter("id"));
            Usuario vo = new Usuario();
            vo.setIdUsuario(idUsuario);
            Connection cnn = Conectar.getCnn();
            ControlUsuario controlUsuario = new ControlUsuario(cnn);
            controlUsuario.eliminar(vo);
            response.sendRedirect("PaginaPrincipal.jsp");
            //rs = smt.executeQuery("select * from usuario");
            %>
            
            <script src="eliminarusuarios_usu.jsp"></script>
                     
</body>
</html>