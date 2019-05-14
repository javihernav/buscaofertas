function cargarComboBoxProducto() {

    $.ajax({
        type: 'POST',
        url: '/BuscaOfertas/usus/consultarProductos', //nombre url del servlet
        //contentType:'application/json',
        //data:(objDatos),
        //dataType:'json',
        success: function (data, textStatus, jqXHR) {
            if (data.codigo === -1) {
                alert("Error crítico: " + data.mensaje);
            } else if (data.codigo === 0) {
                alert("No hay datos de productos para mostrar");
            } else if (data.codigo === 1) {
                //alert("Si hay datos: "+data.data);
                llenarComboBoxProductos(data.data);
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('NO OK ' + JSON.stringify(jqXHR));
        }


    });
    function llenarComboBoxProductos(datosComboBox) {
        //debugger;
        //var comboBox = $("#tablaDatos");
        var comboBox = document.getElementById("cbProducto");
        //var tablita = $("table");

        for (var i = 0; i < datosComboBox.length; i++) {
            var item = datosComboBox[i];
            var opcion = document.createElement("option");
            opcion.setAttribute("value", item.idProducto);
            //opcion.setAttribute("style", "style='color: #000; background: #fff;'");
            opcion.setAttribute("label", item.nombreProducto);
            opcion.innerHTML = "" + item.nombreProducto;
            comboBox.appendChild(opcion);
        }
    }
}
