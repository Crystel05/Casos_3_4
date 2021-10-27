package Model;

import Model.Requests.IRequest;
import Model.Requests.PostRequest;

import java.util.ArrayList;

public class Artista {

    //Servidor server
    ArrayList<Seguidor> seguidores;
    String nickName;//No se pide
    int artistaId;
    boolean activo;


    public Artista(int artistaId){
        this.seguidores = new ArrayList<>();
        this.artistaId = artistaId;
        this.activo = true;
    }


    public void post(String postContent){
        sendRequest(new PostRequest(postContent));

    }

    //Esto es propio del cliente del servidor
    public void sendRequest(IRequest request) {
    }

    //El response que recibe es tratado de acuerdo a como sea necesario.
    /*public void receiveResponse(IResponse response){

    }*/

    //Servidor tendria ReceiveRequest y SendResponse;

    public void darseDeBaja(){
        this.activo = false;
    }

    public void addFollower(Seguidor seguidor){
        this.seguidores.add(seguidor);
    }
}
