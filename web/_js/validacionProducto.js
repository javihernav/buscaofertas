function validarNombreProducto() {
    var retorno = 1;
    var nombres = document.getElementById("txtNombreProducto").value;
    expresion = /^[a-zA-Z áéíóúÁÉÍÓÚñÑ0-9'&!.]{0,45}$/;
    if (nombres === "") {
        document.getElementById("txtNombreProducto").style.borderColor = "#FF0000";
        document.getElementById("errorNombre").innerHTML = "El campo nombre no puede estar vacío! ";
        retorno = 0;
    } else if (nombres.length > 45) {
        document.getElementById("txtNombreProducto").style.borderColor = "#FF0000";
        document.getElementById("errorNombre").innerHTML = "El campo nombre no puede tener mas de 45 caracteres! ";
        retorno = 0;
    } else if (!expresion.test(nombres)) {
        document.getElementById("txtNombreProducto").style.borderColor = "#FF0000";
        document.getElementById("errorNombre").innerHTML = "Hay un caracter no válido en el nombre! ";
        retorno = 0;
    } else {
        document.getElementById("txtNombreProducto").style.borderColor = "#000000";
        document.getElementById("errorNombre").innerHTML = "";
    }
    return retorno === 1;
}

function validarCategoria() {
    var retorno = 1;

    var numCategoria = $('#cbCategoria option:selected').attr("value");
    console.log("categoria: " + numCategoria);
    if (numCategoria === "0") {
        document.getElementById("cbCategoria").style.borderColor = "#FF0000";
        document.getElementById("errorCategoria").innerHTML = "Debe seleccionar una categoria de la lista! ";
        retorno = 0;
    } else {
        document.getElementById("cbCategoria").style.borderColor = "#000000";
        document.getElementById("errorCategoria").innerHTML = "";
    }
    return retorno === 1;

}
function validarMarca() {
    var retorno = 1;
    var nombres = document.getElementById("txtMarca").value;
    expresion = /^[a-zA-Z áéíóúÁÉÍÓÚñÑ0-9'&!.]{0,45}$/;
    if (nombres === "") {
        document.getElementById("txtMarca").style.borderColor = "#FF0000";
        document.getElementById("errorMarca").innerHTML = "El campo marca no puede estar vacío! ";
        retorno = 0;
    } else if (nombres.length > 45) {
        document.getElementById("txtMarca").style.borderColor = "#FF0000";
        document.getElementById("errorMarca").innerHTML = "El campo marca no puede tener mas de 45 caracteres! ";
        retorno = 0;
    } else if (!expresion.test(nombres)) {
        document.getElementById("txtMarca").style.borderColor = "#FF0000";
        document.getElementById("errorMarca").innerHTML = "Hay un caracter no válido en la marca! ";
        retorno = 0;
    } else {
        document.getElementById("txtMarca").style.borderColor = "#000000";
        document.getElementById("errorMarca").innerHTML = "";
    }
    return retorno === 1;
}
function validarFormularioProducto(){
    if(validarNombreProducto()&&validarCategoria()&&validarMarca()){
        return true;
    }
    return false;
}