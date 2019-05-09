function cargarComboBoxCategorias() {
    //debugger;
    //alert("cargar combo box categorias");
    //cargarComboBoxCiudad();
    $.ajax({
        type: 'POST',
        url: '/BuscaOfertas/usus/consultarCategoria', //nombre url del servlet
        //contentType:'application/json',
        //data:(objDatos),
        //dataType:'json',
        success: function (data, textStatus, jqXHR) {
            if (data.codigo === -1) {
                alert("Error crítico: " + data.mensaje);
            } else if (data.codigo === 0) {
                alert("No hay datos para mostrar en categorías");
            } else if (data.codigo === 1) {
                //alert("Si hay datos: "+data.data);
                llenarComboBoxCategorias(data.data);
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('NO OK ' + JSON.stringify(jqXHR));
        }


    });
    function llenarComboBoxCategorias(datosComboBox) {
        //debugger;
        //var comboBox = $("#tablaDatos");
        var comboBox = document.getElementById("cbCategoria");
        //var tablita = $("table");

        for (var i = 0; i < datosComboBox.length; i++) {
            var item = datosComboBox[i];
            var opcion = document.createElement("option");
            opcion.setAttribute("value", item.idCategoria);
            opcion.setAttribute("label", item.nombreCategoria + " | " + item.categoriaPrincipal);

            comboBox.appendChild(opcion);
        }
    }
}