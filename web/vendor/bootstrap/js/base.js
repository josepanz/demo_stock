//funcion que nos muestra la pagina que deseamos ver dentro del html como un iframe
function toggleIfrm(href) {
    if (document.getElementById("frameid").src != href) {
        document.getElementById("frameid").src = href;
        //document.getElementById("iframe").style.visibility = "visible";
    } else {
        /*if (document.getElementById("iframe").style.visibility == "hidden") {*/
            document.getElementById("frameid").src = href;
            document.getElementById("iframe").style.visibility = "visible";
       /* } else {*/
            document.getElementById("iframe").style.visibility = "hidden";
            document.getElementById("frameid").src = "";
       // }
    }

}
/*function toggleMenu(id) {
    id.preventDefault();
    document.getElementById("toggleButton").innerHTML = "Mostrar";
    if (document.getElementById("toggleButton").innerHTML == "Ocultar") {
        document.getElementById("toggleButton").innerHTML = "Mostrar";
    } else {
        document.getElementById("toggleButton").innerHTML = "Ocultar";
    }
    document.getElementById("wrapper").toggleClass("toggled");    
}*/