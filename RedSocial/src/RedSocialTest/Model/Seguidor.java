package RedSocialTest.Model;

import Network.BaseServerClasses.BasicServerClient;
import Network.ObserverPattern.IObservable;
import RedSocialTest.Responses.*;

import java.io.IOException;

public class Seguidor  extends BasicServerClient {

    String username;

    public Seguidor(int idSeguidor, String userName) {
        super(idSeguidor);
        this.username = userName;
    }
    public void seguirArtista(Artista artista) throws IOException {
        if (artista.notFollowing(this)) {
            artista.nuevoSeguidor(this);
            siguiendoCorrectamente();
        } else
            alreadyFollowingArtistResponse();
    }

    public void likePost(Post post) throws IOException {
        if (post.notLiked(this))
            if (post.notUnliked(this))
                post.agregarLike(this);
            else {
                post.quitarUnlike(this);
                post.agregarLike(this);
            }
        else
            alreadyLikedPostResponse();

    }

    public void unlikePost(Post post) throws IOException {
        if (post.notUnliked(this))
            if (post.notLiked(this))
                post.agregarUnlike(this);
            else {
                post.quitarLike(this);
                post.agregarUnlike(this);
            }
        else
            alreadyUnlikedPostResponse();
    }

    private void alreadyUnlikedPostResponse() throws IOException {
        getResponseSender().sendResponse(new AlreadyUnlikedPostResponse());
    }

    public void alreadyLikedPostResponse() throws IOException {
        getResponseSender().sendResponse(new AlreadyLikedPostResponse());
    }

    private void alreadyFollowingArtistResponse() throws IOException {
        getResponseSender().sendResponse(new AlreadyFollowingArtistResponse());
    }

    private void siguiendoCorrectamente() throws IOException {
        getResponseSender().sendResponse(new SuccessFollowing());
    }

    public void likesResponse(int cantidadDeLikes) throws IOException {
        getResponseSender().sendResponse(new LikesAlcanzados(cantidadDeLikes));
    }

    @Override
    public void update(IObservable postNotifier) throws IOException {
        Post post = (Post) postNotifier;
        likesResponse(post.getLikes());
    }
}
