package RedSocialTest.Responses;

//import RedSocialTest.Network.Response.IResponse;

import Network.Response.BaseResponse;
import RedSocialTest.Enums.SocialResponseTypes;

public class AlreadyUnlikedPostResponse extends BaseResponse {
    public String content = "You already disliked this post";
    public AlreadyUnlikedPostResponse(){
        this.type = SocialResponseTypes.ALREADY_UNLIKED;
    }
}
