package com.senecafoundation.webpokedexgame.DataHandler;

import com.senecafoundation.webpokedexgame.PokedexItems.PokedexItem;

interface IDataWriterCreate<T> {
    public void Create(T item);
}
