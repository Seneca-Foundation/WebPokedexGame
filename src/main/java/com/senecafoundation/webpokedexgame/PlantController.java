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
@RequestMapping ("plantsecond")
public class PlantController {

    @Autowired 
    RepoDataWriter dataHandler;

    @GetMapping("/createplant")
    public String showForm(Model model){
        Plant plantsecond = new Plant();
        return "create_plantsecond";
    }

    @RequestMapping(value = "/createplant", method = RequestMethod.POST)
    public String submit(@ModelAttribute("plantsecond") Plant plantsecond, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
    dataHandler.Create(plantsecond);
    model.addAttribute("plantsecond", plantsecond);
    return "plantsecond";
    }


}
