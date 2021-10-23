package com.senecafoundation.webpokedexgame.Repositories.PokedexItemRepositories;

import com.senecafoundation.webpokedexgame.PokedexItems.Plant;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository<T extends Plant> extends PokedexItemRepository<T> {
}
