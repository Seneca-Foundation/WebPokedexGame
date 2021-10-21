package com.senecafoundation.webpokedexgame.PokedexItems;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.senecafoundation.webpokedexgame.DataHandler.IDataWriter;
@Entity
@Table(name = "pokemontrainers")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class PokemonTrainers {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)

    private IDataWriter dataWriter; 
    private String ID; 
    private String name; 
    List<PokedexItem> SixPokemon = new ArrayList<PokedexItem>();
    @OneToOne
    private AnimatedProperties animatedProperties;

    public PokemonTrainers(IDataWriter dataHolder, String name, AnimatedProperties animatedProperties)
    {
        this.dataWriter = dataHolder;
        this.setName(name);
        this.setID(UUID.randomUUID().toString());
        this.setAnimatedProperties(animatedProperties);
    }

    private void setAnimatedProperties(AnimatedProperties animatedProperties) {
        this.animatedProperties = animatedProperties;
    }

    public AnimatedProperties getAnimatedProperties() {
        return animatedProperties; 
    }

    public IDataWriter getIDataWriter() {
        return dataWriter;
    }

    public String getID(){
        return ID; 
    }

    private void setID(String id) {
        this.ID = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public List<PokedexItem> getSixPokemon() {
        return SixPokemon;
    }

    public void setSixPokemon(List<PokedexItem> SixPokemon) {
        this.SixPokemon = SixPokemon; 
    }    
}


















