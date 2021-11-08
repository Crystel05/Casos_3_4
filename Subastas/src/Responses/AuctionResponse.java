package Responses;

import Enums.AuctionRequestType;
import Enums.AutionResponseType;
import Model.SubastaServer;
import Network.Response.IResponse;

public class AuctionResponse implements IResponse {
    public SubastaServer auctionServer;
    public AutionResponseType type;

    public AuctionResponse(SubastaServer auctionServer){
        this.auctionServer = auctionServer;
        this.type = AutionResponseType.SUBASTA_FINALIZADA;
    }

    @Override
    public Enum getType() {
        return type;
    }
}