package com.senecafoundation.webpokedexgame;

import com.senecafoundation.webpokedexgame.DataHandler.PokemonSecondDataWriter;
import com.senecafoundation.webpokedexgame.PokedexItems.Pokemon.PokemonWithSecondAbility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
}
