package com.senecafoundation.webpokedexgame.DataHandler;

import java.util.List;

import com.senecafoundation.webpokedexgame.PokedexItems.PokedexItem;

public abstract class DataWriter implements IDataWriter {
	@Override
	public abstract void Create(PokedexItem item);
	
	@Override
	public abstract PokedexItem Read(String ID) throws Exception;

	@Override
	public abstract PokedexItem Update(PokedexItem itemToUpdate);

	@Override
	public abstract Boolean Delete(String ID) throws Exception;

	@Override
	public abstract List<PokedexItem> ReadAll(); 

	public String GetTypeOfProvider() {
		return this.toString();
	}
}