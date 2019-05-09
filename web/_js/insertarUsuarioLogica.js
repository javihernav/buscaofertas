window.onload = function () {
    cargarComboBoxDatos();
    cargarFechaNacimiento();
       // $('#formulario').validate();

    $('#botonRegistrar').on('click', accionEnviarDatos);
};

function accionEnviarDatos() {
    //debugger;
    
                
    if (validarFormularioPerfil()) {
        $('#formulario').validate();
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
        alert("Los datos ingresados tienen errores o están incompletos!!!");
    }
}

