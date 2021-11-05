package Model;

import Network.ObserverPattern.ConcreteObserver;

import java.util.ArrayList;

//TODO: Tiene que extender de Cliente de la libreria de conexion
public class AuctionClient extends ConcreteObserver {

    String nickName;
    ArrayList<Auction> subastasHechas;
    ArrayList<Auction> subastasSuscritas;

    public AuctionClient(String nickName){
        this.nickName = nickName;
        subastasHechas = new ArrayList<>();
        subastasSuscritas = new ArrayList<>();
    }


    public void ofertar(int idSubasta,double monto){
        for (Auction subasta:subastasSuscritas) {
            if(subasta.getSubastaId() == idSubasta){
                //Tiene que llamar al server
                subasta.incrementarPrecio(monto);
            }
        }
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