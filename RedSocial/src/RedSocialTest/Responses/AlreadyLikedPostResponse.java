package RedSocialTest.Responses;


import Network.Response.BaseResponse;
import RedSocialTest.Enums.SocialResponseTypes;

public class AlreadyLikedPostResponse extends BaseResponse {
    public String content = "You already liked this post";
    public AlreadyLikedPostResponse(){
        this.type = SocialResponseTypes.ALREADY_LIKED;
    }
}
