package com.senecafoundation.webpokedexgame.DataHandler;

import java.util.List;

import com.senecafoundation.webpokedexgame.PokedexItems.PokedexItem;

public class PlantDataWriter extends RepoDataWriter {
    
    @Override
    public List<PokedexItem> ReadAll() {
        return this.pokedexItemRepository.findAllPlant();
    }

    
}
