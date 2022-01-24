package beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class Photo implements Serializable {
    
    private int id;
    private String filepath;
    private String bio;
    private int hauteur;
    private int largeur;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private int albumId;

    public Photo() {}

    public Photo(String filepath, String bio, int hauteur, int largeur, int albumId) {
        this.filepath = filepath;
        this.bio = bio;
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.albumId = albumId;
    }
    
    public Photo(int id, String filepath, String bio, int hauteur, int largeur, Timestamp createdAt, Timestamp updatedAt, int albumId) {
        this.id = id;
        this.filepath = filepath;
        this.bio = bio;
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.albumId = albumId;
    }
    
    public Photo(Photo photo) {
        this.id = photo.id;
        this.filepath = photo.filepath;
        this.bio = photo.bio;
        this.hauteur = photo.hauteur;
        this.largeur = photo.largeur;
        this.createdAt = photo.createdAt;
        this.updatedAt = photo.updatedAt;
        this.albumId = photo.albumId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }
    
}
