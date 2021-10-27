package Model.Requests;

import Model.Post;

public class LikePostRequest {
    Post post; //O puede ser tambien el post Id

    public LikePostRequest(Post post){
        this.post = post;
    }
}
