package RedSocialTest.Responses;

import Network.Response.BaseResponse;
import RedSocialTest.Enums.SocialResponseTypes;

public class DislikeSuccessfully extends BaseResponse {
    public String content = "You disliked the post successfully";
    public DislikeSuccessfully(){
        this.type = SocialResponseTypes.SUCCESS_DISLIKE;
    }
}
