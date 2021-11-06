package RedSocialTest.Responses;


import Network.Response.BaseResponse;
import RedSocialTest.Enums.SocialResponseTypes;

public class PostCreadoResponse extends BaseResponse {

    public String content = "Post creado exitosamente";

    public PostCreadoResponse(){
        type = SocialResponseTypes.CREATED_POST;
    }
}
