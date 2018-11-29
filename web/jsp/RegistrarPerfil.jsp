<%-- 
    Document   : Consultas
    Created on : Nov 22, 2018, 3:56:00 PM
    Author     : JAVIER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <title>Entrega Proyecto BuscaOfertas</title>
    <meta charset="UTF-8">
    <meta name="titulo" content="Proyecto BuscaOfertas">
    <meta name="descripcion" content="Entrega Proyecto BuscaOfertas">
    <meta name="viewport" content="width=device-width" , user-scalable=no, initial-scale=1.0, maximum-scale=1.0,
        maximum-scalable=1.0>
    <link rel="shortcut icon" type="image/x-icon" href="../_img/LETRERO-BUSCAOFERTAS-Y-nombre-técnico.png">
    <link href="https://fonts.googleapis.com/css?family=Krub" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Michroma" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=PT+Mono" rel="stylesheet">
</head>

<body onload="cargarComboBoxDatos()">
    <header>

        <div class="topnav">
            <a class="active" href="#home">Home</a>
            <a href="#news">Acerca de nosotros</a>
            <a href="#news">Contáctanos</a>
            <a href="#contact">Siguenos en Redes Sociales</a>
            <a href="#about">Ayuda</a>
            <a href="#about">Inicia Sesión</a>
            <a href="#about">Regístrate</a>
        </div>
    </header>

    <figure>
        <img class="letreroCA" src="../_img/LETRERO-BUSCAOFERTAS-sin-nombre-tecnico.png" alt="BuscaOfertas.jpg" width="500">

    </figure>

    <div>
        <form class="registrarPerfil" autocomplete="on">
            <table style="width:100% ">
                <tr>
                    <th>
                        <div><label>Nombres:</label><input id="txtNombres" type="text" value="" maxlength="45" placeholder="Introduzca sus nombres " oninput="validarNombres()" required></div><br />
                    </th>
                    <th>
                        <div><label>Apellidos:</label><input id="txtApellidos" type="text" value="" maxlength="45" placeholder="Introduzca sus apellidos " oninput="validarApellidos()" required></div><br />
                    </th>
                    <th>
                        <div><label>Email:</label><input id="txtCorreo" type="email" value="" maxlength="45" placeholder="Introduzca su e-mail " oninput="validarCorreo()" required></div><br />
                    </th>
                </tr>
                <tr>
                    <th>
                        <div><label>Teléfono:</label><input id="txtTelefono" type="text" value="" maxlength="20" placeholder="Introduzca su teléfono " oninput="validarTelefono()" required></div><br />
                    </th>
                    <th>
                    <div><label>Ciudad:</label><select id="cbCiudadUsuario" type="text" required><option value="0">Seleccione Ciudad</option></select></div><br />
                    </th>
                    <th>
                        <div><label>Fecha de Nacimiento:</label><input id="txtFechaDeNacimiento" type="date" value="" maxlength="45"  oninput="validarFecha()" required></div><br />
                </tr>
                <tr>
                    <th>
                        <div><label>Usuario:</label><input id="txtUsuario" type="text" value="" maxlength="20" placeholder="Nombre de usuario para su cuenta" oninput="validarNombreUsuario()" required></div><br />
                    </th>
                    <th>
                        <div><label>Password:</label><input id="txtPassword" type="password" value="" maxlength="20" placeholder="Introduzca su contraseña" oninput="validarPassword()" required></div><br />
                    </th>
                    <th>
                        <div><label>Password:</label><input id="txtPasswordConfirmacion" type="password" value="" maxlength="20" placeholder="Confirme su contraseña"  oninput="validarPassword()" required></div><br />
                    </th>
                    
                </tr>
            <tr>
                    <th>
            <div><label>Genero:</label><select id="cbGenero" type="text" onchange="validarGenero()" required><option value="0">Género</option><option value="m">Masculino</option><option value="f">Femenino</option></select></div><br />
                    </th>
                
                <th> <input id="botonCancelar" type="button" value="Cancelar"></th>
                <th><input id="botonRegistrar" type="submit" value="Registrar" ></th>
            </tr>
            </table>
           
                

        </form>
    </div>
    <link href="../_css/styles.css" rel="stylesheet" type="text/css" />

    <script type="text/javascript" src="../_js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="../_js/consultasCiudadLogica.js"></script>
    <script type="text/javascript" src="../_js/validacion.js"></script>
    <script type="text/javascript" src="../_js/insertarUsuarioLogica.js"></script>
</body>

</html>