package RedSocialTest.Requests;

//import RedSocialTest.Network.Request.IRequest;

import Network.Request.BaseRequest;
import RedSocialTest.Enums.SocialRequestTypes;

public class DislikeRequest extends BaseRequest {

    public int seguidorId;
    public int postId;

    public DislikeRequest(int seguidorActualId, int postId) {
        this.type = SocialRequestTypes.UNLIKE;
        this.seguidorId = seguidorActualId;
        this.postId = postId;
    }
}
