package Request;

import Enums.AuctionRequestType;
import Model.Auction;
import Network.Request.IRequest;

public class AuctionRequest implements IRequest {
    public Auction auction;
    public AuctionRequestType type;

    public AuctionRequest(Auction auction){
        this.auction = auction;
        this.type = AuctionRequestType.SUBASTAR;
    }

    public Auction getAuction(){
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    @Override
    public Enum getType() {
        return type;
    }
}
