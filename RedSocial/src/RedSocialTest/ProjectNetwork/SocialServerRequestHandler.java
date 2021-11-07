package RedSocialTest.ProjectNetwork;


import Network.BaseServerClasses.BasicServerClient;
import Network.Request.IHandleRequest;
import Network.Request.IRequest;
import Network.Server.ServerRequestHandler;
import RedSocialTest.ClientTypes.SeguidorClient;
import RedSocialTest.Enums.SocialRequestTypes;
import RedSocialTest.Enums.UserType;
import RedSocialTest.Model.ArtistaServer;
import RedSocialTest.Model.Data.ArtistData;
import RedSocialTest.Model.Data.SeguidorData;
import RedSocialTest.Model.PostServer;
import RedSocialTest.Model.SeguidorServer;
import RedSocialTest.Requests.*;
import RedSocialTest.Responses.*;

import java.io.IOException;
import java.util.ArrayList;

public class SocialServerRequestHandler implements IHandleRequest {

    //GetClients1 es para los artistas
    //GetClients2 es para los seguidores
    //Recibe todos los request
    @Override
    public void parseRequest(IRequest request, ServerRequestHandler requestHandler) throws IOException {
        SocialRequestTypes type = (SocialRequestTypes) request.getType();//Saca el tipo del request
        System.out.println(request);
        switch (type) {

            case CONNECT: {
                ConnectionRequest connectcionRequest = (ConnectionRequest) request;
                if (connectcionRequest.userType.equals(UserType.CELEBRITY)) {
                    int clientId = requestHandler.getClientes().size();
                    requestHandler.addToClients(new ArtistaServer(clientId,connectcionRequest.userName));
                    requestHandler.getResponseSender().sendResponse(new ConnectionResponse(clientId));

                } else if (connectcionRequest.userType.equals(UserType.FOLLOWER)) {
                    int clientId = requestHandler.getClientes2().size();
                    requestHandler.addToClients2(new SeguidorServer(clientId,connectcionRequest.userName));
                    requestHandler.getResponseSender().sendResponse(new ConnectionResponse(clientId));
                }
                break;
            }
            case LIKE: {
                LikeRequest likeRequest = (LikeRequest) request;//Casteo al tipo de request que se busca
                PostServer postServer = (PostServer) requestHandler.getServer().getObject(likeRequest.postId);//Viene dentro del LikeRquest se busca el post
                SeguidorServer seguidorServer = (SeguidorServer) requestHandler.getServer().getClient(likeRequest.seguidorId, requestHandler.getClientes2());//Se busca el seguidor en el servidor por el id que viene en el request
                seguidorServer.likePost(postServer);//Que el seguidor le de like al post
                break;
            }
            case POST: {
                PostRequest postRequest = (PostRequest) request;//Convierte el Irequest en PostRequest
                //Se busca el artista en el server por el id que llega en el request
                ArtistaServer artistaServer = (ArtistaServer) requestHandler.getServer().getClient(postRequest.artistId, requestHandler.getClientes());
                PostServer post = artistaServer.createPost(requestHandler.getObjects().size(),postRequest.content);
                if(post != null)
                    requestHandler.addToObjects(post);//Con este se guardan las subastas/post
                System.out.println(postRequest.content);
                requestHandler.getResponseSender().sendResponse(new PostCreadoResponse());
                break;
            }
            case UNLIKE: {
                DislikeRequest unlikeRequest = (DislikeRequest) request;
                PostServer postServer = (PostServer) requestHandler.getServer().getObject(unlikeRequest.postId);
                SeguidorServer seguidorServer = (SeguidorServer) requestHandler.getServer().getClient(unlikeRequest.seguidorId, requestHandler.getClientes2());
                seguidorServer.unlikePost(postServer);
                break;
            }
            case GET_ALL_ARTIST:
                ArrayList<ArtistData> artistas = new ArrayList<>();//Es la lista de datos a enviar en la peticion
                for (BasicServerClient client:requestHandler.getClientes()) {
                    artistas.add(((ArtistaServer) client).getData());//Castea todos los clientes del lado del servidor a su forma de Artista y se le hace un get data
                }
                requestHandler.getResponseSender().sendResponse(new GetArtistasResponse(artistas));
                break;
            case GET_ALL_FOLLOWERS:
                ArrayList<SeguidorData> seguidores = new ArrayList<>();//Envia todo lo de lista 2 pero como datos de seguidor
                for (BasicServerClient client:requestHandler.getClientes2()) {
                    seguidores.add(((SeguidorServer) client).getData());
                }
                requestHandler.getResponseSender().sendResponse(new GetSeguidoresResponse(seguidores));
                break;
            default: {
                break;
            }
        }
    }
}
