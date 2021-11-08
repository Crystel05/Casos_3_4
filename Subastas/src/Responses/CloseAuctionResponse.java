package Responses;

import Enums.AuctionResponseType;
import Model.Data.AuctionData;
import Model.SubastaServer;
import Network.Response.BaseResponse;
import Request.CloseAuctionRequest;

public class CloseAuctionResponse extends BaseResponse {

   public String content;

    //Aca se puede agregar el mensaje de felicitaciones
    public CloseAuctionResponse(AuctionData subasta){
        this.type = AuctionResponseType.SUBASTA_FINALIZADA;
        content = "Has ganado la subasta "+subasta.subastaId + "de "+ subasta.producto.getNombre();
    }

}
