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
                alert(data.mensaje);
                if (data.codigo !== 0) {
                    $(location).attr('href', '/BuscaOfertas/jsp/RegistrarOferta.jsp');
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert('Datos Incorrectos ' + JSON.stringify(jqXHR));
            }


        });
    } else {
        alert("Los datos en el formulario son erroneos!!!");
    }
}

