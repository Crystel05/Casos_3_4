package RedSocialTest.ProjectNetwork;

import RedSocialTest.Requests.ConnectionRequest;
import RedSocialTest.Model.Artista;
import RedSocialTest.Model.Seguidor;
import RedSocialTest.Requests.PostRequest;
import RedSocialTest.Enums.SocialRequestTypes;
import RedSocialTest.Enums.UserType;
import Network.Request.IHandleRequest;
import Network.Request.IRequest;
import Network.Server.ServerRequestHandler;
import RedSocialTest.Responses.TestResponse;

import java.io.IOException;

public class SocialServerRequestHandler implements IHandleRequest {

    @Override
    public void parseRequest(IRequest request, ServerRequestHandler requestHandler) throws IOException {
        SocialRequestTypes type = (SocialRequestTypes) request.getType();
        switch (type){
            case CONNECT:{
                ConnectionRequest connectcionRequest = (ConnectionRequest) request;
                if(connectcionRequest.userType.equals(UserType.CELEBRITY)){
                    requestHandler.addToClients(new Artista());

                }
                else if(connectcionRequest.userType.equals(UserType.FOLLOWER)){
                    requestHandler.addToClients2(new Seguidor());
                    requestHandler.getResponseSender().sendResponse(new TestResponse("Welcome Follower"));
                }
            }
            case LIKE:{
                break;
            }
            case POST:{
                PostRequest postRequest = (PostRequest) request;
                //requestHandler.getServer().addObject(new Post(((PostRequest) request).content));
                System.out.println(postRequest.content);
                break;
            }
            case UNLIKE:{
                break;
            }
            default:{
                break;
            }
        }
    }
}
