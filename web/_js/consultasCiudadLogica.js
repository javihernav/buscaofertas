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
            //opcion.setAttribute("style", "style='color: #000000; background: #FFEEEE;'");
            opcion.setAttribute("label", item.nombreCiudad + " | " + item.departamentoCiudad);
            opcion.innerHTML=""+item.nombreCiudad + " | " + item.departamentoCiudad;
            //var texto = document.createTextNode("<option value='"+item.idCiudad+"' label='"+item.nombreCiudad+"'></option>");
            //opcion.appendChild(document.createTextNode(texto));
            //comboBox.appendChild(opcion);
            comboBox.appendChild(opcion);
        }
    }
}
