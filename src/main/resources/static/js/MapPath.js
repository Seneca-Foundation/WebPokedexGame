class MapPath {
    constructor(isDebug, numSquares, mapUrl, backgroundSize, width, height, startX, startY) {
        this.isDebug = isDebug;
        this.numSquares = numSquares;
        this.mapUrl = mapUrl;
        this.backgroundSize = backgroundSize;
        this.width = width;
        this.height = height;
        this.startX = startX;
        this.startY = startY;
        this.isBlockedList = new Array(this.numSquares);
        this.NPCs = [];
        this.EntryWays = [];
    }

    getStartX() {
        return this.startX;
    }

    getStartY() {
        return this.startY;
    }

    drawMap() {
        var map = document.querySelector(".map");
        map.style.backgroundImage = 'url("' + this.mapUrl + '")';
        map.style.backgroundSize = this.backgroundSize;
        map.style.width = 'calc(' + this.width + ' * var(--grid-cell))';
        map.style.height = 'calc(' + this.height + ' * var(--grid-cell))';
    }

    drawGrid() {
        // Remove any previous tiles
        document.querySelectorAll('.mapTileSize').forEach(e => e.remove());
        for (let i = 0; i < this.numSquares; i++) {
            var mapCellPos = document.createElement("div");
            mapCellPos.appendChild(document.createTextNode(i));
            mapCellPos.className += "mapTileSizePosition";
            var mapCell = document.createElement("div");
            mapCell.className += "mapTileSize";
            mapCell.appendChild(mapCellPos);
            mapCell.dataset.debug = this.isDebug;
            if (this.isBlockedList[i] == true) {
                mapCell.dataset.blocked = "true";
            }
            document.querySelector(".map").appendChild(mapCell);
        }
    }

    switchDebug() {
        if (this.isDebug) {
            this.isDebug = false;
            document.querySelectorAll('.mapTileSize[data-debug="true"]').forEach(e => e.dataset.debug = "false");
            document.querySelector(".camera").style.overflow = "hidden";
        }
        else {
            this.isDebug = true;
            document.querySelectorAll('.mapTileSize[data-debug="false"]').forEach(e => e.dataset.debug = "true");
            document.querySelector(".camera").style.overflow = "inherit";
        }
    }

    switchBlocked(pathIndex) {
        this.isBlockedList[pathIndex] = !this.isBlockedList[pathIndex];
        this.drawGrid();
    }

    switchBlockedRange(startIndex, stopIndex) {
        for (let pathIndex = startIndex; pathIndex <= stopIndex; pathIndex++) {
            this.isBlockedList[pathIndex] = !this.isBlockedList[pathIndex];
        }
        this.drawGrid();
    }

    switchBlockedRangeVert(startIndex, numSquares, columnWidth) {
        for (let pathIndex = 0; pathIndex <= numSquares; pathIndex++) {
            this.isBlockedList[startIndex] = !this.isBlockedList[startIndex];
            startIndex = startIndex += columnWidth;
        }
        this.drawGrid();
    }

    isCharacterBlocked() {
        return (document.querySelectorAll('.mapTileSize[data-character-grid="true"][data-blocked="true"]').length > 0);
    }

    getAllBlocked() {
        return document.querySelectorAll('.mapTileSize[data-character-grid="true"][data-blocked="true"]');
    }

    drawCharacterGrid(character) {
        document.querySelectorAll('.mapTileSize[data-character-grid="true"]').forEach(e => e.dataset.characterGrid = "");

        document.querySelectorAll('.mapTileSize').forEach(e => {
            if(detectCollision(e, character)) {
                e.dataset.characterGrid = "true";
            }
        });
    }

    eraseCharacterGrid(character) {
        document.querySelectorAll('.mapTileSize').forEach(e => {
            if(detectCollision(e, character)) {
                e.dataset.characterGrid = "false";
            }
        });
    }
}




