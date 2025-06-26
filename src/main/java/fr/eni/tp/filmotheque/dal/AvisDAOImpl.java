package fr.eni.tp.filmotheque.dal;

import fr.eni.tp.filmotheque.bo.Avis;
import fr.eni.tp.filmotheque.bo.Participant;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AvisDAOImpl implements AvisDAO{
    // Requêtes SQl
    private final String INSERT_AVIS =  "INSERT INTO AVIS note, commentaire, id_membre, id_film VALUES (note = :note, commentaire= :commentaire, id_membre = :id_membre, id_film = :id_film);";
    private final String FIND_BY_FILM = "SELECT id, note, commentaire, id_membre,id_film FROM AVIS WHERE id_film = ?";

    private NamedParameterJdbcTemplate npjdbc;

    public AvisDAOImpl(NamedParameterJdbcTemplate npjdbc) {
        this.npjdbc = npjdbc;
    }

    @Override
    public int create(Avis avis, long idFilm) {
        //keyholder?
        MapSqlParameterSource namedParameters =  new MapSqlParameterSource();

        namedParameters.addValue("note", avis.getNote());
        namedParameters.addValue("commentaire", avis.getCommentaire());
        namedParameters.addValue("id_membre", avis.getMembre().getId());
        namedParameters.addValue("id_film", idFilm);

        return npjdbc.update(INSERT_AVIS, namedParameters);
    }

    @Override
    public List<Avis> findByIdFilm(long idFilm) {
        return npjdbc.getJdbcOperations().query(FIND_BY_FILM, new BeanPropertyRowMapper<>(Avis.class), idFilm);
    }
}
