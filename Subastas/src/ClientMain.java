import Enums.UserType;
import Network.Client.Client;
import ProjectNetwork.AuctionClientResponseHandler;
import Request.ConnectionRequest;

import java.io.IOException;


//Creo que el cliente no necesita una estrategia para enviar request o talvez para que ahi esten los metodos que preparan los strings o algo asi.
public class ClientMain {
    public static void main(String[] args) {

            //Client client = new Client("localhost", 9999,new AuctionClientResponseHandler());
            //client.request(new ConnectionRequest(UserType.SUBASTADOR));
            //Ejemplo
            //client.request(new AuctionRequest(new Auction(1,new Product("Ukulele Fender","Soprano color rosado",30000,0))));


    }
}
