package ProjectNetwork;

import Enums.AutionResponseType;
import Network.Client.ClientResponseHandler;
import Network.Response.IHandleResponse;
import Network.Response.IResponse;
import Responses.ConnectionResponse;


import java.io.IOException;
import java.util.ArrayList;


public class AuctionClientResponseHandler implements IHandleResponse {
    @Override
    public void parseResponse(IResponse response, ClientResponseHandler client) throws IOException, ClassNotFoundException {
        AutionResponseType type = (AutionResponseType) response.getType();
        switch (type){
            case CONEXION_EXITOSA:
                ConnectionResponse connection = (ConnectionResponse) response;
                System.out.println(connection.content);
                break;

            /*case GET_CLIENTS: {
                System.out.println("AHGS");
                break;
            }*/
            default:
                break;
        }
    }
}