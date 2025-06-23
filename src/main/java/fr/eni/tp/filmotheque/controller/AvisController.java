package fr.eni.tp.filmotheque.controller;

import fr.eni.tp.filmotheque.bll.FilmService;
import fr.eni.tp.filmotheque.bo.Avis;
import fr.eni.tp.filmotheque.bo.Film;
import fr.eni.tp.filmotheque.bo.Membre;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(path="/avis",method = {RequestMethod.GET,RequestMethod.POST})
@Controller
@SessionAttributes({"membreSession"})
public class AvisController {

    private FilmService filmService;

    public AvisController(FilmService filmService){
        this.filmService = filmService;
    }

    @GetMapping("/creer-avis")
     private String creerAvis(@RequestParam(defaultValue = "0") long filmId, Model avis){
        Film film = filmService.consulterFilmParId(filmId);
        //System.out.println(filmId);
        //System.out.println(film);
        //On peux aussi transmettre le titre et l'id séparément pour optimiser
        avis.addAttribute("film", film);
        avis.addAttribute("avis",new Avis());
        return "view-avis-creer";
    }

    @PostMapping("/publier")
        private ModelAndView publier(@RequestParam int filmId, Avis avis,
                                     @ModelAttribute("membreEnSession") Membre membreEnSession){
        avis.setMembre(membreEnSession);
        filmService.publierAvis(avis,filmId);
        return new ModelAndView("redirect:/films/liste-films","avis",avis);
    }





}
