package com.senecafoundation.webpokedexgame.PokedexItems;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import com.senecafoundation.webpokedexgame.DataHandler.IDataWriter;

@MappedSuperclass
public abstract class PokedexItem {

    //states
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID ID; 
    protected String color;
    @Transient
    private IDataWriter dataWriter; 
    
    public PokedexItem(String color, IDataWriter dataHolder) 
    {
        this.dataWriter = dataHolder;
        this.setColor(color);
        this.setID(UUID.randomUUID());
    }

    public UUID getID() {
		return ID;
	}

	public void setID(UUID iD) {
		this.ID = iD;
	}

	public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public IDataWriter getIDataWriter() {
        return dataWriter;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "," + this.getID().toString()+ "," + this.getColor();
    }
}