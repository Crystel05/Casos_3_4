package RedSocialTest.ProjectNetwork;


import Network.Request.IHandleRequest;
import Network.Request.IRequest;
import Network.Server.ServerRequestHandler;
import RedSocialTest.Enums.SocialRequestTypes;
import RedSocialTest.Enums.UserType;
import RedSocialTest.Model.Artista;
import RedSocialTest.Model.Post;
import RedSocialTest.Model.Seguidor;
import RedSocialTest.Requests.ConnectionRequest;
import RedSocialTest.Requests.PostRequest;
import RedSocialTest.Responses.ConnectionResponse;

import java.io.IOException;

public class SocialServerRequestHandler implements IHandleRequest {

    @Override
    public void parseRequest(IRequest request, ServerRequestHandler requestHandler) throws IOException {
        SocialRequestTypes type = (SocialRequestTypes) request.getType();
        System.out.println(request);
        switch (type) {
            case CONNECT: {
                ConnectionRequest connectcionRequest = (ConnectionRequest) request;
                if (connectcionRequest.userType.equals(UserType.CELEBRITY)) {
                    int clientId = requestHandler.getClientes().size()+1;
                    requestHandler.addToClients(new Artista(clientId,connectcionRequest.userName));
                    requestHandler.getResponseSender().sendResponse(new ConnectionResponse(clientId));

                } else if (connectcionRequest.userType.equals(UserType.FOLLOWER)) {
                    int clientId = requestHandler.getClientes().size()+1;
                    requestHandler.addToClients2(new Seguidor(clientId,connectcionRequest.userName));
                    requestHandler.getResponseSender().sendResponse(new ConnectionResponse(clientId));//Puedo agregar el id de conexion
                }
                break;
            }
            case LIKE: {

                break;
            }
            case POST: {
                PostRequest postRequest = (PostRequest) request;
                requestHandler.addToObjects(new Post(requestHandler.getObjects().size()+1,postRequest.content,postRequest.artist));
                System.out.println(postRequest.content);
                break;
            }
            case UNLIKE: {
                break;
            }
            default: {
                break;
            }
        }
    }
}
