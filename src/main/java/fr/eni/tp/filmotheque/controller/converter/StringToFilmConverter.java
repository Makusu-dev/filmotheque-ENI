
package fr.eni.tp.filmotheque.controller.converter;

import fr.eni.tp.filmotheque.bll.FilmService;


import fr.eni.tp.filmotheque.bo.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

    @Component
    public class StringToFilmConverter implements Converter<String, Film> {

        private FilmService filmService;


        @Autowired
        public void setFilmService(FilmService filmService) {
            System.out.println("StringToFilmConverter - setFilmService");
            this.filmService = filmService;
        }

        @Override
        public Film convert(String id) {
            //attention chek if null
            System.out.println("Convert - " + id);
            Integer TheId = Integer.parseInt(id);
            return filmService.consulterFilmParId(TheId);
        }


    }


