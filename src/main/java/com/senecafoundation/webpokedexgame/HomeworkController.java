package com.senecafoundation.webpokedexgame;


import java.util.List;
import java.util.UUID;

import com.senecafoundation.webpokedexgame.DataHandler.HomeworkDataWriter;
import com.senecafoundation.webpokedexgame.DataHandler.RepoDataWriter;
import com.senecafoundation.webpokedexgame.PokedexItems.Homework;
import com.senecafoundation.webpokedexgame.PokedexItems.PokedexItem;

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
@RequestMapping ("homework")
public class HomeworkController {


    @Autowired 
    @Qualifier("homeworkDataWriter")
    HomeworkDataWriter dataHandler;

    @GetMapping("/createform")
    public String showForm(Model model){
        Homework homework = new Homework();
        model.addAttribute("homework", homework);
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
    @GetMapping("/deleteform")
    public String showFormDelete(Model model){
        List<PokedexItem> homeworkList = dataHandler.ReadAll(); 
        model.addAttribute("homeworkList", homeworkList);
        return "delete_homework";
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
    @RequestMapping(value = "/updateform/{id}", method = RequestMethod.GET)
    public String showFormUpdate(@PathVariable("id") String Id, Model model) {

        Homework readHomework;
        try {
            readHomework = (Homework) dataHandler.Read(UUID.fromString(Id));
            model.addAttribute("homework", readHomework);
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        return "create_homework";
    }



    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showFormRead(@PathVariable("id") String Id, Model model) {

       Homework readHomework;
        try {
            readHomework = (Homework) dataHandler.Read(UUID.fromString(Id));
            model.addAttribute("homework", readHomework);
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        return "homework";
    }

}