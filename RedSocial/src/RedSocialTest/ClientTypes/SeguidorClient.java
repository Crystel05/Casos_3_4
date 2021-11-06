package RedSocialTest.ClientTypes;

import Controlador.ControladorSeguidor;
import Network.Client.Client;
import Network.Response.IHandleResponse;
import RedSocialTest.Enums.UserType;
import RedSocialTest.Requests.ConnectionRequest;
import RedSocialTest.Requests.GetArtistasRequest;
import RedSocialTest.Requests.GetSeguidoresRequest;

import java.io.IOException;

public class SeguidorClient extends Client {

    ControladorSeguidor controladorSeguidor;
    String notificaciones;

    public SeguidorClient(String host, int port, IHandleResponse responseHandler, ControladorSeguidor controladorSeguidor) throws IOException, ClassNotFoundException {
        super(host, port, responseHandler);
        this.controladorSeguidor = controladorSeguidor;
        this.notificaciones = "";
    }

    @Override
    public void connect() throws IOException, ClassNotFoundException {
        request(new ConnectionRequest(UserType.FOLLOWER,"Seguidor"+getClientId()));
        request(new GetArtistasRequest());
        request(new GetSeguidoresRequest());
    }

    public ControladorSeguidor getControladorSeguidor() {
        return controladorSeguidor;
    }

    public void addToNotificaciones(String text){
        notificaciones += text;
    }

    public String getNotificaciones(){
        return notificaciones;
    }
}
