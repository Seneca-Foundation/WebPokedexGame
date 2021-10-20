package com.senecafoundation.webpokedexgame;

import java.util.List;
import java.util.UUID;

import com.senecafoundation.webpokedexgame.DataHandler.BearDataWriter;
import com.senecafoundation.webpokedexgame.PokedexItems.Bear;
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
@RequestMapping ("bear")
public class BearController {
    

    @Autowired  
    @Qualifier("bearDataWriter")
    BearDataWriter dataHandler;

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

    @GetMapping("/deleteform")
    public String showFormDelete(Model model) {
        List<PokedexItem> bearList = dataHandler.ReadAll();
        model.addAttribute("bearList", bearList);
        return "delete_bear";
    }

    @RequestMapping(value = "/deleteform/{id}", method = RequestMethod.DELETE )
    public String delete(@PathVariable("id") String Id, ModelMap model) {
        try {
            dataHandler.Delete(UUID.fromString(Id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("Id", Id);
        return "itemdelete";

    }

    @RequestMapping(value = "/updateForm/{id}", method = RequestMethod.GET)
    public String showFormUpdate(@PathVariable("id") String Id, Model model) {

        Bear readBear;
        try {
            readBear = (Bear) dataHandler.Read(UUID.fromString(Id));
            model.addAttribute("bear", readBear);
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        return "create_bear";
    }

    @RequestMapping(value="/updateForm", method = RequestMethod.POST)
    public String change(Bear bear, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        dataHandler.Update(bear);
        return "bear";   
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showFormRead(@PathVariable("id") String Id, Model model) {

        Bear readBear;
        try {
            readBear = (Bear) dataHandler.Read(UUID.fromString(Id));
            model.addAttribute("bear", readBear);
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        return "bear";
    }
}