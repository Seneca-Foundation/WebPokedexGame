
function PopulateNPCSpriteFromServer(npc, spriteId) {
    var xhr = new XMLHttpRequest();
    xhr.callingNpc = npc;
    xhr.withCredentials = true;

    xhr.addEventListener("readystatechange", function() {
        if(this.readyState === 4) {
            Object.assign(this.callingNpc, JSON.parse(this.responseText));
            this.callingNpc.renderSpriteToHtml();
        }
    });

    xhr.open("GET", "/npcs/" + spriteId);
    xhr.setRequestHeader("Content-Type", "application/json");

    xhr.send();
}

class NPC {

    constructor(id, x, y, held_directions, speed) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.held_directions = held_directions;
        this.reverse_direction = [...held_directions].reverse();
        this.speed = speed;
        this.reverse_direction.forEach((direction, index, reverse_direction) => {
            if (direction === "right") { reverse_direction[index] = "left" }
            if (direction === "left") { reverse_direction[index] = "right"; }
            if (direction === "down") { reverse_direction[index] = "up"; }
            if (direction === "up") { reverse_direction[index] = "down"; }
        });

        var npcSpriteSheet = document.createElement("div");
        npcSpriteSheet.className += "character_spritesheet ";
        npcSpriteSheet.className += "pixel-art";
        var npcShadowSpriteSheet = document.createElement("div");
        npcShadowSpriteSheet.className += "shadow ";
        npcShadowSpriteSheet.className += "pixel-art";
        var npcWindow = document.createElement("div");
        npcWindow.className += "character ";
        npcWindow.className += this.id + "-npc";
        npcWindow.appendChild(npcShadowSpriteSheet);
        npcWindow.appendChild(npcSpriteSheet);
        npcWindow.setAttribute("facing", "down");
        npcWindow.setAttribute("walking", "true");
        var map = document.querySelector(".map");
        map.appendChild(npcWindow);

