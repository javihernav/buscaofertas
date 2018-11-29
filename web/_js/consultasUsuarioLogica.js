window.onload = function () {
    
    cargarTablaDatos();
    
}

function cargarTablaDatos() {
    $.ajax({
        type: 'POST',
        url: '/BuscaOfertas/usus/consultar',
        //contentType:'application/json',
        //data:(objDatos),
        //dataType:'json',
        success: function (data, textStatus, jqXHR) {
            if (data.codigo === -1) {
                alert("Error crítico: " + data.mensaje)
            } else if (data.codigo === 0) {
                alert("No hay datos para mostrar")
            } else if (data.codigo === 1) {
                llenarTabla(data.data);
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('NO OK ' + JSON.stringify(jqXHR));
        }


    });
    function llenarTabla(datosTabla) {
        //debugger;
        //var divTabla = $("#tablaDatos");
        var divTabla = document.getElementById("tablaDatos");
        //var tablita = $("table");
        var tablita = document.createElement("table");
        //for (var item in datosTabla) {
        for (var i=0;i<datosTabla.length;i++){
            var item = datosTabla[i]; 
            var trInterno = document.createElement("tr");
            
            var idUsuario = document.createElement("td");
            var Ciudad_idCiudad = document.createElement("td");
            var nombreUsuario = document.createElement("td");
            var contrasena = document.createElement("td");
            var nombre = document.createElement("td");
            var apellido = document.createElement("td");
            var telefono = document.createElement("td");
            var correo = document.createElement("td");
            var fechaNacimiento = document.createElement("td");
            var genero = document.createElement("td");
            var rol = document.createElement("td");
            idUsuario.innerHTML = item.idUsuario;
            Ciudad_idCiudad.innerHTML = item.Ciudad_idCiudad ;
            nombreUsuario.innerHTML = item.nombreUsuario ;
            contrasena.innerHTML = item.contrasena ;
            nombre.innerHTML = item.nombre ;
            apellido.innerHTML = item.apellido ;
            telefono.innerHTML = item.telefono ;
            correo.innerHTML = item.correo ;
            fechaNacimiento.innerHTML = item.fechaNacimiento ;
            genero.innerHTML = item.genero ;
            rol.innerHTML = item.correo ;
            trInterno.appendChild(idUsuario);
            trInterno.appendChild(Ciudad_idCiudad);
            trInterno.appendChild(nombreUsuario);
            trInterno.appendChild(contrasena);
            trInterno.appendChild(nombre);
            trInterno.appendChild(apellido);
            trInterno.appendChild(telefono);
            trInterno.appendChild(correo);
            trInterno.appendChild(fechaNacimiento);
            trInterno.appendChild(genero);
            trInterno.appendChild(rol);
            
            tablita.appendChild(trInterno);
            /* "idUsuario"
             "Ciudad_idCiudad"
             "nombreUsuario"
             "contrasena"
             "nombre"
             "apellido"
             "telefono"
             "correo"
             "fechaNacimiento"
             "genero"
             "rol"*/
        }
        divTabla.appendChild(tablita);
    }
}
