package fr.eni.tp.filmotheque.controller;

import fr.eni.tp.filmotheque.bll.FilmService;
import fr.eni.tp.filmotheque.bo.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("films")

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
    private String detail(@RequestParam(defaultValue = "0") int id, Model filmListModel){
        Film requestedFilm= filmService.consulterFilmParId(id);// souci d'index quid émarre a 1
        filmListModel.addAttribute("requestedFilm", requestedFilm);
        System.out.println(requestedFilm);
        return "detail";
    }



}
