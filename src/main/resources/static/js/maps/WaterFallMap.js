waterFallMap = new MapPath(false, 6000, "/images/maps/waterfallmap.png", '100%', 30, 17.55, 240, 260);
waterFallMap.setUpPaths = function() {


    waterFallMap.switchBlocked(5787);
    waterFallMap.switchBlocked(1965);
    waterFallMap.switchBlocked(3489);
    waterFallMap.switchBlocked(2289);
    waterFallMap.switchBlocked(2190);
    waterFallMap.switchBlocked(3863);
    waterFallMap.switchBlocked(1324);
    waterFallMap.switchBlocked(1125);
    waterFallMap.switchBlocked(4339);
    waterFallMap.switchBlocked(5020);
    waterFallMap.switchBlocked(5727);
    waterFallMap.switchBlocked(2288);



    waterFallMap.switchBlockedRangeVert(4129, 8, 100);
    waterFallMap.switchBlockedRangeVert(4636, 4, 100);
    waterFallMap.switchBlockedRangeVert(3346, 16, 100);
    waterFallMap.switchBlockedRangeVert(3555, 15, 100);
    waterFallMap.switchBlockedRangeVert(3326, 8, 100);
    waterFallMap.switchBlockedRangeVert(1434, 9, 100);
    waterFallMap.switchBlockedRangeVert(4919, 8, 100);
    waterFallMap.switchBlockedRangeVert(5096, 7, 100);
    waterFallMap.switchBlockedRangeVert(1566, 3,100);
    waterFallMap.switchBlockedRangeVert(1965,1,100);
    waterFallMap.switchBlockedRangeVert(1590,3,100);
    waterFallMap.switchBlockedRangeVert(2999,6,100);
    waterFallMap.switchBlockedRangeVert(3881,3,100);
    waterFallMap.switchBlockedRangeVert(3980,2,100);
    waterFallMap.switchBlockedRangeVert(3472,3,100);
    waterFallMap.switchBlockedRangeVert(3473,3,100);
    waterFallMap.switchBlockedRangeVert(2300,8,100);
    waterFallMap.switchBlockedRangeVert(1567,3,100);
    waterFallMap.switchBlockedRangeVert(1093,5,100);
    waterFallMap.switchBlockedRangeVert(1084,2,100);
    waterFallMap.switchBlockedRangeVert(590,3,100);
    waterFallMap.switchBlockedRangeVert(267, 12,100);
    waterFallMap.switchBlockedRangeVert(1893,4,100);
    waterFallMap.switchBlockedRangeVert(4172,2,100);
    waterFallMap.switchBlockedRangeVert(4673,7,100);
    waterFallMap.switchBlockedRangeVert(4871,3,100);
    waterFallMap.switchBlockedRangeVert(4756,3,100);
    waterFallMap.switchBlockedRangeVert(5163,2,100);
    waterFallMap.switchBlockedRangeVert(3859, 2, 100);
    waterFallMap.switchBlockedRangeVert(1192,3,100);
    waterFallMap.switchBlockedRangeVert(872,4,100);
    waterFallMap.switchBlockedRangeVert(389,3,100); 
    waterFallMap.switchBlockedRangeVert(2018,3,100);
    waterFallMap.switchBlockedRangeVert(1022,12,100);
    waterFallMap.switchBlockedRangeVert(1926,4,100);
    waterFallMap.switchBlockedRangeVert(5388, 4, 100);
    waterFallMap.switchBlockedRangeVert(3440, 12, 100);
    waterFallMap.switchBlockedRangeVert(3638, 2, 100)



    



    
    waterFallMap.switchBlockedRange(5037, 5046);
    waterFallMap.switchBlockedRange(3447, 3455);
    waterFallMap.switchBlockedRange(4456, 4462);
    waterFallMap.switchBlockedRange(4556, 4562);
    waterFallMap.switchBlockedRange(4926, 4928);
    waterFallMap.switchBlockedRange(5359, 5361);
    waterFallMap.switchBlockedRange(3236, 3247);
    waterFallMap.switchBlockedRange(3254, 3264);
    waterFallMap.switchBlockedRange(3200, 3228);
    waterFallMap.switchBlockedRange(2418, 2426);
    waterFallMap.switchBlockedRange(2335, 2343);
    waterFallMap.switchBlockedRange(5720, 5726);
    waterFallMap.switchBlockedRange(5730, 5734);
    waterFallMap.switchBlockedRange(5935, 5985);
    waterFallMap.switchBlockedRange(5888, 5895);
    waterFallMap.switchBlockedRange(5174, 5186);
    waterFallMap.switchBlockedRange(5191, 5195);
    waterFallMap.switchBlockedRange(2363, 2372);
    waterFallMap.switchBlockedRange(3271, 3280);
    waterFallMap.switchBlockedRange(1379, 1383);
    waterFallMap.switchBlockedRange(1372, 1375);
    waterFallMap.switchBlockedRange(1463, 1466);
    waterFallMap.switchBlockedRange(2061, 2064);
    waterFallMap.switchBlockedRange(2479, 2488);
    waterFallMap.switchBlockedRange(2886, 2899); 
    waterFallMap.switchBlockedRange(3681, 3699);
    waterFallMap.switchBlockedRange(3588, 3590);
    waterFallMap.switchBlockedRange(2148, 2161);
    waterFallMap.switchBlockedRange(2301, 2310);
    waterFallMap.switchBlockedRange(2244, 2247);
    waterFallMap.switchBlockedRange(990, 993);
    waterFallMap.switchBlockedRange(268, 288);
    waterFallMap.switchBlockedRange(3874, 3880);
    waterFallMap.switchBlockedRange(5159,5161);
    waterFallMap.switchBlockedRange(5279,5280);
    waterFallMap.switchBlockedRange(873,883);
    waterFallMap.switchBlockedRange(1027,1037);
    waterFallMap.switchBlockedRange(5926, 5931);
    waterFallMap.switchBlockedRange(4637, 4639);
    waterFallMap.switchBlockedRange(3936, 3939)
    waterFallMap.switchBlockedRange(4722, 4725)


    //Entrance to PokeShop Center 
    waterFallMap.switchBlockedRange(1809, 1815);
    
    //Entrance to house in the middle 
    waterFallMap.switchBlockedRange(4150,4152)

    //Entrance to gym bottom right 
    waterFallMap.switchBlockedRange(5279,5280);

    //Entrance to pokemon lab top right 
    waterFallMap.switchBlockedRange(1377,1378)


    
    
    



}


