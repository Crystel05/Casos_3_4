package RedSocialTest.Model;

import Network.ObserverPattern.ConcreteObserver;
import Network.ObserverPattern.IObservable;
import Network.ObserverPattern.IObserver;
import RedSocialTest.Responses.ArtistaInactivoResponse;
import RedSocialTest.Responses.GetDownSuccessfulResponse;
import RedSocialTest.Responses.LikesAlcanzados;
import RedSocialTest.Responses.SeguidoresAlcanzados;

import java.io.IOException;
import java.util.ArrayList;

public class Artista extends ConcreteObserver {

    private final int FOLLOWERS_MULTIPLIER = 10;
    private final String nickName;
    int idArtista;
    ArrayList<Post> posts;
    ArrayList<IObserver> seguidores;
    boolean activo;

    public Artista(int idArtista,String nickName){
        this.idArtista = idArtista;
        this.activo = true;
        this.nickName = nickName;
    }

    public void createPost(int id ,String contenido) throws IOException {
        if(activo){
            posts.add(new Post(id,contenido,this));
            postCreadoResponse();
        }
        else{
            artistaInactivoResponse();
        }

    }

    private void artistaInactivoResponse() throws IOException {
        getResponseSender().sendResponse(new ArtistaInactivoResponse());
    }

    private void postCreadoResponse() throws IOException {
        getResponseSender().sendResponse(new PostCreadoResponse());
    }

    public void seguidoresResponse(int cantidadDeSeguidores) throws IOException {
        getResponseSender().sendResponse(new SeguidoresAlcanzados(cantidadDeSeguidores));
    }

    public void likesResponse(int cantidadDeLikes) throws IOException {
        getResponseSender().sendResponse(new LikesAlcanzados(cantidadDeLikes));
    }

    public void bajaCorrectaResponse() throws IOException {
        getResponseSender().sendResponse(new GetDownSuccessfulResponse());
    }

    public void darseDeBaja(){
        this.activo = false;
    }


//    @Override
//    public void update(IObservable observable) throws IOException {
//        Post post = (Post) observable;
//        likesResponse(post.getLikes());
//    }

    public boolean notFollowing(IObserver seguidorBuscado) {
        for (IObserver seguidor:seguidores) {
            if (seguidor.equals(seguidorBuscado))
                return false;
        }
        return true;
    }

    public void nuevoSeguidor(Seguidor seguidor) {
        if(activo){
            seguidores.add(seguidor);
            if(checkSeguidores()){

            }
        }

    }

    private boolean checkSeguidores() {
        return seguidores.size()%FOLLOWERS_MULTIPLIER ==0;
    }

    public void likesReached(Post post) throws IOException {
        likesResponse(post.getLikes());
    }
}
