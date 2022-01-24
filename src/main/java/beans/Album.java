package beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class Album implements Serializable {
    
    private int id;
    private String theme;
    private int audience;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private int userId;

    public Album() {}
    
    public Album(int id, String theme) {
        this.id = id;
        this.theme = theme;
    }

    public Album(String theme, int audience, int userId) {
        this.theme = theme;
        this.audience = audience;
        this.userId = userId;
    }
    
    public Album(int id, String theme, int audience, Timestamp createdAt, Timestamp updatedAt, int userId) {
        this.id = id;
        this.theme = theme;
        this.audience = audience;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.userId = userId;
    }
    
    public Album(Album album) {
        this.id = album.id;
        this.theme = album.theme;
        this.audience = album.audience;
        this.createdAt = album.createdAt;
        this.updatedAt = album.updatedAt;
        this.userId = album.userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public int getAudience() {
        return audience;
    }

    public void setAudience(int audience) {
        this.audience = audience;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
}
