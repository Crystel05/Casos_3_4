package RedSocialTest.Responses;

//import RedSocialTest.Network.Response.IResponse;

import Network.Response.BaseResponse;
import RedSocialTest.Enums.SocialResponseTypes;

public class GetDownSuccessfulResponse extends BaseResponse {
    public GetDownSuccessfulResponse(){
        this.type = SocialResponseTypes.GET_DOWN_SUCCSESSFULY;
    }
}
