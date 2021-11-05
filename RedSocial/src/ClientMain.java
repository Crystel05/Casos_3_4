import Network.Client.Client;
import RedSocialTest.ClientTypes.ArtistaClient;
import RedSocialTest.Enums.UserType;
import RedSocialTest.Model.Artista;
import RedSocialTest.ProjectNetwork.ArtistaResponseHandler;
import RedSocialTest.Requests.ConnectionRequest;
import RedSocialTest.Requests.PostRequest;


import java.io.IOException;


public class ClientMain {
    public static void main(String[] args) {
       try {
            ArtistaClient client = new ArtistaClient("localhost", 6000,  new ArtistaResponseHandler());
            client.connect();
            client.request(new PostRequest("Hola server"));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
