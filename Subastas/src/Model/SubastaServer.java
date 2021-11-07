package Model;

import Enums.AuctionState;
import Network.BaseServerClasses.BasicServerObject;
import Network.Server.ObserverPattern.IObserver;

import java.util.ArrayList;
import java.util.Date;

public class SubastaServer extends BasicServerObject {

    //int subastaId;
    private ArrayList<IObserver> oferentes;
    private Product producto;
    private Date inicio;
    private Date fin;
    private AuctionState estado;
    private AuctionClientServer owner;


    public Product getProducto() {
        return producto;
    }

    public Date getInicio() {
        return inicio;
    }

    public Date getFin() {
        return fin;
    }

    public AuctionState getEstado() {
        return estado;
    }

    public SubastaServer(int subastaId){
        super(subastaId);

    }

    public SubastaServer(int subastaId, Product producto) {
        super(subastaId);
        this.oferentes = new ArrayList<>();
        this.estado = AuctionState.ACTIVO;
        this.producto = producto;
        this.inicio = new Date();
    }

    public void cerrar(){
        if(estado.equals(AuctionState.ACTIVO)){
            estado = AuctionState.TERMINADO;
            fin = new Date();
        }
    }
    public void cancelar(){
        if(!estado.equals(AuctionState.CANCELADO)){
            estado = AuctionState.CANCELADO;
            fin = new Date();
        }
    }

    public void incrementarPrecio(double precio){
        if(estado.equals(AuctionState.ACTIVO) && precio > producto.getPrecioFinal()){
            producto.setPrecioFinal(precio);
        }
    }

    public void agregarOferente(AuctionClientServer oferente)
    {
        oferentes.add(oferente);
    }

    public AuctionData getData(){
        //No se si esta bien poner aca lo objs
        return new AuctionData(getIdClient(), oferentes.size(), producto, inicio, fin , estado, owner.getNickName());
    }

}
