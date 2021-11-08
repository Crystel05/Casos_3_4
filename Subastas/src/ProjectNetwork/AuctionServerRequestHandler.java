package ProjectNetwork;

import Enums.AuctionRequestType;
import Model.AuctionClientServer;
import Model.Data.ClientData;
import Model.SubastaServer;
import Network.BaseServerClasses.BasicServerClient;
import Network.Request.IHandleRequest;
import Network.Request.IRequest;
import Network.Server.ServerRequestHandler;
import Request.AuctionRequest;
import Request.BidRequest;
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
                SubastaServer subasta = new SubastaServer(requestHandler.getObjects().size(),auctionRequest.getAuctionData().producto);
                AuctionClientServer client = (AuctionClientServer) requestHandler.getServer().getClient(auctionRequest.subastadorId, requestHandler.getClientes());
                client.agregarSubasta(subasta);
                break;
            }
            case PUJAR:{
                System.out.println("Intenta ofertar");
                BidRequest bidRequest = (BidRequest) request;
                AuctionClientServer oferenteServer = (AuctionClientServer) requestHandler.getServer().getClient(bidRequest.bid.getOferenteId(), requestHandler.getClientes());
                SubastaServer subastaServer = (SubastaServer) requestHandler.getServer().getObject(bidRequest.bid.getSubastaId());
                AuctionClientServer subastadorServer = subastaServer.getOwner();
                oferenteServer.ofertar(bidRequest.bid,subastadorServer);
                break;
            }

            default:{
                break;
            }
        }
    }
}
