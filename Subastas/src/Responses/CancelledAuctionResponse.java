package Responses;

import Enums.AuctionResponseType;
import Model.Data.AuctionData;
import Network.Response.BaseResponse;

public class CancelledAuctionResponse extends BaseResponse {
    public String content;

    public CancelledAuctionResponse(AuctionData subasta){
        this.type = AuctionResponseType.SUBASTA_CANCELADA;
        this.content = "La subasta " +subasta.subastaId+ " ha sido cancelada";
    }
}
