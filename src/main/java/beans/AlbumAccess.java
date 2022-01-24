package beans;

import java.io.Serializable;

public class AlbumAccess implements Serializable {

    private int userId;
    private int albumId;

    public AlbumAccess() {}
    
    public AlbumAccess(int userId, int albumId) {
        this.userId = userId;
        this.albumId = albumId;
    }

    public AlbumAccess(AlbumAccess selected) {
        this.userId = selected.userId;
        this.albumId = selected.albumId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

}
