package fr.eni.tp.filmotheque.dal;

import fr.eni.tp.filmotheque.bo.Avis;
import fr.eni.tp.filmotheque.bo.Participant;

import java.util.List;

public interface AvisDAO {

   int create(Avis avis, long idFilm);
   List<Avis> findByIdFilm(long idFilm);


}
