function validarNombres() {
    var retorno = 1;
    var nombres = document.getElementById("txtNombres").value;
    expresion = /^[a-zA-Z áéíóúÁÉÍÓÚñÑ]{0,45}$/;
    if (nombres === "") {
        document.getElementById("txtNombres").style.borderColor = "#FF0000";
        document.getElementById("errorNombres").innerHTML = "El campo nombres no puede estar vacío! ";
        retorno = 0;
    } else if (nombres.length > 45) {
        document.getElementById("txtNombres").style.borderColor = "#FF0000";
        document.getElementById("errorNombres").innerHTML = "El campo nombres no puede tener mas de 45 caracteres! ";
        retorno = 0;
    } else if (!expresion.test(nombres)) {
        document.getElementById("txtNombres").style.borderColor = "#FF0000";
        document.getElementById("errorNombres").innerHTML = "Solo se permiten letras mayúsculas o minúsculas con tildes y espacios! ";
        retorno = 0;
    } else {
        document.getElementById("txtNombres").style.borderColor = "#000000";
        document.getElementById("errorNombres").innerHTML = "";
    }

    return retorno === 1;
}
function validarApellidos() {
    var retorno = 1;
    var apellidos = document.getElementById("txtApellidos").value;
    expresion = /^[a-zA-Z áéíóúÁÉÍÓÚñÑ]{0,45}$/;
    if (apellidos === "") {
        document.getElementById("txtApellidos").style.borderColor = "#FF0000";
        document.getElementById("errorApellidos").innerHTML = "El campo apellidos no puede estar vacío! ";
        retorno = 0;
    } else if (apellidos.length > 45) {
        document.getElementById("txtApellidos").style.borderColor = "#FF0000";
        document.getElementById("errorApellidos").innerHTML = "El campo apellidos no puede tener mas de 45 caracteres! ";
        retorno = 0;
    } else if (!expresion.test(apellidos)) {
        document.getElementById("txtApellidos").style.borderColor = "#FF0000";
        document.getElementById("errorApellidos").innerHTML = "Solo se permiten letras mayúsculas o minúsculas con tildes y espacios";
        retorno = 0;
    } else {
        document.getElementById("txtApellidos").style.borderColor = "#000000";
        document.getElementById("errorApellidos").innerHTML = "";
    }


    return retorno === 1;
}
function validarTelefono() {
    var retorno = 1;
    var expresion = /^[1-9]{1}[0-9-]{0,19}$/;
    var telefono = document.getElementById("txtTelefono").value;
    if (telefono === "") {
        document.getElementById("txtTelefono").style.borderColor = "#FF0000";
        document.getElementById("errorTelefono").innerHTML = "El campo teléfono no puede estar vacío";
        retorno = 0;
    } else if (telefono.length > 20) {
        document.getElementById("txtTelefono").style.borderColor = "#FF0000";
        document.getElementById("errorTelefono").innerHTML = "Solo se permiten teléfonos con longitud máxima de 20 dígitos! ";
        retorno = 0;
    } else if (telefono.length < 7) {
        document.getElementById("txtTelefono").style.borderColor = "#FF0000";
        document.getElementById("errorTelefono").innerHTML = "El número de teléfono es demasiado corto! ";
        retorno = 0;
    } else if (!(expresion.test(telefono))) {
        document.getElementById("txtTelefono").style.borderColor = "#FF0000";
        document.getElementById("errorTelefono").innerHTML = "Digite un número de teléfono válido! ";
        retorno = 0;
    } else if (isNaN(telefono)) {
        document.getElementById("txtTelefono").style.borderColor = "#FF0000";
        document.getElementById("errorTelefono").innerHTML = "El número debe tener solo dígitos! ";
        retorno = 0;
    } else {
        document.getElementById("txtTelefono").style.borderColor = "#000000";
        document.getElementById("errorTelefono").innerHTML = "";
    }


    return retorno === 1;

}

