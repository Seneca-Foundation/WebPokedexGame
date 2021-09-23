package com.senecafoundation.webpokedexgame.DataHandler;

import java.util.List;
import java.util.UUID;

import com.senecafoundation.webpokedexgame.PokedexItems.PokedexItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

@Service
public class RepoDataWriter extends DataWriter {

    @Autowired
    public PokedexItemRepository pokedexItemRepository;

    @Override
    public void Create(PokedexItem item) {
        pokedexItemRepository.save(item);        
    }

    @Override
    public PokedexItem Read(UUID ID) throws Exception {
        return (PokedexItem) pokedexItemRepository.findAll();
    }

    @Override
    public PokedexItem Update(PokedexItem itemToUpdate) {
        return pokedexItemRepository.save(itemToUpdate);
    }

    @Override
    public Boolean Delete(UUID ID) throws Exception {
        pokedexItemRepository.deleteById(ID);
        return null;
    }

    @Override
    public List<PokedexItem> ReadAll() {
        return pokedexItemRepository.findAll();
    }
    
}
