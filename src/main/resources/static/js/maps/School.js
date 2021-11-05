schoolMap = new MapPath(false, 4564, "/images/maps/school.png", '100%', 25, 16.5, 121, 151);
schoolMap.setUpPaths = function() {
     //walls or borders of the map
     schoolMap.switchBlockedRange(3927, 3930);
     schoolMap.switchBlockedRange(3933, 3954);
     schoolMap.switchBlockedRangeVert(2128, 12, 83);
     schoolMap.switchBlockedRange(2648,2650);
     schoolMap.switchBlockedRangeVert(2734, 14, 83);
     schoolMap.switchBlockedRange(2380,2386);
     schoolMap.switchBlockedRange(2391,2395);
     schoolMap.switchBlockedRange(4239,4256);
     schoolMap.switchBlockedRangeVert(2413, 18, 83);
     schoolMap.switchBlockedRange(3079,3082);
     schoolMap.switchBlockedRange(2499,2513);
     schoolMap.switchBlockedRange(2441, 2455); 
     schoolMap.switchBlockedRangeVert(2374,7, 83);
     schoolMap.switchBlockedRangeVert(4008,2, 83);
     schoolMap.switchBlockedRangeVert(4008,2, 83); 
 
     //doorways 
     schoolMap.switchBlockedRange(3785, 3788);
     schoolMap.switchBlockedRange(3203, 3208);
     schoolMap.switchBlockedRangeVert(1769,8, 83);
     schoolMap.switchBlockedRangeVert(1610,11, 83);
     schoolMap.switchBlockedRange(1028, 1031);

     //green room bottom right 
     schoolMap.switchBlockedRangeVert(2295, 10, 83);
     schoolMap.switchBlockedRange(2969,2972);
     schoolMap.switchBlockedRangeVert(2562, 1, 83);
     schoolMap.switchBlockedRange(3643,3646);
     schoolMap.switchBlockedRange(3637,3641);
     schoolMap.switchBlockedRange(4218,4222);
     schoolMap.switchBlockedRangeVert(2640, 3, 83);
     schoolMap.switchBlockedRangeVert(3724, 3, 83);

     //bedroom top right 
     schoolMap.switchBlockedRange(873, 879); 
     schoolMap.switchBlockedRange(950,955);
     schoolMap.switchBlockedRange(1463, 1465); 
     schoolMap.switchBlockedRangeVert(1549,4, 83);
     schoolMap.switchBlockedRange(1954, 1964); 

     //art room main room 
     schoolMap.switchBlockedRange(3104, 3120); 
     schoolMap.switchBlockedRange(3774, 3775);
     schoolMap.switchBlockedRange(3780, 3781);
     schoolMap.switchBlocked(3784);

}


schoolMap.beforeGameLoopEvents = function() {
    document.querySelectorAll('[class*="npc-"]').forEach(element => {
        element.remove();
    });
    this.colonel = new NPC("3c842d11-cc82-4b6b-b213-69afbef7c99d", 30, 145, Array(40).fill("right").concat(Array(10).fill("up")).concat(Array(100).fill("right")).concat(Array(120).fill("down")), 0.5);
    PopulateNPCSpriteFromServer(this.colonel);
}

schoolMap.duringGameLoopEvents = function() {
    this.colonel.placeCharacter();   
    var schooldoor = document.querySelectorAll('.mapTileSize')[3764];
    if (detectCollision(character, schooldoor)) {
        currentMap = townMap;
        currentMap.beforeGameLoopEvents();
        currentMap.drawMap();
        currentMap.setUpPaths();
        x = 7;
        y = currentMap.getStartY();
    } 

    document.addEventListener("keydown", (e) => {
        if (e.code === 'Space') {
            if (this.colonel.characterDialogue.boxIsShowing()) {
                this.colonel.characterDialogue.hideDialogue();
            }
            else {
                if(detectCollision(this.colonel.character, character)) {
                    this.colonel.characterDialogue.showDialogue(this.colonel.dialogueTree.World[0]);
                }
            }
        };
    })
}

schoolMap.afterGameLoopEvents = function() {
}