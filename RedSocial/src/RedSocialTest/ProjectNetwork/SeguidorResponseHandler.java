package RedSocialTest.ProjectNetwork;

import Network.Client.ClientResponseHandler;
import Network.Response.IHandleResponse;
import Network.Response.IResponse;
import RedSocialTest.Enums.SocialResponseTypes;
import RedSocialTest.Responses.ConnectionResponse;

import java.io.IOException;

public class SeguidorResponseHandler implements IHandleResponse {

    @Override
    public void parseResponse(IResponse response, ClientResponseHandler client) throws IOException, ClassNotFoundException {
        SocialResponseTypes type = (SocialResponseTypes) response.getType();
        switch (type){
            case LIKES_MILE:{
                //seguidores.actualizarB("");
                break;
            }
            case CONNECTION:
                ConnectionResponse connectionResponse = (ConnectionResponse) response;
                System.out.println(connectionResponse.content);
                break;
            case ALREADY_LIKED:
                break;
            case FOLLOWER_MILE:
                break;
            case ALREADY_UNLIKED:
                break;
            case UNACTIVE_ARTIST:
                break;
            case ALREADY_FOLLOWING:
                break;
            case SUCCESS_FOLLOWING:
                break;
            case GET_ARTISTAS:
                break;
            case GET_SEGUIDORES:
                break;
            default:
                break;
        }
    }

}
