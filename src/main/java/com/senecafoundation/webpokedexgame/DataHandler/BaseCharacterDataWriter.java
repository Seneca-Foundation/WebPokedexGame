package com.senecafoundation.webpokedexgame.DataHandler;

import java.util.List;
import java.util.UUID;

import com.senecafoundation.webpokedexgame.DataHandler.Repositories.BaseCharacterRepository;
import com.senecafoundation.webpokedexgame.Trainers.BaseCharacter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseCharacterDataWriter extends DataWriter<BaseCharacter> {

    @Autowired
    public BaseCharacterRepository<BaseCharacter> baseCharacterRepository;
    
    @Override
    public void Create(BaseCharacter item) {
        baseCharacterRepository.save((BaseCharacter) item);        
    }

    @Override 
    public BaseCharacter Read(UUID ID) throws Exception {
        return (BaseCharacter) baseCharacterRepository.findById(ID).orElseThrow();
    }

    @Override
    public BaseCharacter Update(BaseCharacter itemToUpdate) {
        return (BaseCharacter) baseCharacterRepository.save(itemToUpdate);
    }

    @Override
    public Boolean Delete(UUID ID) throws Exception {
        baseCharacterRepository.deleteById(ID);
        return true;
    }

    @Override 
    public List<BaseCharacter> ReadAll() {
        return (List<BaseCharacter>) this.baseCharacterRepository.findAll();
    }
}