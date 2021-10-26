package com.senecafoundation.webpokedexgame.DataHandler.BaseCharacterDataWriters;

import java.util.ArrayList;
import java.util.List;
import com.senecafoundation.webpokedexgame.Repositories.BaseCharacterRepositories.BaseCharacterRepository;
import com.senecafoundation.webpokedexgame.Trainers.NPC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NPCDataWriter extends BaseCharacterDataWriter<NPC> {
    
    @Autowired
    public BaseCharacterRepository<NPC> npcRepository;

    @Override
    public List<NPC> ReadAll() {
        ArrayList<NPC> listOfItemsToReturn = new ArrayList<NPC>();
        for (NPC pokemonSecond : this.npcRepository.findAll()) {
            listOfItemsToReturn.add(pokemonSecond);
        }
        return listOfItemsToReturn;
    }    
}
