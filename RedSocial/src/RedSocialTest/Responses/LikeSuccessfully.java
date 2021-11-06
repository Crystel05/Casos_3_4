package RedSocialTest.Responses;

import Network.Response.BaseResponse;
import RedSocialTest.Enums.SocialResponseTypes;

public class LikeSuccessfully extends BaseResponse {
    public String content = "You liked the post successfully";
    public LikeSuccessfully(){
        this.type = SocialResponseTypes.SUCCESS_LIKE;
    }
}
