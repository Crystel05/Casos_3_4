package RedSocialTest.ProjectNetwork;

import RedSocialTest.Requests.ConnectionRequest;
import RedSocialTest.Model.Celebrity;
import RedSocialTest.Model.Follower;
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
                if(connectcionRequest.userType.equals(UserType.CELEB)){
                    requestHandler.addToClients(new Celebrity());

                }
                else if(connectcionRequest.userType.equals(UserType.FOLLOWER)){
                    requestHandler.addToClients2(new Follower());
                    requestHandler.getResponseSender().sendResponse(new TestResponse("XD"));
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
