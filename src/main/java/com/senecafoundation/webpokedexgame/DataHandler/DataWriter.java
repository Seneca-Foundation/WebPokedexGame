package com.senecafoundation.webpokedexgame.DataHandler;

import java.util.List;
import java.util.UUID;

public abstract class DataWriter<T> implements IDataWriter<T> {
	
	@Override
	public abstract void Create(T item);

	public String GetTypeOfProvider() {
		return this.toString();
	}
}