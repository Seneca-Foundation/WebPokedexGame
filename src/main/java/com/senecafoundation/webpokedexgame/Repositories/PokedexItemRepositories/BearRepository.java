package com.senecafoundation.webpokedexgame.Repositories.PokedexItemRepositories;

import com.senecafoundation.webpokedexgame.PokedexItems.Bear;

import org.springframework.stereotype.Repository;

@Repository
public interface BearRepository<T extends Bear> extends PokedexItemRepository<T> {
    
}
