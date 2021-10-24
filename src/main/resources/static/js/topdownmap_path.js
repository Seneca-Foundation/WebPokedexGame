class MapPath {
    constructor(isDebug, numSquares) {
        this.isDebug = isDebug;
        this.numSquares = numSquares;
        this.isBlockedList = new Array(this.numSquares);
    }

    getIsBlockedList() {
        return this.isBlockedList;
    }

    drawGrid() {
        // Remove any previous tiles
        document.querySelectorAll('.mapTileSize').forEach(e => e.remove());
        this.numSquares = this.numSquares;
        for (let i = 0; i < this.numSquares; i++) {
            var mapCellPos = document.createElement("div");
            mapCellPos.appendChild(document.createTextNode(i));
            mapCellPos.className += "mapTileSizePosition";
            var mapCell = document.createElement("div");
            mapCell.className += "mapTileSize";
            mapCell.appendChild(mapCellPos);
            mapCell.dataset.debug = this.isDebug;
            if (this.isBlockedList[i] == true) {
                mapCell.dataset.blocked = true;
            }
            document.querySelector(".map").appendChild(mapCell);
        }
    }

    switchDebug() {
        if (this.isDebug) {
            this.isDebug = false;
            document.querySelectorAll('.mapTileSize').forEach(e => e.remove());
        }
        else {
            this.isDebug = true;
        }
        this.drawGrid(this.numSquares);
    }

    switchBlocked(pathIndex) {
        this.isBlockedList[pathIndex] = !this.isBlockedList[pathIndex];
        this.drawGrid(this.numSquares);
    }

    switchBlockedRange(startIndex, stopIndex) {
        for (let pathIndex = startIndex; pathIndex < stopIndex; pathIndex++) {
            this.isBlockedList[pathIndex] = !this.isBlockedList[pathIndex];
        }
        this.drawGrid(this.numSquares);
    }

    isCharacterBlocked(character) {
        document.querySelectorAll('.mapTileSize').forEach(e => {
            if(detectCollision(e, character)) {
                if(e.dataset.blocked === "true") {
                    return true;
                }
            }
        });
    }
}




