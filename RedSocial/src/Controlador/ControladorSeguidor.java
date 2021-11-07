package Controlador;

import Network.Client.ClientRequestSender;
import RedSocialTest.ClientTypes.ArtistaClient;
import RedSocialTest.ClientTypes.SeguidorClient;
import RedSocialTest.Model.ArtistaServer;
import RedSocialTest.Model.Data.ArtistData;
import RedSocialTest.Model.Data.PostData;
import RedSocialTest.Model.Data.SeguidorData;
import RedSocialTest.Model.SeguidorServer;
import RedSocialTest.ProjectNetwork.ArtistaResponseHandler;
import RedSocialTest.ProjectNetwork.SeguidorResponseHandler;
import RedSocialTest.Requests.*;
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
        this.seguidoresCliente = new ArrayList<>();
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
        seguidoresCliente.get(seguidorActualId).request(new LikeRequest(this.seguidorActualId,postId));
    }

    public void dislike(int postId) throws IOException, ClassNotFoundException {
        seguidoresCliente.get(seguidorActualId).request(new DislikeRequest(this.seguidorActualId,postId));
    }

    public void follow() throws IOException, ClassNotFoundException {
        seguidoresCliente.get(seguidorActualId).request(new FollowRequest(seguidorActualId,artistaActualId));
    }

    public ArrayList<PostData> getCurrentPosts() {
        if(!artistas.isEmpty())
            return artistas.get(artistaActualId).posts;
        else
            return null;
    }

    public void getSeguidores() throws IOException, ClassNotFoundException { //Actualiza
        seguidoresCliente.get(seguidorActualId).request(new GetArtistasRequest());
    }

    public void getArtistas() throws IOException, ClassNotFoundException {
        seguidoresCliente.get(artistaActualId).request(new GetArtistasRequest());
    }

    public void setSeguidores(ArrayList<SeguidorData> seguidores) {
        this.seguidores = seguidores;
        seguidoresPantalla.setSeguidores(seguidores);
    }

    public void setArtistas(ArrayList<ArtistData> artistas) {
        this.artistas = artistas;
            artistaActualId = 0;
            seguidoresPantalla.setArtistas(artistas);
    }

    public void defaultUpdate() {
        seguidoresPantalla.defaultConectionUpdate();//Pantalla llene los datos con las listas que acaban de llegar
    }

    public String getNotificaciones() {
        return  seguidoresCliente.get(seguidorActualId).getNotificaciones();
    }

    public void addToNotificaciones(String text){
        seguidoresCliente.get(seguidorActualId).addToNotificaciones(text);
        seguidoresPantalla.setNotificaciones();
    }

    public void update() throws IOException, ClassNotFoundException {
        seguidoresCliente.get(seguidorActualId).request(new GetArtistasRequest());
        seguidoresCliente.get(seguidorActualId).request(new GetSeguidoresRequest());
    }
}