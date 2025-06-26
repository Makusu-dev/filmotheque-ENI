package fr.eni.tp.filmotheque.bo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Film {

    //Atributs
    private long id;
    @NotBlank
    @Size(min = 1, max = 250)
    private String titre;
    @NotNull
    @Min(1900)
    private int annee;
    @Min(0)
    private int duree;
    @Size(min = 20, max = 250)
    private String synopsis;

    //Associations

    private List<Participant> acteurs;
    private List<Avis> avis = new ArrayList<>();
    @NotNull
    private Participant realisateur;
    @NotNull
    private Genre genre;


    public Film() {
    }

    public Film(String titre, int annee, int duree, String synopsis) {
        this.titre = titre;
        this.annee = annee;
        this.duree = duree;
        this.synopsis = synopsis;
        this.acteurs = new ArrayList<>();
        this.avis = new ArrayList<>();

    }

    public Film(long id, String titre, int annee, int duree, String synopsis) {
        this.id = id;
        this.titre = titre;
        this.annee = annee;
        this.duree = duree;
        this.synopsis = synopsis;
        acteurs = new ArrayList<>();
        this.avis = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public Participant getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(Participant realisateur) {
        this.realisateur = realisateur;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public List<Participant> getActeurs() {
        return acteurs;
    }

    public void setActeurs(List<Participant> acteurs) {
        this.acteurs = acteurs;
    }

    public List<Avis> getAvis() {
        return avis;
    }

    public void ajouterAvis(Avis avis) {
        this.avis.add(avis);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Film ");
        sb.append("(").append(id).append(")\n");
        sb.append("\t").append("Titre : ").append(titre);
        sb.append("\t").append("[ Annee :").append(annee);
        sb.append("\t").append(", duree=").append(duree).append(" ]\n");
        sb.append("\t").append("Synopsis : \'").append(synopsis).append('\'');
        sb.append("\t").append("Realisateur: ").append(realisateur).append('\n');
        sb.append("\t").append("Acteurs=").append(acteurs).append("\n");
        sb.append("\t").append("Genre=").append(genre).append("\n");
        sb.append("\t").append("Avis=").append(avis).append("\n");

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Film film)) return false;
        return id == film.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
