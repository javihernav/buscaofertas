function alertaeliminar(id)
{
    var mensaje;
    var opcion = confirm("¿Desea eliminar el usuario?");
    if (opcion == true) {
        mensaje = "Si";
        $(location).attr('href', '/BuscaOfertas/usuario_eliminarusuario?id=' + id);//href="../usuario_eliminarusuario?id="
    } else {
        mensaje = "No";
        $(location).attr('href', '/BuscaOfertas/jsp/misdatos.jsp');
    }
    document.getElementById("ejemplo").innerHTML = mensaje;
}