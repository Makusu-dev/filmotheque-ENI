package fr.eni.tp.filmotheque.dal;

import fr.eni.tp.filmotheque.bo.Film;

import java.util.List;

public class FilmDAOImpl implements FilmDAO {

    @Override
    public void create(Film film) {

    }

    @Override
    public Film read(long id) {
        return null;
    }

    @Override
    public List<Film> findAll() {
        return List.of();
    }

    @Override
    public String findTitre(long id) {
        return "";
    }
}
