package com.senecafoundation.webpokedexgame.DataHandler.Repositories;

import com.senecafoundation.webpokedexgame.PokedexItems.Bear;

import org.springframework.stereotype.Repository;

@Repository
public interface BearRepository<T extends Bear> extends PokedexItemRepository<T> {
    
}
