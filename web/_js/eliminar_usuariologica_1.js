function alertaeliminar()
    {
    var mensaje;
    var opcion = confirm("¿Desea eliminar el usuario?");
    if (opcion == true) {
        mensaje = "Si";
        $(location).attr('href','/BuscaOfertas/usuario_eliminarusuario');
	} else {
	    mensaje = "No";
            $(location).attr('href','/BuscaOfertas/eliminarusuarios_usu.jsp');
	}
	document.getElementById("ejemplo").innerHTML = mensaje;
    }
