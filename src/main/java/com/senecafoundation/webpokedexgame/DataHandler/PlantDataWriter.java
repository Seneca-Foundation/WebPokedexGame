package com.senecafoundation.webpokedexgame.DataHandler;

import java.util.List;
import java.util.UUID;

import com.senecafoundation.webpokedexgame.PokedexItems.PokedexItem;

import org.springframework.stereotype.Service;

@Service
public class PlantDataWriter extends RepoDataWriter {
    
    @Override
    public List<PokedexItem> ReadAll() {
        return this.pokedexItemRepository.findAllPlant();
    }

    @Override
    public Boolean Delete(UUID ID) throws Exception {
        this.pokedexItemRepository.deleteById(ID);
        return null;
    }
    
}
