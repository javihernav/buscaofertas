window.onload = function () {
    $('#btnAgregar').on('click', accionAgregarOferta);
    $('#btnModificar').on('click', accionModificarOferta);
    $('#btnEliminar').on('click', accionEliminarOferta);
};
function accionAgregarOferta() {
    $(location).attr('href', '/BuscaOfertas/jsp/RegistrarOferta.jsp');
}
function accionModificarOferta() {
    //debugger;
    if (true) {
        var objDatos = {
            idOferta: $('input[name = "oferta"]:checked').val()
        };

        console.log(objDatos);

        $.ajax({
            type: 'POST',
            url: '/BuscaOfertas/SeleccionOferta',
            //contentType:'application/json',
            data: (objDatos),
            //dataType:'json',
            success: function (data, textStatus, jqXHR) {
                alert(data.mensaje);
                if (data.codigo !== 0) {
                    $(location).attr('href', '/BuscaOfertas/jsp/ModificarOferta.jsp');
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
function accionEliminarOferta() {
    $(location).attr('href', '/BuscaOfertas/jsp/EliminarOferta.jsp');
}
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


	$(document).ready(function()
		{
		$("input[name=oferta]").click(function () {	 
			alert($('input:radio[name=oferta]:checked').val());
			
			});
		 });
