
townMap = new MapPath(false, 4233, "/images/maps/town.png", '100%', 25, 15.4, 21, 101);
townMap.setUpPaths = function() {
    townMap.switchBlockedRange(1414, 1443);
    townMap.switchBlockedRange(1331, 1360);
    townMap.switchBlockedRange(1494, 1496);
    townMap.switchBlockedRange(1577, 1579);
    townMap.switchBlockedRange(1660, 1662);
    townMap.switchBlockedRange(1743, 1745);
    townMap.switchBlockedRange(1826, 1828);
    townMap.switchBlockedRange(1909, 1911);
    townMap.switchBlockedRange(1992, 1994);
    townMap.switchBlockedRange(2075, 2077);
    townMap.switchBlockedRange(2161, 2187);
    townMap.switchBlockedRange(2244, 2270);

    townMap.switchBlockedRange(2188, 2190);
    townMap.switchBlockedRange(2271, 2273);
    townMap.switchBlockedRange(2354, 2356);
    townMap.switchBlockedRange(2437, 2439);
    townMap.switchBlockedRange(2520, 2522);
    townMap.switchBlockedRange(2603, 2605);
    townMap.switchBlockedRange(2686, 2688);
    townMap.switchBlockedRange(2769, 2771);

    townMap.switchBlockedRange(2029, 2042);
    townMap.switchBlockedRange(2112, 2125);
    townMap.switchBlockedRange(2195, 2208);
    townMap.switchBlockedRange(2278, 2291);
    townMap.switchBlockedRange(2361, 2374);
    townMap.switchBlockedRange(2444, 2457);
    townMap.switchBlockedRange(2527, 2540);

    townMap.switchBlockedRange(2852, 2854);
    townMap.switchBlockedRange(2935, 2937);
    townMap.switchBlockedRange(3019, 3020);
    townMap.switchBlockedRange(3102, 3103);
    townMap.switchBlockedRange(1278, 1286);

    townMap.switchBlockedRange(3185, 3195);
    townMap.switchBlockedRange(3249, 3278);
    townMap.switchBlockedRange(3913, 3978);

    townMap.switchBlockedRange(3200, 3236);
    townMap.switchBlockedRange(3283, 3319);

    townMap.switchBlockedRange(627, 636);
    townMap.switchBlockedRange(1291, 1299);

    townMap.switchBlockedRangeVert(41, 14, 83);
    townMap.switchBlockedRangeVert(46, 6, 83);
    townMap.switchBlockedRangeVert(719, 14, 83);

    townMap.switchBlockedRange(2545, 2565);
    townMap.switchBlockedRange(1882, 1899);

    townMap.switchBlockedRangeVert(1900, 7, 83);
    townMap.switchBlockedRangeVert(2628, 6, 83);
    townMap.switchBlockedRangeVert(3248, 8, 83)
    townMap.switchBlockedRangeVert(3398, 7, 83)
    
    //Opening door to first market
    townMap.switchBlockedRange(1335, 1338);
    townMap.switchBlockedRange(1418, 1421);
}

townMap.beforeGameLoopEvents = function() {
    
}

townMap.duringGameLoopEvents = function() {
      
    var waterfalldoor = document.querySelectorAll('.mapTileSize')[43];
    if (detectCollision(character, waterfalldoor)) {
        currentMap = waterFallMap;
        currentMap.beforeGameLoopEvents();
        currentMap.drawMap();
        currentMap.setUpPaths();
        x = currentMap.getStartX();
        y = currentMap.getStartY();
    } 
}

townMap.afterGameLoopEvents = function() {
}