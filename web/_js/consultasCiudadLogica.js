function cargarComboBoxDatos() {
    $.ajax({
        type: 'POST',
        url: '/BuscaOfertas/usus/consultarCiudad',//nombre url del servlet
        //contentType:'application/json',
        //data:(objDatos),
        //dataType:'json',
        success: function (data, textStatus, jqXHR) {
            if (data.codigo === -1) {
                alert("Error crítico: " + data.mensaje);
            } else if (data.codigo === 0) {
                alert("No hay datos para mostrar");
            } else if (data.codigo === 1) {
                //alert("Si hay datos: "+data.data);
                llenarComboBox(data.data);
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('NO OK ' + JSON.stringify(jqXHR));
        }


    });
    function llenarComboBox(datosComboBox) {
        //debugger;
        //var comboBox = $("#tablaDatos");
        var comboBox = document.getElementById("cbCiudadUsuario");
        //var tablita = $("table");

        for (var i = 0; i < datosComboBox.length; i++) {
            var item = datosComboBox[i];
            var opcion = document.createElement("option");
            opcion.setAttribute("value", item.idCiudad);
            opcion.setAttribute("label", item.nombreCiudad + " | " + item.departamentoCiudad);

            comboBox.appendChild(opcion);
        }
    }
}
