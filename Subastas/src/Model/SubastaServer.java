package Model;

import Enums.AuctionState;
import Model.Data.AuctionData;
import Model.Data.Product;
import Network.BaseServerClasses.BasicServerObject;

import java.util.Date;

public class SubastaServer extends BasicServerObject {

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

    public SubastaServer(int subastaId, Product producto) {
        super(subastaId);
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
        addObserver(oferente);
    }

    public AuctionData getData(){
        return new AuctionData(getIdClient(), getObservadores().size(), producto, inicio, fin , estado, owner.getNickName());
    }

    public void setOwner(AuctionClientServer owner) {
        this.owner = owner;
    }

    public AuctionClientServer getOwner() {
        return this.owner;
    }
}
