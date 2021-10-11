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

    @GetMapping("/plants")
    List<PokedexItem> plantList = dataHandler.ReadAll()


    @GetMapping("/plants/{id}")
    Plant plant(@PathVariable Long id) {

        return dataHandler.Read(UUID.fromString(id))
        .orElseThrow(() -> new Exception(id));
    }

    @PutMapping("/plants/{id}")
    Plant replacePlant(@RequestBody Plant  )


    @DeleteMapping("/plants/{id}")
    void deleteplant(@PathVariable String id) {
        PlantDataWriter.Delete(UUID.fromString(id));
    }

    
}
