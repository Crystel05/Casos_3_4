package Request;

import Enums.AuctionRequestType;
import Network.Request.BaseRequest;

public class CloseAuctionRequest extends BaseRequest{

    public int subastaId;
    public int subastadorId;

    public CloseAuctionRequest(int subastaId, int subastadorId) {
        this.subastaId = subastaId;
        this.subastadorId = subastadorId;
        this.type = AuctionRequestType.CERRAR_SUBASTA;
    }
}
