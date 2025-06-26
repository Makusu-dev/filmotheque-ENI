package fr.eni.tp.filmotheque.dal;

import fr.eni.tp.filmotheque.bo.Participant;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ParticipantDAOImpl implements ParticipantDAO{

    //Requêtes SQL
    private String FIND_ALL = "SELECT id, nom, prenom FROM PARTICIPANT";
    private String FIND_BY_ID = "SELECT id, nom, prenom FROM PARTICIPANT WHERE id = ?";

    private String FIND_ACTEURS_BY_FILM_ID = "SELECT id, nom, prenom FROM ACTEURS AS a INNER JOIN PARTICIPANT as p ON (a.id_participant = p.id) WHERE p.id = ? ; ";

    private String CREATE_ACTEUR = "INSERT INTO ACTEURS (id_film, id_participant) VALUES (id_film = :id_film, id_participant = :id_participant)";


    private NamedParameterJdbcTemplate npjdbc;

    public ParticipantDAOImpl(NamedParameterJdbcTemplate npjdbc) {
        this.npjdbc = npjdbc;
    }

    @Override
    public Participant read(long id) {
        return npjdbc.getJdbcOperations().queryForObject(FIND_BY_ID, new BeanPropertyRowMapper<>(Participant.class), id);
    }

    @Override
    public List<Participant> findAll() {
        return npjdbc.getJdbcOperations().query(FIND_ALL, new BeanPropertyRowMapper<>(Participant.class));
    }

    @Override
    public List<Participant> findActeurs(long idFilm) {
        return npjdbc.getJdbcOperations().query(FIND_ACTEURS_BY_FILM_ID, new BeanPropertyRowMapper<>(Participant.class), idFilm);
    }

    @Override
    public int createActeur(long idParticipant, long idFilm) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id_film", idFilm);
        namedParameters.addValue("id_participant", idParticipant);
        return npjdbc.update(CREATE_ACTEUR, namedParameters);
    }
}
