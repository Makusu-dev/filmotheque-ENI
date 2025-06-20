package fr.eni.tp.filmotheque.controller.converter;

import fr.eni.tp.filmotheque.bll.FilmService;
import fr.eni.tp.filmotheque.bo.Genre;
import fr.eni.tp.filmotheque.bo.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToParticipantConverter implements Converter<String, Participant> {

    private FilmService filmService;

    @Autowired
    public void setFilmService(FilmService filmService) {
        System.out.println("StringToParticipantConverter - setFilmService");
        this.filmService = filmService;
    }

    @Override
    public Participant convert(String id) {
        //attention chek if null
        System.out.println("Convert - " + id);
        Integer TheId = Integer.parseInt(id);
        return filmService.consulterParticipantParId(TheId);
    }

}
