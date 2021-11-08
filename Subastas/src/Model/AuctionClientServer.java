package Model;

import Model.Data.AuctionData;
import Model.Data.ClientData;
import Network.BaseServerClasses.BasicServerClient;
import Network.ObserverPattern.IObservable;
import Responses.*;

import java.io.IOException;
import java.util.ArrayList;

//TODO: Tiene que extender de Cliente de la libreria de conexion
public class AuctionClientServer extends BasicServerClient {

    String nickName;
    ArrayList<SubastaServer> subastasHechas;
    ArrayList<SubastaServer> subastasSuscritas;
    SubastaServer.NotifyMode notifyMode;

    public AuctionClientServer(int objectId, String nickName){
        super(objectId);
        this.nickName = nickName;
        subastasHechas = new ArrayList<>();
        subastasSuscritas = new ArrayList<>();
    }

    public String getNickName() {
        return nickName;
    }


    public void ofertar(Bid bid,AuctionClientServer subastador) throws IOException {
        subastador.recibirOferta(bid);
        //Una vez enviada la oferta es enviada al subastador (Otro cliente del servidor)
    }

    private void recibirOferta(Bid bid) throws IOException {
        //El nombre de los metodos de sacar el id esta mal en la libreria.
        getResponseSender().sendResponse(new BidToAprove(bid));
    }

    private int getId() {
        return getObjectId();
    }

    public ClientData getData() {
        ArrayList<AuctionData> subastas_hechas = new ArrayList<>();
        ArrayList<AuctionData> subastas_Suscritas = new ArrayList<>();
        for (SubastaServer ad:subastasHechas) {
            subastas_hechas.add(ad.getData());
        }
        for (SubastaServer ad:subastasSuscritas) {
            subastas_Suscritas.add(ad.getData());
        }
        System.out.println("Hola en getData en AuctionClientServer");
        return new ClientData(nickName,subastas_hechas,subastas_Suscritas);

    }

    public void unirseASubasta(SubastaServer subastaServer) throws IOException {
        subastasSuscritas.add(subastaServer);
        subastaServer.agregarOferente(this);
    }

    public void agregarSubasta(SubastaServer subasta) throws IOException {
        subasta.setOwner(this);
        subastasHechas.add(subasta);
        getResponseSender().sendResponse(new SubastaExitosaResponse());
    }

    public void aceptarOferta(SubastaServer subasta, AuctionClientServer oferenteServer, double monto) throws IOException {
         subasta.incrementarPrecio(monto);
         oferenteServer.getResponseSender().sendResponse(new BidResponse(true,subasta.getData()));
    }

    public void rechazarOferta(SubastaServer subasta, AuctionClientServer oferenteServer, double monto) throws IOException {
        oferenteServer.getResponseSender().sendResponse(new BidResponse(false,subasta.getData()));
    }

    public void setNotifyMode(SubastaServer.NotifyMode notifyMode) {
        this.notifyMode = notifyMode;
    }

    @Override
    public void update(IObservable observable) throws IOException {
        SubastaServer subasta = (SubastaServer) observable;
        switch (notifyMode){
            case AUCTION_BID:
                getResponseSender().sendResponse(new UpdateBidders(subasta.getData()));
                break;
            case AUCTION_CANCELATION:
                getResponseSender().sendResponse(new CancelledAuctionResponse(subasta.getData()));
                break;
            default:
                System.out.println("Error");
        }
    }
}

//Se levanta el servidor
//Se inicia la aplicacion
//Los clientes crean subastas(Tienen una referencia de las subastas que crearon)
//Los cliente se suscriben a subastas(Tienen una referencia a las subastas suscritas)
//Las subastas guardan la referencia de su cliente
//Los clientes hacen una puja a una subasta
//La subasta notifica a todos sus clientes suscritos
//El cliente termina una subasta
//La subasta avisa a todos sus clientes