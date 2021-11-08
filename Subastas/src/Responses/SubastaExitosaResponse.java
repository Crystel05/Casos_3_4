package Responses;

import Enums.AuctionResponseType;
import Network.Response.BaseResponse;

public class SubastaExitosaResponse extends BaseResponse {

    public String content = "La subasta se ha creado con exito";

    public SubastaExitosaResponse(){
        this.type = AuctionResponseType.SUBASTA_EXITOSA;
    }
}
