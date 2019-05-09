function cargarFechaNacimiento() {
    console.log("cargarFechaNacimiento");
    var fechaActual = new Date();
    console.log("fecha actual: "+fechaActual);
    
//Año
//alert(fechaActual);
    var anio = fechaActual.getFullYear();
    console.log("año actual: "+anio);
//Mes
    var mes = fechaActual.getMonth() + 1;
    console.log("mes actual: "+mes);
//Día
    var dia = fechaActual.getDate();
    console.log("dia actual: "+dia);

var fechamaxima = ""+(anio-18) + "-" + (mes<10? "0"+mes : mes) + "-" + (dia<10? "0"+dia : dia);

    document.getElementById("txtFechaDeNacimiento").value = fechamaxima;
    console.log(document.getElementById("txtFechaDeNacimiento").value);
    document.getElementById("txtFechaDeNacimiento").max = fechamaxima;
    console.log("('txtFechaDeNacimiento').max: "+document.getElementById("txtFechaDeNacimiento").max);

};


