package RedSocialTest.Responses;


import Network.Response.BaseResponse;
import RedSocialTest.Enums.SocialResponseTypes;

public class ConnectionResponse extends BaseResponse {

    public String content = "Conexion exitosa con el servidor";
    public int clientId;

    public ConnectionResponse(int clientId){
        this.type = SocialResponseTypes.CONNECTION;
        this.clientId = clientId;
    }

}
