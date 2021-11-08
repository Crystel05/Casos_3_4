package Responses;

import Enums.AuctionResponseType;
import Network.Response.BaseResponse;
import Network.Response.IResponse;
import Request.FollowAuctionRequest;

public class FollowAuctionResponse extends BaseResponse {

    String content = "Siguiendo subasta con exito";

    public FollowAuctionResponse(){
        this.type = AuctionResponseType.SEGUIR_SUBASTA_EXISTOSA;
    }
}
