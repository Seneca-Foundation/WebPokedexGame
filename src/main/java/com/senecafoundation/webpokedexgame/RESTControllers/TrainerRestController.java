package com.senecafoundation.webpokedexgame.RESTControllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import com.senecafoundation.webpokedexgame.DataHandler.AnimatedPropertiesDataWriter;
import com.senecafoundation.webpokedexgame.DataHandler.BaseCharacterDataWriters.NPCDataWriter;
import com.senecafoundation.webpokedexgame.DataHandler.BaseCharacterDataWriters.TrainerDataWriter;
import com.senecafoundation.webpokedexgame.DataHandler.PokedexItemDataWriters.PokemonSecondDataWriter;
import com.senecafoundation.webpokedexgame.PokedexItems.AnimatedProperties;
import com.senecafoundation.webpokedexgame.PokedexItems.Pokemon.Pokemon;
import com.senecafoundation.webpokedexgame.PokedexItems.Pokemon.PokemonWithSecondAbility;
import com.senecafoundation.webpokedexgame.Trainers.NPC;
import com.senecafoundation.webpokedexgame.Trainers.Trainer;

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
public class TrainerRestController {

    @Autowired
    TrainerDataWriter dataHandler;

    @Autowired
    @Qualifier("animatedPropertiesDataWriter")
    AnimatedPropertiesDataWriter animPropsDataHandler;

    @Autowired
    @Qualifier("pokemonSecondDataWriter")
    PokemonSecondDataWriter pokemonDataWriter;

    @PostMapping("/trainers")
    Trainer newnpc(@RequestBody Trainer newTrainer) {
        AnimatedProperties animatedProperties = newTrainer.getAnimatedProperties();
        animPropsDataHandler.Create(animatedProperties);
        newTrainer.setAnimatedProperties(animatedProperties);

        ArrayList<PokemonWithSecondAbility> sixPokemons = (ArrayList<PokemonWithSecondAbility>) newTrainer.getSixPokemon();
        for (Pokemon pokemon : sixPokemons) {
            AnimatedProperties pokemonAnimatedProperties = pokemon.getAnimatedProperties();
            animPropsDataHandler.Create(pokemonAnimatedProperties);
            pokemon.setAnimatedProperties(pokemonAnimatedProperties);
            pokemonDataWriter.Create((PokemonWithSecondAbility) pokemon);
        }
        newTrainer.setSixPokemon(sixPokemons);

        dataHandler.Create(newTrainer);
        return newTrainer;
    }

    @GetMapping("/trainers")
    List<Trainer> allnpcs() {
        return dataHandler.ReadAll();
    }

    @GetMapping("/trainers/{id}")
    Trainer getTrainerWithId(@PathVariable String id) throws Exception
    {
        return dataHandler.Read(UUID.fromString(id));
    }

    @PutMapping("/trainers/{id}")
    Trainer replaceTrainer(@RequestBody Trainer newtrainer, @PathVariable String id) throws Exception {
        Trainer trainer = (Trainer) dataHandler.Read(UUID.fromString(id));
        
        if (trainer != null) {
            AnimatedProperties propsToSave = animPropsDataHandler.Read(trainer.getAnimatedProperties().getId());
            newtrainer.getAnimatedProperties().setId(propsToSave.getId());
            animPropsDataHandler.Update(newtrainer.getAnimatedProperties());
            newtrainer.setAnimatedProperties(propsToSave);

            for (Pokemon newPokemon : newtrainer.getSixPokemon()) {
                Pokemon pokemonFromDb = pokemonDataWriter.Read(newPokemon.getID());
                newPokemon.setID(pokemonFromDb.getID());
                pokemonDataWriter.Update((PokemonWithSecondAbility) newPokemon);
            }

            newtrainer.setSixPokemon(newtrainer.getSixPokemon());

            newtrainer.setID(trainer.getID());
            dataHandler.Update(newtrainer);
            return newtrainer;
        }
        else {
            throw new Exception("Trainer with id: " + id + " not found.");
        }
    }

    @DeleteMapping("/trainer/{id}")
    void deleteTrainers(@PathVariable String id) throws Exception
    {
        dataHandler.Delete(UUID.fromString(id));
    }
}