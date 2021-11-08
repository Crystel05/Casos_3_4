package ProjectNetwork;

import Enums.AuctionRequestType;
import Model.AuctionClientServer;
import Model.Data.ClientData;
import Model.SubastaServer;
import Network.BaseServerClasses.BasicServerClient;
import Network.Request.IHandleRequest;
import Network.Request.IRequest;
import Network.Server.ServerRequestHandler;
import Request.*;
import Responses.ConnectionResponse;
import Responses.GetClientsResponse;
import Responses.SubastaExitosaResponse;


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
                AuctionClientServer subastador = getClient(auctionRequest.subastadorId,requestHandler);
                subastador.agregarSubasta(subasta);
                break;
            }
            case PUJAR:{
                System.out.println("Intenta ofertar");
                BidRequest bidRequest = (BidRequest) request;
                AuctionClientServer oferenteServer = getClient(bidRequest.bid.getOferenteId(),requestHandler);
                SubastaServer subastaServer = getSubasta(bidRequest.bid.getSubastaId(),requestHandler);
                AuctionClientServer subastadorServer = subastaServer.getOwner();//Esto para que se le pueda notificar de la oferta
                oferenteServer.ofertar(bidRequest.bid,subastadorServer);//Metodo del objeto cliente del servidor para enviar respuesta de peticion de oferta
                break;
            }
            case APROVED_BID_REQUEST:{
                System.out.println("Respuesta de subastador");
                AprovedBid aprovedBid = (AprovedBid) request;
                SubastaServer subastaServer = getSubasta(aprovedBid.bid.getSubastaId(),requestHandler);
                AuctionClientServer subastador = getClient(aprovedBid.subastadorId,requestHandler);
                AuctionClientServer oferenteServer = getClient(aprovedBid.bid.getOferenteId(),requestHandler);
                if(aprovedBid.aproved)
                    subastador.aceptarOferta(subastaServer,oferenteServer,aprovedBid.bid.getMonto());
                else
                    subastador.rechazarOferta(subastaServer,oferenteServer,aprovedBid.bid.getMonto());
                break;
            }
            case CERRAR_SUBASTA:{
                System.out.println("Cerrando la subasta");
                CloseAuctionRequest closeAuctionRequest = (CloseAuctionRequest) request;
                SubastaServer subasta = getSubasta(closeAuctionRequest.subastaId,requestHandler);
                subasta.cerrar();
                break;
            }
            case CANCELAR_SUBASTA:{
                System.out.println("Cancelando la subasta");
                CancelAuctionRequest cancelAuctionRequest = (CancelAuctionRequest) request;
                SubastaServer subasta = getSubasta(cancelAuctionRequest.subastaId,requestHandler);
                subasta.cancelar();
                break;
            }
            case SUBSCRIBE_TO_AUCTION:{
                System.out.println("Uniendose a subasta");
                FollowAuctionRequest followAuctionRequest = (FollowAuctionRequest) request;
                SubastaServer subastaServer = getSubasta(followAuctionRequest.auctionId,requestHandler);
                AuctionClientServer auctionClientServer = getClient(followAuctionRequest.oferenteId,requestHandler);
                auctionClientServer.unirseASubasta(subastaServer);
            }
            default:{
                break;
            }
        }
    }

    public AuctionClientServer getClient(int id,ServerRequestHandler handler){
        return (AuctionClientServer) handler.getServer().getClient(id,handler.getClientes());
    }

    public SubastaServer getSubasta(int id,ServerRequestHandler handler){
        return (SubastaServer) handler.getServer().getObject(id);
    }
}
