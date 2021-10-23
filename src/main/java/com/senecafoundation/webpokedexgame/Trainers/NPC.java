package com.senecafoundation.webpokedexgame.Trainers;

import java.util.Hashtable;
import java.util.List;

import com.senecafoundation.webpokedexgame.PokedexItems.AnimatedProperties;

public class NPC extends BaseCharacter {

    private Hashtable<String, List<String>> dialogueTree;

    public NPC(String name, AnimatedProperties animatedProperties, Hashtable<String, List<String>> dialogueTree) {
        super(name, animatedProperties);
        this.setDialogueTree(dialogueTree);
    }

    public Hashtable<String, List<String>> getDialogueTree() {
        return dialogueTree; 
    }

    public void setDialogueTree(Hashtable<String, List<String>> dialogueTree) {
        this.dialogueTree = dialogueTree; 
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
