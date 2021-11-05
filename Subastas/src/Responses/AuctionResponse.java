package Responses;

import Enums.AuctionRequestType;
import Enums.AutionResponseType;
import Model.Auction;
import Network.Response.IResponse;

public class AuctionResponse implements IResponse {
    public Auction auction;
    public AuctionRequestType type;

    public AuctionResponse(Auction auction){
        this.auction = auction;
        this.type = AuctionRequestType.SUBASTAR;
    }

    @Override
    public Enum getType() {
        return type;
    }
}