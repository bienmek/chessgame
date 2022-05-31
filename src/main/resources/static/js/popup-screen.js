



const signup = document.querySelector(".sign-up")
signup.addEventListener("click", function(){
    document.querySelector(".suc-content").style.display = "block"
    document.querySelector(".dark").style.display = "block"
    document.querySelector(".dark").style.opacity = "0.3"

})

const login = document.querySelector(".log-in")
login.addEventListener("click", function(){
    document.querySelector(".lic-content").style.display = "block"
    document.querySelector(".dark").style.display = "block"
    document.querySelector(".dark").style.opacity = "0.3"
})

const dark = document.querySelector(".dark")
dark.addEventListener("click", function(){
    document.querySelector(".suc-content").style.display = "none"
    document.querySelector(".lic-content").style.display = "none"
    document.querySelector(".dark").style.display = "none"

})

if(document.URL === "http://localhost:8080/profil"){
    document.querySelector(".suc-content").style.display = "block"
    document.querySelector(".dark").style.display = "block"
    document.querySelector(".dark").style.opacity = "0.3"
}

const rq = new XMLHttpRequest()
rq.open("GET", "http://localhost:8080/urq/page="+document.URL.p)
rq.send()