
import Network.Server.Server;
import RedSocialTest.ProjectNetwork.SocialServerRequestHandler;

import java.io.IOException;

public class ServerMain {
    public static void main(String[] args) {
        try {
            Server server = new Server(6000, new SocialServerRequestHandler());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("WHAT");
            e.printStackTrace();
        }
    }
}
