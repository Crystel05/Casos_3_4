package Responses;

import Enums.AuctionResponseType;
import Network.Response.BaseResponse;


public class ConnectionResponse extends BaseResponse {

    public String content = "Conexion exitosa con el servidor";
    public int clientId;

    public ConnectionResponse(int clientId){
        this.type = AuctionResponseType.CONEXION_EXITOSA;
        this.clientId = clientId;
    }

}