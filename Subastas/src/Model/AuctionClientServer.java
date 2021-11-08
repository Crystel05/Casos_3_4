package Model;

import Model.Data.AuctionData;
import Model.Data.ClientData;
import Network.BaseServerClasses.BasicServerClient;
import Responses.AprobacionOfertaResponse;

import java.io.IOException;
import java.util.ArrayList;

//TODO: Tiene que extender de Cliente de la libreria de conexion
public class AuctionClientServer extends BasicServerClient {

    String nickName;
    ArrayList<SubastaServer> subastasHechas;
    ArrayList<SubastaServer> subastasSuscritas;

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
        getResponseSender().sendResponse(new AprobacionOfertaResponse(bid));
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

    public void unirseASubasta(int idSubasta){

    }

    public void agregarSubasta(SubastaServer subasta){
        subasta.setOwner(this);
        subastasHechas.add(subasta);
    }

    public void felicitacionGanador(){

    }
    
    public void aceptarOferta(){

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