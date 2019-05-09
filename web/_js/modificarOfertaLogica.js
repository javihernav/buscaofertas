window.onload = function () {
    cargarComboBoxCiudad();
    $('#botonActualizar').on('click', accionEnviarDatos);
    $('#botonCancelar').on('click', volver);
};

function accionEnviarDatos() {
    if (true) {
        var formData = new FormData(document.getElementById("formOferta"))
        /*
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
        };*/

        console.log(formData);

        $.ajax({
            type: 'POST',
            url: '/BuscaOfertas/ModificarOferta',
            //contentType:'application/json',
            data: (formData),
            dataType:'html',
            cache: false,
            contentType: false,
            processData: false,
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
        alert("Los datos ingresados tienen errores o están incompletos!!!");
    }
}

function volver() {
    $(location).attr('href', '/BuscaOfertas/jsp/GestionarOfertas.jsp');

}