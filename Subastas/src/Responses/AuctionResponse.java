package Responses;

import Enums.AuctionResponseType;
import Model.SubastaServer;
import Network.Response.BaseResponse;
import Network.Response.IResponse;

public class AuctionResponse extends BaseResponse {
    public SubastaServer auctionServer;

    public AuctionResponse(SubastaServer auctionServer){
        this.auctionServer = auctionServer;
        this.type = AuctionResponseType.SUBASTA_FINALIZADA;
    }

    @Override
    public Enum getType() {
        return type;
    }
}