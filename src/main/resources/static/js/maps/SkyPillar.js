skyPillarMap = new MapPath(false, 4233, "/images/maps/SkyPillar.png", '100%', 25, 15.4, 21, 101);
SkyPillarMap.setUpPaths = function() {
    skyPillarMap.switchBlockedRange(1414, 1443);
    skyPillarMap.switchBlockedRange(1331, 1360);
    SkyPillarMap.switchBlockedRange(1494, 1496);
    skyPillarMap.switchBlockedRange(1577, 1579);
    skyPillarMap.switchBlockedRange(1660, 1662);
    skyPillarMap.switchBlockedRange(1743, 1745);
    skyPillarMap.switchBlockedRange(1826, 1828);
    skyPillarMap.switchBlockedRange(1909, 1911);
    skyPillarMap.switchBlockedRange(1992, 1994);
    skyPillarMap.switchBlockedRange(2075, 2077);
    skyPillarMap.switchBlockedRange(2161, 2187);
    skyPillarMap.switchBlockedRange(2244, 2270);

    skyPillarMap.switchBlockedRange(2188, 2190);
    skyPillarMap.switchBlockedRange(2271, 2273);
    skyPillarMap.switchBlockedRange(2354, 2356);
    skyPillarMap.switchBlockedRange(2437, 2439);
    skyPillarMap.switchBlockedRange(2520, 2522);
    skyPillarMap.switchBlockedRange(2603, 2605);
    skyPillarMap.switchBlockedRange(2686, 2688);
    skyPillarMap.switchBlockedRange(2769, 2771);

    skyPillarMap.switchBlockedRange(2029, 2042);
    skyPillarMap.switchBlockedRange(2112, 2125);
    skyPillarMap.switchBlockedRange(2195, 2208);
    skyPillarMap.switchBlockedRange(2278, 2291);
    skyPillarMap.switchBlockedRange(2361, 2374);
    skyPillarMap.switchBlockedRange(2444, 2457);
    skyPillarMap.switchBlockedRange(2527, 2540);

    skyPillarMap.switchBlockedRange(2852, 2854);
    skyPillarMap.switchBlockedRange(2935, 2937);
    skyPillarMap.switchBlockedRange(3019, 3020);
    skyPillarMap.switchBlockedRange(3102, 3103);
    skyPillarMap.switchBlockedRange(1278, 1286);

    skyPillarMap.switchBlockedRange(3185, 3195);
    skyPillarMap.switchBlockedRange(3249, 3278);
    skyPillarMap.switchBlockedRange(3913, 3978);

    skyPillarMap.switchBlockedRange(3200, 3236);
    skyPillarMap.switchBlockedRange(3283, 3319);

    skyPillarMap.switchBlockedRange(627, 636);
    skyPillarMap.switchBlockedRange(1291, 1299);

    skyPillarMap.switchBlockedRangeVert(41, 14, 83);
    skyPillarMap.switchBlockedRangeVert(46, 6, 83);
    skyPillarMap.switchBlockedRangeVert(719, 14, 83);

    skyPillarMap.switchBlockedRange(2545, 2565);
    skyPillarMap.switchBlockedRange(1882, 1899);

    skyPillarMap.switchBlockedRangeVert(1900, 7, 83);
    skyPillarMap.switchBlockedRangeVert(2628, 6, 83);
    skyPillarMap.switchBlockedRangeVert(3248, 8, 83)
    skyPillarMap.switchBlockedRangeVert(3398, 7, 83)
    
}

skyPillarMap.beforeGameLoopEvents = function() {
    document.querySelectorAll('[class*="npc-"]').forEach(element => {
        element.remove();
    });
    this.bulbasaur  = new NPC("32659a2e-c18d-4c7c-a27d-db44d4c249cc", 50, 90, Array(110).fill("right").concat(Array(70).fill("down")), 1.0);
    PopulateNPCSpriteFromServer(this.bulbasaur);
}

skyPillarMap.duringGameLoopEvents = function() {
    this.usagi.placeCharacter();
    
    document.addEventListener("keydown", (e) => {
        if (e.code === 'Space') {
            if (this.usagi.characterDialogue.boxIsShowing()) {
                this.usagi.characterDialogue.hideDialogue();
            }
            else {
                if(detectCollision(this.usagi.character, character)) {
                    this.usagi.characterDialogue.showDialogue(this.usagi.dialogueTree.World);
                }
            }
        };
    }) 
}

skyPillarMap.afterGameLoopEvents = function() {
}