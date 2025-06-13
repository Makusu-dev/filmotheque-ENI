package fr.eni.tp.filmotheque.bo;

import java.util.List;
import java.util.Objects;

public class Genre {

    //Attributs
    private long id;
    private String titre;



    public Genre() {
    }

    public Genre(long id, String titre) {
        this.id = id;
        this.titre = titre;
    }

    public Genre(String titre) {
        this.titre = titre;
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

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Genre genre)) return false;
        return id == genre.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
