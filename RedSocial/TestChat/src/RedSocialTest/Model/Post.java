package RedSocialTest.Model;

import Network.ObserverPattern.IObservable;
import Network.ObserverPattern.IObserver;

import java.io.IOException;
import java.util.ArrayList;

public class Post implements IObservable {
    int id;
    String content;
    ArrayList<IObserver> seguidores;
    ArrayList<IObserver> likes;
    ArrayList<IObserver> unlikes;
    Artista owner;
    final int LIKES_MULTIPLIER = 10;


    public Post(int id,String content, Artista owner){
        this.id = id;
        this.owner = owner;
        this.content = content;
    }

    @Override
    public void updateAll() {
        for (IObserver observer:seguidores) {
            observer.update(this);
        }
    }

    @Override
    public void addObserver(IObserver observer) {
        this.seguidores.add(observer);
    }

    public boolean notLiked(IObserver seguidorBuscado) {
        for (IObserver seguidor:likes) {
            if(seguidor.equals(seguidorBuscado))
                return  false;
        }
        return  true;
    }

    public boolean notUnliked(IObserver seguidorBuscado) {
        for (IObserver seguidor:unlikes) {
            if(seguidor.equals(seguidorBuscado))
                return  false;
        }
        return  true;
    }

    public void agregarLike(Seguidor seguidor) throws IOException {
        likes.add(seguidor);
        checkLikes();
    }

    public void quitarUnlike(Seguidor seguidor) {
        unlikes.remove(seguidor);
    }

    public void agregarUnlike(Seguidor seguidor) {
        unlikes.add(seguidor);
    }

    public void quitarLike(Seguidor seguidor) {
        likes.remove(seguidor);
    }

    public int getLikes() {
        return this.likes.size();
    }

    public void checkLikes() throws IOException {
        if(getLikes()%LIKES_MULTIPLIER ==0){
            owner.likesReached(this);//Avisa al dueno
            updateAll();//Avisa a todos los suscritos
        }
    }
}
