package fr.eni.tp.filmotheque.dal;

import fr.eni.tp.filmotheque.bo.Genre;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenreDAOImpl implements GenreDAO {
    //Requêtes SQL
    private final String SELECT_BY_ID = "SELECT id, titre FROM GENRE WHERE id = :id";
    private final String SELECT_ALL = "SELECT id, titre FROM GENRE";

    // jdbc template
    private NamedParameterJdbcTemplate npjdbc;

    public GenreDAOImpl(NamedParameterJdbcTemplate npjdbc) {
        this.npjdbc = npjdbc;
    }



    @Override
    public Genre read(long id) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", id);
        return npjdbc.queryForObject(SELECT_BY_ID,namedParameters, new BeanPropertyRowMapper<>(Genre.class));
    }

    @Override
    public List<Genre> findAll() {
        return npjdbc.getJdbcOperations().query(SELECT_ALL, new BeanPropertyRowMapper<>(Genre.class));
    }
}
