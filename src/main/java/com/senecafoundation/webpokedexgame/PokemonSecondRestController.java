package com.senecafoundation.webpokedexgame;

import java.util.List;
import java.util.UUID;

import com.senecafoundation.webpokedexgame.DataHandler.PokemonSecondDataWriter;
import com.senecafoundation.webpokedexgame.PokedexItems.PokedexItem;
import com.senecafoundation.webpokedexgame.PokedexItems.Pokemon.PokemonWithSecondAbility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonSecondRestController {
    
    @Autowired
    @Qualifier("PokeomonSecondDataWriter")
    PokemonSecondDataWriter dataHandler;

    @PostMapping("/pokemonSeconds")
    PokemonWithSecondAbility newPokemonWithSecondAbility(@RequestBody PokemonWithSecondAbility newPokemonWithSecondAbility) {
        dataHandler.Create(newPokemonWithSecondAbility);
        return newPokemonWithSecondAbility;
    }

    @GetMapping("/pokemonSeconds")
    List<PokedexItem> allPokemonSeconds() {
        return dataHandler.ReadAll();
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