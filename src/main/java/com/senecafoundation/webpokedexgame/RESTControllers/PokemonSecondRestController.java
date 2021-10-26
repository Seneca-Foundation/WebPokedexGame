package com.senecafoundation.webpokedexgame.RESTControllers;

import java.util.List;
import java.util.UUID;

import com.senecafoundation.webpokedexgame.DataHandler.AnimatedPropertiesDataWriter;
import com.senecafoundation.webpokedexgame.DataHandler.PokedexItemDataWriters.PokemonSecondDataWriter;
import com.senecafoundation.webpokedexgame.PokedexItems.AnimatedProperties;
import com.senecafoundation.webpokedexgame.PokedexItems.Pokemon.PokemonWithSecondAbility;

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
public class PokemonSecondRestController {
    
    @Autowired
    @Qualifier("pokemonSecondDataWriter")
    PokemonSecondDataWriter dataHandler;

    @Autowired
    @Qualifier("animatedPropertiesDataWriter")
    AnimatedPropertiesDataWriter animPropsDataHandler;

    @PostMapping("/pokemonSeconds")
    PokemonWithSecondAbility newPokemonWithSecondAbility(@RequestBody PokemonWithSecondAbility newPokemonWithSecondAbility) {
        AnimatedProperties animatedProperties = newPokemonWithSecondAbility.getAnimatedProperties();
        animPropsDataHandler.Create(animatedProperties);
        newPokemonWithSecondAbility.setAnimatedProperties(animatedProperties);
        dataHandler.Create(newPokemonWithSecondAbility);
        return newPokemonWithSecondAbility;
    }

    @GetMapping("/pokemonSeconds")
    List<PokemonWithSecondAbility> allPokemonSeconds() {
        return dataHandler.ReadAll();
    }


    @GetMapping("/pokemonSeconds/{id}")
    PokemonWithSecondAbility getPokemonWithId(@PathVariable String id) throws Exception
    {
        return dataHandler.Read(UUID.fromString(id));
    }
    
    @PutMapping("/pokemonSeconds/{id}")
    PokemonWithSecondAbility replacePokemonWithSecondAbility(@RequestBody PokemonWithSecondAbility newPokemonWithSecondAbility, @PathVariable String id) throws Exception {
        PokemonWithSecondAbility pokemonSeconds = (PokemonWithSecondAbility) dataHandler.Read(UUID.fromString(id));
        if (pokemonSeconds != null) {
            newPokemonWithSecondAbility.setID(pokemonSeconds.getID());
            dataHandler.Update(newPokemonWithSecondAbility);
            return newPokemonWithSecondAbility;
        }
        else {
            throw new Exception("Pokemon with id: " + id + " not found.");
        }
    }

    @DeleteMapping("/pokemonSeconds/{id}")
    void deletePokemonSeconds(@PathVariable String id) throws Exception
    {
        dataHandler.Delete(UUID.fromString(id));
    }
    
}