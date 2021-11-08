package Request;

import Enums.AuctionRequestType;
import Model.Data.AuctionData;
import Network.Request.BaseRequest;

public class AuctionRequest extends BaseRequest {
    public AuctionData auctionData;
    public int subastadorId;

    public AuctionRequest(AuctionData auctionData,int subastadorId){
        this.auctionData = auctionData;
        this.type = AuctionRequestType.SUBASTAR;
        this.subastadorId = subastadorId;
    }

    public AuctionData getAuctionData() {
        return auctionData;
    }
}
