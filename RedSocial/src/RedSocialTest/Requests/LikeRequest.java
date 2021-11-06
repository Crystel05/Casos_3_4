package RedSocialTest.Requests;

//import RedSocialTest.Network.Request.IRequest;

import Network.Request.BaseRequest;
import RedSocialTest.Enums.SocialRequestTypes;

public class LikeRequest extends BaseRequest {

    public int seguidorId;
    public int postId;

    public LikeRequest(int seguidorId,int postId){
        this.seguidorId = seguidorId;
        this.postId = postId;
        this.type = SocialRequestTypes.LIKE;
    }
}
