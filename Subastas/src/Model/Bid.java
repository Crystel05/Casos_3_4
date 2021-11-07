package Model;

public class Bid {

    AuctionClientServer oferente;
    double montoPujado;

    public Bid(AuctionClientServer oferente, double montoPujado){
        this.oferente = oferente;
        this.montoPujado = montoPujado;
    }
}
