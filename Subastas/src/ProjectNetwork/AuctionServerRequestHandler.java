package ProjectNetwork;

import Enums.AuctionRequestType;
import Enums.UserType;
import Network.Request.IHandleRequest;
import Network.Request.IRequest;
import Network.Server.ServerRequestHandler;
import Request.AuctionRequest;
import Request.ConnectionRequest;
import Responses.ConnectionResponse;


import java.io.IOException;

public class AuctionServerRequestHandler implements IHandleRequest {

    @Override
    public void parseRequest(IRequest request, ServerRequestHandler requestHandler) throws IOException {
        AuctionRequestType type = (AuctionRequestType) request.getType();
        switch (type){
            case CONNECT:{
                ConnectionRequest connection = (ConnectionRequest) request;
                if(connection.userType.equals(UserType.SUBASTADOR)){
                    //Aqui no sabria como manjera lo del nombre
                    //requestHandler.addToClients(new AuctionClient("NI IDEA"));
                    requestHandler.getResponseSender().sendResponse(new ConnectionResponse("Conexión exitosa!"));

                }
                //Aqui pues no sé por qué se haría tal distinción
                else if(connection.userType.equals(UserType.OFERENTE)){
                    //requestHandler.addToClients2(new AuctionClient("NI IDEA"));

                }
                break;
            }
            case SUBASTAR:{
                System.out.println("Intenta subastar");
                // >:C
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
