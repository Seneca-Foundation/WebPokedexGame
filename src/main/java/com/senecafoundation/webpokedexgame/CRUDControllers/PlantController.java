package com.senecafoundation.webpokedexgame.CRUDControllers;


import java.util.List;
import java.util.UUID;

import com.senecafoundation.webpokedexgame.DataHandler.PokedexItemDataWriters.PlantDataWriter;
import com.senecafoundation.webpokedexgame.PokedexItems.Plant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller 
@RequestMapping ("plant")
public class PlantController {

    @Autowired 
    @Qualifier("plantDataWriter")
    PlantDataWriter dataHandler;

    @GetMapping("/createform")
    public String showForm(Model model){
        Plant plant = new Plant();
        model.addAttribute("plant", plant);
        return "create_plant";
    }

    @RequestMapping(value = "/createform", method = RequestMethod.POST)
    public String submit(@ModelAttribute("plant") Plant plant, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        dataHandler.Create(plant);
        model.addAttribute("plant", plant);
        return "plant";
    }

    @GetMapping("/deleteform")
    public String showFormDelete(Model model){
        List<Plant> plantList = dataHandler.ReadAll(); 
        model.addAttribute("plantList", plantList);
        return "delete_plant";
    }

    @RequestMapping(value = "/deleteform/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") String Id, ModelMap model) {
        try {
            dataHandler.Delete(UUID.fromString(Id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("Id", Id);
        return "itemdelete";
    }

    @RequestMapping(value ="/updateform/{id}", method = RequestMethod.GET)
    public String showFormUpdate(@PathVariable("id") String Id, Model model) {

        Plant readPlant; 
        try {
            readPlant = (Plant) dataHandler.Read(UUID.fromString(Id));
            model.addAttribute("plant", readPlant);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return "create_plant";
    }

    @RequestMapping(value ="/updateForm", method = RequestMethod.POST)
    public String change (Plant plant, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        dataHandler.Update(plant);
        return "plant";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showFormRead(@PathVariable("id") String Id, Model model) {

        Plant readPlant;
        try {
            readPlant = (Plant) dataHandler.Read(UUID.fromString(Id));
            model.addAttribute("plant", readPlant);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return "plant"; 
    }



} 