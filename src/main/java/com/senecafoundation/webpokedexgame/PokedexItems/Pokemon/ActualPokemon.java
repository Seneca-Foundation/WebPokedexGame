package com.senecafoundation.webpokedexgame.PokedexItems.Pokemon;

import javax.persistence.MappedSuperclass;

import com.senecafoundation.webpokedexgame.DataHandler.IDataWriter;
import com.senecafoundation.webpokedexgame.PokedexItems.PokedexItem;

@MappedSuperclass
public class ActualPokemon extends PokedexItem {
   
    private String ability1; 
     
    public ActualPokemon(String color,String ability1, IDataWriter dataHolder) {
        super(color, dataHolder);
        this.ability1 = ability1;
    }
    
    public ActualPokemon() {
        super();
    }

    public String getAbility1()
    {
        return ability1; 
    }
    public void setAbility1(String ability1)
    {
        this.ability1 = ability1; 
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "," + this.getID() + "," + this.getColor() + "," + this.getAbility1();
    }
}