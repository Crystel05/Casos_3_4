package RedSocialTest.ClientTypes;

import Network.Client.Client;
import Network.Response.IHandleResponse;
import RedSocialTest.Enums.UserType;
import RedSocialTest.Model.Artista;
import RedSocialTest.Model.Post;
import RedSocialTest.Requests.ConnectionRequest;

import java.io.IOException;
import java.util.ArrayList;

public class ArtistaClient extends Client {

    ArrayList<Post> posts;
    ArrayList<Artista>artistas;

    public ArtistaClient(String host, int port, IHandleResponse responseHandler) throws IOException, ClassNotFoundException {
        super(host, port, responseHandler);
    }
    public void getData(){

    }

    @Override
    public void connect() throws IOException, ClassNotFoundException {
        request(new ConnectionRequest(UserType.FOLLOWER,"Test"));
    }
}
