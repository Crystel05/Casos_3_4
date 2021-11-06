package RedSocialTest.Model.Data;

import RedSocialTest.Model.PostServer;

import java.io.Serializable;
import java.util.ArrayList;

public class ArtistData implements Serializable {

    public String nickname;
    public ArrayList<PostData> posts;
    int seguidores;
    boolean activo;

    public ArtistData(String nickname, ArrayList<PostData> post, int seguidores, boolean activo) {
        this.nickname = nickname;
        this.posts = post;
        this.seguidores = seguidores;
        this.activo = activo;
    }
}
