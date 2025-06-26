package fr.eni.tp.filmotheque.bll;

import fr.eni.tp.filmotheque.bo.*;
import fr.eni.tp.filmotheque.dal.*;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service
@Profile("dev")
public class FilmServiceImpl implements FilmService {
    //requêtes SQL




// implementation des DAO
    private final FilmDAO filmDAO;
    private final GenreDAO genreDAO;
    private final AvisDAO avisDAO;
    private final MembreDAO membreDAO;
    private final ParticipantDAO participantDAO;



    private NamedParameterJdbcTemplate npjdbc;

    public FilmServiceImpl(FilmDAO filmDAO, GenreDAO genreDAO, AvisDAO avisDAO, MembreDAO membreDAO, ParticipantDAO participantDAO ,NamedParameterJdbcTemplate npjdbc) {
        this.filmDAO = filmDAO;
        this.genreDAO = genreDAO;
        this.avisDAO = avisDAO;
        this.membreDAO = membreDAO;
        this.participantDAO = participantDAO;
        this.npjdbc = npjdbc;

    }

    @Override
    public List<Film> consulterFilms() {
        return filmDAO.findAll();
    }

    @Override
    public Film consulterFilmParId(long id) {
        return filmDAO.read(id);
    }

    @Override
    public List<Genre> consulterGenres() {
        return genreDAO.findAll();
    }

    @Override
    public List<Participant> consulterParticipants() {
        return participantDAO.findAll();
    }

    @Override
    public Genre consulterGenreParId(long id) {
        return genreDAO.read(id);
    }

    @Override
    public Participant consulterParticipantParId(long id) {
        return participantDAO.read(id);
    }

    @Override
    public void creerFilm(Film film) {
        filmDAO.create(film);
    }

    @Override
    public String consulterTitreFilm(long id) {
        return filmDAO.findTitre(id);
    }

    @Override
    public void publierAvis(Avis avis, long idFilm) {
        avisDAO.create(avis, idFilm);
    }

    @Override
    public List<Avis> consulterAvis(long idFilm) {
        return avisDAO.findByIdFilm(idFilm);
    }
}
