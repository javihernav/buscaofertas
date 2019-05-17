window.onload = function () {
    console.log("btnAgregar: ");
    $('#btnAgregar').on('click', accionAgregarOferta);
    var botonesModificar = $('.btnModificar');

    asignarFuncionModificar();
    asignarFuncionEliminar();
};
function accionAgregarOferta() {
    $(location).attr('href', '/BuscaOfertas/jsp/RegistrarOferta.jsp');
}
function asignarFuncionEliminar() {
    console.log("asignarFuncionEliminar");
    var botonesEliminar = document.getElementsByClassName("btnEliminar");
    for (var i = 0; i < botonesEliminar.length; i++) {
        botonesEliminar[i].setAttribute('onclick', "accionEliminarOferta("+botonesEliminar[i].getAttribute('idoferta')+")");
    }
}
function asignarFuncionModificar() {
    console.log("asignarFuncionModificar");
    var botonesModificar = document.getElementsByClassName("btnModificar");
    for (var i = 0; i < botonesModificar.length; i++) {
        botonesModificar[i].setAttribute('onclick', "accionModificarOferta("+botonesModificar[i].getAttribute('idoferta')+")");
    }
}
//    $('#btnModificar').on('click', accionModificarOferta);
//    $('#btnEliminar')
function accionModificarOferta(idOfert) {
    //debugger;
    if (true) {
        var objDatos = {
            idOferta: idOfert
        };

        console.log(objDatos);

        $.ajax({
            type: 'POST',
            url: '/BuscaOfertas/jsp/ModificarOferta.jsp',

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
        alert("Los datos ingresados tienen errores o están incompletos!!!");
    }
}
function accionEliminarOferta(idOfert) {
    if (confirm('¿Estas seguro de eliminar esta oferta?')) {
        var objDatos2 = {
            idOferta: idOfert
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
//        alert("Los datos ingresados tienen errores o están incompletos!!!");
    }
}

