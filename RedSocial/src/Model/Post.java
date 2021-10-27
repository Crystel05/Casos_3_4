package Model;

import Model.Requests.MetaPostRequest;

public class Post {
    int postId;
    String mensaje;
    int likes;
    int dislikes;
    final int LIKES_MULTIPLIER = 10;
    Artista artista;

    public Post(int postId,String mensaeje,Artista artista){
        this.postId = postId;
        this.mensaje = mensaeje;
        this.artista = artista;
    }

    public void addLike(){
        this.likes++;
        checkLikes();
    }

    public void addDislikes(){
        this.dislikes++;
    }

    public void checkLikes(){
        if(likes%LIKES_MULTIPLIER ==0){
            artista.sendRequest(new MetaPostRequest(this));
        }
    }
}
