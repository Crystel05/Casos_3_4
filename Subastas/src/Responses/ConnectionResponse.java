package Responses;

import Enums.AutionResponseType;
import Network.Response.IResponse;

public class ConnectionResponse implements IResponse {

    AutionResponseType type;
    public String content;

    public ConnectionResponse(String string){

        this.type = AutionResponseType.TEST;
        content = string;
    }

    @Override
    public Enum getType() {
        return type;
    }
}