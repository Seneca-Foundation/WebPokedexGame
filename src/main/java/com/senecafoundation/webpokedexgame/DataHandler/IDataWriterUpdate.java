package com.senecafoundation.webpokedexgame.DataHandler;

import com.senecafoundation.webpokedexgame.PokedexItems.PokedexItem;

public interface IDataWriterUpdate<T> {
    public T Update(T itemToUpdate);
}

