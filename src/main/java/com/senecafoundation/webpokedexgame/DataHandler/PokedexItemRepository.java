package com.senecafoundation.webpokedexgame.DataHandler;

import java.util.List;
import java.util.UUID;

import com.senecafoundation.webpokedexgame.PokedexItems.PokedexItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PokedexItemRepository extends JpaRepository<PokedexItem, UUID> {
    @Query("SELECT p FROM Plant p")
    List<PokedexItem> findAllPlant();

    @Query("SELECT p FROM PokemonWithSecondAbility p")
    List<PokedexItem> findAllPokemonWithSecondAbility();
}

