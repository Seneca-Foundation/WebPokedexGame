var character = document.querySelector(".character");
var map = document.querySelector(".map");
var pokeball = document.querySelector("#pokeball")

//start in the middle of the map
var x = 21;
var y = 101;
var held_directions = []; //State of which arrow keys we are holding down
var speed = 2.5; //How fast the character moves in pixels per frame

mapPath = new MapPath(false, 4233);
mapPath.switchBlockedRange(1414, 1443);
mapPath.switchBlockedRange(1331, 1360);
mapPath.switchBlockedRange(1494, 1496);
mapPath.switchBlockedRange(1577, 1579);
mapPath.switchBlockedRange(1660, 1662);
mapPath.switchBlockedRange(1743, 1745);
mapPath.switchBlockedRange(1826, 1828);
mapPath.switchBlockedRange(1909, 1911);
mapPath.switchBlockedRange(1992, 1994);
mapPath.switchBlockedRange(2075, 2077);
mapPath.switchBlockedRange(2161, 2187);
mapPath.switchBlockedRange(2244, 2270);

mapPath.switchBlockedRange(2188, 2190);
mapPath.switchBlockedRange(2271, 2273);
mapPath.switchBlockedRange(2354, 2356);
mapPath.switchBlockedRange(2437, 2439);
mapPath.switchBlockedRange(2520, 2522);
mapPath.switchBlockedRange(2603, 2605);
mapPath.switchBlockedRange(2686, 2688);
mapPath.switchBlockedRange(2769, 2771);

mapPath.switchBlockedRange(2029, 2042);
mapPath.switchBlockedRange(2112, 2125);
mapPath.switchBlockedRange(2195, 2208);
mapPath.switchBlockedRange(2278, 2291);
mapPath.switchBlockedRange(2361, 2374);
mapPath.switchBlockedRange(2444, 2457);
mapPath.switchBlockedRange(2527, 2540);

mapPath.switchBlockedRange(2852, 2854);
mapPath.switchBlockedRange(2935, 2937);
mapPath.switchBlockedRange(3019, 3020);
mapPath.switchBlockedRange(3102, 3103);
mapPath.switchBlockedRange(1278, 1286);

mapPath.switchBlockedRange(3185, 3195);
mapPath.switchBlockedRange(3249, 3278);
mapPath.switchBlockedRange(3913, 3978);

mapPath.switchBlockedRange(3200, 3236);
mapPath.switchBlockedRange(3283, 3319);

mapPath.switchBlockedRange(627, 636);
mapPath.switchBlockedRange(1291, 1299);

mapPath.switchBlockedRangeVert(41, 14, 83);
mapPath.switchBlockedRangeVert(46, 6, 83);
mapPath.switchBlockedRangeVert(719, 14, 83);

mapPath.switchBlockedRange(2545, 2565);
mapPath.switchBlockedRange(1882, 1899);

mapPath.switchBlockedRangeVert(1900, 7, 83);
mapPath.switchBlockedRangeVert(2628, 6, 83);
mapPath.switchBlockedRangeVert(3248, 8, 83)
mapPath.switchBlockedRangeVert(3398, 7, 83)




const placeCharacter = () => {

    var pixelSize = parseInt(
        getComputedStyle(document.documentElement).getPropertyValue('--pixel-size')
    );
    
    const held_direction = held_directions[0];
    if (held_direction) {
        if (held_direction === directions.right) {x += speed;}
        if (held_direction === directions.left) {x -= speed;}
        if (held_direction === directions.down) {y += speed;}
        if (held_direction === directions.up) {y -= speed;}
        character.setAttribute("facing", held_direction);
    }
    character.setAttribute("walking-left", "false");
    character.setAttribute("walking-right", "false");
    character.setAttribute("walking-up", "false");
    character.setAttribute("walking-down", "false");
    character.setAttribute("walking-"+held_direction, held_direction ? "true" : "false");
    
    var camera_left = pixelSize * 66;
    var camera_top = pixelSize * 42;

    if (mapPath.isCharacterBlocked(character)) {
        var revertMovement = false;
        mapPath.getAllBlocked().forEach(element => {
            if (detectCollision(element, character)) {
                revertMovement = true;
            }
        });
        if (revertMovement) {
            if (held_direction === directions.right) {x = x-3;} //-2
            if (held_direction === directions.left) {x = x+3;} //+2
            if (held_direction === directions.down) {y = y-3;} //-2
            if (held_direction === directions.up) {y = y+3;} //+2
            held_directions = [];
        }
    }

    map.style.transform = `translate3d( ${-x*pixelSize+camera_left}px, ${-y*pixelSize+camera_top}px, 0 )`;
    character.style.transform = `translate3d( ${x*pixelSize}px, ${y*pixelSize}px, 0 )`;  
    mapPath.drawCharacterGrid(character);
}


