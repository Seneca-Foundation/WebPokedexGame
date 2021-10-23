package com.senecafoundation.webpokedexgame.Trainers;

import java.util.ArrayList;
import java.util.Hashtable;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.senecafoundation.webpokedexgame.PokedexItems.AnimatedProperties;

@Entity
@Table(name = "npc") 
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class NPC extends BaseCharacter {

    private Hashtable<String, ArrayList<String>> dialogueTree;

    public NPC(String name, AnimatedProperties animatedProperties, Hashtable<String, ArrayList<String>> dialogueTree) {
        super(name, animatedProperties);
        this.setDialogueTree(dialogueTree);
    }

    public Hashtable<String, ArrayList<String>> getDialogueTree() {
        return dialogueTree; 
    }

    public void setDialogueTree(Hashtable<String, ArrayList<String>> dialogueTree) {
        this.dialogueTree = dialogueTree; 
    }

}