function validarCorreo() {
    var retorno = 1;
    var expresion = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/;
    var correo = document.getElementById("txtCorreo").value;
    var correoConf = document.getElementById("txtConfirmarCorreo").value;
    if (correo === "") {
        document.getElementById("txtCorreo").style.borderColor = "#FF0000";
        document.getElementById("errorCorreo").innerHTML = "El campo correo esta vacío! ";
        retorno = 0;
    } else if (correo.length > 45) {
        document.getElementById("txtCorreo").style.borderColor = "#FF0000";
        document.getElementById("errorCorreo").innerHTML = "Solo se permiten correos con longitud máxima de 45 dígitos! ";
        retorno = 0;
    } else if (!(expresion.test(correo))) {
        document.getElementById("txtCorreo").style.borderColor = "#FF0000";
        document.getElementById("errorCorreo").innerHTML = "Debe ingresar un correo válido! ";
        retorno = 0;
    } else if (correo !== correoConf) {
        document.getElementById("txtCorreo").style.borderColor = "#FF0000";
        document.getElementById("txtConfirmarCorreo").style.borderColor = "#FF0000";
        document.getElementById("errorCorreo").innerHTML = "Los dos correos no coinciden! ";
        retorno = 0;
    } else {
        document.getElementById("txtCorreo").style.borderColor = "#000000";
        document.getElementById("txtConfirmarCorreo").style.borderColor = "#000000";
        document.getElementById("errorCorreo").innerHTML = "";
    }
    return retorno === 1;
}

function validarCorreoConf() {
    var retorno = 1;
    var expresion = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/;
    var correoConf = document.getElementById("txtConfirmarCorreo").value;
    var correo = document.getElementById("txtCorreo").value;
    if (correoConf === "") {
        document.getElementById("txtConfirmarCorreo").style.borderColor = "#FF0000";
        document.getElementById("errorCorreoConf").innerHTML = "El campo correo esta vacío! ";
        retorno = 0;
    } else if (correoConf.length > 45) {
        document.getElementById("txtConfirmarCorreo").style.borderColor = "#FF0000";
        document.getElementById("errorCorreoConf").innerHTML = "Solo se permiten correos con longitud máxima de 45 dígitos! ";
        retorno = 0;
    } else if (!(expresion.test(correoConf))) {
        document.getElementById("txtConfirmarCorreo").style.borderColor = "#FF0000";
        document.getElementById("errorCorreoConf").innerHTML = "Debe ingresar un correo válido! ";
        retorno = 0;
    } else if (correo !== correoConf) {
        document.getElementById("txtCorreo").style.borderColor = "#FF0000";
        document.getElementById("txtConfirmarCorreo").style.borderColor = "#FF0000";
        document.getElementById("errorCorreo").innerHTML = "Los dos correos no coinciden! ";
        retorno = 0;
    } else {
        document.getElementById("txtCorreo").style.borderColor = "#000000";
        document.getElementById("txtConfirmarCorreo").style.borderColor = "#000000";
        document.getElementById("errorCorreo").innerHTML = "";
    }
    return retorno === 1;
}

function validarFecha() {
    var retorno = 1;
    var expresion = /^[1-2]{1}[0-9]{3}-[0-1]{1}[0-9]{1}-[0-3]{1}[0-9]{1}$/;
    var fechaNacimiento = document.getElementById("txtFechaDeNacimiento").value;
    if (fechaNacimiento === "") {
        document.getElementById("txtFechaDeNacimiento").style.borderColor = "#FF0000";
        document.getElementById("errorFecha").innerHTML = "Debe seleccionar una fecha válida! ";
        retorno = 0;
    } else if (fechaNacimiento.length > 45) {
        document.getElementById("txtFechaDeNacimiento").style.borderColor = "#FF0000";
        document.getElementById("errorFecha").innerHTML = "Solo se permiten fechas con longitud máxima de 10 dígitos! ";
        retorno = 0;
    } else if (!(expresion.test(fechaNacimiento))) {
        document.getElementById("txtFechaDeNacimiento").style.borderColor = "#FF0000";
        document.getElementById("errorFecha").innerHTML = "Fecha no válida! ";
        retorno = 0;
    } else if (!(validarMayor18(fechaNacimiento))) {
        document.getElementById("txtFechaDeNacimiento").style.borderColor = "#FF0000";
        document.getElementById("errorFecha").innerHTML = "Debe ser mayor de 18 años para registrarse! ";
        retorno = 0;
    } else {
        document.getElementById("txtFechaDeNacimiento").style.borderColor = "#000000";
        document.getElementById("errorFecha").innerHTML = "";
    }
    return retorno === 1;

}
function validarMayor18(fechaNacimientoTxt) {
    var retorno = 1;
    var fechaNacimientoDate = new Date();
    var segmentos = fechaNacimientoTxt.split("-");
    fechaNacimientoDate.setFullYear(segmentos[0], segmentos[1] - 1, segmentos[2]);//convierte la fecha de nacimiento a date.
    var today = new Date();//obtiene fecha de hoy
    var fechaHace18 = new Date();
    fechaHace18.setFullYear(today.getFullYear() - 18, today.getMonth() + 1, today.getDate());
    if (fechaNacimientoDate >= fechaHace18)
        retorno = 0;
    else
        return retorno === 1;
}

