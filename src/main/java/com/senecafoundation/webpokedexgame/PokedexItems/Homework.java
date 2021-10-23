package com.senecafoundation.webpokedexgame.PokedexItems;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.senecafoundation.webpokedexgame.DataHandler.Interfaces.IDataWriter;
import com.senecafoundation.webpokedexgame.PokedexItems.Pokemon.PokemonWithSecondAbility;

@Entity
@Table(name = "pokemonwithsecondability")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Homework extends PokedexItem {

    private String shape;

    private Integer words;

    private Boolean foldAction;

    private String name; 

    @OneToOne
    private PokemonWithSecondAbility myCharmander;

    public Homework(String color, String shape, Integer words, Boolean foldAction, PokemonWithSecondAbility charmanderFromUser, String name) {
        super (color);
        this.shape = shape; 
        this.words = words; 
        this.foldAction = foldAction; 
        this.myCharmander = charmanderFromUser;
        this.name = name; 

    }

    public Homework() {
        super();
    }

    public String getName(){
        return this.name;
    }

    public String getShape(){
        return this.shape;
    }
    public Integer getWords(){
        return this.words;
    }
    public Boolean getFoldAction(){
        return this.foldAction;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setShape(String shape){
        this.shape = shape;
    }
    public void setWords(Integer words){
        this.words = words;
    }
    public void setfoldAction(Boolean foldAction){
        this.foldAction = foldAction;
    }

    public String getsCrumbled(){
        if (foldAction && words > 1 && shape == "circle"){
            return "This is someone's homework ... maybe you should give it back";
        }
        return "This homework is still isn't crumbled";
    }

    public String getAnExcuse() {
        return "My " + myCharmander.getName() + " ate it";
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "," + this.getID() + "," + this.getColor() + "," + this.getShape() + "," + this.getWords().toString() + "," + this.getFoldAction().toString() + "," + this.myCharmander.toString();
    }
}