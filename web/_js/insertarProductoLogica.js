window.onload = function () {
    cargarComboBoxCategorias();
    $('#botonAgregar').on('click', accionEnviarDatos);
    $('#botonCancelar').on('click', volver);
};


function accionEnviarDatos() {
    if (validarFormularioProducto()) {
        
        
         var objDatos = {
         
         nombreProducto: $('#txtNombreProducto').val(),
         categoriaProducto: $('#cbCategoria option:selected').attr("value"),
         marcaProducto: $('#txtMarca').val()
         
         };

        console.log(objDatos);

        $.ajax({
            type: 'POST',
            url: '/BuscaOfertas/RegistrarProducto',
            //contentType:'application/json',
            data: (objDatos),
            //dataType: 'html',
            //cache: false,
            //contentType: false,
            //processData: false,
            success: function (data, textStatus, jqXHR) {
                alert(data.mensaje);
                if (data.codigo !== 0) {
                    $(location).attr('href', '/BuscaOfertas/jsp/PaginaPrincipal.jsp');
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert('NO OK ' + JSON.stringify(jqXHR));
            }


        });
    } else {
        alert("Los datos ingresados tienen errores o están incompletos!!!");
    }
}




function volver() {
    $(location).attr('href', '/BuscaOfertas/jsp/PaginaPrincipal.jsp');

}