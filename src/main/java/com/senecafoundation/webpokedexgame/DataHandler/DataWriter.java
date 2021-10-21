package com.senecafoundation.webpokedexgame.DataHandler;


import java.util.List;
import java.util.UUID;

public abstract class DataWriter<T> implements IDataWriter<T> {
	@Override
	public abstract void Create(T item);
	
	@Override
	public abstract T Read(UUID ID) throws Exception;

	@Override
	public abstract T Update(T itemToUpdate);

	@Override
	public abstract Boolean Delete(UUID ID) throws Exception;

	@Override
	public abstract List<T> ReadAll(); 

	public String GetTypeOfProvider() {
		return this.toString();
	}
}