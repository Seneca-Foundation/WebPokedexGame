package com.senecafoundation.webpokedexgame.RESTControllers;

import java.util.List;
import java.util.UUID;
import com.senecafoundation.webpokedexgame.DataHandler.AnimatedPropertiesDataWriter;
import com.senecafoundation.webpokedexgame.DataHandler.BaseCharacterDataWriters.NPCDataWriter;
import com.senecafoundation.webpokedexgame.PokedexItems.AnimatedProperties;
import com.senecafoundation.webpokedexgame.Trainers.NPC;
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
public class NPCRestController {

    @Autowired
    NPCDataWriter dataHandler;

    @Autowired
    @Qualifier("animatedPropertiesDataWriter")
    AnimatedPropertiesDataWriter animPropsDataHandler;

    @PostMapping("/npcs")
    NPC newnpc(@RequestBody NPC newnpc) {
        AnimatedProperties animatedProperties = newnpc.getAnimatedProperties();
        animPropsDataHandler.Create(animatedProperties);
        newnpc.setAnimatedProperties(animatedProperties);
        dataHandler.Create(newnpc);
        return newnpc;
    }

    @GetMapping("/npcs")
    List<NPC> allnpcs() {
        return dataHandler.ReadAll();
    }

    @GetMapping("/npcs/{id}")
    NPC getPokemonWithId(@PathVariable String id) throws Exception
    {
        return dataHandler.Read(UUID.fromString(id));
    }

    @PutMapping("/npcs/{id}")
    NPC replacePokemonWithSecondAbility(@RequestBody NPC newnpc, @PathVariable String id) throws Exception {
        NPC npcs = (NPC) dataHandler.Read(UUID.fromString(id));
        
        if (npcs != null) {
            AnimatedProperties propsToSave = animPropsDataHandler.Read(npcs.getAnimatedProperties().getId());
            newnpc.getAnimatedProperties().setId(propsToSave.getId());
            animPropsDataHandler.Update(newnpc.getAnimatedProperties());
            newnpc.setAnimatedProperties(propsToSave);
            newnpc.setID(npcs.getID());
            dataHandler.Update(newnpc);
            return newnpc;
        }
        else {
            throw new Exception("Pokemon with id: " + id + " not found.");
        }
    }

    @DeleteMapping("/npcs/{id}")
    void deletenpcs(@PathVariable String id) throws Exception
    {
        dataHandler.Delete(UUID.fromString(id));
    }
}