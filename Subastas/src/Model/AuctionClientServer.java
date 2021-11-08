package Model;

import Network.BaseServerClasses.BasicServerClient;

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


    /*public void ofertar(int idSubasta,double monto){
        for (SubastaServer subasta:subastasSuscritas) {
            if(subasta.getObjectId() == idSubasta){
                //Tiene que llamar al server
                subasta.incrementarPrecio(monto);
            }
        }
    }*/

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

    public void verSubastas(){

    }

    public void sendRequest(){

    }

    public void crearSubasta(){

    }

    public void cerrarSubasta(){

    }

    public void cancelarSubasta(){

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