package com.senecafoundation.webpokedexgame.DataHandler.Repositories;

import com.senecafoundation.webpokedexgame.PokedexItems.Plant;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository<T extends Plant> extends PokedexItemRepository<T> {
}
