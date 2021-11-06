package RedSocialTest.Requests;

//import RedSocialTest.Network.Request.IRequest;

import Network.Request.BaseRequest;
import RedSocialTest.Enums.SocialRequestTypes;

public class LikeRequest extends BaseRequest {

    int seguidorId;
    int postId;
    int artistaId;

    public LikeRequest(int seguidorId,int postId, int artistaId){
        this.seguidorId = seguidorId;
        this.type = SocialRequestTypes.LIKE;
    }
}
