package com.senecafoundation.webpokedexgame.Trainers;

import java.util.UUID;

import javax.persistence.OneToOne;

import com.senecafoundation.webpokedexgame.PokedexItems.AnimatedProperties;

public class BaseCharacter {

    protected String name;
    private UUID ID; 
    @OneToOne
    protected AnimatedProperties animatedProperties;
    
    public BaseCharacter (String name, AnimatedProperties animatedProperties) {
        this.setName(name);
        this.setID(UUID.randomUUID());
        this.setAnimatedProperties(animatedProperties);
    }

    public UUID getID() {
		return ID;
	}

	public void setID(UUID iD) {
		this.ID = iD;
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
