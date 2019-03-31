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
    if (confirm('¿Estas seguro de eliminar esta oferta?')) {
        var objDatos2 = {
            idOferta: $('input[name = "oferta"]:checked').val()
        };

        console.log(objDatos2);

        $.ajax({
            type: 'POST',
            url: '/BuscaOfertas/EliminarOferta',
            //contentType:'application/json',
            data: (objDatos2),
            //dataType:'json',
            success: function (data, textStatus, jqXHR) {
                alert(data.mensaje);
                if (data.codigo !== 0) {
                    $(location).attr('href', '/BuscaOfertas/jsp/GestionarOfertas.jsp');
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert('Fallo al eliminar oferta ' + JSON.stringify(jqXHR));
            }


        });
    } else {
        alert("Los datos en el formulario son erroneos!!!");
    }
}


/*
	$(document).ready(function()
		{
		$("input[name=oferta]").click(function () {	 
			alert($('input:radio[name=oferta]:checked').val());
			
			});
		 });
*/