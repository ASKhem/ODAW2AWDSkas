window.onload = function () {
    let desplegar = document.getElementById("hamburguer-menu");
    let contenedor = document.getElementById("fondo-menu-desplegable");
    desplegar.addEventListener("click", function () {
        if (document.getElementById("lateral-socials").classList.contains("hide-lateral-socials")) {
            document.getElementById("lateral-socials").classList.remove("hide-lateral-socials")
        } else{
            document.getElementById("lateral-socials").classList.add("hide-lateral-socials")
        }
    });

    contenedor.addEventListener("mouseenter", function () {
        document.getElementById("lateral-socials").classList.add("hide-lateral-socials");
    });
}