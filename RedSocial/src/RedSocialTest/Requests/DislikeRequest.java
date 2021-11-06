package RedSocialTest.Requests;

//import RedSocialTest.Network.Request.IRequest;

import Network.Request.BaseRequest;
import RedSocialTest.Enums.SocialRequestTypes;

public class DislikeRequest extends BaseRequest {

    int seguidorId;
    int postId;
    int artistaActualId;

    public DislikeRequest(int seguidorActualId, int postId, int artistaActualId) {
        this.type = SocialRequestTypes.UNLIKE;
        this.seguidorId = seguidorActualId;
        this.postId = postId;
        this.artistaActualId = artistaActualId;
    }
}
