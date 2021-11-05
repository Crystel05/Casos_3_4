package RedSocialTest.Model;


import Network.BaseServerClasses.BasicServerClient;
import Network.ObserverPattern.IObservable;
import Network.ObserverPattern.IObserver;
import RedSocialTest.Model.Data.ArtistData;
import RedSocialTest.Model.Data.PostData;
import RedSocialTest.Responses.*;
import java.io.IOException;
import java.util.ArrayList;

public class ArtistaServer extends BasicServerClient {

    private final int FOLLOWERS_MULTIPLIER = 10;
    private final String nickName;
    ArrayList<PostServer> posts;
    ArrayList<IObserver> seguidores;
    boolean activo;

    public ArtistaServer(int idArtista, String nickName) {
        super(idArtista);
        this.activo = true;
        this.nickName = nickName;
        this.posts = new ArrayList<>();
        this.seguidores  = new ArrayList<>();
    }

    public void createPost(int id, String contenido) throws IOException {
        if (activo) {
            posts.add(new PostServer(id, contenido, this));
            postCreadoResponse();
        } else {
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

    public void darseDeBaja() {
        this.activo = false;
    }


    @Override
    public void update(IObservable observable) throws IOException {
        PostServer post = (PostServer) observable;
        likesResponse(post.getLikes());
    }

    public boolean notFollowing(IObserver seguidorBuscado) {
        for (IObserver seguidor : seguidores) {
            if (seguidor.equals(seguidorBuscado))
                return false;
        }
        return true;
    }

    public void nuevoSeguidor(SeguidorServer seguidor) {
        if (activo) {
            seguidores.add(seguidor);
            if (checkSeguidores()) {

            }
        }

    }

    private boolean checkSeguidores() {
        return seguidores.size() % FOLLOWERS_MULTIPLIER == 0;
    }

    public void likesReached(PostServer post) throws IOException {
        likesResponse(post.getLikes());
    }

    public  String toString(){
        return "Nickname: " + nickName; //Agregar los post
    }

    public ArtistData getData() {
        ArrayList<PostData> postsData = new ArrayList<>();
        for (PostServer post:posts) {
            postsData.add(post.getData());
        }
        return new ArtistData(nickName,postsData,seguidores.size(),activo);
    }

    public String getNickName() {
        return this.nickName;
    }
}
