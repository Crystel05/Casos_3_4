package Vista;

import Network.Server.Server;
import ProjectNetwork.AuctionServerRequestHandler;


import java.io.IOException;



public class ServerMain {
    public static void main(String[] args) {
        try {
            Server server = new Server(9999, new AuctionServerRequestHandler());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
