package com.senecafoundation.webpokedexgame;

import java.util.List;
import java.util.UUID;

import com.senecafoundation.webpokedexgame.DataHandler.HomeworkDataWriter;
import com.senecafoundation.webpokedexgame.PokedexItems.Homework;
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
public class HomeworkRestController {
    
@Autowired 
@Qualifier("HomeworkDataWriter")
HomeworkDataWriter dataHandler;

    @PostMapping("/homeworks")
        Homework newHomework(@RequestBody Homework newHomework) {
        dataHandler.Create(newHomework);
        return newHomework;
    }

    @GetMapping("/homeworks")
    List<PokedexItem> allHomeworks() {
        return dataHandler.ReadAll();
    }
    
    @PutMapping("/homeworks/{id}")
    Homework replaceHomework(@RequestBody Homework newHomework, @PathVariable String id) throws Exception {
        Homework homeworks = (Homework) dataHandler.Read(UUID.fromString(id));
        if (homeworks != null) {
            newHomework.setID(homeworks.getID());
            dataHandler.Update(newHomework);
            return newHomework;
        }
        else {
            throw new Exception("Homework with id: " + id + " not found.");
        }
    }

    @DeleteMapping("/homeworks/{id}")
    void deleteHomeworks(@PathVariable String id) throws Exception
    {
        dataHandler.Delete(UUID.fromString(id));
    }
    
}
