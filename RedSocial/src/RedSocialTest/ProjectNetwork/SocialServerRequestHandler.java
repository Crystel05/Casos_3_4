package RedSocialTest.ProjectNetwork;


import Network.BaseServerClasses.BasicServerClient;
import Network.Request.IHandleRequest;
import Network.Request.IRequest;
import Network.Server.ServerRequestHandler;
import RedSocialTest.Enums.SocialRequestTypes;
import RedSocialTest.Enums.UserType;
import RedSocialTest.Model.ArtistaServer;
import RedSocialTest.Model.Data.ArtistData;
import RedSocialTest.Model.PostServer;
import RedSocialTest.Model.SeguidorServer;
import RedSocialTest.Requests.ConnectionRequest;
import RedSocialTest.Requests.LikeRequest;
import RedSocialTest.Requests.PostRequest;
import RedSocialTest.Responses.ConnectionResponse;
import RedSocialTest.Responses.GetArtistasResponse;
import RedSocialTest.Responses.PostCreadoResponse;

import java.io.IOException;
import java.util.ArrayList;

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
                    requestHandler.addToClients(new ArtistaServer(clientId,connectcionRequest.userName));
                    requestHandler.getResponseSender().sendResponse(new ConnectionResponse(clientId));

                } else if (connectcionRequest.userType.equals(UserType.FOLLOWER)) {
                    int clientId = requestHandler.getClientes().size()+1;
                    requestHandler.addToClients2(new SeguidorServer(clientId,connectcionRequest.userName));
                    requestHandler.getResponseSender().sendResponse(new ConnectionResponse(clientId));//Puedo agregar el id de conexion
                }
                break;
            }
            case LIKE: {
                LikeRequest likeRequest = (LikeRequest) request;

                break;
            }
            case POST: {
                PostRequest postRequest = (PostRequest) request;
                ArtistaServer artistaServer = (ArtistaServer) requestHandler.getServer().getClient(postRequest.artistId, requestHandler.getClientes());
                PostServer post = artistaServer.createPost(requestHandler.getObjects().size()+1,postRequest.content);
                if(post != null)
                    requestHandler.addToObjects(post);
                System.out.println(postRequest.content);
                requestHandler.getResponseSender().sendResponse(new PostCreadoResponse());
                break;
            }
            case UNLIKE: {
                break;
            }
            case GET_ALL_ARTIST:
                ArrayList<ArtistData> artistas = new ArrayList<>();
                for (BasicServerClient client:requestHandler.getClientes()) {
                    artistas.add(((ArtistaServer) client).getData());
                }
                requestHandler.getResponseSender().sendResponse(new GetArtistasResponse(artistas));
                break;
            default: {
                break;
            }
        }
    }
}
