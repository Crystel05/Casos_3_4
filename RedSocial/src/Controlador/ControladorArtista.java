package Controlador;

import RedSocialTest.ClientTypes.ArtistaClient;
import RedSocialTest.Model.Data.ArtistData;
import RedSocialTest.Model.Data.PostData;
import RedSocialTest.Model.Data.SeguidorData;
import RedSocialTest.ProjectNetwork.ArtistaResponseHandler;
import RedSocialTest.Requests.GetArtistasRequest;
import RedSocialTest.Requests.PostRequest;
import Vista.CrearPost;
import Vista.Famosos;

import java.io.IOException;
import java.util.ArrayList;

public class ControladorArtista {

    ArrayList<ArtistaClient> artistasClientes;
    ArrayList<ArtistData> artistas;
    int artistaActualId;
    Famosos pantallaFamosos;
    CrearPost pantallaCrearPost;
    private static ControladorArtista controlador;

    private ControladorArtista() {
        this.artistasClientes = new ArrayList<>();
    }

    public static ControladorArtista getInstance(){
        if(controlador == null){
            controlador = new ControladorArtista();
        }
        return controlador;
    }

    public void setPantallaFamosos(Famosos famosos) {
        this.pantallaFamosos = famosos;
    }

    public void setPantallaPost(CrearPost crearPost) {
        this.pantallaCrearPost = crearPost;
    }


    public void nuevaConexion(String testName) throws IOException, ClassNotFoundException {
        ArtistaClient nuevoCliente = new ArtistaClient("localhost",6000,new ArtistaResponseHandler(),this);
        nuevoCliente.connect();
        artistasClientes.add(nuevoCliente);
    }

    public void setArtistas(ArrayList<ArtistData> artistas) {
        this.artistas = artistas;
        pantallaFamosos.setArtistas(artistas);
        pantallaFamosos.loadPosts();
    }

    public void setCurrentClientId(int clientId) {
        this.artistaActualId = clientId;
    }

    public ArrayList<PostData> getCurrentPosts() {
        return artistas.get(artistaActualId).posts;
    }

    public void post(String content) throws IOException, ClassNotFoundException {
        artistasClientes.get(artistaActualId).request(new PostRequest(content,artistaActualId));
    }

    public void getArtistas() throws IOException, ClassNotFoundException {
        artistasClientes.get(artistaActualId).request(new GetArtistasRequest());
    }



}
