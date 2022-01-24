package beans;

import java.io.Serializable;

public class Keyword implements Serializable {

    private String word;
    private int photoId;

    public Keyword() {}

    public Keyword(String word, int photoId) {
        this.word = word;
        this.photoId = photoId;
    }

    public Keyword(Keyword keyword) {
        this.word = keyword.word;
        this.photoId = keyword.photoId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

}
