package com.senecafoundation.webpokedexgame;

import java.util.List;
import java.util.UUID;

import com.senecafoundation.webpokedexgame.DataHandler.AnimatedPropertiesDataWriter;
import com.senecafoundation.webpokedexgame.DataHandler.BearDataWriter;
import com.senecafoundation.webpokedexgame.PokedexItems.AnimatedProperties;
import com.senecafoundation.webpokedexgame.PokedexItems.Bear;

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
public class BearRestController {
    
    @Autowired
    @Qualifier("bearDataWriter")
    BearDataWriter dataHandler;

    @Autowired
    @Qualifier("animatedPropertiesDataWriter")
    AnimatedPropertiesDataWriter animPropsDataHandler;

    @PostMapping("/bears")
    Bear newBear(@RequestBody Bear newBears) {
        AnimatedProperties animatedProperties = newBears.getAnimatedProperties();
        animPropsDataHandler.Create(animatedProperties);
        newBears.setAnimatedProperties(animatedProperties);
        dataHandler.Create(newBears);
        return newBears;
    }

    @GetMapping("/bears")
    List<Bear> allBears() {
        return dataHandler.ReadAll();
    }


    @GetMapping("/bears/{id}")
    Bear getBeatWithId(@PathVariable String id) throws Exception
    {
        return dataHandler.Read(UUID.fromString(id));
    }
    
    @PutMapping("/bears/{id}")
    Bear replaceBear(@RequestBody Bear newBears, @PathVariable String id) throws Exception {
        Bear bears = (Bear) dataHandler.Read(UUID.fromString(id));
        if (bears != null) {
            newBears.setID(bears.getID());
            dataHandler.Update(newBears);
            return newBears;
        }
        else {
            throw new Exception("Bear with id: " + id + " not found.");
        }
    }

    @DeleteMapping("/bears/{id}")
    void deleteBears(@PathVariable String id) throws Exception
    {
        dataHandler.Delete(UUID.fromString(id));
    }
    
}