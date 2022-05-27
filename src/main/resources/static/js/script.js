const row = ["1", "2", "3", "4", "5", "6", "7", "8"]
const column = ["a", "b", "c", "d", "e", "f", "g", "h"]
const chessboard = document.querySelector(".chessboard");
const tiles = chessboard.children
const map = new Map()

let toDisplay =""
let color = ""
let j =0, h=7

for(let i=0;i<tiles.length;++i) {
    map.set(tiles.item(i), column[j+(i%8)] + row[h])
    if(j+(i%8) === 7 )
        h--
}

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
        console.log(color)
        if(color === "white"){
            item.style.color = "black";
        }else{
            item.style.color = "white";
        }
    });
}


