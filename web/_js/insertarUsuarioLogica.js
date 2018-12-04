window.onload = function () {
    cargarComboBoxDatos();

    $('#botonRegistrar').on('click', accionEnviarDatos);
};

function accionEnviarDatos() {
    //debugger;
    if (validarFormulario()) {
        var objDatos = {
            nombres: $('#txtNombres').val(),
            apellidos: $('#txtApellidos').val(),
            correo: $('#txtCorreo').val(),
            telefono: $('#txtTelefono').val(),
            ciudad: $('#cbCiudadUsuario option:selected').attr("value"),
            fechaDeNacimiento: $('#txtFechaDeNacimiento').val(),
            usuario: $('#txtUsuario').val(),
            clave: $('#txtPassword').val(),
            genero: $('#cbGenero option:selected').attr("value")

        };
        
        console.log(objDatos);

        $.ajax({
            type: 'POST',
            url: '/BuscaOfertas/RegistrarUsuario',
            //contentType:'application/json',
            data: (objDatos),
            //dataType:'json',
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
        alert("Los datos en el formulario son erroneos!!!");
    }
}

