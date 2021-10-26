package com.senecafoundation.webpokedexgame.Trainers;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.senecafoundation.webpokedexgame.PokedexItems.AnimatedProperties;
import com.senecafoundation.webpokedexgame.PokedexItems.Pokemon.Pokemon;

public class Trainer extends NPC {

    private List<Pokemon> sixPokemon; 

    private Integer trainerLevel; 

    public Trainer(List<Pokemon> sixPokemon, Integer trainerLevel, String name, AnimatedProperties animatedProperties, Hashtable<String, ArrayList<String>> dialogueTree ) {
        super(name, animatedProperties, dialogueTree);
        this.setSixPokemon(sixPokemon);
        this.setTrainerLevel(trainerLevel);
    }

    public List<Pokemon> getSixPokemon() {
        return sixPokemon;
    }

    public void setSixPokemon(List<Pokemon> sixPokemon)  {
        this.sixPokemon = sixPokemon; 
    }

    public Integer getTrainerLevel() {
        return trainerLevel;
    }
    
    public void setTrainerLevel(Integer trainerLevel) {
        this.trainerLevel = trainerLevel; 
    }



    
}
