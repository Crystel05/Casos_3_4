package Model;

import Model.Requests.IRequest;
import Model.Requests.IResponse;

public class Seguidor {
    int idCliente;
    //Servidor servidor;

    public Seguidor(int idCliente){
        this.idCliente = idCliente;
    }

    //Por objeto o por codigo. Tiene que hacer la peticion al servidor
    public void follow(Artista artista){

    }

    public void likePost(Post post){

    }

    public void dislikePost(Post post){

    }

    public void verArtistas(){
        //Para traer del servidor y cargar en la pantalla.
    }

    public void verPost(){

    }

    public IResponse sendRequest(IRequest request){
        //return server.request();
        return null;
    }

    //Tengo que poder ver todos los artistas

}
