package fr.eni.tp.filmotheque.bo;

import java.util.Objects;

public abstract class Personne {

    //Attributs
    private long id;
    private String nom;
    private String prenom;

    //Constructeurs


    public Personne() {}

    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Personne(long id, String nom, String prenom) {
        this(nom,prenom);
        this.id = id;
    }

    //getter setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    //ToString


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(prenom);
        sb.append(" ").append(nom);
        sb.append(" (").append(id).append(") ");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Personne personne)) return false;
        return id == personne.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
