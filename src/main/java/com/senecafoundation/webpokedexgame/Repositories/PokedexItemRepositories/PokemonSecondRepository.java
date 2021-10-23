package com.senecafoundation.webpokedexgame.Repositories.PokedexItemRepositories;

import com.senecafoundation.webpokedexgame.PokedexItems.Pokemon.PokemonWithSecondAbility;

import org.springframework.stereotype.Repository;

@Repository
public interface PokemonSecondRepository<T extends PokemonWithSecondAbility> extends PokedexItemRepository<T> {
}
