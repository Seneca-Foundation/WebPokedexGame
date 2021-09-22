package com.senecafoundation.webpokedexgame;


import java.util.List;
import java.util.UUID;

import javax.activation.DataHandler;

import com.senecafoundation.webpokedexgame.DataHandler.PlantDataWriter;
import com.senecafoundation.webpokedexgame.DataHandler.RepoDataWriter;
import com.senecafoundation.webpokedexgame.PokedexItems.Plant;
import com.senecafoundation.webpokedexgame.PokedexItems.PokedexItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller 
@RequestMapping ("plant")
public class PlantController {

    @Autowired 
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
        //Plant plant = new Plant();
        List<PokedexItem> plantList = dataHandler.ReadAll(); 
        model.addAttribute("plantList", plantList);
        return "delete_plant";
    }

    @RequestMapping(value = "/deleteform", method = RequestMethod.DELETE)
    public String delete(@ModelAttribute("plant") UUID plant, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        try {
            dataHandler.Delete(plant);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("plant",plant);
        return "plant";
    }
}