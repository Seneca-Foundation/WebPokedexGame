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
    if (x2 > w1 + x1 || x1 > w2 + x2 || y2 > h1 + y1 || y1 > h2 + y2) {
        return false;
    }
    return true;
}

function betterCollision(r1, r2) {
    r1 = r1.getBoundingClientRect();
    r2 = r2.getBoundingClientRect();
    if (r1.x + r1.width >= r2.x &&
        r1.x <= r2.x + r2.width &&
        r1.y + r1.height >= r2.y &&
        r1.y <= r2.y + r2.height)
    {
        const top_diff = r2.y + r2.height - r1.y;
        const bottom_diff = r1.y + r1.height - r2.y;
        const left_diff = r2.x + r2.width - r1.x;
        const right_diff = r1.x + r1.width - r2.x;

        const min = Math.min(bottom_diff, top_diff, left_diff, right_diff);

        return {
            up: bottom_diff == min,
            left: right_diff == min,
            right: left_diff == min,
            down: top_diff == min
        }
    }
    return false;
}