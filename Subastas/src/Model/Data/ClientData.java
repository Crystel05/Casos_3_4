package Model.Data;

import Model.Data.AuctionData;

import java.io.Serializable;
import java.util.ArrayList;

public class ClientData implements Serializable {
    public String nickName;
    public ArrayList<AuctionData> subastasHechas;
    public ArrayList<AuctionData> subastasSuscritas;

    public ClientData(String nickName, ArrayList<AuctionData> subastasHechas, ArrayList<AuctionData> subastasSuscritas) {
        this.nickName = nickName;
        this.subastasHechas = subastasHechas;
        this.subastasSuscritas = subastasSuscritas;
    }

    public String getNickName() {
        return nickName;
    }

}
