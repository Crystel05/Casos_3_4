package RedSocialTest.Requests;

//import RedSocialTest.Network.Request.IRequest;

import Network.Request.BaseRequest;
import RedSocialTest.Enums.SocialRequestTypes;

public class FollowRequest extends BaseRequest {

    public FollowRequest(){
        this.type = SocialRequestTypes.FOLLOW;
    }
}
