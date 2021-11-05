package RedSocialTest.Model.Data;

import RedSocialTest.Model.PostServer;

import java.io.Serializable;
import java.util.ArrayList;

public class ArtistData implements Serializable {

    String nickname;
    ArrayList<PostData> post;
    int seguidores;
    boolean activo;

    public ArtistData(String nickname, ArrayList<PostData> post, int seguidores, boolean activo) {
        this.nickname = nickname;
        this.post = post;
        this.seguidores = seguidores;
        this.activo = activo;
    }
}
