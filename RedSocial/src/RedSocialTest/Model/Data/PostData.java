package RedSocialTest.Model.Data;

import java.io.Serializable;

public class PostData implements Serializable {
    int likes;
    int unlikes;
    public String content;
    String owner;

    public PostData(int likes, int unlikes, String content, String owner) {
        this.likes = likes;
        this.unlikes = unlikes;
        this.content = content;
        this.owner = owner;
    }
}
