package com.senecafoundation.webpokedexgame.DataHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.senecafoundation.webpokedexgame.DataHandler.Repositories.PokedexItemRepository;
import com.senecafoundation.webpokedexgame.PokedexItems.PokedexItem;
import com.senecafoundation.webpokedexgame.PokedexItems.Pokemon.PokemonWithSecondAbility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonSecondDataWriter extends PokedexRepoDataWriter {
    
    @Autowired
    public PokedexItemRepository<PokemonWithSecondAbility> pokedexItemRepository;

    @Override
    public PokedexItem Read(UUID ID) throws Exception {
        return (PokedexItem) pokedexItemRepository.findById(ID).orElseThrow();
    }
    
    @Override
    public List<PokedexItem> ReadAll() {
        ArrayList<PokedexItem> listOfItemsToReturn = new ArrayList<PokedexItem>();
        for (PokemonWithSecondAbility pokemonSecond : this.pokedexItemRepository.findAll()) {
            listOfItemsToReturn.add(pokemonSecond);
        }
        return listOfItemsToReturn;
    }    
}
