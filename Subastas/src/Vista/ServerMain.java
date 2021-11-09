package Vista;

import Network.Server.Server;
import ProjectNetwork.AuctionServerRequestHandler;


import java.io.IOException;

/**
 * Caso 3: Editor de texto
 * Fabrizio Ferreto 2019177147
 * Ulises Rodríguez 2019380067
 * Natalia Vargas   2019077180
 * Fernando Álvarez 2019171657
 * Crystel Montero  2019158736
 * */

public class ServerMain {
    public static void main(String[] args) {
        try {
            Server server = new Server(9999, new AuctionServerRequestHandler());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
