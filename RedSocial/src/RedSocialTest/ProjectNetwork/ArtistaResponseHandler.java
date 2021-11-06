package RedSocialTest.ProjectNetwork;

import Controlador.ControladorArtista;
import Network.Client.ClientResponseHandler;
import Network.Response.IHandleResponse;
import Network.Response.IResponse;
import RedSocialTest.ClientTypes.ArtistaClient;
import RedSocialTest.Enums.SocialResponseTypes;
import RedSocialTest.Requests.GetArtistasRequest;
import RedSocialTest.Responses.ConnectionResponse;
import RedSocialTest.Responses.GetArtistasResponse;
import RedSocialTest.Responses.PostCreadoResponse;

import java.io.IOException;

public class ArtistaResponseHandler implements IHandleResponse {


    @Override
    public void parseResponse(IResponse response, ClientResponseHandler handler) throws IOException, ClassNotFoundException {
        ControladorArtista controlador = ((ArtistaClient) handler.getClient()).getControladorArtista();
        SocialResponseTypes type = (SocialResponseTypes) response.getType();
        switch (type){
            case CONNECTION:
                ConnectionResponse connectionResponse = (ConnectionResponse) response;
                handler.getClient().setClientId(connectionResponse.clientId);
                controlador.setCurrentClientId(connectionResponse.clientId);
                System.out.println(connectionResponse.content);
                break;
            case GET_DOWN_SUCCSESSFULY:
                break;
            case CREATED_POST:
                PostCreadoResponse postCreadoResponse = (PostCreadoResponse) response;
                System.out.println(postCreadoResponse.content);
                break;
            case GET_POSTS:
                break;
            case GET_ARTISTAS:
                GetArtistasResponse artistasResponse = (GetArtistasResponse) response;
                controlador.setArtistas(artistasResponse.artistas);
                System.out.println("Vienen datos del servidor");
                break;
            case GET_SEGUIDORES:
                break;
            default:
                break;
        }
    }
}
