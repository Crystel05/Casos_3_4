package Model;

import Model.Data.AuctionData;
import Model.Data.ClientData;

import java.io.Serializable;

public class Bid implements Serializable {

    int oferenteId;
    int subastaId;
    double montoPujado;

    public Bid(int oferente,int subasta, double montoPujado){
        this.oferenteId = oferente;
        this.montoPujado = montoPujado;
        this.subastaId = subasta;
    }

    public int getOferenteId() {
        return oferenteId;
    }

    public int getSubastaId() {
        return subastaId;
    }

    public double getMonto() {
        return montoPujado;
    }
}
