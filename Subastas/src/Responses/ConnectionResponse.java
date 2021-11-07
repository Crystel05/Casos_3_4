package Responses;

import Enums.AutionResponseType;
import Network.Response.BaseResponse;
import Network.Response.IResponse;


public class ConnectionResponse extends BaseResponse {

    public String content = "Conexion exitosa con el servidor";
    public int clientId;

    public ConnectionResponse(int clientId){
        this.type = AutionResponseType.CONEXION_EXITOSA;
        this.clientId = clientId;
    }

}