function alertaeliminar(id)
{
    var opcion = confirm("¿Desea eliminar el usuario?, también se eliminarán las ofertas del usuario!!!");
    if (opcion == true) {
        $(location).attr('href', '/BuscaOfertas/usuario_eliminarusuario?id=' + id);//href="../usuario_eliminarusuario?id="
    }
//    } else {
//        $(location).attr('href', '/BuscaOfertas/jsp/GestionarUsuarios.jsp');
//    }
}