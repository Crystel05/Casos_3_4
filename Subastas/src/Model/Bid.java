package Model;

public class Bid {

    AuctionClient oferente;
    double montoPujado;

    public Bid(AuctionClient oferente, double montoPujado){
        this.oferente = oferente;
        this.montoPujado = montoPujado;
    }
}
