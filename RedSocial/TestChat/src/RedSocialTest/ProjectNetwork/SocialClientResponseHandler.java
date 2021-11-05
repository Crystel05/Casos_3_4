package RedSocialTest.ProjectNetwork;

import Network.Client.ClientResponseHandler;
import Network.Response.IHandleResponse;
import Network.Response.IResponse;
import RedSocialTest.Enums.SocialResponseTypes;
import Vista.Seguidores;
//import RedSocialTest.Responses.TestResponse;

import java.io.IOException;

public class SocialClientResponseHandler implements IHandleResponse {
    Seguidores seguidores = new Seguidores(); //singlenton

    public SocialClientResponseHandler() throws IOException, ClassNotFoundException {
    }

    @Override
    public void parseResponse(IResponse response, ClientResponseHandler client) throws IOException, ClassNotFoundException {
        SocialResponseTypes type = (SocialResponseTypes) response.getType();
//        switch (type){
//            case NOTIFICACION:
//                seguidores.actualizarB("");//notificacion
//                break;
////                case TEST:
////                    TestResponse testResponse = (TestResponse) response;
////                    System.out.println(testResponse.content);
////                    break;
//            default:
//                break;
//        }
    }
}
