schoolMap = new MapPath(false, 4564, "/images/maps/school.png", '100%', 25, 16.5, 21, 101);
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
     schoolMap.switchBlockedRange(2499,2513)








     
 
     //doorways 
     schoolMap.switchBlockedRange(3785, 3788);
     schoolMap.switchBlockedRange(3203, 3208);

     //green room bottom right 
     schoolMap.switchBlockedRangeVert(2295, 6, 83);
     schoolMap.switchBlockedRange(2969,2972);
     schoolMap.switchBlockedRangeVert(2562, 1, 83);
     schoolMap.switchBlockedRange(3643,3646);
     schoolMap.switchBlockedRange(3637,3641);
     schoolMap.switchBlockedRange(4218,4222);
     schoolMap.switchBlockedRangeVert(2640, 3, 83);
     schoolMap.switchBlockedRangeVert(3724, 3, 83);







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