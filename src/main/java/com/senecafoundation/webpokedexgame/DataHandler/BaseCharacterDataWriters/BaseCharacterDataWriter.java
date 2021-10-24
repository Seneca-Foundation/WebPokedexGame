package com.senecafoundation.webpokedexgame.DataHandler.BaseCharacterDataWriters;

import java.util.List;
import java.util.UUID;
import com.senecafoundation.webpokedexgame.DataHandler.Interfaces.DataWriter;
import com.senecafoundation.webpokedexgame.Repositories.BaseCharacterRepositories.BaseCharacterRepository;
import com.senecafoundation.webpokedexgame.Trainers.BaseCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseCharacterDataWriter<T extends BaseCharacter> extends DataWriter<T> {

    @Autowired
    public BaseCharacterRepository<T> baseCharacterRepository;
    
    @Override
    public void Create(T item) {
        baseCharacterRepository.save((T) item);        
    }

    @Override 
    public T Read(UUID ID) throws Exception {
        return (T) baseCharacterRepository.findById(ID).orElseThrow();
    }

    @Override
    public T Update(T itemToUpdate) {
        return (T) baseCharacterRepository.save(itemToUpdate);
    }

    @Override
    public Boolean Delete(UUID ID) throws Exception {
        baseCharacterRepository.deleteById(ID);
        return true;
    }

    @Override 
    public List<T> ReadAll() {
        return (List<T>) this.baseCharacterRepository.findAll();
    }
}