waterFallMap.beforeGameLoopEvents = function() {

    document.querySelectorAll('[class*="npc-"]').forEach(element => {
        element.remove();
    });

    this.charizard = new NPC("c35ac5a0-4d37-4b4f-9eea-3c9fd610062e",130, 140, /* Array(40).fill("right").concat(Array(10).fill("up")).concat(Array(100).fill("right")).concat(Array(120).fill("down")) */ [], 0.5 );
    PopulateNPCSpriteFromServer(this.charizard);


    this.garren = new NPC("43d840f5-7a32-4887-a234-135739af271c", 50, 120, Array(40).fill("right"), 0.5);
    PopulateNPCSpriteFromServer(this.garren);

    this.colonel = new NPC("a594634f-2f02-4ded-a67a-8bef2e4619a1",40, 100, /* Array(40).fill("right").concat(Array(10).fill("up")).concat(Array(100).fill("right")).concat(Array(120).fill("down")) */ Array(40).fill("right").concat(Array(10).fill("right")), 0.5 );
    PopulateNPCSpriteFromServer(this.colonel);



}

waterFallMap.duringGameLoopEvents = function() {
    this.charizard.placeCharacter();
    this.colonel.placeCharacter();
    this.garren.placeCharacter();
    
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
            if (this.garren.characterDialogue.boxIsShowing()) {
                this.garren.characterDialogue.hideDialogue();
            }
            else {
                if(detectCollision(this.garren.character, character)) {
                    this.garren.characterDialogue.showDialogue(this.garren.dialogueTree.World[0]);
                }
            }
        };
    }) 
     
    var towndoor = document.querySelectorAll('.mapTileSize')[5861];
    if (detectCollision(character, towndoor)) {
        currentMap = townMap;
        currentMap.beforeGameLoopEvents();
        currentMap.drawMap();
        currentMap.setUpPaths();
        currentMap.setUpPaths();
        x = 200;
        y = 18;
    } 
}


waterFallMap.afterGameLoopEvents = function() {
}
