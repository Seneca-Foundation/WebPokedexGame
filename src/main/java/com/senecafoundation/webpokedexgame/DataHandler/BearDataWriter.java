package com.senecafoundation.webpokedexgame.DataHandler;

import java.util.ArrayList;
import java.util.List;

import com.senecafoundation.webpokedexgame.DataHandler.Repositories.PokedexItemRepository;
import com.senecafoundation.webpokedexgame.PokedexItems.Bear;
import com.senecafoundation.webpokedexgame.PokedexItems.PokedexItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class BearDataWriter extends RepoDataWriter<Bear> {

    @Autowired 
    public PokedexItemRepository<Bear> pokedexItemRepository;

    @Override
    public List<Bear> ReadAll() {
        List<Bear> listOfBearsToReturn = new ArrayList<Bear>();
        for (Bear bear : this.pokedexItemRepository.findAll()) {
            listOfBearsToReturn.add(bear);
        }
        return listOfBearsToReturn;
    }
    
}
