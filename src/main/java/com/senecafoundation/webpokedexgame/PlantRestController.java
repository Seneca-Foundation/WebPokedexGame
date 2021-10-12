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
    
    // @PostMapping("/plants")
    //     Plant newPlant(@RequestBody Plant newPlant) {
    //     dataHandler.Create(newPlant);
    //     return newPlant;
    // }


    // @GetMapping("/plants/{id}")
    // Plant plant(@PathVariable String id) {

    //     dataHandler.Read(UUID.fromString(id))
    //     .orElseThrow(() -> newPlantNotFoundException(id));
    // }

    @GetMapping("/plants") //ReadAll of the items in Plant 
    List<PokedexItem> all() {
        return dataHandler.ReadAll();
    }

    @PostMapping("/plants") //Updating a Plant? I think 
    Plant newPlant(@RequestBody Plant newPlant) {
        return (Plant) dataHandler.Update(newPlant);
    }


    @GetMapping("/plants/{id}") //Read a Single Item
    Plant plant(@PathVariable String id) throws Exception {
        return (Plant) dataHandler.Read(UUID.fromString(id));
    }

    @PutMapping("/plants/{id}") //Idk what this part does 
    Plant replacePlant(@RequestBody Plant newPlant, @PathVariable String id) {
        return dataHandler.Read(UUID.fromString(id))
        .map( plant -> {
            plant.setSmell(newPlant.getName());
            plant.setHasLeaves(newPlant.getHasLeaves());
            return dataHandler.Create(plant);
        })
        .orElseGet(() -> {
            newPlant.setId(id);
            return dataHandler.Create(newPlant);
        });
    }

    @DeleteMapping("/plants/{id}")
    void deletePlant(@PathVariable String id) {
        try {
            dataHandler.Delete(UUID.fromString(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
