package Responses;

import Enums.AuctionRequestType;
import Model.ClientData;
import Network.Response.BaseResponse;

import java.util.ArrayList;

public class GetClientsResponse extends BaseResponse {

    public ArrayList<ClientData> artistas;
    //Si no funcionara se puede hacer una clase artista data lo mismo para post y seguidor

    public GetClientsResponse(ArrayList<ClientData> artistas){
        this.type = AuctionRequestType.GET_CLIENTS;
        this.artistas = artistas;
    }
}

