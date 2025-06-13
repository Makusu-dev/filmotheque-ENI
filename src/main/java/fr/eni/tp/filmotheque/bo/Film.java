package fr.eni.tp.filmotheque.bo;

import java.util.List;
import java.util.Objects;

public class Film {

    //Atributs
    private long id;
    private String Titre;
    private int annee;
    private int duree;
    private String synopsis;

    //Associations

    private List<Participant> listeActeurs;
    private Participant realisateur;
    private Genre genre;


    public Film() {
    }

    public Film(String titre, int annee, int duree, String synopsis, Participant realisateur, Genre genre) {
        Titre = titre;
        this.annee = annee;
        this.duree = duree;
        this.synopsis = synopsis;
        this.realisateur = realisateur;
        this.genre = genre;
    }

    public Film(long id, String titre, int annee, int duree, String synopsis, Participant realisateur, Genre genre) {
        this.id = id;
        Titre = titre;
        this.annee = annee;
        this.duree = duree;
        this.synopsis = synopsis;
        this.realisateur = realisateur;
        this.genre = genre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String titre) {
        Titre = titre;
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

    public List<Participant> getListeActeurs() {
        return listeActeurs;
    }

    public void ajouterActeur(Participant acteur) {
        this.listeActeurs.add(acteur);
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", Titre='" + Titre + '\'' +
                ", annee=" + annee +
                ", duree=" + duree +
                ", synopsis='" + synopsis + '\'' +
                ", realisateur=" + realisateur +
                ", genre=" + genre +
                '}';
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
