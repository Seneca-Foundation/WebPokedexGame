
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

    constructor(x, y, held_directions, speed) {
        this.character = document.querySelector(".character.barb-npc");
        this.x = x;
        this.y = y;
        this.held_directions = held_directions;
        this.speed = speed;
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
                if (held_direction === directions.right) {this.x += speed;}
                if (held_direction === directions.left) {this.x -= speed;}
                if (held_direction === directions.down) {this.y += speed;}
                if (held_direction === directions.up) {this.y -= speed;}
            }
        }
        this.character.setAttribute("facing", held_direction); 
        this.character.setAttribute("walking-left", "false");
        this.character.setAttribute("walking-right", "false");
        this.character.setAttribute("walking-up", "false");
        this.character.setAttribute("walking-down", "false");
        this.character.setAttribute("walking-"+held_direction, held_direction ? "true" : "false");
    
        this.character.style.transform = `translate3d( ${this.x*pixelSize}px, ${this.y*pixelSize}px, 0 )`; 
    }

    renderSpriteToHtml() {
        var sheetWithAnimations=document.styleSheets[0]; // load the stylesheet for modifying

        var backgroundImageRuleToChangeIndex = this.findCSSRule('.character_spritesheet', sheetWithAnimations);
        sheetWithAnimations.cssRules[backgroundImageRuleToChangeIndex].style.background = "url('" + this.animatedProperties.spriteSheetUrl + "') no-repeat no-repeat";
        sheetWithAnimations.cssRules[backgroundImageRuleToChangeIndex].style.backgroundSize = "100%";
        sheetWithAnimations.cssRules[backgroundImageRuleToChangeIndex].style.backgroundPositionX = "calc( var(--pixel-size) * " + this.animatedProperties.xOfCharacterPositionDown + " )";
        sheetWithAnimations.cssRules[backgroundImageRuleToChangeIndex].style.backgroundPositionY = "calc( var(--pixel-size) * " + this.animatedProperties.yOfCharacterPositionDown + " )";            

        var characterFacingSpriteSheetRuleToChange = this.findCSSRule('.character[facing="down"] .character_spritesheet', sheetWithAnimations);
        sheetWithAnimations.cssRules[characterFacingSpriteSheetRuleToChange].style.backgroundPositionX = "calc( var(--pixel-size) * " + this.animatedProperties.xOfCharacterPositionDown + " )";
        sheetWithAnimations.cssRules[characterFacingSpriteSheetRuleToChange].style.backgroundPositionY = "calc( var(--pixel-size) * " + this.animatedProperties.yOfCharacterPositionDown + " )";            
        characterFacingSpriteSheetRuleToChange = this.findCSSRule('.character[facing="up"] .character_spritesheet', sheetWithAnimations);
        sheetWithAnimations.cssRules[characterFacingSpriteSheetRuleToChange].style.backgroundPositionX = "calc( var(--pixel-size) * " + this.animatedProperties.xOfCharacterPositionUp + " )";
        sheetWithAnimations.cssRules[characterFacingSpriteSheetRuleToChange].style.backgroundPositionY = "calc( var(--pixel-size) * " + this.animatedProperties.yOfCharacterPositionUp + " )";
        characterFacingSpriteSheetRuleToChange = this.findCSSRule('.character[facing="left"] .character_spritesheet', sheetWithAnimations);
        sheetWithAnimations.cssRules[characterFacingSpriteSheetRuleToChange].style.backgroundPositionX = "calc( var(--pixel-size) * " + this.animatedProperties.xOfCharacterPositionLeft + " )";
        sheetWithAnimations.cssRules[characterFacingSpriteSheetRuleToChange].style.backgroundPositionY = "calc( var(--pixel-size) * " + this.animatedProperties.yOfCharacterPositionLeft + " )";
        characterFacingSpriteSheetRuleToChange = this.findCSSRule('.character[facing="right"] .character_spritesheet', sheetWithAnimations);
        sheetWithAnimations.cssRules[characterFacingSpriteSheetRuleToChange].style.backgroundPositionX = "calc( var(--pixel-size) * " + this.animatedProperties.xOfCharacterPositionRight + " )";
        sheetWithAnimations.cssRules[characterFacingSpriteSheetRuleToChange].style.backgroundPositionY = "calc( var(--pixel-size) * " + this.animatedProperties.yOfCharacterPositionRight + " )";

        var characterWindowRuleToChange = this.findCSSRule('.character[facing="down"]', sheetWithAnimations);
        sheetWithAnimations.cssRules[characterWindowRuleToChange].style.width = "calc( var(--grid-cell)* " + this.animatedProperties.widthOfCharacterWindowDown + " )";
        sheetWithAnimations.cssRules[characterWindowRuleToChange].style.height = "calc( var(--grid-cell)* " + this.animatedProperties.heightOfCharacterWindowDown + " )";
        characterWindowRuleToChange = this.findCSSRule('.character[facing="up"]', sheetWithAnimations);
        sheetWithAnimations.cssRules[characterWindowRuleToChange].style.width = "calc( var(--grid-cell)* " + this.animatedProperties.widthOfCharacterWindowUp + " )";
        sheetWithAnimations.cssRules[characterWindowRuleToChange].style.height = "calc( var(--grid-cell)* " + this.animatedProperties.heightOfCharacterWindowUp + " )";
        characterWindowRuleToChange = this.findCSSRule('.character[facing="left"]', sheetWithAnimations);
        sheetWithAnimations.cssRules[characterWindowRuleToChange].style.width = "calc( var(--grid-cell)* " + this.animatedProperties.widthOfCharacterWindowLeft + " )";
        sheetWithAnimations.cssRules[characterWindowRuleToChange].style.height = "calc( var(--grid-cell)* " + this.animatedProperties.heightOfCharacterWindowLeft + " )";
        characterWindowRuleToChange = this.findCSSRule('.character[facing="right"]', sheetWithAnimations);
        sheetWithAnimations.cssRules[characterWindowRuleToChange].style.width = "calc( var(--grid-cell)* " + this.animatedProperties.widthOfCharacterWindowRight + " )";
        sheetWithAnimations.cssRules[characterWindowRuleToChange].style.height = "calc( var(--grid-cell)* " + this.animatedProperties.heightOfCharacterWindowRight + " )";

        var characterAnimationRuleToChange = this.findCSSRule('walkRightAnimation', sheetWithAnimations);
        sheetWithAnimations.cssRules[characterAnimationRuleToChange][0].style.transform = 'translate3d(' + this.animatedProperties.animationStartPercentageRight + '%, 0%, 0px)';
        sheetWithAnimations.cssRules[characterAnimationRuleToChange][1].style.transform = 'translate3d(' + this.animatedProperties.animationStopPercentageRight + '%, 0%, 0px)';
        var characterStepCountRuleToChange = this.findCSSRule('.character[walking-right="true"] .character_spritesheet', sheetWithAnimations);
        sheetWithAnimations.cssRules[characterStepCountRuleToChange].style.animation = 'walkRightAnimation 0.6s steps(' + this.animatedProperties.stepCountRight + ') infinite'

        var characterAnimationRuleToChange = this.findCSSRule('walkLeftAnimation', sheetWithAnimations);
        sheetWithAnimations.cssRules[characterAnimationRuleToChange][0].style.transform = 'translate3d(' + this.animatedProperties.animationStartPercentageLeft + '%, 0%, 0px)';
        sheetWithAnimations.cssRules[characterAnimationRuleToChange][1].style.transform = 'translate3d(' + this.animatedProperties.animationStopPercentageLeft + '%, 0%, 0px)';
        var characterStepCountRuleToChange = this.findCSSRule('.character[walking-left="true"] .character_spritesheet', sheetWithAnimations);
        sheetWithAnimations.cssRules[characterStepCountRuleToChange].style.animation = 'walkLeftAnimation 0.6s steps(' + this.animatedProperties.stepCountLeft + ') infinite'

        var characterAnimationRuleToChange = this.findCSSRule('walkUpAnimation', sheetWithAnimations);
        sheetWithAnimations.cssRules[characterAnimationRuleToChange][0].style.transform = 'translate3d(' + this.animatedProperties.animationStartPercentageUp + '%, 0%, 0px)';
        sheetWithAnimations.cssRules[characterAnimationRuleToChange][1].style.transform = 'translate3d(' + this.animatedProperties.animationStopPercentageUp + '%, 0%, 0px)';
        var characterStepCountRuleToChange = this.findCSSRule('.character[walking-up="true"] .character_spritesheet', sheetWithAnimations);
        sheetWithAnimations.cssRules[characterStepCountRuleToChange].style.animation = 'walkUpAnimation 0.6s steps(' + this.animatedProperties.stepCountUp + ') infinite'

        var characterAnimationRuleToChange = this.findCSSRule('walkDownAnimation', sheetWithAnimations);
        sheetWithAnimations.cssRules[characterAnimationRuleToChange][0].style.transform = 'translate3d(' + this.animatedProperties.animationStartPercentageDown + '%, 0%, 0px)';
        sheetWithAnimations.cssRules[characterAnimationRuleToChange][1].style.transform = 'translate3d(' + this.animatedProperties.animationStopPercentageDown + '%, 0%, 0px)';
        var characterStepCountRuleToChange = this.findCSSRule('.character[walking-down="true"] .character_spritesheet', sheetWithAnimations);
        sheetWithAnimations.cssRules[characterStepCountRuleToChange].style.animation = 'walkDownAnimation 0.6s steps(' + this.animatedProperties.stepCountDown + ') infinite'
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