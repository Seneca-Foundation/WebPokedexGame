package com.senecafoundation.webpokedexgame.DataHandler;

import java.util.List;
import java.util.UUID;

import com.senecafoundation.webpokedexgame.DataHandler.Repositories.AnimatedPropertiesRepository;
import com.senecafoundation.webpokedexgame.PokedexItems.AnimatedProperties;
import com.senecafoundation.webpokedexgame.PokedexItems.PokedexItem;

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
    
}