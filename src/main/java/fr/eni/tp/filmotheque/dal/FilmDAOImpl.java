package fr.eni.tp.filmotheque.dal;

import fr.eni.tp.filmotheque.bll.FilmService;
import fr.eni.tp.filmotheque.bll.FilmServiceImpl;
import fr.eni.tp.filmotheque.bo.Film;
import fr.eni.tp.filmotheque.bo.Genre;
import fr.eni.tp.filmotheque.bo.Participant;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class FilmDAOImpl implements FilmDAO {
    //Requêtes SQL
    private final String SELECT_BY_ID = "SELECT id, titre, annee, duree, synopsis, id_realisateur, id_genre FROM FILM WHERE id = ?";
    private final String SELECT_ALL = "SELECT id, titre, annee, duree, synopsis, id_realisateur, id_genre FROM FILM";
    private final String FIND_TITRE = "SELECT titre FROM FILM WHERE id =  ?";
    private final String INSERT_FILM = """
    INSERT INTO FILM ( titre, annee, duree, synopsis, id_realisateur, id_genre)
    VALUES (titre = :titre, annee = :annee, duree = :duree,
     synopsis = :synopsis, id_realisateur = :id_realisateur, id_genre = :id_genre);
    """;

    private NamedParameterJdbcTemplate npjdbc;
    private FilmService filmService;

    public FilmDAOImpl(NamedParameterJdbcTemplate npjdbc) {
        this.npjdbc = npjdbc;
        this.filmService = filmService;
    }

    @Override
    public int create(Film film) {
        //attention remonter la clé primaire créée
        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("titre", film.getTitre());
        paramSource.addValue("annee", film.getAnnee());
        paramSource.addValue("duree", film.getDuree());
        paramSource.addValue("synopsis", film.getSynopsis());
        paramSource.addValue("id_realisateur", film.getRealisateur().getId());
        paramSource.addValue("id_genre", film.getGenre().getId());


        int nb_enregistrement = npjdbc.update(INSERT_FILM, paramSource, keyHolder);

        if (keyHolder!=null && keyHolder.getKey() != null){
            film.setId(keyHolder.getKey().longValue());
        }
        return nb_enregistrement;
    }

    @Override
    public Film read(long id) {

        return npjdbc.getJdbcOperations().queryForObject(SELECT_BY_ID, new FilmRowMapper(),id);
    }



    @Override
    public List<Film> findAll() {
        return npjdbc.getJdbcOperations().query(SELECT_ALL, new FilmRowMapper());
    }

    @Override
    public String findTitre(long id) {
        return npjdbc.getJdbcOperations().queryForObject(FIND_TITRE, new BeanPropertyRowMapper<>(String.class), id);
    }


    //définition du rowMapper ci-dessus pour associer les Réalisateurs et genre

    class FilmRowMapper implements RowMapper<Film>  {

        @Override
        public Film mapRow(ResultSet rs, int rowNum) throws SQLException {
            Film film = new Film();
            film.setTitre(rs.getString("titre"));
            film.setAnnee(rs.getInt("annee"));
            film.setDuree(rs.getInt("duree"));
            film.setSynopsis(rs.getString("synopsis"));

            //Association
            Participant realisateur = new Participant();
            realisateur.setId(rs.getLong("id_realisateur"));
            film.setRealisateur(realisateur);

            Genre genre = new Genre();
            genre.setId(rs.getLong("id_genre"));
            film.setGenre(genre);
            return film;
        }
    }
}
