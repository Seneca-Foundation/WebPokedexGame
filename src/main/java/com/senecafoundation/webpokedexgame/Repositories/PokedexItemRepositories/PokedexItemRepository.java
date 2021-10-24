package com.senecafoundation.webpokedexgame.Repositories.PokedexItemRepositories;

import java.util.UUID;
import com.senecafoundation.webpokedexgame.PokedexItems.PokedexItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokedexItemRepository<T extends PokedexItem> extends JpaRepository<T, UUID> {
}

