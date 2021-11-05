package Model;

import Enums.AuctionState;

import java.util.ArrayList;
import java.util.Date;

public class Auction {

    int subastaId;
    ArrayList<AuctionClient> oferentes;
    Product producto;
    Date inicio;
    Date fin;
    AuctionState estado;

    public int getSubastaId() {
        return subastaId;
    }

    public ArrayList<AuctionClient> getOferentes() {
        return oferentes;
    }

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

    public Auction(int subastaId, Product producto){
        this.oferentes = new ArrayList<>();
        estado = AuctionState.ACTIVO;
        this.producto = producto;
        this.subastaId = subastaId;
        inicio = new Date();
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

    public void agregarOferente(AuctionClient oferente)
    {
        oferentes.add(oferente);
    }

}
