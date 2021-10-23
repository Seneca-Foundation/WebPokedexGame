package com.senecafoundation.webpokedexgame.Trainers;

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

import com.senecafoundation.webpokedexgame.PokedexItems.AnimatedProperties;

@Entity
@Table(name = "basecharacter")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class BaseCharacter {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID ID; 

    protected String name;

    @OneToOne
    protected AnimatedProperties animatedProperties;
    
    public BaseCharacter() {
    }

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
