function detectCollision(element1, element2) {

    x1 = element1.getBoundingClientRect().x;
    y1 = element1.getBoundingClientRect().y;
    w1 = element1.getBoundingClientRect().width;
    h1 = element1.getBoundingClientRect().height;
    x2 = element2.getBoundingClientRect().x;
    y2 = element2.getBoundingClientRect().y;
    w2 = element2.getBoundingClientRect().width;
    h2 = element2.getBoundingClientRect().height;
    
    // Check x and y for overlap
    if (x2 > w1 + x1 || x1 > w2 + x2 || y2 > h1 + y1 || y1 > h2 + y2){
        return false;
    }
    return true;
}