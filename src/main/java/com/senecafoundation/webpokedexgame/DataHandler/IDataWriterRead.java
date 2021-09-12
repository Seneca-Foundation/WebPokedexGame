package com.senecafoundation.webpokedexgame.DataHandler;

import java.util.List;
import com.senecafoundation.webpokedexgame.PokedexItems.PokedexItem;

public interface IDataWriterRead {
    public PokedexItem Read(String ID) throws Exception;
    public List<PokedexItem> ReadAll();
}