function validarNombreUsuario() {
    var retorno = 1;
    var expresion = /^[a-zA-ZñÑÁÉÍÓÚáéíóú]{1,45}$/;
    var documento = document.getElementById("txtUsuario").value;
    if (documento === "") {
        //alert("El campo documento esta vacio!!! ");
        document.getElementById("txtUsuario").style.borderColor = "#FF0000";
        document.getElementById("errorUsuario").innerHTML = "Debe escribir un nombre de usuario! ";
        retorno = 0;
    } else if (documento.length > 45) {
        //alert("Solo se permiten nombres de usuario con longitud máxima de 45 caracteres!!! ");
        document.getElementById("txtUsuario").style.borderColor = "#FF0000";
        document.getElementById("errorUsuario").innerHTML = "No se permiten nombres de usuario mayores a 45 caracteres! ";
        retorno = 0;
    } else if (!(expresion.test(documento))) {
        document.getElementById("txtUsuario").style.borderColor = "#FF0000";
        document.getElementById("errorUsuario").innerHTML = "Solo se permiten letras, letras con tilde y sin espacios en el nombre de usuario! ";
        retorno = 0;
    } else {
        document.getElementById("txtUsuario").style.borderColor = "#000000";
        document.getElementById("errorUsuario").innerHTML = "";
    }

    return retorno === 1;

}
function validarCiudad() {

    var retorno = 1;

    var numCiudad = $('#cbCiudadUsuario option:selected').attr("value");
    console.log("ciudad: " + numCiudad);
    if (numCiudad === "0") {
        document.getElementById("cbCiudadUsuario").style.borderColor = "#FF0000";
        document.getElementById("errorCiudad").innerHTML = "Debe seleccionar una ciudad de la lista! ";
        retorno = 0;
    } else {
        document.getElementById("cbCiudadUsuario").style.borderColor = "#000000";
        document.getElementById("errorCiudad").innerHTML = "";
    }
    return retorno === 1;

}
function validarGenero() {
    var retorno = 1;

    var genero = $('#cbGenero option:selected').attr("value");
    console.log("genero: " + genero);
    if (genero !== "m" && genero !== "f") {
        document.getElementById("cbGenero").style.borderColor = "#FF0000";
        document.getElementById("errorGenero").innerHTML = "Debe seleccionar un género de la lista! ";
        retorno = 0;
    } else {
        document.getElementById("cbGenero").style.borderColor = "#000000";
        document.getElementById("errorGenero").innerHTML = "";
    }
    return retorno === 1;

}

function validarPassword() {
    var retorno = 1;
    //var expresion = /^\w{4,20}$/;
    var longitudMinima = 4;
    var documento = document.getElementById("txtPassword").value;
    var documentoConf = document.getElementById("txtPasswordConfirmacion").value;
    if (documento.length < longitudMinima) {
        document.getElementById("txtPassword").style.borderColor = "#FF0000";
        document.getElementById("errorPassword").innerHTML = "El password debe medir mínimo " + longitudMinima + " caracteres";
        retorno = 0;
    } else if (documentoConf.length < longitudMinima) {
        document.getElementById("txtPasswordConfirmacion").style.borderColor = "#FF0000";
        document.getElementById("errorPassword2").innerHTML = "El password debe medir mínimo " + longitudMinima + " caracteres";
        retorno = 0;
    } else if (documento === "") {
        //alert("El campo documento esta vacio!!! ");
        document.getElementById("txtPassword").style.borderColor = "#FF0000";
        document.getElementById("errorPassword").innerHTML = "Debe especificar un password! ";
        retorno = 0;
    } else if (documentoConf === "") {
        //alert("El campo documento esta vacio!!! ");
        document.getElementById("txtPasswordConfirmacion").style.borderColor = "#FF0000";
        document.getElementById("errorPassword2").innerHTML = "Debe especificar un password! ";
        retorno = 0;
    } else if (documento.length > 20 || documentoConf.length > 20) {
        document.getElementById("txtPassword").style.borderColor = "#FF0000";
        document.getElementById("errorPassword").innerHTML = "El password no puede superar los 20 caracteres! ";
        //alert("Solo se permiten passwords de usuario con longitud máxima de 20 caracteres!!! ");
        retorno = 0;
    } else if (documentoConf.length > 20) {
        document.getElementById("txtPasswordConfirmacion").style.borderColor = "#FF0000";
        document.getElementById("errorPassword2").innerHTML = "El password no puede superar los 20 caracteres! ";
        //alert("Solo se permiten passwords de usuario con longitud máxima de 20 caracteres!!! ");
        retorno = 0;
    } else if (documento !== documentoConf) {
        //alert("password no coincide");
        document.getElementById("txtPassword").style.borderColor = "#FF0000";
        document.getElementById("txtPasswordConfirmacion").style.borderColor = "#FF0000";
        document.getElementById("errorPassword").innerHTML = "El password y su confirmación no coinciden! ";
        retorno = 0;
    } else {
        document.getElementById("txtPassword").style.borderColor = "#000000";
        document.getElementById("txtPasswordConfirmacion").style.borderColor = "#000000";
        document.getElementById("errorPassword").innerHTML = "";
        document.getElementById("errorPassword2").innerHTML = "";
    }
    return retorno === 1;

}



