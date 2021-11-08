package Model;

import Enums.AuctionState;
import Network.Server.ObserverPattern.IObserver;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class AuctionData  implements Serializable {
    private int subastaId;
    private int oferentes;
    private Product producto;
    private Date inicio;
    private Date fin;
    private AuctionState estado;
    private String nickname;

    public AuctionData(int subastaId, int oferentes, Product producto, Date inicio, Date fin, AuctionState estado,String nickname) {
        this.subastaId = subastaId;
        this.oferentes = oferentes;
        this.producto = producto;
        this.inicio = inicio;
        this.fin = fin;
        this.estado = estado;
        this.nickname = nickname;
    }
    public AuctionData(Product producto, Date inicio, Date fin) {
        this.producto = producto;
        this.inicio = inicio;
        this.fin = fin;
    }

    public void setSubastaId(int subastaId) {
        this.subastaId = subastaId;
    }

    public int getSubastaId() {
        return subastaId;
    }
    public String getNickname() {
        return nickname;
    }

}
