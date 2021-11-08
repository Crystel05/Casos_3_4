package ProjectNetwork;

import Controller.AuctionClientController;
import Enums.AuctionResponseType;
import ClientTypes.ClientNetwork;
import Network.Client.ClientResponseHandler;
import Network.Response.IHandleResponse;
import Network.Response.IResponse;
import Responses.AprobacionOfertaResponse;
import Responses.ConnectionResponse;
import Responses.GetClientsResponse;
import Responses.SubastaExitosaResponse;


public class AuctionClientResponseHandler implements IHandleResponse {
    @Override
    public void parseResponse(IResponse response, ClientResponseHandler client){
        AuctionResponseType type = (AuctionResponseType) response.getType();
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
            case SUBASTA_EXITOSA:{
                SubastaExitosaResponse subastaExitosaResponse = (SubastaExitosaResponse) response;
                controlador.getCurrentClient().addToNotifications(subastaExitosaResponse.content);
            }
            case APROBACION_OFERTA:{
                AprobacionOfertaResponse aprobacionOfertaResponse = (AprobacionOfertaResponse) response;
                //Tiene que llevar la subasta para luego enviar un request con aceptado o denegado
                controlador.setBidToAccept(aprobacionOfertaResponse.bid);
                controlador.addToNotifiacions(aprobacionOfertaResponse.content);
            }
            default:
                break;
        }
    }
}