package ProjectNetwork;

import Controller.AuctionClientController;
import Enums.AutionResponseType;
import Model.ClientNetwork;
import Network.Client.ClientResponseHandler;
import Network.Response.IHandleResponse;
import Network.Response.IResponse;
import Responses.ConnectionResponse;
import Responses.GetClientsResponse;


import java.io.IOException;
import java.util.ArrayList;


public class AuctionClientResponseHandler implements IHandleResponse {
    @Override
    public void parseResponse(IResponse response, ClientResponseHandler client){
        AutionResponseType type = (AutionResponseType) response.getType();
        AuctionClientController controlador = ((ClientNetwork) client.getClient()).getAuctionClientController();

        switch (type){
            case CONEXION_EXITOSA:
                ConnectionResponse connection = (ConnectionResponse) response;
                controlador.setSubastadorActualId(((ConnectionResponse) response).clientId);  //Setea el id actual
                System.out.println(connection.content);
                break;

            case GET_CLIENTS: {
                GetClientsResponse clientResponse = (GetClientsResponse) response;
                controlador.setClients(clientResponse.clients);
                controlador.defaultUpdate();
                System.out.println("Vienen datos del servidor");
                break;
            }
            default:
                break;
        }
    }
}