package RedSocialTest.Requests;

//import RedSocialTest.Network.Request.IRequest;

import Network.Request.BaseRequest;
import RedSocialTest.Enums.SocialRequestTypes;

public class GetDownRequest extends BaseRequest {
    public GetDownRequest(){
        this.type = SocialRequestTypes.GETDOWN;
    }
}