        this.character = document.querySelector(".character"+"."+this.id+"-npc");
        
    }

    placeCharacter() {

        var pixelSize = parseInt(
            getComputedStyle(document.documentElement).getPropertyValue('--pixel-size')
        );
        
        const held_direction = this.held_directions[0];
        if (held_direction) {
            currentMap.drawCharacterGrid(this.character);
            if (currentMap.isCharacterBlocked(this.character)) {
                currentMap.getAllBlocked(this.character).forEach(element => {
                    if (betterCollision(element, this.character).left) {
                        this.x += 1;
                    }
                    if (betterCollision(element, this.character).right) {
                        this.x -= 1;
                    }
                    if (betterCollision(element, this.character).down) {
                        this.y -= 1;
                    }
                    if (betterCollision(element, this.character).up) {
                        this.y += 1;
                    }
                });
            }
            else {
                if (held_direction === directions.right) {this.x += this.speed;}
                if (held_direction === directions.left) {this.x -= this.speed;}
                if (held_direction === directions.down) {this.y += this.speed;}
                if (held_direction === directions.up) {this.y -= this.speed;}
            }
        }
        this.character.setAttribute("facing", held_direction == undefined ? "down" : held_direction); 
        this.character.setAttribute("walking-left", "false");
        this.character.setAttribute("walking-right", "false");
        this.character.setAttribute("walking-up", "false");
        this.character.setAttribute("walking-down", "false");
        this.character.setAttribute("walking-"+held_direction, held_direction ? "true" : "false");
    
        this.character.style.transform = `translate3d( ${this.x*pixelSize}px, ${this.y*pixelSize}px, 0 )`; 
        if (this.held_directions.length != 0) {
            this.held_directions.shift();
        }
        else {
            this.held_directions = [...this.reverse_direction];
            this.reverse_direction = this.reverse_direction.reverse();
            this.reverse_direction.forEach((direction, index, reverse_direction) => {
                if (direction === "right") { reverse_direction[index] = "left" }
                if (direction === "left") { reverse_direction[index] = "right"; }
                if (direction === "down") { reverse_direction[index] = "up"; }
                if (direction === "up") { reverse_direction[index] = "down"; }
            });
        }
    }

    renderSpriteToHtml() {
        var sheetWithAnimations=document.styleSheets[0]; // load the stylesheet for modifying

        var backgroundImageRuleToAdd = '.' + this.id + '-npc .character_spritesheet {';
        backgroundImageRuleToAdd += 'background: url("' + this.animatedProperties.spriteSheetUrl + '") no-repeat no-repeat;';
        backgroundImageRuleToAdd += 'background-size: 100%;';
        backgroundImageRuleToAdd += 'background-position-x: calc( var(--pixel-size) * ' + this.animatedProperties.xOfCharacterPositionDown + ');';
        backgroundImageRuleToAdd += 'background-position-y: calc( var(--pixel-size) * ' + this.animatedProperties.yOfCharacterPositionDown + ');';
        backgroundImageRuleToAdd += 'width: calc( var(--grid-cell)* 8 );';
        backgroundImageRuleToAdd += 'height: calc( var(--grid-cell)* 8 );';
        backgroundImageRuleToAdd += '}';

        sheetWithAnimations.insertRule(backgroundImageRuleToAdd);
        
        var characterFacingSpriteSheetDownRuleToAdd = '.' + this.id + '-npc.character[facing="down"] .character_spritesheet {';
        characterFacingSpriteSheetDownRuleToAdd += "background-position-x: calc( var(--pixel-size) * " + this.animatedProperties.xOfCharacterPositionDown + " );";
        characterFacingSpriteSheetDownRuleToAdd += "background-position-y: calc( var(--pixel-size) * " + this.animatedProperties.yOfCharacterPositionDown + " );";            
        characterFacingSpriteSheetDownRuleToAdd += '}';
        sheetWithAnimations.insertRule(characterFacingSpriteSheetDownRuleToAdd);

        var characterFacingSpriteSheetUpRuleToAdd = '.' + this.id + '-npc.character[facing="up"] .character_spritesheet {';
        characterFacingSpriteSheetUpRuleToAdd += "background-position-x: calc( var(--pixel-size) * " + this.animatedProperties.xOfCharacterPositionUp + " );";
        characterFacingSpriteSheetUpRuleToAdd += "background-position-y:  calc( var(--pixel-size) * " + this.animatedProperties.yOfCharacterPositionUp + " );";            
        characterFacingSpriteSheetUpRuleToAdd += '}';
        sheetWithAnimations.insertRule(characterFacingSpriteSheetUpRuleToAdd);

        var characterFacingSpriteSheetLeftRuleToAdd = '.' + this.id + '-npc.character[facing="left"] .character_spritesheet {';
        characterFacingSpriteSheetLeftRuleToAdd += "background-position-x: calc( var(--pixel-size) * " + this.animatedProperties.xOfCharacterPositionLeft + " );";
        characterFacingSpriteSheetLeftRuleToAdd += "background-position-y:  calc( var(--pixel-size) * " + this.animatedProperties.yOfCharacterPositionLeft + " );";            
        characterFacingSpriteSheetLeftRuleToAdd += '}';
        sheetWithAnimations.insertRule(characterFacingSpriteSheetLeftRuleToAdd);

        var characterFacingSpriteSheetRightRuleToAdd = '.' + this.id + '-npc.character[facing="right"] .character_spritesheet {';
        characterFacingSpriteSheetRightRuleToAdd += "background-position-x: calc( var(--pixel-size) * " + this.animatedProperties.xOfCharacterPositionRight + " );";
        characterFacingSpriteSheetRightRuleToAdd += "background-position-y: calc( var(--pixel-size) * " + this.animatedProperties.yOfCharacterPositionRight + " );";            
        characterFacingSpriteSheetRightRuleToAdd += '}';
        sheetWithAnimations.insertRule(characterFacingSpriteSheetRightRuleToAdd);

        var characterFacingDownWindowRuleToAdd = '.' + this.id + '-npc.character[facing="down"] {';
        characterFacingDownWindowRuleToAdd += 'width: calc( var(--grid-cell)* ' + this.animatedProperties.widthOfCharacterWindowDown +  ');';
        characterFacingDownWindowRuleToAdd += 'height: calc( var(--grid-cell)* ' + this.animatedProperties.heightOfCharacterWindowDown + ');';
        characterFacingDownWindowRuleToAdd += '}';
        sheetWithAnimations.insertRule(characterFacingDownWindowRuleToAdd);

        var characterFacingUpWindowRuleToAdd = '.' + this.id + '-npc.character[facing="up"] {';
        characterFacingUpWindowRuleToAdd += 'width: calc( var(--grid-cell)* ' + this.animatedProperties.widthOfCharacterWindowUp + ');';
        characterFacingUpWindowRuleToAdd += 'height: calc( var(--grid-cell)* ' + this.animatedProperties.heightOfCharacterWindowUp + ');';
        characterFacingUpWindowRuleToAdd += '}';
        sheetWithAnimations.insertRule(characterFacingUpWindowRuleToAdd);

        var characterFacingLeftWindowRuleToAdd = '.' + this.id + '-npc.character[facing="left"] {';
        characterFacingLeftWindowRuleToAdd += 'width: calc( var(--grid-cell)* ' + this.animatedProperties.widthOfCharacterWindowLeft + ');';
        characterFacingLeftWindowRuleToAdd += 'height: calc( var(--grid-cell)* ' + this.animatedProperties.heightOfCharacterWindowLeft + ');';
        characterFacingLeftWindowRuleToAdd += '}';
        sheetWithAnimations.insertRule(characterFacingLeftWindowRuleToAdd);

        var characterFacingRightWindowRuleToAdd = '.' + this.id + '-npc.character[facing="right"] {';
        characterFacingRightWindowRuleToAdd += 'width: calc( var(--grid-cell)* ' + this.animatedProperties.widthOfCharacterWindowRight + ');';
        characterFacingRightWindowRuleToAdd += 'height: calc( var(--grid-cell)* ' + this.animatedProperties.heightOfCharacterWindowRight + ');';
        characterFacingRightWindowRuleToAdd += '}';
        sheetWithAnimations.insertRule(characterFacingRightWindowRuleToAdd);

        var characterAnimationRightRuleToAdd = 'walkRightAnimation' + this.id + ' {';
        characterAnimationRightRuleToAdd += 'from { transform: translate3d(' + this.animatedProperties.animationStartPercentageRight + '%, 0%, 0px); }';
        characterAnimationRightRuleToAdd += 'to { transform: translate3d(' + this.animatedProperties.animationStopPercentageRight + '%, 0%, 0px); }';
        characterAnimationRightRuleToAdd += '}';
        sheetWithAnimations.insertRule(characterAnimationRightRuleToAdd);

        var characterAnimationRightRuleToAdd = '.' + this.id + '-npc.character[walking-right="true"] .character_spritesheet {';
        characterAnimationRightRuleToAdd += 'animation: walkRightAnimation' + this.id + ' 0.6s steps(' + this.animatedProperties.stepCountRight + ') infinite;';
        characterAnimationRightRuleToAdd += '}';
        sheetWithAnimations.insertRule(characterAnimationRightRuleToAdd);


        var characterAnimationLeftRuleToAdd = 'walkLeftAnimation' + this.id + ' {';
        characterAnimationLeftRuleToAdd += 'from { transform: translate3d(' + this.animatedProperties.animationStartPercentageLeft + '%, 0%, 0px); }';
        characterAnimationLeftRuleToAdd += 'to { transform: translate3d(' + this.animatedProperties.animationStopPercentageLeft + '%, 0%, 0px); }';
        characterAnimationLeftRuleToAdd += '}';
        sheetWithAnimations.insertRule(characterAnimationLeftRuleToAdd);

        var characterAnimationLeftRuleToAdd = '.' + this.id + '-npc.character[walking-left="true"] .character_spritesheet {';
        characterAnimationLeftRuleToAdd += 'animation: walkLeftAnimation' + this.id + ' 0.6s steps(' + this.animatedProperties.stepCountLeft + ') infinite;';
        characterAnimationLeftRuleToAdd += '}';
        sheetWithAnimations.insertRule(characterAnimationLeftRuleToAdd);


        var characterAnimationDownRuleToAdd = 'walkDownAnimation' + this.id + ' {';
        characterAnimationDownRuleToAdd += 'from { transform: translate3d(' + this.animatedProperties.animationStartPercentageDown + '%, 0%, 0px); }';
        characterAnimationDownRuleToAdd += 'to { transform: translate3d(' + this.animatedProperties.animationStopPercentageDown + '%, 0%, 0px); }';
        characterAnimationDownRuleToAdd += '}';
        sheetWithAnimations.insertRule(characterAnimationDownRuleToAdd);

        var characterAnimationDownRuleToAdd = '.' + this.id + '-npc.character[walking-down="true"] .character_spritesheet {';
        characterAnimationDownRuleToAdd += 'animation: walkDownAnimation' + this.id + ' 0.6s steps(' + this.animatedProperties.stepCountDown + ') infinite;';
        characterAnimationDownRuleToAdd += '}';
        sheetWithAnimations.insertRule(characterAnimationDownRuleToAdd);


        var characterAnimationUpRuleToAdd = 'walkUpAnimation' + this.id + ' {';
        characterAnimationUpRuleToAdd += 'from { transform: translate3d(' + this.animatedProperties.animationStartPercentageUp + '%, 0%, 0px); }';
        characterAnimationUpRuleToAdd += 'to { transform: translate3d(' + this.animatedProperties.animationStopPercentageUp + '%, 0%, 0px); }';
        characterAnimationUpRuleToAdd += '}';
        sheetWithAnimations.insertRule(characterAnimationUpRuleToAdd);

        var characterAnimationUpRuleToAdd = '.' + this.id + '-npc.character[walking-up="true"] .character_spritesheet {';
        characterAnimationUpRuleToAdd += 'animation: walkUpAnimation' + this.id + ' 0.6s steps(' + this.animatedProperties.stepCountUp + ') infinite;';
        characterAnimationUpRuleToAdd += '}';
        sheetWithAnimations.insertRule(characterAnimationUpRuleToAdd);

    }

    findCSSRule(selector, mySheet) {
        var ruleIndex = -1;
        var theRules = mySheet.cssRules ? mySheet.cssRules : mySheet.rules;
        for (var i=0; i<theRules.length; i++) {
            if (theRules[i].selectorText == selector) {
                ruleIndex = i;
                break;
            } 
            else if (theRules[i].name == selector) {
                ruleIndex = i;
                break;
            }
        }
        return ruleIndex;
    }
}