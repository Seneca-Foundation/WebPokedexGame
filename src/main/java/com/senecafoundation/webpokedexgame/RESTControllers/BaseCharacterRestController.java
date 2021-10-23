package com.senecafoundation.webpokedexgame.RESTControllers;

import java.util.List;
import java.util.UUID;

import com.senecafoundation.webpokedexgame.DataHandler.AnimatedPropertiesDataWriter;
import com.senecafoundation.webpokedexgame.DataHandler.BaseCharacterDataWriters.BaseCharacterDataWriter;
import com.senecafoundation.webpokedexgame.PokedexItems.AnimatedProperties;
import com.senecafoundation.webpokedexgame.Trainers.BaseCharacter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseCharacterRestController {

    @Autowired
    @Qualifier("baseCharacterDataWriter")
    BaseCharacterDataWriter dataHandler;

    @Autowired
    @Qualifier("animatedPropertiesDataWriter")
    AnimatedPropertiesDataWriter animPropsDataHandler;

    @PostMapping("/baseCharacters")
    BaseCharacter newBaseCharacter(@RequestBody BaseCharacter newBaseCharacter) {
        AnimatedProperties animatedProperties = newBaseCharacter.getAnimatedProperties();
        animPropsDataHandler.Create(animatedProperties);
        newBaseCharacter.setAnimatedProperties(animatedProperties);
        dataHandler.Create(newBaseCharacter);
        return newBaseCharacter;
    }

    @GetMapping("/baseCharacters")
    List<BaseCharacter> allBaseCharacters() {
        return dataHandler.ReadAll();
    }

    @GetMapping("/baseCharacters/{id}")
    BaseCharacter getPokemonWithId(@PathVariable String id) throws Exception
    {
        return dataHandler.Read(UUID.fromString(id));
    }

    @PutMapping("/baseCharacters/{id}")
    BaseCharacter replacePokemonWithSecondAbility(@RequestBody BaseCharacter newBaseCharacter, @PathVariable String id) throws Exception {
        BaseCharacter baseCharacters = (BaseCharacter) dataHandler.Read(UUID.fromString(id));
        
        if (baseCharacters != null) {
            AnimatedProperties propsToSave = animPropsDataHandler.Read(baseCharacters.getAnimatedProperties().getId());
            newBaseCharacter.getAnimatedProperties().setId(propsToSave.getId());
            animPropsDataHandler.Update(newBaseCharacter.getAnimatedProperties());
            newBaseCharacter.setAnimatedProperties(propsToSave);
            newBaseCharacter.setID(baseCharacters.getID());
            dataHandler.Update(newBaseCharacter);
            return newBaseCharacter;
        }
        else {
            throw new Exception("Pokemon with id: " + id + " not found.");
        }
    }

    @DeleteMapping("/baseCharacters/{id}")
    void deletebaseCharacters(@PathVariable String id) throws Exception
    {
        dataHandler.Delete(UUID.fromString(id));
    }
}