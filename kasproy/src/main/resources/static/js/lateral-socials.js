window.onload = function () {
    let desplegar = document.getElementsByClassName("arrow")[0];
    desplegar.addEventListener("click", function () {
        if (document.getElementById("lateral-socials").classList.contains("hide-lateral-socials")) {
            document.getElementById("lateral-socials").classList.remove("hide-lateral-socials")
            document.getElementById("arrow-image").setAttribute("src", "/img/public/main/lateral-socials/arrow2.png")
        } else{

            document.getElementById("arrow-image").setAttribute("src", "/img/public/main/lateral-socials/arrow.png")
            document.getElementById("lateral-socials").classList.add("hide-lateral-socials")
        }
        
    });
    var video = document.querySelector('video');
    var source = document.querySelector('source');

    video.muted = true;
    video.play();
    video.loop = true;
}