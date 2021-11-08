package Model;

import Enums.AuctionState;
import Model.Data.AuctionData;
import Model.Data.Product;
import Network.BaseServerClasses.BasicServerObject;
import Network.ObserverPattern.IObserver;
import Request.FollowAuctionRequest;
import Responses.CloseAuctionResponse;
import Responses.FollowAuctionResponse;

import java.io.IOException;
import java.util.Date;

public class SubastaServer extends BasicServerObject {

    private Product producto;
    private Date inicio;
    private Date fin;
    private AuctionState estado;
    private AuctionClientServer owner;
    private AuctionClientServer winner;
    private NotifyMode notifyMode;

    enum NotifyMode{
        AUCTION_CANCELATION,AUCTION_CLOSE,AUCTION_BID
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

    public SubastaServer(int subastaId, Product producto) {
        super(subastaId);
        this.estado = AuctionState.ACTIVO;
        this.producto = producto;
        this.inicio = new Date();
    }

    public void cerrar() throws IOException {
        if(estado.equals(AuctionState.ACTIVO)){
            estado = AuctionState.TERMINADO;
            fin = new Date();
            felicitarGanador();
        }
    }

    private void felicitarGanador() throws IOException {
        winner.getResponseSender().sendResponse(new CloseAuctionResponse(this.getData()));
    }

    public void cancelar() throws IOException {
        if(!estado.equals(AuctionState.CANCELADO)){
            estado = AuctionState.CANCELADO;
            fin = new Date();
            this.notifyMode = NotifyMode.AUCTION_CANCELATION;
        }
    }

    public void incrementarPrecio(double precio) throws IOException {
        if(estado.equals(AuctionState.ACTIVO) && precio > producto.getPrecioFinal()){
            producto.setPrecioFinal(precio);
            this.notifyMode = NotifyMode.AUCTION_BID;
            updateAll();
        }
    }

    @Override
    public void updateAll() throws IOException {
        for (IObserver subscribed:getObservadores()) {
            AuctionClientServer oferente = (AuctionClientServer) subscribed;
            oferente.setNotifyMode(notifyMode);
            oferente.update(this);
        }
    }

    public void agregarOferente(AuctionClientServer oferente) throws IOException {
        addObserver(oferente);
        oferente.getResponseSender().sendResponse(new FollowAuctionResponse());
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
