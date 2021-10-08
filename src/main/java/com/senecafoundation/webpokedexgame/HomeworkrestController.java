package com.senecafoundation.webpokedexgame;

import com.senecafoundation.webpokedexgame.DataHandler.HomeworkDataWriter;
import com.senecafoundation.webpokedexgame.PokedexItems.Homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeworkRestController {
    
    @Autowired 
    @Qualifier("HomeworkDataWriter")
    HomeworkDataWriter dataHandler;

    @PostMapping("/Homeworks")
        Homework newHomework(@RequestBody Homework newHomework) {
        dataHandler.Create(newHomework);
        return newHomework;
    }
}