//Set up the game loop
const step = () => {
    
    // Draw the character
    placeCharacter();
    
    // A rudimentary example of collision detection
    if (detectCollision(character, pokeball)) {
        console.log("You found the pokeball!");
        document.getElementById("pokeball").style.display = "none";
        pokeballDialogue = new DialogueBox("url", "meow");
        pokeballDialogue.showDialogue("holy sh*t yall, I found a pokeball!");
    };

    var door = document.querySelectorAll('.mapTileSize')[1502];
    if (detectCollision(character, door)) {
        console.log("entered the door");
    }

    // Restart the game loop
    window.requestAnimationFrame(() => {
        step();
    })
}
step(); //kick off the first step!



/* Direction key state */
const directions = {
    up: "up",
    down: "down",
    left: "left",
    right: "right",
}

const keys = {
    38: directions.up,
    37: directions.left,
    39: directions.right,
    40: directions.down,
}

document.addEventListener("keydown", (e) => {
    var dir = keys[e.which];
    if (dir && held_directions.indexOf(dir) === -1) {
        held_directions.unshift(dir)
    }
})

document.addEventListener("keyup", (e) => {
    var dir = keys[e.which];
    var index = held_directions.indexOf(dir);
    if (index > -1) {
        held_directions.splice(index, 1)
    }
});

/* BONUS! Dpad functionality for mouse and touch */
var isPressed = false;
const removePressedAll = () => {
    document.querySelectorAll(".dpad-button").forEach(d => {
        d.classList.remove("pressed")
    })
}

document.body.addEventListener("mousedown", () => {
    console.log('mouse is down')
    isPressed = true;
})

document.body.addEventListener("mouseup", () => {
    console.log('mouse is up')
    isPressed = false;
    held_directions = [];
    removePressedAll();
})

const handleDpadPress = (direction, click) => {   
    if (click) {
        isPressed = true;
    }
    held_directions = (isPressed) ? [direction] : []
    
    if (isPressed) {
        removePressedAll();
        document.querySelector(".dpad-"+direction).classList.add("pressed");
    }
}

//Bind a ton of events for the dpad
document.querySelector(".dpad-left").addEventListener("touchstart", (e) => handleDpadPress(directions.left, true));
document.querySelector(".dpad-up").addEventListener("touchstart", (e) => handleDpadPress(directions.up, true));
document.querySelector(".dpad-right").addEventListener("touchstart", (e) => handleDpadPress(directions.right, true));
document.querySelector(".dpad-down").addEventListener("touchstart", (e) => handleDpadPress(directions.down, true));

document.querySelector(".dpad-left").addEventListener("mousedown", (e) => handleDpadPress(directions.left, true));
document.querySelector(".dpad-up").addEventListener("mousedown", (e) => handleDpadPress(directions.up, true));
document.querySelector(".dpad-right").addEventListener("mousedown", (e) => handleDpadPress(directions.right, true));
document.querySelector(".dpad-down").addEventListener("mousedown", (e) => handleDpadPress(directions.down, true));

document.querySelector(".dpad-left").addEventListener("mouseover", (e) => handleDpadPress(directions.left));
document.querySelector(".dpad-up").addEventListener("mouseover", (e) => handleDpadPress(directions.up));
document.querySelector(".dpad-right").addEventListener("mouseover", (e) => handleDpadPress(directions.right));
document.querySelector(".dpad-down").addEventListener("mouseover", (e) => handleDpadPress(directions.down));