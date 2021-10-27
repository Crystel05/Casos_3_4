package Model;

import ObserverPattern.IObservable;
import ObserverPattern.IObserver;

import java.util.ArrayList;
import java.util.Map;

//TODO: Tiene que extender de Cliente de la libreria de conexion
public class ClienteSubasta {

    String nickName;
    ArrayList<Subasta> subastasHechas;
    ArrayList<Subasta> subastasSuscritas;

    public ClienteSubasta(String nickName){
        this.nickName = nickName;
        subastasHechas = new ArrayList<>();
        subastasSuscritas = new ArrayList<>();
    }


    public void ofertar(int idSubasta,double monto){
        for (Subasta subasta:subastasSuscritas) {
            if(subasta.getSubastaId() == idSubasta){
                //Tiene que llamar al server
                subasta.incrementarPrecio(monto);
            }
        }
    }
    
    public void unirseASubasta(int idSubasta){

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