package RedSocialTest.Requests;

//import RedSocialTest.Network.Request.IRequest;

import Network.Request.BaseRequest;
import RedSocialTest.Enums.SocialRequestTypes;

public class DislikeRequest extends BaseRequest {

    public DislikeRequest(){
        this.type = SocialRequestTypes.UNLIKE;
    }

}
