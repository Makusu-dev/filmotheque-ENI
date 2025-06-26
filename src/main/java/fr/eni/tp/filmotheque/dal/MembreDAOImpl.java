package fr.eni.tp.filmotheque.dal;

import fr.eni.tp.filmotheque.bo.Membre;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MembreDAOImpl implements MembreDAO{

    //Requêtes SQL
    private String FIND_MEMBRE_BY_ID = "SELECT id, nom, prenom, email, admin FROM MEMBRE WHERE id = ?";
    private String FIND_MEMBRE_BY_MAIL = "SELECT id, nom, prenom, email, admin FROM MEMBRE WHERE email = ?";



    private NamedParameterJdbcTemplate npjdbc;

    public MembreDAOImpl(NamedParameterJdbcTemplate npjdbc) {
        this.npjdbc = npjdbc;
    }


    @Override
    public Membre read(long id) {
        return npjdbc.getJdbcOperations().queryForObject(FIND_MEMBRE_BY_ID, new BeanPropertyRowMapper<>(Membre.class), id);
    }

    @Override
    public Membre read(String email) {
        return npjdbc.getJdbcOperations().queryForObject(FIND_MEMBRE_BY_MAIL, new BeanPropertyRowMapper<>(Membre.class), email);
    }
}
