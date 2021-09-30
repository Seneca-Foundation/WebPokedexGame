package com.senecafoundation.webpokedexgame.DataHandler;


import java.util.List;
import java.util.UUID;

import com.senecafoundation.webpokedexgame.PokedexItems.PokedexItem;

public abstract class DataWriter implements IDataWriter {
	@Override
	public abstract void Create(PokedexItem item);
	
	@Override
	public abstract PokedexItem Read(UUID ID) throws Exception;

	@Override
	public abstract PokedexItem Update(PokedexItem itemToUpdate);

	@Override
	public abstract Boolean Delete(UUID ID) throws Exception;

	@Override
	public abstract List<PokedexItem> ReadAll(); 

	public String GetTypeOfProvider() {
		return this.toString();
	}
}