package com.senecafoundation.webpokedexgame.DataHandler.Repositories;

import com.senecafoundation.webpokedexgame.PokedexItems.Pokemon.PokemonWithSecondAbility;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonSecondRepository<T extends PokemonWithSecondAbility> extends PokedexItemRepository<T> {
}
