spriteButton = document.querySelector(".switchspritebutton");

spriteButton.onclick = getNewSpriteFromServer;

function getNewSpriteFromServer() {
    var xhr = new XMLHttpRequest();
    xhr.withCredentials = true;

    xhr.addEventListener("readystatechange", function() {
        if(this.readyState === 4) {
            console.log(this.responseText);
            newSprite = JSON.parse(this.responseText); //rehydration
            var sheetWithAnimations=document.styleSheets[0]; // load the stylesheet for modifying

            backgroundImageRuleToChangeIndex = findCSSRule('.character_spritesheet', sheetWithAnimations);
            sheetWithAnimations.cssRules[backgroundImageRuleToChangeIndex].style.background = "url('" + newSprite.animatedProperties.spriteSheetUrl + "') no-repeat no-repeat";
            sheetWithAnimations.cssRules[backgroundImageRuleToChangeIndex].style.backgroundSize = "100%";

            characterFacingSpriteSheetRuleToChange = findCSSRule('.character[facing="down"] .character_spritesheet', sheetWithAnimations);
            sheetWithAnimations.cssRules[characterFacingSpriteSheetRuleToChange].style.backgroundPositionX = "calc( var(--pixel-size) * " + newSprite.animatedProperties.xOfCharacterPositionDown + " )";
            sheetWithAnimations.cssRules[characterFacingSpriteSheetRuleToChange].style.backgroundPositionY = "calc( var(--pixel-size) * " + newSprite.animatedProperties.yOfCharacterPositionDown + " )";            
            characterFacingSpriteSheetRuleToChange = findCSSRule('.character[facing="up"] .character_spritesheet', sheetWithAnimations);
            sheetWithAnimations.cssRules[characterFacingSpriteSheetRuleToChange].style.backgroundPositionX = "calc( var(--pixel-size) * " + newSprite.animatedProperties.xOfCharacterPositionUp + " )";
            sheetWithAnimations.cssRules[characterFacingSpriteSheetRuleToChange].style.backgroundPositionY = "calc( var(--pixel-size) * " + newSprite.animatedProperties.yOfCharacterPositionUp + " )";
            characterFacingSpriteSheetRuleToChange = findCSSRule('.character[facing="left"] .character_spritesheet', sheetWithAnimations);
            sheetWithAnimations.cssRules[characterFacingSpriteSheetRuleToChange].style.backgroundPositionX = "calc( var(--pixel-size) * " + newSprite.animatedProperties.xOfCharacterPositionLeft + " )";
            sheetWithAnimations.cssRules[characterFacingSpriteSheetRuleToChange].style.backgroundPositionY = "calc( var(--pixel-size) * " + newSprite.animatedProperties.yOfCharacterPositionLeft + " )";
            characterFacingSpriteSheetRuleToChange = findCSSRule('.character[facing="right"] .character_spritesheet', sheetWithAnimations);
            sheetWithAnimations.cssRules[characterFacingSpriteSheetRuleToChange].style.backgroundPositionX = "calc( var(--pixel-size) * " + newSprite.animatedProperties.xOfCharacterPositionRight + " )";
            sheetWithAnimations.cssRules[characterFacingSpriteSheetRuleToChange].style.backgroundPositionY = "calc( var(--pixel-size) * " + newSprite.animatedProperties.yOfCharacterPositionRight + " )";

            characterWindowRuleToChange = findCSSRule('.character[facing="down"]', sheetWithAnimations);
            sheetWithAnimations.cssRules[characterWindowRuleToChange].style.width = "calc( var(--grid-cell)* " + newSprite.animatedProperties.widthOfCharacterWindowDown + " )";
            sheetWithAnimations.cssRules[characterWindowRuleToChange].style.height = "calc( var(--grid-cell)* " + newSprite.animatedProperties.heightOfCharacterWindowDown + " )";
            characterWindowRuleToChange = findCSSRule('.character[facing="up"]', sheetWithAnimations);
            sheetWithAnimations.cssRules[characterWindowRuleToChange].style.width = "calc( var(--grid-cell)* " + newSprite.animatedProperties.widthOfCharacterWindowUp + " )";
            sheetWithAnimations.cssRules[characterWindowRuleToChange].style.height = "calc( var(--grid-cell)* " + newSprite.animatedProperties.heightOfCharacterWindowUp + " )";
            characterWindowRuleToChange = findCSSRule('.character[facing="left"]', sheetWithAnimations);
            sheetWithAnimations.cssRules[characterWindowRuleToChange].style.width = "calc( var(--grid-cell)* " + newSprite.animatedProperties.widthOfCharacterWindowLeft + " )";
            sheetWithAnimations.cssRules[characterWindowRuleToChange].style.height = "calc( var(--grid-cell)* " + newSprite.animatedProperties.heightOfCharacterWindowLeft + " )";
            characterWindowRuleToChange = findCSSRule('.character[facing="right"]', sheetWithAnimations);
            sheetWithAnimations.cssRules[characterWindowRuleToChange].style.width = "calc( var(--grid-cell)* " + newSprite.animatedProperties.widthOfCharacterWindowRight + " )";
            sheetWithAnimations.cssRules[characterWindowRuleToChange].style.height = "calc( var(--grid-cell)* " + newSprite.animatedProperties.heightOfCharacterWindowRight + " )";

            characterWindowRuleToChange = findCSSRule('.character[facing="down"]', sheetWithAnimations);
            sheetWithAnimations.cssRules[characterWindowRuleToChange].style.width = "calc( var(--grid-cell)* " + newSprite.animatedProperties.widthOfCharacterWindowDown + " )";
            sheetWithAnimations.cssRules[characterWindowRuleToChange].style.height = "calc( var(--grid-cell)* " + newSprite.animatedProperties.heightOfCharacterWindowDown + " )";
            characterWindowRuleToChange = findCSSRule('.character[facing="up"]', sheetWithAnimations);
            sheetWithAnimations.cssRules[characterWindowRuleToChange].style.width = "calc( var(--grid-cell)* " + newSprite.animatedProperties.widthOfCharacterWindowUp + " )";
            sheetWithAnimations.cssRules[characterWindowRuleToChange].style.height = "calc( var(--grid-cell)* " + newSprite.animatedProperties.heightOfCharacterWindowUp + " )";
            characterWindowRuleToChange = findCSSRule('.character[facing="left"]', sheetWithAnimations);
            sheetWithAnimations.cssRules[characterWindowRuleToChange].style.width = "calc( var(--grid-cell)* " + newSprite.animatedProperties.widthOfCharacterWindowLeft + " )";
            sheetWithAnimations.cssRules[characterWindowRuleToChange].style.height = "calc( var(--grid-cell)* " + newSprite.animatedProperties.heightOfCharacterWindowLeft + " )";
            characterWindowRuleToChange = findCSSRule('.character[facing="right"]', sheetWithAnimations);
            sheetWithAnimations.cssRules[characterWindowRuleToChange].style.width = "calc( var(--grid-cell)* " + newSprite.animatedProperties.widthOfCharacterWindowRight + " )";
            sheetWithAnimations.cssRules[characterWindowRuleToChange].style.height = "calc( var(--grid-cell)* " + newSprite.animatedProperties.heightOfCharacterWindowRight + " )";

            characterAnimationRuleToChange = findCSSRule('walkRightAnimation', sheetWithAnimations);
            sheetWithAnimations.cssRules[characterAnimationRuleToChange][0].style.transform = 'translate3d(' + newSprite.animatedProperties.animationStartPercentageRight + '%, 0%, 0px)';
            sheetWithAnimations.cssRules[characterAnimationRuleToChange][1].style.transform = 'translate3d(' + newSprite.animatedProperties.animationStopPercentageRight + '%, 0%, 0px)';
            characterStepCountRuleToChange = findCSSRule('.character[walking-right="true"] .character_spritesheet', sheetWithAnimations);
            sheetWithAnimations.cssRules[characterStepCountRuleToChange].style.animation = 'walkRightAnimation 0.6s steps(' + newSprite.animatedProperties.stepCountRight + ') infinite'

            characterAnimationRuleToChange = findCSSRule('walkLeftAnimation', sheetWithAnimations);
            sheetWithAnimations.cssRules[characterAnimationRuleToChange][0].style.transform = 'translate3d(' + newSprite.animatedProperties.animationStartPercentageLeft + '%, 0%, 0px)';
            sheetWithAnimations.cssRules[characterAnimationRuleToChange][1].style.transform = 'translate3d(' + newSprite.animatedProperties.animationStopPercentageLeft + '%, 0%, 0px)';
            characterStepCountRuleToChange = findCSSRule('.character[walking-left="true"] .character_spritesheet', sheetWithAnimations);
            sheetWithAnimations.cssRules[characterStepCountRuleToChange].style.animation = 'walkLeftAnimation 0.6s steps(' + newSprite.animatedProperties.stepCountLeft + ') infinite'

            characterAnimationRuleToChange = findCSSRule('walkUpAnimation', sheetWithAnimations);
            sheetWithAnimations.cssRules[characterAnimationRuleToChange][0].style.transform = 'translate3d(' + newSprite.animatedProperties.animationStartPercentageUp + '%, 0%, 0px)';
            sheetWithAnimations.cssRules[characterAnimationRuleToChange][1].style.transform = 'translate3d(' + newSprite.animatedProperties.animationStopPercentageUp + '%, 0%, 0px)';
            characterStepCountRuleToChange = findCSSRule('.character[walking-up="true"] .character_spritesheet', sheetWithAnimations);
            sheetWithAnimations.cssRules[characterStepCountRuleToChange].style.animation = 'walkUpAnimation 0.6s steps(' + newSprite.animatedProperties.stepCountUp + ') infinite'

            characterAnimationRuleToChange = findCSSRule('walkDownAnimation', sheetWithAnimations);
            sheetWithAnimations.cssRules[characterAnimationRuleToChange][0].style.transform = 'translate3d(' + newSprite.animatedProperties.animationStartPercentageDown + '%, 0%, 0px)';
            sheetWithAnimations.cssRules[characterAnimationRuleToChange][1].style.transform = 'translate3d(' + newSprite.animatedProperties.animationStopPercentageDown + '%, 0%, 0px)';
            characterStepCountRuleToChange = findCSSRule('.character[walking-down="true"] .character_spritesheet', sheetWithAnimations);
            sheetWithAnimations.cssRules[characterStepCountRuleToChange].style.animation = 'walkDownAnimation 0.6s steps(' + newSprite.animatedProperties.stepCountDown + ') infinite'

        }
    });

    xhr.open("GET", "/pokemonSeconds/84534574-67c2-4417-8610-96edd19d3173");
    xhr.setRequestHeader("Content-Type", "application/json");

    xhr.send();
}

function findCSSRule(selector, mySheet) {
    var ruleIndex = -1;				// Default to 'not found'
    var theRules = mySheet.cssRules ? mySheet.cssRules : mySheet.rules;
    for (i=0; i<theRules.length; i++) {
        if (theRules[i].selectorText == selector) {
            ruleIndex = i;
            break;
        } 
        else if (theRules[i].name == selector) {
            ruleIndex = i;
            break;
        }// endif theRules[i]
    } // end for i
    return ruleIndex;
} // end findCSSRule()