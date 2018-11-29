window.onload = function () {
    cargarComboBoxCiudad();

    $('#botonRegistrar').on('click', accionEnviarDatos);
};

function accionEnviarDatos() {
    if (validarFormularioRegistrarOferta()) {
        var objDatos = {
            nombreProducto: $('#txtNombreProducto').val(),
            nombreOferta: $('#txtNombreOferta').val(),
            ciudadOferta: $('#cbCiudadOferta option:selected').attr("value"),
            nombreTienda: $('#txtNombreTienda').val(),
            imagenProducto: $('#imgProducto').val(),
            direccionTienda: $('#txtDireccionTienda').val(),
            precioOferta: $('#txtPrecio').val(),
            fechaInicio: $('#txtFechaDeInicio').val(),
            fechaFinalizacion: $('#txtFechaDeFinalizacion').val()
        };
        
        console.log(objDatos);

        $.ajax({
            type: 'POST',
            url: '/BuscaOfertas/RegistrarOfertas',
            //contentType:'application/json',
            data: (objDatos),
            //dataType:'json',
            success: function (data, textStatus, jqXHR) {
                alert(data.mensaje);
                if (data.codigo !== 0) {
                    $(location).attr('href', '/BuscaOfertas/Principal');
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert('NO OK ' + JSON.stringify(jqXHR));
            }


        });
    } else {
        alert("Los datos en el formulario son erroneos!!!");
    }
}

