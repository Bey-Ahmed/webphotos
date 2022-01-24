package beans;

import java.io.Serializable;

public class AlbumPhoto implements Serializable {

    private int photoId;
    private int albumId;

    public AlbumPhoto() {}
    
    public AlbumPhoto(int photoId, int albumId) {
        this.photoId = photoId;
        this.albumId = albumId;
    }

    public AlbumPhoto(AlbumPhoto ap) {
        this.photoId = ap.photoId;
        this.albumId = ap.albumId;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

}
