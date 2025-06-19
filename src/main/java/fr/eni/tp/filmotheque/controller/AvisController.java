package fr.eni.tp.filmotheque.controller;

import fr.eni.tp.filmotheque.bll.FilmService;
import fr.eni.tp.filmotheque.bo.Avis;
import fr.eni.tp.filmotheque.bo.Film;
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

    @GetMapping("/creer")
     private String creerAvis(@RequestParam(defaultValue = "0") int filmId, Model model){
        Film film = filmService.consulterFilmParId(filmId);
        System.out.println(filmId);
        System.out.println(film);
        model.addAttribute("film", film);
        return "avis";
    }

    @PostMapping("/publier")
        private ModelAndView publierAvis(@RequestParam int filmId, Avis avis){
        filmService.publierAvis(avis,filmId);
        return new ModelAndView("redirect:/films/liste-films","avis",avis);
    }





}
