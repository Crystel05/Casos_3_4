package RedSocialTest.Requests;

//import RedSocialTest.Network.Request.IRequest;

import Network.Request.BaseRequest;
import RedSocialTest.Enums.SocialRequestTypes;

public class FollowRequest extends BaseRequest {

    public int artistaId;
    public int seguidorId;


    public FollowRequest(int seguidorId,int artistaId) {
        this.type = SocialRequestTypes.FOLLOW;
        this.seguidorId = seguidorId;
        this.artistaId = artistaId;
    }
}
