import Network.Client.Client;
import RedSocialTest.Enums.UserType;
import RedSocialTest.ProjectNetwork.SocialClientResponseHandler;
import RedSocialTest.Requests.ConnectionRequest;
import RedSocialTest.Requests.PostRequest;

import java.io.IOException;


//Creo que el cliente no necesita una estrategia para enviar request o talvez para que ahi esten los metodos que preparan los strings o algo asi.
public class ClientMain {
    public static void main(String[] args) {
        try {
            Client client = new Client("localhost", 6000,new SocialClientResponseHandler());
            client.request(new ConnectionRequest(UserType.FOLLOWER));
            client.request(new PostRequest("Hola server"));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
