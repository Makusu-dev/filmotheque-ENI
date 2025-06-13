package fr.eni.tp.filmotheque.bo;

import java.util.Objects;

public class Avis {

    //Attributs
    private long id;
    private int note;
    private String commentaire;

    //Associations
    private Membre membre;
    private Film film;

    public Avis() {
    }

    public Avis(long id, int note, String commentaire, Membre membre, Film film) {
        this.id = id;
        this.note = note;
        this.commentaire = commentaire;
        this.membre = membre;
    }

    public Avis(int note, String commentaire, Membre membre, Film film) {
        this.note = note;
        this.commentaire = commentaire;
        this.membre = membre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }



    @Override
    public String toString() {
        return "Avis{" +
                "id=" + id +
                ", note=" + note +
                ", commentaire='" + commentaire + '\'' +
                ", membre=" + membre +
                ", film=" + film +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Avis avis)) return false;
        return id == avis.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
