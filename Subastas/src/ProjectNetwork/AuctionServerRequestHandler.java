package ProjectNetwork;

import Enums.AuctionRequestType;
import Enums.UserType;
import Model.AuctionClientServer;
import Model.ClientData;
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
                System.out.println(((AuctionRequest) request).getAuction());
                //requestHandler.addToObjects(((AuctionRequest) request).getAuction());
                //requestHandler.getResponseSender().sendResponse(new AuctionRequest());
                break;
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
