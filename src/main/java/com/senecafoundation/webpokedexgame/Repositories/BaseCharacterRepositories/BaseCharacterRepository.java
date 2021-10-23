package com.senecafoundation.webpokedexgame.Repositories.BaseCharacterRepositories;

import java.util.UUID;
import com.senecafoundation.webpokedexgame.Trainers.BaseCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseCharacterRepository<T extends BaseCharacter> extends JpaRepository<T, UUID> {

}