package RedSocialTest.Requests;

//import RedSocialTest.Network.Request.IRequest;

import Network.Request.BaseRequest;
import RedSocialTest.Enums.SocialRequestTypes;

public class LikeRequest extends BaseRequest {
    public LikeRequest(){
        this.type = SocialRequestTypes.LIKE;
    }
}
