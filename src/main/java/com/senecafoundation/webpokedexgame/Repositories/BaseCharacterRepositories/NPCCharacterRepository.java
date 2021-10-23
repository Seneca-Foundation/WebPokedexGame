package com.senecafoundation.webpokedexgame.Repositories.BaseCharacterRepositories;

import com.senecafoundation.webpokedexgame.Trainers.NPC;
import org.springframework.stereotype.Repository;

@Repository
public interface NPCCharacterRepository<T extends NPC> extends BaseCharacterRepository<T> {
    
}
