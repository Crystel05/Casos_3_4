package Request;

import Enums.AuctionRequestType;
import Model.Bid;
import Network.Request.BaseRequest;

public class BidRequest extends BaseRequest{

    public Bid bid;
    public int subastadorId;


    public BidRequest(Bid bid,int subastadorId) {
        this.bid = bid;
        this.type = AuctionRequestType.PUJAR;
        this.subastadorId = subastadorId;
    }
}
