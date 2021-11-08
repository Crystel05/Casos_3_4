package Responses;

import Enums.AuctionResponseType;
import Model.Bid;
import Network.Response.BaseResponse;

public class AprobacionOfertaResponse extends BaseResponse {

    public String content;
    public Bid bid;

    public AprobacionOfertaResponse(Bid bid){
        this.type = AuctionResponseType.APROBACION_OFERTA;
        this.bid = bid;
        //Se puede cambiar el contenido para mostrar otras cosas en el mensaje.
        content = "Se ha recibido una oferta de: " +bid.getOferenteId() + "para la subasta de: "+bid.getSubastaId() +"por:" +bid.getMonto();
    }

}
