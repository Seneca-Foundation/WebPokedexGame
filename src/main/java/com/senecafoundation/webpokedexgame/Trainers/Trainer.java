package com.senecafoundation.webpokedexgame.Trainers;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.senecafoundation.webpokedexgame.PokedexItems.AnimatedProperties;
import com.senecafoundation.webpokedexgame.PokedexItems.Pokemon.PokemonWithSecondAbility;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Trainer extends NPC {

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
    private List<PokemonWithSecondAbility> sixPokemon; 

    private Integer trainerLevel; 

    public Trainer() {
        super();
    }

    public Trainer(ArrayList<PokemonWithSecondAbility> sixPokemon, Integer trainerLevel, String name, AnimatedProperties animatedProperties, Hashtable<String, ArrayList<String>> dialogueTree ) {
        super(name, animatedProperties, dialogueTree);
        this.setSixPokemon(sixPokemon);
        this.setTrainerLevel(trainerLevel);
    }

    public List<PokemonWithSecondAbility> getSixPokemon() {
        return sixPokemon;
    }

    public void setSixPokemon(List<PokemonWithSecondAbility> sixPokemon)  {
        this.sixPokemon = sixPokemon; 
    }

    public Integer getTrainerLevel() {
        return trainerLevel;
    }
    
    public void setTrainerLevel(Integer trainerLevel) {
        this.trainerLevel = trainerLevel; 
    }



    
}
