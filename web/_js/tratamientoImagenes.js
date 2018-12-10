function mostrarImagen(){
    var preview = document.querySelector('img');
    var file = document.querySelector('input[type=file]').files[0];
    var leer = new FileReader();
    if(file){
        leer.readAsDataURL(file);
        leer.onloadend=function(){
            preview.src=leer.result;
        };
    }
    else
    {
        preview.src="";
    }
}

