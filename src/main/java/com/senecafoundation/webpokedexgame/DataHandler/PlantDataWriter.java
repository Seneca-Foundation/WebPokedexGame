package com.senecafoundation.webpokedexgame.DataHandler;

import java.util.ArrayList;
import java.util.List;

import com.senecafoundation.webpokedexgame.DataHandler.Repositories.PokedexItemRepository;
import com.senecafoundation.webpokedexgame.PokedexItems.Plant;
import com.senecafoundation.webpokedexgame.PokedexItems.PokedexItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlantDataWriter extends PokedexRepoDataWriter {
    
    @Autowired
    public PokedexItemRepository<Plant> pokedexItemRepository;

    @Override
    public List<PokedexItem> ReadAll() {
        ArrayList<PokedexItem> listOfItemsToReturn = new ArrayList<PokedexItem>();
        for (Plant plant : this.pokedexItemRepository.findAll()) {
            listOfItemsToReturn.add(plant);
        }
        return listOfItemsToReturn;
    }    
}
