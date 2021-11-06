package RedSocialTest.Requests;

import Network.Request.BaseRequest;
import RedSocialTest.Enums.SocialRequestTypes;
import RedSocialTest.Model.ArtistaServer;

public class PostRequest extends BaseRequest {
    public String content;
    public int artistId;

    public PostRequest(String content,int artistId) {
        this.content = content;
        this.type = SocialRequestTypes.POST;
        this.artistId = artistId;
    }

}
