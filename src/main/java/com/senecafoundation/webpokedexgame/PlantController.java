package com.senecafoundation.webpokedexgame;


import com.senecafoundation.webpokedexgame.DataHandler.RepoDataWriter;
import com.senecafoundation.webpokedexgame.PokedexItems.Plant;

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
    RepoDataWriter dataHandler;

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
        
        return "delete_plant";

    }


}
