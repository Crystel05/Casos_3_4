package Responses;

import Enums.AuctionResponseType;
import Model.Data.AuctionData;
import Network.Response.BaseResponse;

public class BidResponse extends BaseResponse {

    public String  content;
    ;
    public BidResponse(boolean accepted,AuctionData auctionData){
        this.type = AuctionResponseType.BID_RESPONSE;
        String isAccepted = accepted?"aceptada":"denegada";
        content = "La subasta de "+auctionData.producto.getNombre() + "fue" + isAccepted;
    }

}
