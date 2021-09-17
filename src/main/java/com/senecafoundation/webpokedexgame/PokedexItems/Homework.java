package com.senecafoundation.webpokedexgame.PokedexItems;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.senecafoundation.webpokedexgame.DataHandler.IDataWriter;
import com.senecafoundation.webpokedexgame.PokedexItems.Pokemon.PokemonWithSecondAbility;

@Entity
@Table(name = "Homework")

public class Homework extends PokedexItem {

    private String shape;

    private Integer words;

    private Boolean foldAction;

    @OneToOne
    private PokemonWithSecondAbility myCharmander;

    public Homework() {
        super (color, dataHolder);
        this.shape = shape; 
        this.words = words; 
        this.foldAction = foldAction; 
        this.myCharmander = charmanderFromUser;
    }

    public Homework() {
    }

    public Homework() {
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