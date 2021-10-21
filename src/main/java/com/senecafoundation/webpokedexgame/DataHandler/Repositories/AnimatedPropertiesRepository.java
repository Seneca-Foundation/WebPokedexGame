package com.senecafoundation.webpokedexgame.DataHandler.Repositories;

import java.util.UUID;

import com.senecafoundation.webpokedexgame.PokedexItems.AnimatedProperties;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimatedPropertiesRepository<T extends AnimatedProperties> extends JpaRepository<T,UUID> {
    
}
