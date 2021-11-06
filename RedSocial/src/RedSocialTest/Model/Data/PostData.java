package RedSocialTest.Model.Data;

import java.io.Serializable;

public class PostData implements Serializable {
    public int likes;
    public int unlikes;
    public String content;
    public String owner;

    public PostData(int likes, int unlikes, String content, String owner) {
        this.likes = likes;
        this.unlikes = unlikes;
        this.content = content;
        this.owner = owner;
    }
}
