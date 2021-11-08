package Responses;

import Enums.AuctionResponseType;
import Model.Bid;
import Network.Response.BaseResponse;

public class BidToAprove extends BaseResponse {

    public String content;
    public Bid bid;

    public BidToAprove(Bid bid){
        this.type = AuctionResponseType.APROBACION_OFERTA;
        this.bid = bid;
        //Se puede cambiar el contenido para mostrar otras cosas en el mensaje.
        content = "Se ha recibido una oferta de: " +bid.getOferenteId() + "para la subasta de: "+bid.getSubastaId() +"por:" +bid.getMonto();
    }

}
