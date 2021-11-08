package Request;

import Enums.AuctionRequestType;
import Model.Bid;
import Network.Request.BaseRequest;

public class BidRequest extends BaseRequest{

    public Bid bid;
    public int subastadorId;


    public BidRequest(Bid bid) {
        this.bid = bid;
        this.type = AuctionRequestType.PUJAR;
    }
}
