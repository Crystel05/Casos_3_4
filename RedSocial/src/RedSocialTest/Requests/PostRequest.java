package RedSocialTest.Requests;

import Network.Request.BaseRequest;
import RedSocialTest.Enums.SocialRequestTypes;
import RedSocialTest.Model.ArtistaServer;

public class PostRequest extends BaseRequest {
    public String content;
    public ArtistaServer artist;

    public PostRequest(String content) {
        this.content = content;
        this.type = SocialRequestTypes.POST;
    }

}
