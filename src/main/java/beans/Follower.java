package beans;

import java.io.Serializable;

public class Follower implements Serializable {

    private int userId;
    private int followerId;

    public Follower() {}
    
    public Follower(int userId, int followerId) {
        this.userId = userId;
        this.followerId = followerId;
    }

    public Follower(Follower follower) {
        this.userId = follower.userId;
        this.followerId = follower.followerId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFollowerId() {
        return followerId;
    }

    public void setFollowerId(int followerId) {
        this.followerId = followerId;
    }

}
