window.onload = function () {
    cargarComboBoxDatos(document.getElementById("cbCiudadUsuario").getAttribute("selectedIndex"));
    seleccionarOption();
    $('#botonRegistrar').on('click', accionEnviarDatos);
};
function seleccionarOption() {
    var combo = document.getElementById('cbCiudadUsuario');
    var seleccion = combo.getAttribute("selectedindex");
    console.log('seleccion: ' + seleccion);
//    $("#cbCiudadUsuario option[value = '" + seleccion + "']").attr("selected", 'selected');
    document.getElementById('cbCiudadUsuario').options[document.getElementById('cbCiudadUsuario').selectedIndex].text = seleccion.text;
//   var cantidad = combo.length;
//    for (i = 0; i < cantidad; i++) {
//
//        if (combo[i].value == seleccion) {
//            combo[i].selected="selected";
//        }
//    }
}
function accionEnviarDatos() {
    //debugger;
    if (validarFormularioPerfil()) {
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
            url: '/BuscaOfertas/ActualizarUsuario',
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

