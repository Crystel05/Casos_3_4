package Request;

import Enums.AuctionRequestType;
import Network.Request.BaseRequest;


public class GetClientsRequest extends BaseRequest {

    public GetClientsRequest(){
        this.type = AuctionRequestType.GET_CLIENTS;
    }

}
