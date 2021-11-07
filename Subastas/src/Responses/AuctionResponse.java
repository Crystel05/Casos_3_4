package Responses;

import Enums.AuctionRequestType;
import Model.SubastaServer;
import Network.Response.IResponse;

public class AuctionResponse implements IResponse {
    public SubastaServer auctionServer;
    public AuctionRequestType type;

    public AuctionResponse(SubastaServer auctionServer){
        this.auctionServer = auctionServer;
        this.type = AuctionRequestType.SUBASTAR;
    }

    @Override
    public Enum getType() {
        return type;
    }
}