package Request;

import Enums.AuctionRequestType;
import Model.AuctionData;
import Model.SubastaServer;
import Network.Request.BaseRequest;
import Network.Request.IRequest;

public class AuctionRequest extends BaseRequest {
    public AuctionData auctionData;
    public AuctionRequestType type;

    public AuctionRequest(AuctionData auctionData){
        this.auctionData = auctionData;
        this.type = AuctionRequestType.SUBASTAR;
    }

    public AuctionData getAuctionData() {
        return auctionData;
    }
}
