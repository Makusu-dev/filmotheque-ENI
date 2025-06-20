package fr.eni.tp.filmotheque.controller;

import fr.eni.tp.filmotheque.bll.FilmService;
import fr.eni.tp.filmotheque.bo.Avis;
import fr.eni.tp.filmotheque.bo.Film;
import fr.eni.tp.filmotheque.bo.Genre;
import fr.eni.tp.filmotheque.bo.Membre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping({"/","films"})
@SessionAttributes({"genreSession","membreSession"})
@Controller
public class FilmController {

    private FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService){
        this.filmService = filmService;
    }



    @RequestMapping(path="/liste-films",  method = {RequestMethod.GET, RequestMethod.POST})
        private String listerFilms(Model filmListModel){
        List<Film> listeFilms = filmService.consulterFilms();
        filmListModel.addAttribute("listeFilms", listeFilms);
        return "view-liste-films";
    }

    @RequestMapping(path="/detail",  method = {RequestMethod.GET, RequestMethod.POST})
    private String detail(@RequestParam(defaultValue = "0") int id, @RequestParam(defaultValue = "true") boolean readonly , Model detail){
        Film film= filmService.consulterFilmParId(id);// souci d'index quid émarre a 1
        detail.addAttribute("film", film);
        //System.out.println(requestedFilm);
        //System.out.println(readonly);
        List<Avis> listeAvis = filmService.consulterAvis(id);
        detail.addAttribute("listeAvis", listeAvis);

        return "view-film-detail";
    }

    // mise a jour d'un film (méthode non existante dans le service pour le moment)
    /*
    @RequestMapping(path="/detail",  method = {RequestMethod.GET, RequestMethod.POST})
    public String detail(@ModelAttribute("film") Film film) {
        System.out.println("Le film récupéré depuis le modèle: ");
        System.out.println(film);
        filmService.majFilm();
        return "redirect:/films/liste-films";
    }
     */

    @GetMapping("/creer")
    public ModelAndView creerFilm(){
        Film film = new Film();
        return new ModelAndView("view-film-creer", "film", film);
    }

    @PostMapping("/creer")
    public String creerFilm(@ModelAttribute("film") Film film){
        filmService.creerFilm(film);
        return "redirect:/liste-films";
    }

    @RequestMapping(path="/avis",  method = {RequestMethod.GET, RequestMethod.POST})
    private String avis() {
        return "view-avis-creer";
    }

    // Méthode pour charger la liste des cours en session
    @ModelAttribute("genreSession")
    public List<Genre> chargerGenresSession() {
        System.out.println("Les genre ont été chargs en session");
        return filmService.consulterGenres();
    }

    @ModelAttribute("membreSession")
    public Membre AddMembre(){
        System.out.println("Add Attribut Membre to Session");
        return new Membre();
    }



}
