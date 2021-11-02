var character = document.querySelector(".character");
character.id = "playercharacter";
var bulbasaur  = new NPC("4981c8ec-1999-4938-892c-72c00d431090", 50, 90, ["right","right","right","right","right","right","right","right","right","right","right","right","right"], 2.0);

var map = document.querySelector(".map");
var pokeball = document.querySelector("#pokeball")
var currentMap = townMap; // Maps stored in external js files
var x = currentMap.getStartX();
var y = currentMap.getStartY();
var held_directions = []; //State of which arrow keys we are holding down
var speed = 2.5; //How fast the character moves in pixels per frame

/* Direction key state */
const directions = {
    up: "up",
    down: "down",
    left: "left",
    right: "right",
}

currentMap.setUpPaths();
currentMap.drawMap();
PopulateNPCSpriteFromServer(bulbasaur);

const placeCharacter = () => {

    var pixelSize = parseInt(
        getComputedStyle(document.documentElement).getPropertyValue('--pixel-size')
    );
    
    const held_direction = held_directions[0];
    if (held_direction) {
        currentMap.drawCharacterGrid(character);
        if (currentMap.isCharacterBlocked(character)) {
            currentMap.getAllBlocked(character).forEach(element => {
                if (betterCollision(element, character).left) {
                    x += 1;
                }
                if (betterCollision(element, character).right) {
                    x -= 1;
                }
                if (betterCollision(element, character).down) {
                    y -= 1;
                }
                if (betterCollision(element, character).up) {
                    y += 1;
                }
            });
        }
        else {
            if (held_direction === directions.right) {x += speed;}
            if (held_direction === directions.left) {x -= speed;}
            if (held_direction === directions.down) {y += speed;}
            if (held_direction === directions.up) {y -= speed;}
        }
    }
    character.setAttribute("facing", held_direction); 
    character.setAttribute("walking-left", "false");
    character.setAttribute("walking-right", "false");
    character.setAttribute("walking-up", "false");
    character.setAttribute("walking-down", "false");
    character.setAttribute("walking-"+held_direction, held_direction ? "true" : "false");

    var camera_left = pixelSize * 66;
    var camera_top = pixelSize * 42;
    map.style.transform = `translate3d( ${-x*pixelSize+camera_left}px, ${-y*pixelSize+camera_top}px, 0 )`;
    character.style.transform = `translate3d( ${x*pixelSize}px, ${y*pixelSize}px, 0 )`; 
}

//Set up the game loop
const step = () => {
    
    // Draw the character
    placeCharacter();
    bulbasaur.placeCharacter();
    
    var door = document.querySelectorAll('.mapTileSize')[1502];
    if (detectCollision(character, door)) {
        currentMap = houseMap;
        currentMap.drawMap();
        currentMap.setUpPaths();
        x = currentMap.getStartX();
        y = currentMap.getStartY();
    }

    // Restart the game loop
    window.requestAnimationFrame(() => {
        step();
    })
}
step(); //kick off the first step!




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