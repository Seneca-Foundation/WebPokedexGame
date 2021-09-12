package com.senecafoundation.webpokedexgame.DataHandler;

import java.util.List;
import java.util.UUID;

import com.senecafoundation.webpokedexgame.PokedexItems.PokedexItem;

public interface IDataWriterRead {
    public PokedexItem Read(UUID ID) throws Exception;
    public List<PokedexItem> ReadAll();
}


