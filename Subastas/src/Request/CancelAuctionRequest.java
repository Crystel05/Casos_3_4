package Request;

import Enums.AuctionRequestType;
import Network.Request.BaseRequest;

public class CancelAuctionRequest extends BaseRequest {

    public int subastadorId;
    public int subastaId;

    public CancelAuctionRequest(int subastadorId, int subastaId) {
        this.subastadorId = subastadorId;
        this.subastaId = subastaId;
        this.type = AuctionRequestType.CANCELAR_SUBASTA;
    }
}
