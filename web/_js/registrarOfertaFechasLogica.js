function cargarFechas() {
    var fechaActual = new Date();
//Año
//alert(fechaActual);
    var anio = fechaActual.getFullYear();
//Mes
    var mes = fechaActual.getMonth() + 1;
//Día
    var dia = fechaActual.getDate();


    document.getElementById("txtFechaDeInicio").value = ""+anio + "-" + (mes<10? "0"+mes : mes) + "-" + dia;
    document.getElementById("txtFechaDeFinalizacion").value = ""+anio + "-" + (mes<10? "0"+mes : mes) + "-" + dia;
    document.getElementById("txtFechaDeInicio").min = ""+anio + "-" + (mes<10? "0"+mes : mes) + "-" + dia;
    document.getElementById("txtFechaDeFinalizacion").min = ""+anio + "-" + (mes<10? "0"+mes : mes) + "-" + dia;
}
;


