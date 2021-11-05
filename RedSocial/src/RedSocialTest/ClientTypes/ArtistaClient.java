package RedSocialTest.ClientTypes;

import Controlador.ControladorArtista;
import Network.Client.Client;
import Network.Response.IHandleResponse;
import RedSocialTest.Enums.UserType;
import RedSocialTest.Model.ArtistaServer;
import RedSocialTest.Model.PostServer;
import RedSocialTest.Requests.ConnectionRequest;
import RedSocialTest.Requests.GetArtistasRequest;

import java.io.IOException;
import java.util.ArrayList;

public class ArtistaClient extends Client {

    ArrayList<PostServer> posts;
    ArrayList<ArtistaServer>artistas;
    ControladorArtista controladorArtista;

    public ArtistaClient(String host, int port, IHandleResponse responseHandler,ControladorArtista controladorArtista) throws IOException, ClassNotFoundException {
        super(host, port, responseHandler);
        this.controladorArtista = controladorArtista;
    }

    public void getData(){

    }

    @Override
    public void connect() throws IOException, ClassNotFoundException {
        request(new ConnectionRequest(UserType.CELEBRITY,"Test"));
        request(new GetArtistasRequest());
    }

    public ControladorArtista getControladorArtista() {
        return controladorArtista;
    }
}
