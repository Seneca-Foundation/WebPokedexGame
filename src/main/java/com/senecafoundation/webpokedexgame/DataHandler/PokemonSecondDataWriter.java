package com.senecafoundation.webpokedexgame.DataHandler;

import java.util.ArrayList;
import java.util.List;

import com.senecafoundation.webpokedexgame.DataHandler.Repositories.PokedexItemRepository;
import com.senecafoundation.webpokedexgame.PokedexItems.PokedexItem;
import com.senecafoundation.webpokedexgame.PokedexItems.Pokemon.PokemonWithSecondAbility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonSecondDataWriter extends RepoDataWriter<PokemonWithSecondAbility> {
    
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
