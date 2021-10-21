package com.senecafoundation.webpokedexgame.DataHandler;

import java.util.List;
import java.util.UUID;

import com.senecafoundation.webpokedexgame.DataHandler.Repositories.AnimatedPropertiesRepository;
import com.senecafoundation.webpokedexgame.PokedexItems.AnimatedProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimatedPropertiesDataWriter extends DataWriter<AnimatedProperties> {

    @Autowired
    public AnimatedPropertiesRepository<AnimatedProperties> animatedPropertiesRepository;

    @Override
    public void Create(AnimatedProperties item) {
        animatedPropertiesRepository.save((AnimatedProperties) item);        
    }

    @Override 
    public AnimatedProperties Read(UUID ID) throws Exception {
        return (AnimatedProperties) animatedPropertiesRepository.findById(ID).orElseThrow();
    }

    @Override
    public AnimatedProperties Update(AnimatedProperties itemToUpdate) {
        return (AnimatedProperties) animatedPropertiesRepository.save(itemToUpdate);
    }

    @Override
    public Boolean Delete(UUID ID) throws Exception {
        animatedPropertiesRepository.deleteById(ID);
        return true;
    }

    @Override 
    public List<AnimatedProperties> ReadAll() {
        return (List<AnimatedProperties>) this.animatedPropertiesRepository.findAll();
    }
    
}