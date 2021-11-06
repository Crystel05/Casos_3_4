package RedSocialTest.ClientTypes;

import Controlador.ControladorSeguidor;
import Network.Client.Client;
import Network.Response.IHandleResponse;
import RedSocialTest.Enums.UserType;
import RedSocialTest.Requests.ConnectionRequest;

import java.io.IOException;

public class SeguidorClient extends Client {

    ControladorSeguidor controladorSeguidor;

    public SeguidorClient(String host, int port, IHandleResponse responseHandler, ControladorSeguidor controladorSeguidor) throws IOException, ClassNotFoundException {
        super(host, port, responseHandler);
        this.controladorSeguidor = controladorSeguidor;
    }

    @Override
    public void connect() throws IOException, ClassNotFoundException {
        request(new ConnectionRequest(UserType.FOLLOWER,"Test"));
    }
}
