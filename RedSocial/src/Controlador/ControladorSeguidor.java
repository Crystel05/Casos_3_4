package Controlador;

import Network.Client.ClientRequestSender;
import RedSocialTest.ClientTypes.ArtistaClient;
import RedSocialTest.ClientTypes.SeguidorClient;
import RedSocialTest.Model.ArtistaServer;
import RedSocialTest.Model.Data.ArtistData;
import RedSocialTest.Model.Data.SeguidorData;
import RedSocialTest.Model.SeguidorServer;
import RedSocialTest.ProjectNetwork.ArtistaResponseHandler;
import RedSocialTest.ProjectNetwork.SeguidorResponseHandler;
import RedSocialTest.Requests.DislikeRequest;
import RedSocialTest.Requests.FollowRequest;
import RedSocialTest.Requests.GetArtistasRequest;
import RedSocialTest.Requests.LikeRequest;
import Vista.Seguidores;

import java.io.IOException;
import java.util.ArrayList;

public class ControladorSeguidor {

    ArrayList<ArtistData> artistas;
    ArrayList<SeguidorData> seguidores;
    ArrayList<SeguidorClient> seguidoresCliente;
    int seguidorActualId; //Cuando conecto puedo setearlo como el principal
    int artistaActualId;
    static ControladorSeguidor controlador;

    Seguidores seguidoresPantalla;

    private ControladorSeguidor() {
        this.artistas = new ArrayList<>();
        this.seguidores = new ArrayList<>();
    }


    public void setSeguidoresPantalla(Seguidores seguidoresPantalla) {
        this.seguidoresPantalla = seguidoresPantalla;
    }

    public int getSeguidorActualId() {
        return seguidorActualId;
    }

    public void setSeguidorActualId(int seguidorActualId) {
        this.seguidorActualId = seguidorActualId;
    }

    public int getArtistaActualId() {
        return artistaActualId;
    }

    public void setArtistaActualId(int artistaActualId) {
        this.artistaActualId = artistaActualId;
    }

    public static ControladorSeguidor getInstance() {
        if (controlador == null) {
            controlador = new ControladorSeguidor();
        }
        return controlador;
    }

    public void nuevaConexion(String testName) throws IOException, ClassNotFoundException {
        SeguidorClient nuevoCliente = new SeguidorClient("localhost",6000,new SeguidorResponseHandler(),this);
        nuevoCliente.connect();
        seguidoresCliente.add(nuevoCliente);
    }

    public void like(int postId) throws IOException, ClassNotFoundException {
        seguidoresCliente.get(seguidorActualId-1).request(new LikeRequest(this.seguidorActualId,postId,this.artistaActualId));
    }

    public void dislike(int postId) throws IOException, ClassNotFoundException {
        seguidoresCliente.get(seguidorActualId-1).request(new DislikeRequest(this.seguidorActualId,postId,this.artistaActualId));
    }

    public void follow() throws IOException, ClassNotFoundException {
        seguidoresCliente.get(seguidorActualId-1).request(new FollowRequest(seguidorActualId-1,artistaActualId-1));
    }
}