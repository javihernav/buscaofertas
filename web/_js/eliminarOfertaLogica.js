function eliminarOfertaId(id,usuario)
{
    
    var mensaje;
    console.log("idOferta"+id);
    console.log("usuario"+usuario);
    var opcion = confirm("¿Confirma que desea eliminar la oferta?");
    if (opcion == true) {
        //mensaje = "Si";
        $(location).attr('href', '/BuscaOfertas/EliminarOferta?id=' + id+"&usuario="+usuario);//href="../usuario_eliminarusuario?id="
    } else {
        //mensaje = "No";
        $(location).attr('href', '/BuscaOfertas/jsp/GestionarOfertas.jsp');
    }
    //document.getElementById("ejemplo").innerHTML = mensaje;
}

