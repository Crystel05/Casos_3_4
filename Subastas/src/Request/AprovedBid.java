package Request;

import Enums.AuctionRequestType;
import Model.Bid;
import Network.Request.BaseRequest;

public class AprovedBid extends BaseRequest {

    public Bid bid;
    public int subastadorId;
    public boolean aproved;

    public AprovedBid(Bid bid, int subastadorId,boolean aproved){
        this.bid = bid;
        this.aproved = aproved;
        this.subastadorId = subastadorId;
        this.type = AuctionRequestType.APROVED_BID_REQUEST;
    }

}
