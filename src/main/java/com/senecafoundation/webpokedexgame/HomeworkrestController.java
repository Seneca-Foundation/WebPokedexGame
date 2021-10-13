package com.senecafoundation.webpokedexgame;

import java.util.UUID;

import com.senecafoundation.webpokedexgame.DataHandler.HomeworkDataWriter;
import com.senecafoundation.webpokedexgame.PokedexItems.Homework;

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
public class HomeworkRestController {
    
    @Autowired 
    @Qualifier("HomeworkDataWriter")
    HomeworkDataWriter dataHandler;

    @PostMapping("/Homeworks")
        Homework newHomework(@RequestBody Homework newHomework) {
        dataHandler.Create(newHomework);
        return newHomework;
    }
    @GetMapping("/Homeworks")
    Homework allHomeworks() {
        return (Homework) dataHandler.ReadAll();
    }
    
    @PutMapping("/Homework{id}")
    Homework replaceHomework(@RequestBody Homework newHomework, @PathVariable String id) throws Exception {
        Homework homework= (Homework) dataHandler.Read(UUID.fromString(id));
        if (homework != null) {
            newHomework.setID(homework.getID());
            dataHandler.Update(newHomework(newHomework);
            return newHomework;
        }
        else {
            throw new Exception("Homework with id: " + id + " not found.");
        }
    }

    @DeleteMapping("/Homeworks/{id}")
    void deleteHomeworks(@PathVariable String id) throws Exception
    {
        dataHandler.Delete(UUID.fromString(id));
    }
    
}
