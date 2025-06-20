package fr.eni.tp.filmotheque.controller.converter;

import fr.eni.tp.filmotheque.bll.FilmService;
import fr.eni.tp.filmotheque.bo.Avis;
import fr.eni.tp.filmotheque.bo.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StringToAvisConverter implements Converter<String, List<Avis>> {

    private FilmService filmService;


    @Autowired
    public void setFilmService(FilmService filmService) {
        System.out.println("StringToAvisConverter - setFilmService");
        this.filmService = filmService;
    }

    @Override
    public List<Avis> convert(String id) {
        //attention chek if null
        System.out.println("Convert - " + id);
        Integer TheId = Integer.parseInt(id);
        return filmService.consulterAvis(TheId);
    }


}
