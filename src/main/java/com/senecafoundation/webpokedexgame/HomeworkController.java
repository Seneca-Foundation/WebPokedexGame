package com.senecafoundation.webpokedexgame;


import com.senecafoundation.webpokedexgame.DataHandler.RepoDataWriter;
import com.senecafoundation.webpokedexgame.PokedexItems.Homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller 
@RequestMapping ("homework")
public class HomeworkController {


    @Autowired 
    @Qualifier("repoDataWriter")
    RepoDataWriter dataHandler;

    @GetMapping("/createform")
    public String showForm(Model model){
        Homework Homework = new Homework();
        model.addAttribute("homework", Homework);
        return "create_homework";
    }

    @RequestMapping(value = "/createform", method = RequestMethod.POST)
    public String submit(@ModelAttribute("homework") Homework homework, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        dataHandler.Create(homework);
        model.addAttribute("homework", homework);
        return "homework";
    }


}