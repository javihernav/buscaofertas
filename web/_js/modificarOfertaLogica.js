window.onload = function () {
    cargarComboBoxCiudad();
    $('#botonActualizar').on('click', accionEnviarDatos);
    $('#botonCancelar').on('click', volver);
};

function accionEnviarDatos() {
    if (true) {
        var objDatos = {

            nombreProducto: $('#txtNombreProducto').val(),
            categoriaProducto: $('#txtCategoria').val(),
            marcaProducto: $('#txtMarca').val(),
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
            url: '/BuscaOfertas/ModificarOferta',
            //contentType:'application/json',
            data: (objDatos),
            //dataType:'json',
            success: function (data, textStatus, jqXHR) {
                alert(data.mensaje);
                if (data.codigo !== 0) {
                    $(location).attr('href', '/BuscaOfertas/jsp/GestionarOfertas.jsp');
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

function volver() {
    $(location).attr('href', '/BuscaOfertas/jsp/GestionarOfertas.jsp');

}