package com.senecafoundation.webpokedexgame.DataHandler.PokedexItemDataWriters;

import java.util.ArrayList;
import java.util.List;

import com.senecafoundation.webpokedexgame.PokedexItems.Homework;
import com.senecafoundation.webpokedexgame.Repositories.PokedexItemRepositories.PokedexItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class HomeworkDataWriter extends PokedexItemDataWriter<Homework> {

    @Autowired 
    public PokedexItemRepository<Homework> pokedexItemRepository;

    @Override
    public List<Homework> ReadAll() {
        ArrayList<Homework> listOfHomeworksToReturn = new ArrayList<Homework>();
        for (Homework homework : this.pokedexItemRepository.findAll()) {
            listOfHomeworksToReturn.add(homework);
        }
        return listOfHomeworksToReturn;
    }
    
}