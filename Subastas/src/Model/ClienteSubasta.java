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
        nickName = nickName;
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
