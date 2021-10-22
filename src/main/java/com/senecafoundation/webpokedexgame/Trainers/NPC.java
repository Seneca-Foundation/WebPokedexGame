package com.senecafoundation.webpokedexgame.Trainers;

import java.util.List;

import com.senecafoundation.webpokedexgame.PokedexItems.AnimatedProperties;

public class NPC extends BaseCharacter {

    List<String> dialogue; 

    public NPC(String name, AnimatedProperties animatedProperties, List<String> dialogue) {
        super(name, animatedProperties);
        this.setDialogue(dialogue);

    }

    public List<String> getDialogue() {
        return dialogue; 
    }

    public void setDialogue(List<String> dialogue) {
        this.dialogue = dialogue; 
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnimatedProperties getAnimatedProperties() {
        return animatedProperties;
    }

    public void setAnimatedProperties(AnimatedProperties animatedProperties) {
        this.animatedProperties = animatedProperties;
    }



    
}
