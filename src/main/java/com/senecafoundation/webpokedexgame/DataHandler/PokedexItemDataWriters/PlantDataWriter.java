package com.senecafoundation.webpokedexgame.DataHandler.PokedexItemDataWriters;

import java.util.ArrayList;
import java.util.List;

import com.senecafoundation.webpokedexgame.PokedexItems.Plant;
import com.senecafoundation.webpokedexgame.Repositories.PokedexItemRepositories.PokedexItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlantDataWriter extends PokedexItemDataWriter<Plant> {
    
    @Autowired
    public PokedexItemRepository<Plant> pokedexItemRepository;

    @Override
    public List<Plant> ReadAll() {
        ArrayList<Plant> listOfItemsToReturn = new ArrayList<Plant>();
        for (Plant plant : this.pokedexItemRepository.findAll()) {
            listOfItemsToReturn.add(plant);
        }
        return listOfItemsToReturn;
    }    
}
