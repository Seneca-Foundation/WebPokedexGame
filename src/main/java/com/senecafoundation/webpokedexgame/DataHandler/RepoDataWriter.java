package com.senecafoundation.webpokedexgame.DataHandler;

import java.util.List;
import java.util.UUID;
import com.senecafoundation.webpokedexgame.DataHandler.Repositories.PokedexItemRepository;
import com.senecafoundation.webpokedexgame.PokedexItems.PokedexItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepoDataWriter<T extends PokedexItem> extends DataWriter<T> {

    @Autowired
    public PokedexItemRepository<T> pokedexItemRepository;

    @Override
    public void Create(PokedexItem item) {
        pokedexItemRepository.save((T) item);        
    }

    @Override
    public T Read(UUID ID) throws Exception {
        return (T) pokedexItemRepository.findById(ID).orElseThrow();
    }

    @Override
    public T Update(PokedexItem itemToUpdate) {
        return pokedexItemRepository.save((T) itemToUpdate);
    }

    @Override
    public Boolean Delete(UUID ID) throws Exception {
        pokedexItemRepository.deleteById(ID);
        return true;
    }

    @Override
    public List<T> ReadAll() {
        return (List<T>) this.pokedexItemRepository.findAll();
    }
    
}
