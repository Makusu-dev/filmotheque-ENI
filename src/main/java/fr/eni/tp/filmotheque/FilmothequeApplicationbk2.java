package fr.eni.tp.filmotheque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import fr.eni.tp.filmotheque.controller.FilmController;

@SpringBootApplication
public class FilmothequeApplicationbk2 {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(FilmothequeApplicationbk2.class, args);

		FilmController controller = context.getBean(FilmController.class);

		// Affichage du film d'identiant 1
		System.out.println("\nLe film d'identiant 1 est : ");
		controller.afficherUnFilm(1);
		
		
		// Affichage de la liste des films
		System.out.println("\n");
		controller.afficherFilms();


	}

}
