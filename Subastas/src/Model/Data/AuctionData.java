package Model.Data;

import Enums.AuctionState;

import java.io.Serializable;
import java.util.Date;

public class AuctionData  implements Serializable {
    public int subastaId;
    public int oferentes;
    public Product producto;
    public Date inicio;
    public Date fin;
    public AuctionState estado;
    public String nickname;

    public AuctionData(int subastaId, int oferentes, Product producto, Date inicio, Date fin, AuctionState estado,String nickname) {
        this.subastaId = subastaId;
        this.oferentes = oferentes;
        this.producto = producto;
        this.inicio = inicio;
        this.fin = fin;
        this.estado = estado;
        this.nickname = nickname;
    }


    public AuctionData(Product product, Date inicio, Date fin) {
        this.producto = product;
        this.inicio = inicio;
        this.fin = fin;
    }
}
