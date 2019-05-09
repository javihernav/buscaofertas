window.onload = function () {

    $('#botonIngresar').on('click', accionEnviarDatos);
};

function accionEnviarDatos() {
    //debugger;
    if (validarFormularioLogin()) {
        var objDatos = {
            usuario: $('#txtUsuario').val(),
            clave: $('#txtPassword').val()
        };

        console.log(objDatos);

        $.ajax({
            type: 'POST',
            url: '/BuscaOfertas/Login',
            //contentType:'application/json',
            data: (objDatos),
            //dataType:'json',
            success: function (data, textStatus, jqXHR) {
                //alert(data.mensaje);
                if (data.codigo !== 0) {
                    $('#ventana1').modal('show'); // abrir
                    setTimeout(ocultarModal1(), 5000);
                    //setTimeout(redireccionar(), 5000);
                } else {
                    $('#ventana2').modal('show'); // abrir
                    setTimeout(ocultarModal2(), 5000);
                }

            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#ventana2').modal('show'); // abrir
                window.setTimeout(ocultarModal2(), 5000);
                //alert('Datos Incorrectos ' + JSON.stringify(jqXHR));
            }


        });
    } else {
        alert("Los datos ingresados tienen errores o están incompletos!!!");
    }
}

function ocultarModal1() {
    $('#ventana1').modal('hide');
}
function ocultarModal2() {
    $('#ventana2').modal('hide');
}
function redireccionar() {
    $(location).attr('href', '/BuscaOfertas/jsp/PaginaPrincipal.jsp');

}