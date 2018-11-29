function validarNombres(){
    var nombres=document.getElementById("txtNombres").value;
    expresion=/^[a-zA-Z áéíóúÁÉÍÓÚ]{0,45}$/;
    if(nombres===""){
        document.getElementById("txtNombres").style.borderColor="#FF0000"; return false; 
        return false;
    }else if(nombres.length>45){
        //alert("Solo se permiten nombres con longitud máxima de 35 caracteres!!!");
        document.getElementById("txtNombres").style.borderColor="#FF0000"; return false;
        return false;
    }else if(!expresion.test(nombres)){
        document.getElementById("txtNombres").style.borderColor="#FF0000"; return false; 
    }else{
        document.getElementById("txtNombres").style.borderColor="#000000"; return true; 
    }
}
function validarApellidos(){
    var apellidos=document.getElementById("txtApellidos").value;
    expresion=/^[a-zA-Z áéíóúÁÉÍÓÚ]{0,45}$/;
    if(apellidos===""){
        //alert("El campo apellidos esta vacio!!!");
        return false;
    }else if(apellidos.length>45){
        document.getElementById("txtApellidos").style.borderColor="#FF0000"; return false;
        //alert("Solo se permiten apellidos con longitud máxima de 35 caracteres!!!");
        return false;
    }else if(!expresion.test(apellidos)){
        document.getElementById("txtApellidos").style.borderColor="#FF0000"; return false; 
    }else{
        document.getElementById("txtApellidos").style.borderColor="#000000"; return true; 
    }
}
function validarTelefono(){
    var expresion= /^[1-9]{1}[0-9-]{0,19}$/;
    var documento=document.getElementById("txtTelefono").value;
    if(documento===""){
        //alert("El campo documento esta vacio!!!");
        return false;
    }else if(documento.length>20){
        //alert("Solo se permiten documentos con longitud máxima de 15 dígitos!!!");
        return false;
    }else if(!(expresion.test(documento))){
        document.getElementById("txtTelefono").style.borderColor="#FF0000"; return false; 
    }else if(isNaN(documento)){
        //alert("El documento debe tener solo dígitos!!!");
        return false;
    }else{
        document.getElementById("txtTelefono").style.borderColor="#000000"; return true; 
    }
}

function validarCorreo(){
    var expresion= /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/;
    var documento=document.getElementById("txtCorreo").value;
    if(documento===""){
        //alert("El campo documento esta vacio!!!");
        return false;
    }else if(documento.length>45){
        //alert("Solo se permiten correos con longitud máxima de 45 dígitos!!!");
        return false;
    }else if(!(expresion.test(documento))){
        document.getElementById("txtCorreo").style.borderColor="#FF0000"; return false; 
    }else{
        document.getElementById("txtCorreo").style.borderColor="#000000"; return true; 
    }
}
function validarFecha(){
    var expresion= /^[1-2]{1}[0-9]{3}-[0-1]{1}[0-9]{1}-[0-3]{1}[0-9]{1}$/;
    var documento=document.getElementById("txtFechaDeNacimiento").value;
    if(documento===""){
        //alert("El campo documento esta vacio!!!");
        return false;
    }else if(documento.length>45){
        //alert("Solo se permiten fechas con longitud máxima de 10 dígitos!!!");
        return false;
    }else if(!(expresion.test(documento))){
        document.getElementById("txtFechaDeNacimiento").style.borderColor="#FF0000"; return false; 
    }else if(!(validarFechaMenorActual(documento))){
        document.getElementById("txtFechaDeNacimiento").style.borderColor="#FF0000"; return false; 
    }else{
        document.getElementById("txtFechaDeNacimiento").style.borderColor="#000000"; return true; 
    }
}
function validarNombreUsuario(){
    var expresion= /^[a-zA-Z]{1}\w{0,44}$/;
    var documento=document.getElementById("txtUsuario").value;
    if(documento===""){
        //alert("El campo documento esta vacio!!!");
        return false;
    }else if(documento.length>45){
        //alert("Solo se permiten nombres de usuario con longitud máxima de 45 caracteres!!!");
        return false;
    }else if(!(expresion.test(documento))){
        document.getElementById("txtUsuario").style.borderColor="#FF0000"; return false; 
    }else{
        document.getElementById("txtUsuario").style.borderColor="#000000"; return true; 
    }
}
function validarGenero(){
    var expresion= /^[mf]{1}$/;
    //var documento=document.getElementById("cbGenero").value;
    var genero=$('#cbGenero option:selected').attr("value");
    if(genero!=="m"&&genero!=="f"){
        alert("El campo género esta sin seleccionar!!!");
        document.getElementById("cbGenero").style.borderColor="#FF0000"; return false; 
    }else if(!(expresion.test(genero))){
        alert("El campo género no cumple la regla!!!");
        document.getElementById("cbGenero").style.borderColor="#FF0000"; return false; 
    }else{
        document.getElementById("cbGenero").style.borderColor="#000000"; return true; 
    }
}

