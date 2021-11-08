package Request;

import Enums.AuctionRequestType;
import Enums.AuctionResponseType;
import Network.Request.BaseRequest;

public class FollowAuctionRequest extends BaseRequest {

    public int auctionId;
    public int oferenteId;

    public FollowAuctionRequest(int auctionId,int oferenteId){
        this.type = AuctionRequestType.SUBSCRIBE_TO_AUCTION;
        this.auctionId = auctionId;
        this.oferenteId = oferenteId;
    }

}
