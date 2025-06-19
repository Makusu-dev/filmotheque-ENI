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
        return "liste-films";
    }

    @RequestMapping(path="/detail",  method = {RequestMethod.GET, RequestMethod.POST})
    private String detail(@RequestParam(defaultValue = "0") int id, @RequestParam(defaultValue = "true") boolean readonly , Model filmListModel){
        Film requestedFilm= filmService.consulterFilmParId(id);// souci d'index quid émarre a 1
        filmListModel.addAttribute("requestedFilm", requestedFilm);
        filmListModel.addAttribute("readonly", readonly);
        //System.out.println(requestedFilm);
        //System.out.println(readonly);
        List<Avis> listeAvis = filmService.consulterAvis(id);
        filmListModel.addAttribute("listeAvis", listeAvis);
        return "detail";
    }

    @RequestMapping(path="/avis",  method = {RequestMethod.GET, RequestMethod.POST})
    private String avis() {
        return "avis";
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
