package com.senecafoundation.webpokedexgame.DataHandler;

import java.util.List;
import java.util.UUID;

import com.senecafoundation.webpokedexgame.PokedexItems.PokedexItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepoDataWriter extends DataWriter {

    @Autowired
    private PokedexItemRepository pokedexItemRepository;

    @Override
    public void Create(PokedexItem item) {
        pokedexItemRepository.save(item);        
    }

    @Override
    public PokedexItem Read(UUID ID) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PokedexItem Update(PokedexItem itemToUpdate) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean Delete(UUID ID) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<PokedexItem> ReadAll() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
