package ProjectNetwork;

import Enums.AutionResponseType;
import Network.Client.ClientResponseHandler;
import Network.Response.IHandleResponse;
import Network.Response.IResponse;
import Responses.ConnectionResponse;

import java.io.IOException;


public class AuctionClientResponseHandler implements IHandleResponse {
    @Override
    public void parseResponse(IResponse response, ClientResponseHandler client) throws IOException, ClassNotFoundException {
        AutionResponseType type = (AutionResponseType) response.getType();
        switch (type){
            case CONEXION_EXITOSA:
                ConnectionResponse connection = (ConnectionResponse) response;
                System.out.println(connection.content);
                break;
            case TEST:
                //TestResponse testResponse = (TestResponse) response;
                //System.out.println(testResponse.content);
                System.out.println("Jumm");
                break;
            default:
                break;
        }
    }
}