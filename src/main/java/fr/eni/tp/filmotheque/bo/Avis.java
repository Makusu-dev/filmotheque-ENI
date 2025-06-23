package fr.eni.tp.filmotheque.bo;

import java.util.Objects;

public class Avis {

    //Attributs
    private long id;
    private int note;
    private String commentaire;

    //Associations
    private Membre membre;

    public Avis() {
    }

    public Avis(long id, int note, String commentaire, Membre membre) {
        this.id = id;
        this.note = note;
        this.commentaire = commentaire;
        this.membre = membre;
    }

    public Avis(int note, String commentaire, Membre membre) {
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

    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }

    @Override
    public String toString() {
        return "Avis{" +
                "id=" + id +
                ", note=" + note +
                ", commentaire='" + commentaire + '\'' +
                ", membre=" + membre +
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
