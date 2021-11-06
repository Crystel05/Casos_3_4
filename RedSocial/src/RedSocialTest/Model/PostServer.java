package RedSocialTest.Model;

import Network.BaseServerClasses.BasicServerObject;
import Network.ObserverPattern.IObserver;
import RedSocialTest.Model.Data.PostData;

import java.io.IOException;
import java.util.ArrayList;

public class PostServer extends BasicServerObject {
    String content;
    ArrayList<IObserver> seguidores;
    ArrayList<IObserver> likes;
    ArrayList<IObserver> unlikes;
    ArtistaServer owner;
    final int LIKES_MULTIPLIER = 10;


    public PostServer(int id, String content, ArtistaServer owner) {
        super(id);
        this.owner = owner;
        this.content = content;
        this.seguidores = new ArrayList<>();
        this.likes = new ArrayList<>();
        this.unlikes = new ArrayList<>();
    }

    @Override
    public void updateAll() throws IOException {
        for (IObserver observer:seguidores) {
            observer.update(this);
        }
    }

    @Override
    public void addObserver(IObserver observer) {
        this.seguidores.add(observer);
    }

    public boolean notLiked(IObserver seguidorBuscado) {
        for (IObserver seguidor : likes) {
            if (seguidor.equals(seguidorBuscado))
                return false;
        }
        return true;
    }

    public boolean notUnliked(IObserver seguidorBuscado) {
        for (IObserver seguidor : unlikes) {
            if (seguidor.equals(seguidorBuscado))
                return false;
        }
        return true;
    }

    public void agregarLike(SeguidorServer seguidor) throws IOException {
        likes.add(seguidor);
        checkLikes();
    }

    public void quitarUnlike(SeguidorServer seguidor) {
        unlikes.remove(seguidor);
    }

    public void agregarUnlike(SeguidorServer seguidor) {
        unlikes.add(seguidor);
    }

    public void quitarLike(SeguidorServer seguidor) {
        likes.remove(seguidor);
    }

    public int getLikes() {
        return this.likes.size();
    }

    public void checkLikes() throws IOException {
        if (getLikes() % LIKES_MULTIPLIER == 0) {
            owner.likesReached(this);//Avisa al dueno
            updateAll();//Avisa a todos los suscritos
        }
    }

    public PostData getData(){
        return new PostData(getIdClient(),likes.size(),unlikes.size(),content,owner.getNickName());
    }
}
