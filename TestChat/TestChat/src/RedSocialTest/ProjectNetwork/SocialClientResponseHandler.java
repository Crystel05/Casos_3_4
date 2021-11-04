package RedSocialTest.ProjectNetwork;

import Network.Client.ClientResponseHandler;
import Network.Response.IHandleResponse;
import Network.Response.IResponse;
import RedSocialTest.Enums.SocialResponseTypes;
import RedSocialTest.Responses.TestResponse;

import java.io.IOException;

public class SocialClientResponseHandler implements IHandleResponse {
    @Override
    public void parseResponse(IResponse response, ClientResponseHandler client) throws IOException, ClassNotFoundException {
        SocialResponseTypes type = (SocialResponseTypes) response.getType();
        switch (type){
            case FELICITACIONES:
                break;
                case TEST:
                    TestResponse testResponse = (TestResponse) response;
                    System.out.println(testResponse.content);
                    break;
            default:
                break;
        }
    }
}
