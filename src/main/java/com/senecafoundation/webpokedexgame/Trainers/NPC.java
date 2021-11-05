package com.senecafoundation.webpokedexgame.Trainers;

import java.util.ArrayList;
import java.util.Hashtable;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import com.senecafoundation.webpokedexgame.PokedexItems.AnimatedProperties;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class NPC extends BaseCharacter {

    private Hashtable<String, ArrayList<String>> dialogueTree;

    public NPC(String name, String profilePhoto, AnimatedProperties animatedProperties, Hashtable<String, ArrayList<String>> dialogueTree) {
        super(name, profilePhoto, animatedProperties);
        this.setDialogueTree(dialogueTree);
    }

    public NPC() {
    }

    public Hashtable<String, ArrayList<String>> getDialogueTree() {
        return dialogueTree; 
    }

    public void setDialogueTree(Hashtable<String, ArrayList<String>> dialogueTree) {
        this.dialogueTree = dialogueTree; 
    }

}
