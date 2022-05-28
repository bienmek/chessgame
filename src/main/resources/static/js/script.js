const row = ["1", "2", "3", "4", "5", "6", "7", "8"]
const column = ["a", "b", "c", "d", "e", "f", "g", "h"]
const chessboard = document.querySelector(".chessboard");
const tiles = chessboard.children
const map = new Map()
let toDisplay =""
let color = ""
let j =0, h=7

/*
Handle the tiles mapping
 */
for(let i=0;i<tiles.length;++i) {
    map.set(tiles.item(i), column[j+(i%8)] + row[h])
    if(j+(i%8) === 7 )
        h--
}




function getId(tile) {
    for(let i=0;i<tiles.length;++i) {
        const ctile = tiles.item(i);
        if(tile === ctile) return i
        if (ctile.hasChildNodes()) {
            const img = ctile.children.item(0)
            if(tile === img) return i
        }
    }
}

getAllImg()

function getAllImg(){
    let out = "";
    for(let i=0;i<tiles.length;++i) {
        const ctile = tiles.item(i);
        if (ctile.hasChildNodes()) {
            out+= i + '.'
        }
    }
    const rq = new XMLHttpRequest()
    rq.open("GET", "http://localhost:8080/rq/init?piecesCoord="+out)
    rq.send()
}

/*
Handle the pieces movement
 */

let dest = null
let origin = null
for(let i=0;i<tiles.length;++i){
    const ctile = tiles.item(i);
    if (ctile.hasChildNodes()) {
        const img = ctile.children.item(0)
        img.addEventListener("click", function OnclickImages() {

            if(dest != null)
                for (let i = 0; i < dest.length; ++i) {
                    tiles.item(dest[i]).style.removeProperty("background")
                    tiles.item(dest[i]).style.removeProperty("cursor")
                    tiles.item(dest[i]).removeEventListener("click", this)
                }

            if(origin != null)
                tiles.item(origin).removeEventListener("click", this)

            const xhttp = new XMLHttpRequest();
            xhttp.open("GET", "http://localhost:8080/rq/plm?origin=" + getId(img))
            xhttp.send()
            xhttp.onload = function () {
                dest = xhttp.responseText.split('.')
                origin = xhttp.responseText.split('/')[1]

                for (let i = 0; i < dest.length; ++i) {
                    const target = tiles.item(dest[i])

                    target.style.cursor = "pointer"

                    if (target.getAttribute("class") === "white-case") {
                        target.style.background = "rgb(161,161,161)";
                        target.style.background = "radial-gradient(circle, rgba(161,161,161,1) 24%, rgba(255,255,255,1) 25%, rgba(255,255,255,1) 100%)";
                    } else if (target.getAttribute("class") === "black-case") {
                        target.style.background = "rgb(161,161,161)";
                        target.style.background = "radial-gradient(circle, rgba(161,161,161,1) 24%, rgba(28,40,65,1) 25%, rgba(28,40,65,1) 100%)";
                    }

                    target.addEventListener("click", function OnclickTiles() {
                        const buff = tiles.item(origin).children
                        const img = buff.item(0)
                        if(img != null){
                            img.remove()
                            const rq = new XMLHttpRequest();
                            rq.open("GET", "http://localhost:8080/rq/mvt?dest=" + getId(target))
                            rq.send()
                            for (let i = 0; i < dest.length; ++i) {
                                tiles.item(dest[i]).style.removeProperty("background")
                                tiles.item(dest[i]).style.removeProperty("cursor")
                                tiles.item(dest[i]).removeEventListener("click", this)
                            }
                            target.appendChild(img)
                        }
                    })
                }
            }
        })
    }
}

/*
Handle the mapping pieces/coordinates
 */
for(let i=0;i<tiles.length;++i){
    const ctile = tiles.item(i);
    ctile.addEventListener("click", function(){
        if(ctile.hasChildNodes()) {
            const buff = ctile.children
            for (let i = 0; i < buff.length; ++i)
                if (buff.item(i).children.length > 0) {
                    const img = buff.item(i).children.item(0)
                    const attr = img.getAttribute("src")
                    const letter = attr.split('/')[3].split('.')[0].split('')[0].toUpperCase()
                    const name = attr.split('/')[3].split('.')[0]
                    color = attr.split('/')[2]
                    if(!(letter === "P")){
                        toDisplay = letter + map.get(ctile)
                        if(name === "knight")
                            toDisplay = "N" + map.get(ctile)
                    }
                    else
                        toDisplay = map.get(ctile)
                }
        }else {
            toDisplay = map.get(ctile)
            color = "#111827"
        }
        const item = document.querySelector(".dynamic")
        item.innerHTML = toDisplay
        item.style.backgroundColor = color
        if(color === "white")
            item.style.color = "black";
        else
            item.style.color = "white";
    });
}




