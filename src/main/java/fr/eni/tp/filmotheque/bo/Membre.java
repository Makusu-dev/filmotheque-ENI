package fr.eni.tp.filmotheque.bo;

import java.util.List;

public class Membre extends Personne{

    private String pseudo;
    private String motDePasse;
    private boolean admin=false;



    //Constructeurs
    public Membre() {}

    public Membre(long id, String nom, String prenom, boolean admin, String motDePasse, String pseudo) {
        super(id, nom, prenom);
        this.admin = admin;
        this.motDePasse = motDePasse;
        this.pseudo = pseudo;
    }

    public Membre(String nom, String prenom, boolean admin, String motDePasse, String pseudo) {
        super(nom, prenom);
        this.admin = admin;
        this.motDePasse = motDePasse;
        this.pseudo = pseudo;
    }

    //getters setters

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    //toString


    @Override
    public String toString() {
        return "Membre{" +
                "pseudo='" + pseudo + '\'' +
                ", admin=" + admin +
                '}';
    }
}
