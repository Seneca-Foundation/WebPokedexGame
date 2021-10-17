package com.senecafoundation.webpokedexgame.DataHandler;

import java.util.List;
import java.util.UUID;
import com.senecafoundation.webpokedexgame.DataHandler.Repositories.PokedexItemRepository;
import com.senecafoundation.webpokedexgame.PokedexItems.PokedexItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepoDataWriter<T extends PokedexItem> extends DataWriter {

    @Autowired
    public PokedexItemRepository<T> pokedexItemRepository;

    @Override
    public void Create(PokedexItem item) {
        pokedexItemRepository.save((T) item);        
    }

    @Override
    public PokedexItem Read(UUID ID) throws Exception {
        return (PokedexItem) pokedexItemRepository.findById(ID).orElseThrow();
    }

    @Override
    public PokedexItem Update(PokedexItem itemToUpdate) {
        return pokedexItemRepository.save((T) itemToUpdate);
    }

    @Override
    public Boolean Delete(UUID ID) throws Exception {
        pokedexItemRepository.deleteById(ID);
        return null;
    }

    @Override
    public List<PokedexItem> ReadAll() {
        return (List<PokedexItem>) this.pokedexItemRepository.findAll();
    }
    
}
