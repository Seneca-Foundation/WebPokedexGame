package com.senecafoundation.webpokedexgame.PokedexItems;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.senecafoundation.webpokedexgame.DataHandler.Interfaces.IDataWriter;

@Entity
@Table(name = "Bear") 
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Bear extends PokedexItem { 
    //states
    private String shape;
    private Integer weight; 
    private Boolean scary;
    private String name; 
    @OneToOne
    private AnimatedProperties animatedProperties; 


    public Bear(String color, String shape, Boolean scary, Integer weight, String name, AnimatedProperties animatedProperties) {
        super(color);
        this.shape = shape;
        this.weight = weight;
        this.scary = scary;
        this.name = name;
        this.setAnimatedProperties(animatedProperties);
    } 

    public Bear() {
        super();
    }


    public String getShape(){
        return shape;
    }
    public Integer getWeight(){
        return weight;

    }
    public Boolean getScary(){
        return scary;
    }
    public String getName(){
        return name;
    }

    public AnimatedProperties getAnimatedProperties() {
        return animatedProperties;
    }

    public void setAnimatedProperties(AnimatedProperties animatedProperties) {
        this.animatedProperties = animatedProperties;
    }

    public void setName(String name){
        this.name = name; 
    }
    public void setShape(String shape){
        this.shape = shape;
    }
    public void setWeight(Integer weight){
        this.weight = weight;
    }
    public void setScary(Boolean scary){
        this.scary = scary;
    }

    
    //Methods
    public Boolean attacks() {
        if (weight > 200 && scary == true) {
            return true;

        }
        return false; 
    }
    public String roll() {
        if (weight > 150 && shape == "circle") {
            return "This is a bear...it's definitly scary, but not a pokemon. maybe try again.";
        
        }
        return "He will NOT roll";
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "," + this.getID() + "," + this.getColor() + "," + this.getShape() + "," + this.getScary().toString() + "," + this.getWeight().toString();
    }
}
