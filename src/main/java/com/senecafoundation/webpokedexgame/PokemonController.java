package com.senecafoundation.webpokedexgame;

import java.util.List;
import java.util.UUID;

import com.senecafoundation.webpokedexgame.DataHandler.PokemonSecondDataWriter;
import com.senecafoundation.webpokedexgame.PokedexItems.PokedexItem;
import com.senecafoundation.webpokedexgame.PokedexItems.Pokemon.PokemonWithSecondAbility;

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
@RequestMapping("pokemonsecond")
public class PokemonController {

    @Autowired
    @Qualifier("pokemonSecondDataWriter")
    PokemonSecondDataWriter dataHandler;
    
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
        List<PokedexItem> pokemonSecondList = dataHandler.ReadAll();
        model.addAttribute("pokemonSecondList", pokemonSecondList);
        return "delete_pokemonsecond";
    }

    @RequestMapping(value = "/deleteform/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") String Id, ModelMap model) {
        try {
            PokemonWithSecondAbility pokemonGettingDeleted = (PokemonWithSecondAbility) dataHandler.Read(UUID.fromString(Id));
            dataHandler.Delete(UUID.fromString(Id));
            model.addAttribute("pokemonGettingDeleted", pokemonGettingDeleted);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "pokemonSecondDelete";
    } 
}

// user can view list of spe. pokemon's traits
// user can select spe. trait to be changed
// user inputs desired change
// computer makes copy of origional pokemon with the new trait 
// computer deletes og pokemon
// computer prints and saves copy of og pokemon w/ change