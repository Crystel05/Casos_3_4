package Responses;

import Enums.AuctionResponseType;
import Model.Data.AuctionData;
import Network.Response.BaseResponse;

public class UpdateBidders extends BaseResponse {

    public String content;

    public UpdateBidders(AuctionData subasta){
        this.type = AuctionResponseType.AVISO_OFERTANTES;
        content = "Se ha hecho una oferta por "+subasta.producto.getPrecioFinal()+ " para el producto "+subasta.producto.getNombre();
    }

}
