package RedSocialTest.Requests;

import Network.Request.BaseRequest;
import RedSocialTest.Enums.SocialRequestTypes;
import RedSocialTest.Model.Artista;

public class PostRequest extends BaseRequest {
    public String content;
    public SocialRequestTypes type;
    public Artista artist;

    public PostRequest(String content) {
        this.content = content;
        this.type = SocialRequestTypes.POST;
    }

}
