package com.senecafoundation.webpokedexgame.DataHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.senecafoundation.webpokedexgame.PokedexItems.AnimatedProperties;
import com.senecafoundation.webpokedexgame.PokedexItems.Bear;
import com.senecafoundation.webpokedexgame.PokedexItems.Homework;
import com.senecafoundation.webpokedexgame.PokedexItems.Plant;
import com.senecafoundation.webpokedexgame.PokedexItems.PokedexItem;
import com.senecafoundation.webpokedexgame.PokedexItems.Pokemon.PokemonWithSecondAbility;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FileDataWriter<T> extends DataWriter<T> {

    private String fileLocation;
    private File file;
    private Scanner scanner;

    public FileDataWriter(String fileLocationFromUser) {
        this.fileLocation = fileLocationFromUser;
        try {
            this.file = new File(fileLocationFromUser);
            this.scanner = new Scanner(this.file);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    @Override
    public void Create(T item) {
        try {
            // See if it exists in the file already
            this.Read(((PokedexItem) item).getID());
        }
        catch (Exception e) { // We catch the custom error here (from line 60)
            if (e.getMessage() == "Item not found with that ID" || e instanceof FileNotFoundException) {
                // Was not found in the file - add it
                BufferedWriter bw;
                try {
                    bw = new BufferedWriter(new FileWriter(this.fileLocation, true));
                    bw.write(item.toString());
                    bw.newLine();
                    bw.flush();
                    bw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }        
    }

	@Override
    public PokedexItem Read(UUID ID) throws Exception {
        //now read the file line by line...
        if (this.file != null) {
            this.scanner = new Scanner(this.file);
            while (this.scanner != null && this.scanner.hasNextLine()) {
                String line = this.scanner.nextLine();
                if(line.contains(ID.toString())) { 
                    String[] props = line.split(",");
                    if (props[0].equals("Bear")) {
                        Bear bearToReturn = new Bear(props[2], props[3], Boolean.parseBoolean(props[4]), Integer.parseInt(props[5]), props [6], this);
                        bearToReturn.setID(UUID.fromString(props[1]));
                        return bearToReturn;
                    }
                }
            }
        }
        // We throw a custom error here if we can't find anything with that ID
        throw new Exception("Item not found with that ID");
    }

    

    @Override
    public PokedexItem Update(PokedexItem itemToUpdate) {
        try {
            this.Delete(itemToUpdate.getID());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.Create((T) itemToUpdate);
        return itemToUpdate;
    }

    @Override
    public Boolean Delete(UUID ID) throws Exception {
        //now read the file line by line...
        ArrayList<String> lines = new ArrayList<String>();
        if (this.file != null) {
            this.scanner = new Scanner(this.file);
            while (this.scanner != null && this.scanner.hasNextLine()) {
                String line = this.scanner.nextLine();
                if(!line.contains(ID.toString())) { 
                    lines.add(line);
                }
            }
        }

        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(this.fileLocation));
            lines.forEach(lineToWrite ->
                { 
                    try {
                        bw.write(lineToWrite);
                        bw.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            );
            bw.flush();
            bw.close();
            return true;
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        // We throw a custom error here if we can't find anything with that ID
        throw new Exception("Item not found with that ID");
    }

    @Override
    public List<PokedexItem> ReadAll() {
        List<PokedexItem> pokedexItemstoReturn = new ArrayList<PokedexItem>();
        try {
            this.file = new File(fileLocation);
            this.scanner = new Scanner(this.file);
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (this.scanner != null && this.scanner.hasNextLine()) {

            String line = this.scanner.nextLine();

            String[] props = line.split(",");

            if(props[0].equals("PokemonWithSecondAbility")) {
                PokemonWithSecondAbility pokemonToAdd = new PokemonWithSecondAbility(
                    props[2], 
                    props[3], 
                    props[4], 
                    props[5], 
                    props[6], 
                    Integer.parseInt(props[7]), 
                    Integer.parseInt(props[8]), 
                    Integer.parseInt(props[9]), 
                    Integer.parseInt(props[10]), 
                    Integer.parseInt(props[11]), 
                    Integer.parseInt(props[12]), 
                    props[13], 
                    props[14], 
                    props[15], 
                    props[16], 
                    new AnimatedProperties(),
                    this
                );
                pokemonToAdd.setID(UUID.fromString(props[1]));       
                pokedexItemstoReturn.add(pokemonToAdd);
            }
            else if (props[0].equals("Bear")) {
                Bear bearToAdd = new Bear(
                    props[2],
                    props[3],
                    Boolean.parseBoolean(props[4]),
                    Integer.parseInt(props[5]),
                    props[6],
                    this
                );
                bearToAdd.setID(UUID.fromString(props[1]));
                pokedexItemstoReturn.add(bearToAdd);
            }
            else if (props[0].equals("Plant")) {
                Plant plantToAdd = new Plant (
                    props [2],
                    props [3],
                    Boolean.parseBoolean(props[4]),
                    Boolean.parseBoolean(props[5]),
                    Boolean.parseBoolean(props[6]),
                    Boolean.parseBoolean(props[7]),
                    props [8],
                    this
                );
                plantToAdd.setID(UUID.fromString(props[1]));
                pokedexItemstoReturn.add(plantToAdd);
            }
            else if (props[0].equals("Homework")) {
                Homework homeworkToAdd = new Homework (
                );
                homeworkToAdd.setID(UUID.fromString(props[1]));
                pokedexItemstoReturn.add(homeworkToAdd);
                
            }
        }
        return pokedexItemstoReturn;
    }


}

   