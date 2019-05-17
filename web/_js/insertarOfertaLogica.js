window.onload = function () {
    cargarComboBoxCiudad();
    cargarComboBoxCategorias();
    cargarComboBoxProducto();
    $('#botonRegistrar').on('click', accionEnviarDatos);
    $('#botonCancelar').on('click', volver);
    //location.reload();
};

function accionEnviarDatos() {
    if (validarFormularioOferta()) {
        var formData = new FormData(document.getElementById("formOferta"));
        /*
         * var objDatos = {
         
         nombreProducto: $('#txtNombreProducto').val(),
         categoriaProducto: $('#txtCategoria').val(),
         marcaProducto: $('#txtMarca').val(),
         nombreOferta: $('#txtNombreOferta').val(),
         ciudadOferta: $('#cbCiudadOferta option:selected').attr("value"),
         nombreTienda: $('#txtNombreTienda').val(),
         imagenProducto: $('#imgProducto').files[0],
         direccionTienda: $('#txtDireccionTienda').val(),
         precioOferta: $('#txtPrecio').val(),
         fechaInicio: $('#txtFechaDeInicio').val(),
         fechaFinalizacion: $('#txtFechaDeFinalizacion').val()
         };*/

        console.log(formData);

        $.ajax({
            type: 'POST',
            url: '/BuscaOfertas/RegistrarOfertas',
            //contentType:'application/json',
            data: (formData),
            dataType: 'html',
            cache: false,
            contentType: false,
            processData: false,
            success: function (data, textStatus, jqXHR) {
//                alert(data.mensaje);
                alert("Oferta creada exitosamente!");
                if (data.codigo !== 0) {
                    $(location).attr('href', '/BuscaOfertas/jsp/GestionarOfertas.jsp');
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
    $(location).attr('href', '/BuscaOfertas/jsp/GestionarOfertas.jsp');

}