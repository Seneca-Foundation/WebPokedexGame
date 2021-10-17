package com.senecafoundation.webpokedexgame;

import java.util.List;
import java.util.UUID;

import com.senecafoundation.webpokedexgame.DataHandler.PlantDataWriter;
import com.senecafoundation.webpokedexgame.PokedexItems.Plant;
import com.senecafoundation.webpokedexgame.PokedexItems.PokedexItem;

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
public class PlantRestController {
    
    @Autowired
    @Qualifier("plantDataWriter")
    PlantDataWriter dataHandler;

    @PostMapping("/plants")
    Plant newPlants(@RequestBody Plant newPlants) {
        dataHandler.Create(newPlants);
        return newPlants;
    }

    @GetMapping("/plants")
    List<PokedexItem> allPlants() {
        return dataHandler.ReadAll();
    }
    
    @PutMapping("/plants/{id}")
    Plant replacePlants(@RequestBody Plant newPlants, @PathVariable String id) throws Exception {
        Plant plants = (Plant) dataHandler.Read(UUID.fromString(id));
        if (plants != null) {
            newPlants.setID(plants.getID());
            dataHandler.Update(newPlants);
            return newPlants;
        }
        else {
            throw new Exception("Pokemon with id: " + id + " not found.");
        }
    }

    @DeleteMapping("/plants/{id}")
    void deletePlants(@PathVariable String id) throws Exception
    {
        dataHandler.Delete(UUID.fromString(id));
    }
    
}