function validarFormularioPerfil() {
    var retorno = 1;
    if (validarNombres()
            && validarApellidos()
            && validarTelefono()
            && validarCorreo()
            && validarFecha()
            && validarCiudad()
            && validarNombreUsuario()
            && validarGenero()
            && validarPassword()) {
        return retorno === 1;
    }
    retorno = 0;
}
function validarUsuario() {
    var retorno = 1;
    var nombres = document.getElementById("txtUsuario").value;
    expresion = /^[a-zA-ZñÑ]{1}[a-zA-ZñÑ0-9]{0,44}$/;
    if (nombres === "") {
        document.getElementById("txtUsuario").style.borderColor = "#FF0000";
        document.getElementById("errorUsuario").innerHTML = "El nombre de usuario es obligatorio! ";
        retorno = 0;

    } else if (nombres.length > 45) {
        //alert("Solo se permiten nombres con longitud máxima de 35 caracteres!!! ");
        document.getElementById("txtUsuario").style.borderColor = "#FF0000";
        document.getElementById("errorUsuario").innerHTML = "El nombre de usuario no debe tener mas de 45 caracteres! ";
        retorno = 0;
    } else if (!expresion.test(nombres)) {
        document.getElementById("txtUsuario").style.borderColor = "#FF0000";
        document.getElementById("errorUsuario").innerHTML = "El nombre de usuario no puede comenzar con número ni incluir tildes! ";
        retorno = 0;
    } else {
        document.getElementById("txtUsuario").style.borderColor = "#000000";
        document.getElementById("errorUsuario").innerHTML = "";
        return retorno === 1;
    }
}
function validarPasswd() {
    var retorno = 1;
    var expresion = /^\w{4,20}$/;
    var documento = document.getElementById("txtPassword").value;
    if (documento === "") {
        document.getElementById("txtPassword").style.borderColor = "#FF0000";
        document.getElementById("errorPassword").innerHTML = "El password es obligatorio! ";
        retorno = 0;
    } else if (documento.length > 20) {
        //alert("Solo se permiten passwords de usuario con longitud máxima de 20 caracteres!!! ");
        document.getElementById("txtPassword").style.borderColor = "#FF0000";
        document.getElementById("errorPassword").innerHTML = "El password no debe tener mas de 20 caracteres! ";
        retorno = 0;
    } else if (!(expresion.test(documento))) {
        document.getElementById("txtPassword").style.borderColor = "#FF0000";
        document.getElementById("errorPassword").innerHTML = "el pasword debe medir al menos 4 caracteres! ";
        retorno = 0;

    } else {
        document.getElementById("txtPassword").style.borderColor = "#000000";
        document.getElementById("errorPassword").innerHTML = "";
        return retorno === 1;
    }
}


function validarFormularioLogin() {
    var retorno = 1;
    if (validarUsuario() && validarPasswd()) {
    } else {
        retorno = 0;
    }
    return retorno === 1;
}
function mostrarFecha() {
    var retorno = 1;
    alert(document.getElementById("txtFechaDeNacimiento").value);
}
// Vaidaciones para registrar oferta
function validarProducto() {
    var retorno = 1;
    return retorno === 1;
}
function validarCategoria() {
    var retorno = 1;
    return retorno === 1;
}
function validarMarca() {
    var retorno = 1;
    return retorno === 1;
}
function validarCiudadOferta() {
    var retorno = 1;
    return retorno === 1;
}
function validarNombreTienda() {
    var retorno = 1;
    return retorno === 1;
}
function validarDireccionTienda() {
    var retorno = 1;
    return retorno === 1;
}
function validarImagen() {
    var retorno = 1;
    return retorno === 1;
}
function validarNombreOferta() {
    var retorno = 1;
    return retorno === 1;
}
function validarPrecioDeOferta() {
    var retorno = 1;
    return retorno === 1;
}
function validarFechaInicio() {
    var retorno = 1;
    return retorno === 1;
}
function validarFechaFinalizacion() {
    var retorno = 1;
    return retorno === 1;
}
