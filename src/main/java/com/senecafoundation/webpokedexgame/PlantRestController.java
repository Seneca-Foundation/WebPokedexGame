package com.senecafoundation.webpokedexgame;


import com.senecafoundation.webpokedexgame.DataHandler.PlantDataWriter;
import com.senecafoundation.webpokedexgame.PokedexItems.Plant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlantRestController {
    
    @Autowired 
    @Qualifier("plantDataWriter")
    PlantDataWriter dataHandler;

    @PostMapping("/plants")
        Plant newBasketball(@RequestBody Plant newPlant) {
        dataHandler.Create(newPlant);
        return newPlant;
    }
}
