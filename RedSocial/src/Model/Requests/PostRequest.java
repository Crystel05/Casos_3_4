package Model.Requests;

public class PostRequest implements  IRequest{
    String postContent;

    public PostRequest(String postContent){
        this.postContent = postContent;
    }
}
