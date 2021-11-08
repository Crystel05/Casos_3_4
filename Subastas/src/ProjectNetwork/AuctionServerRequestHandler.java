package ProjectNetwork;

import Enums.AuctionRequestType;
import Enums.UserType;
import Model.AuctionClientServer;
import Model.AuctionData;
import Model.ClientData;
import Model.SubastaServer;
import Network.BaseServerClasses.BasicServerClient;
import Network.Request.IHandleRequest;
import Network.Request.IRequest;
import Network.Server.ServerRequestHandler;
import Request.AuctionRequest;
import Request.ConnectionRequest;
import Responses.ConnectionResponse;
import Responses.GetClientsResponse;


import java.io.IOException;
import java.util.ArrayList;

public class AuctionServerRequestHandler implements IHandleRequest {

    @Override
    public void parseRequest(IRequest request, ServerRequestHandler requestHandler) throws IOException {
        AuctionRequestType type = (AuctionRequestType) request.getType();
        switch (type){
            case CONNECT:{
                ConnectionRequest connection = (ConnectionRequest) request;
                //Aqui no sabria como manjer lo del nombre
                int clientId = requestHandler.getClientes().size();
                requestHandler.getResponseSender().sendResponse(new ConnectionResponse(clientId));
                requestHandler.addToClients(new AuctionClientServer(clientId,connection.getUserName()));  // Se agrega siempre a clientes
                break;
            }
            case GET_CLIENTS: {

                ArrayList<ClientData> clients = new ArrayList<>();
                for (BasicServerClient client : requestHandler.getClientes()) {
                    clients.add(((AuctionClientServer) client).getData());
                }
                System.out.println("case GET_CLIENTS en AuctionServerRequestHandler");
                System.out.println(clients);
                requestHandler.getResponseSender().sendResponse(new GetClientsResponse(clients));
                break;


            }
            case GET_AUCTIONS: {
                System.out.println("Las subastas");
                break;
            }

            case SUBASTAR:{
                System.out.println("Intenta subastar");
                AuctionRequest auctionRequest = (AuctionRequest) request;
                AuctionData auctionData = ((AuctionRequest) request).getAuctionData();
                auctionData.setSubastaId(requestHandler.getObjects().size());  //Le pone un Id a la subasta
                //SubastaServer subasta = (SubastaServer) requestHandler.getServer().getClientes(auctionData.getSubastaId(),requestHandler.getClientes());
                //requestHandler.addToObjects();

                /*
                //Se busca el artista en el server por el id que llega en el request
                ArtistaServer artistaServer = (ArtistaServer) requestHandler.getServer().getClient(postRequest.artistId, requestHandler.getClientes());
                PostServer post = artistaServer.createPost(requestHandler.getObjects().size(),postRequest.content);
                if(post != null)
                    requestHandler.addToObjects(post);//Con este se guardan las subastas/post
                System.out.println(postRequest.content);
                requestHandler.getResponseSender().sendResponse(new PostCreadoResponse());
                break;
                */
            }
            case PUJAR:{
                System.out.println("Intenta ofertar");
                break;
            }

            default:{
                break;
            }
        }
    }
}
