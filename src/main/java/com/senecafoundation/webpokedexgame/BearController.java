package com.senecafoundation.webpokedexgame;


import com.senecafoundation.webpokedexgame.DataHandler.RepoDataWriter;
import com.senecafoundation.webpokedexgame.PokedexItems.Bear;

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
@RequestMapping ("bear")
public class BearController {

    @Autowired 
    RepoDataWriter dataHandler;

    @GetMapping("/createform")
    public String showForm(Model model){
        Bear bear = new Bear();
        model.addAttribute("bear", bear);
        return "create_bear";
    }

    @RequestMapping(value = "/createform", method = RequestMethod.POST)
    public String submit(@ModelAttribute("bear") Bear bear, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        dataHandler.Create(bear);
        model.addAttribute("bear", bear);
        return "bear";
    }


}