function validarPassword(){
    var expresion= /^\w{4,20}$/;
    var documento=document.getElementById("txtPassword").value;
    var documentoConf=document.getElementById("txtPasswordConfirmacion").value;
    if(documento===""||documentoConf===""){
        //alert("El campo documento esta vacio!!!");
        return false;
    }else if(documento.length>20||documentoConf.length>20){
        //alert("Solo se permiten passwords de usuario con longitud máxima de 20 caracteres!!!");
        return false;
    }else if(!(expresion.test(documento))){
        document.getElementById("txtPassword").style.borderColor="#FF0000"; return false; 
    
    }else if(!(expresion.test(documentoConf))){
        document.getElementById("txtPasswordConfirmacion").style.borderColor="#FF0000"; return false; 
    }else if(documento!==documentoConf){
        //alert("password no coincide");
        document.getElementById("txtPassword").style.borderColor="#FF0000";  
        document.getElementById("txtPasswordConfirmacion").style.borderColor="#FF0000"; return false; 
    }else{
        document.getElementById("txtPassword").style.borderColor="#000000";  
        document.getElementById("txtPasswordConfirmacion").style.borderColor="#000000"; return true; 
    }
}

function validarFechaMenorActual(date){
    var x=new Date();
    var fecha = date.split("-");
    x.setFullYear(fecha[0],fecha[1]-1,fecha[2]);
    var today = new Date();

    if (x >= today)
      return false;
    else
      return true;
}

function validarFormulario(){
    if(validarNombres()
            &&validarApellidos()&&
            validarTelefono()
            &&validarCorreo()
            &&validarFecha()
            &&validarNombreUsuario()
            &&validarGenero()
            &&validarPassword()){
        return true;
    }
    return false;
}
function validarUsuario(){
    var nombres=document.getElementById("txtUsuario").value;
    expresion=/^[a-zA-Z]{1}[a-zA-Z0-9]{0,44}$/;
    if(nombres===""){
        document.getElementById("txtUsuario").style.borderColor="#FF0000"; return false; 
        return false;
    }else if(nombres.length>45){
        //alert("Solo se permiten nombres con longitud máxima de 35 caracteres!!!");
        document.getElementById("txtUsuario").style.borderColor="#FF0000"; return false;
        return false;
    }else if(!expresion.test(nombres)){
        document.getElementById("txtUsuario").style.borderColor="#FF0000"; return false; 
    }else{
        document.getElementById("txtUsuario").style.borderColor="#000000"; return true; 
    }
}
function validarPasswd(){
    var expresion= /^\w{4,20}$/;
    var documento=document.getElementById("txtPassword").value;
    if(documento===""){
        //alert("El campo documento esta vacio!!!");
        return false;
    }else if(documento.length>20){
        //alert("Solo se permiten passwords de usuario con longitud máxima de 20 caracteres!!!");
        return false;
    }else if(!(expresion.test(documento))){
        document.getElementById("txtPassword").style.borderColor="#FF0000"; return false; 
    
    }else{
        document.getElementById("txtPassword").style.borderColor="#000000";  
        return true; 
    }
}


function validarFormularioLogin(){
    if(validarUsuario()&&validarPasswd()){
        return true;
    }
    return false;
}
function mostrarFecha(){
    alert(document.getElementById("txtFechaDeNacimiento").value);
}