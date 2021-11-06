package RedSocialTest.ProjectNetwork;

import Controlador.ControladorArtista;
import Controlador.ControladorSeguidor;
import Network.Client.ClientResponseHandler;
import Network.Response.IHandleResponse;
import Network.Response.IResponse;
import RedSocialTest.ClientTypes.ArtistaClient;
import RedSocialTest.ClientTypes.SeguidorClient;
import RedSocialTest.Enums.SocialResponseTypes;
import RedSocialTest.Responses.*;

import java.io.IOException;

public class SeguidorResponseHandler implements IHandleResponse {

    @Override
    public void parseResponse(IResponse response, ClientResponseHandler handler) throws IOException, ClassNotFoundException {
        ControladorSeguidor controlador = ((SeguidorClient) handler.getClient()).getControladorSeguidor();
        SocialResponseTypes type = (SocialResponseTypes) response.getType();
        switch (type){
            case LIKES_MILE:{
                LikesAlcanzados likesAlcanzados = (LikesAlcanzados) response;
                System.out.println(likesAlcanzados);
                break;
            }
            case CONNECTION:
                ConnectionResponse connectionResponse = (ConnectionResponse) response;
                handler.getClient().setClientId(connectionResponse.clientId);
                controlador.setSeguidorActualId(connectionResponse.clientId);
                System.out.println(connectionResponse.content);
                break;
            case ALREADY_LIKED:
                AlreadyLikedPostResponse alreadyLikedPostResponse = (AlreadyLikedPostResponse) response;
                System.out.println(alreadyLikedPostResponse.content);
                break;
            case FOLLOWER_MILE:
                SeguidoresAlcanzados seguidoresAlcanzados = (SeguidoresAlcanzados) response;
                System.out.println(seguidoresAlcanzados.content);
                break;
            case ALREADY_UNLIKED:
                AlreadyUnlikedPostResponse alreadyUnlikedPostResponse = (AlreadyUnlikedPostResponse) response;
                System.out.println(alreadyUnlikedPostResponse.content);
                break;
            case UNACTIVE_ARTIST:
                ArtistaInactivoResponse artistaInactivoResponse = (ArtistaInactivoResponse) response;
                System.out.println(artistaInactivoResponse.content);
                break;
            case ALREADY_FOLLOWING:
                AlreadyFollowingArtistResponse alreadyFollowingArtistResponse = (AlreadyFollowingArtistResponse) response;
                System.out.println(alreadyFollowingArtistResponse.content);
                break;
            case SUCCESS_FOLLOWING:
                SuccessFollowing successFollowing = (SuccessFollowing) response;
                System.out.println(successFollowing.content);
                break;
            case GET_ARTISTAS:
                GetArtistasResponse artistasResponse = (GetArtistasResponse) response;
                controlador.setArtistas(artistasResponse.artistas);
                System.out.println("Vienen datos de artistas del servidor");
                break;
            case GET_SEGUIDORES:
                GetSeguidoresResponse seguidoresResponse = (GetSeguidoresResponse) response;
                controlador.setSeguidores(seguidoresResponse.seguidores);
                controlador.defaultUpdate();
                System.out.println("Vienen datos de seguidores del servidor");
                break;
            default:
                break;
        }
    }

}
