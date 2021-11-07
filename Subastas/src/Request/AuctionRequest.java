package Request;

import Enums.AuctionRequestType;
import Model.SubastaServer;
import Network.Request.IRequest;

public class AuctionRequest implements IRequest {
    public SubastaServer auctionServer;
    public AuctionRequestType type;

    public AuctionRequest(SubastaServer auctionServer){
        this.auctionServer = auctionServer;
        this.type = AuctionRequestType.SUBASTAR;
    }

    public SubastaServer getAuction(){
        return auctionServer;
    }

    public void setAuction(SubastaServer auctionServer) {
        this.auctionServer = auctionServer;
    }

    @Override
    public Enum getType() {
        return type;
    }
}
