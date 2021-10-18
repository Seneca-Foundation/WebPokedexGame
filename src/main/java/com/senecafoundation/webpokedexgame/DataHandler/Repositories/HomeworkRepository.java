package com.senecafoundation.webpokedexgame.DataHandler.Repositories;

import com.senecafoundation.webpokedexgame.PokedexItems.Homework;

import org.springframework.stereotype.Repository;

@Repository
public interface HomeworkRepository<T extends Homework> extends PokedexItemRepository<T> {
    
}
