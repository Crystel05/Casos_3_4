package Model.Requests;

import Model.Post;

public class MetaPostRequest implements IRequest{
    Post post;

    public MetaPostRequest(Post post){
        this.post = post;
    }
}
