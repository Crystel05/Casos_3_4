package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class ClientData implements Serializable {
    String nickName;
    ArrayList<AuctionData> subastasHechas;
    ArrayList<AuctionData> subastasSuscritas;

    public ClientData(String nickName, ArrayList<AuctionData> subastasHechas, ArrayList<AuctionData> subastasSuscritas) {
        this.nickName = nickName;
        this.subastasHechas = subastasHechas;
        this.subastasSuscritas = subastasSuscritas;
    }
}
