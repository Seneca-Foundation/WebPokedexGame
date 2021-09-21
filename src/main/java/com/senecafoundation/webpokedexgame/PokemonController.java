package com.senecafoundation.webpokedexgame;

import com.senecafoundation.webpokedexgame.DataHandler.RepoDataWriter;
import com.senecafoundation.webpokedexgame.PokedexItems.Pokemon.PokemonWithSecondAbility;

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
@RequestMapping("pokemonsecond")
public class PokemonController {

    @Autowired
    RepoDataWriter dataHandler;
    
    @GetMapping("/createform")
    public String showForm(Model model) {
        PokemonWithSecondAbility pokemonsecond = new PokemonWithSecondAbility();
        model.addAttribute("pokemonsecond", pokemonsecond);
        return "create_pokemonsecond";
    }

    @RequestMapping(value = "/createform", method = RequestMethod.POST)
    public String submit(@ModelAttribute("pokemonsecond") PokemonWithSecondAbility pokemonsecond, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        dataHandler.Create(pokemonsecond);
        model.addAttribute("pokemondsecond", pokemonsecond);
        return "pokemonsecond";
    }
    @GetMapping("/deleteform")
    public String showFormDelete(Model model){

        return "delete_pokemonsecond";

    }

    
}