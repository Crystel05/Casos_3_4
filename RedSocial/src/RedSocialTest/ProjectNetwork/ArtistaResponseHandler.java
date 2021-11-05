package RedSocialTest.ProjectNetwork;

import Network.Client.ClientResponseHandler;
import Network.Response.IHandleResponse;
import Network.Response.IResponse;
import RedSocialTest.Enums.SocialResponseTypes;

import java.io.IOException;

public class ArtistaResponseHandler implements IHandleResponse {


    @Override
    public void parseResponse(IResponse response, ClientResponseHandler client) throws IOException, ClassNotFoundException {
        SocialResponseTypes type = (SocialResponseTypes) response.getType();
        switch (type){
            case GET_DOWN_SUCCSESSFULY:
                break;
            case CREATED_POST:
                break;
            case GET_POSTS:
            case GET_ARTISTAS:
            case GET_SEGUIDORES:
            default:
                break;
        }
    }
}
