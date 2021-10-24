package com.senecafoundation.webpokedexgame.DataHandler.PokedexItemDataWriters;

import java.util.ArrayList;
import java.util.List;

import com.senecafoundation.webpokedexgame.PokedexItems.Pokemon.PokemonWithSecondAbility;
import com.senecafoundation.webpokedexgame.Repositories.PokedexItemRepositories.PokedexItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonSecondDataWriter extends PokedexItemDataWriter<PokemonWithSecondAbility> {
    
    @Autowired
    public PokedexItemRepository<PokemonWithSecondAbility> pokedexItemRepository;

    @Override
    public List<PokemonWithSecondAbility> ReadAll() {
        ArrayList<PokemonWithSecondAbility> listOfItemsToReturn = new ArrayList<PokemonWithSecondAbility>();
        for (PokemonWithSecondAbility pokemonSecond : this.pokedexItemRepository.findAll()) {
            listOfItemsToReturn.add(pokemonSecond);
        }
        return listOfItemsToReturn;
    }    
}
