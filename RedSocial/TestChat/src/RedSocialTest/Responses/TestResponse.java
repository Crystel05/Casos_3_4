package RedSocialTest.Responses;

import Network.Request.IRequest;
import Network.Response.IResponse;
import RedSocialTest.Enums.SocialResponseTypes;

import java.io.Serializable;

public class TestResponse implements IResponse {

    SocialResponseTypes type;
    public String content;

    public TestResponse(String string){

        this.type = SocialResponseTypes.TEST;
        content = string;
    }

    @Override
    public Enum getType() {
        return type;
    }
}
