
const chessboard = document.querySelector(".chessboard")
let images = chessboard.getElementsByTagName("img");
const row = ["a", "b", "c", "d", "e", "f", "g", "h"]
const column = ["1", "2", "3", "4", "5", "6", "7", "8"]
const map = new Map()

console.log(images.length)

for(let i=images.length+1;i>=1;--i)
    if(i>i-row.length)
        map.set(images.item(i-1), row[0]+column[i%12])

console.log(map)


for(let i=0;i<images.length;++i){
    console.log(i)
    const tiles = images.item(i);
    tiles.addEventListener("click", function(){
        tiles.style.backgroundColor = "red"
    });
}
