package RedSocialTest.Requests;

import RedSocialTest.Enums.SocialRequestTypes;
import Network.Request.IRequest;

public class PostRequest implements IRequest {
    public String content;
    public SocialRequestTypes type;

    public PostRequest (String content){
        this.content = content;
        this.type = SocialRequestTypes.POST;
    }

    @Override
    public Enum getType() {
        return type;
    }
}
