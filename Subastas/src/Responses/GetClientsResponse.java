package Responses;

import Enums.AuctionResponseType;
import Model.Data.ClientData;
import Network.Response.BaseResponse;

import java.util.ArrayList;

public class GetClientsResponse extends BaseResponse {

    public ArrayList<ClientData> clients;
    //Si no funcionara se puede hacer una clase artista data lo mismo para post y seguidor

    public GetClientsResponse(ArrayList<ClientData> clients){
        this.type = AuctionResponseType.GET_CLIENTS;
        this.clients = clients;
    }
}

