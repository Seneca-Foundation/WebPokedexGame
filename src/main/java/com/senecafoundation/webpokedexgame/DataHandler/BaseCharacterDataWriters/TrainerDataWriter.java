// package com.senecafoundation.webpokedexgame.DataHandler.BaseCharacterDataWriters;

// import java.util.ArrayList;
// import java.util.List;

// import com.senecafoundation.webpokedexgame.Repositories.BaseCharacterRepositories.BaseCharacterRepository;
// import com.senecafoundation.webpokedexgame.Trainers.Trainer;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// @Service
// public class TrainerDataWriter extends BaseCharacterDataWriter<Trainer> {

//     @Autowired
//     public BaseCharacterRepository<Trainer> trainerRepository;

//     @Override
//     public List<Trainer> ReadAll() {
//         ArrayList<Trainer> listOfItemsToReturn = new ArrayList<Trainer>();
//         for (Trainer trainerSecond : this.trainerRepository.findAll()) {
//             listOfItemsToReturn.add(trainerSecond);
//         }
//         return listOfItemsToReturn;
//     }
    
// }
