package Controlador;

import RedSocialTest.ClientTypes.ArtistaClient;
import RedSocialTest.Model.ArtistaServer;
import RedSocialTest.Model.Data.ArtistData;
import RedSocialTest.ProjectNetwork.ArtistaResponseHandler;
import Vista.Famosos;

import java.io.IOException;
import java.util.ArrayList;

public class ControladorArtista {

    ArrayList<ArtistaClient> artistasClientes;
    ArrayList<ArtistData> artistas;
    int artistaActualId;
    Famosos pantalla;

    public ControladorArtista(Famosos famosos) {
        this.pantalla = famosos;
        this.artistasClientes = new ArrayList<>();
    }


    public void nuevaConexion(String testName) throws IOException, ClassNotFoundException {
        ArtistaClient nuevoCliente = new ArtistaClient("localhost",6000,new ArtistaResponseHandler(),this);
        nuevoCliente.connect();
        artistasClientes.add(nuevoCliente);
    }

    public void setArtistas(ArrayList<ArtistData> artistas) {
        this.artistas = artistas;
        for (ArtistData artista: artistas) {
            System.out.println(artistas);
        }

    }

    /*public void updateData(){
        artistaActual.request(new GetArtistasRequest());
        pantalla.updatePost(artistaActual);
        pantalla.fillFamosos();
    }*/
}
