package Network.Client;

import Network.Request.IRequest;
import Network.Response.IHandleResponse;
import Network.Response.IResponse;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientResponseHandler extends Thread{

    protected Client client;
    ObjectInputStream input;
    protected boolean waitingForResponse;
    IHandleResponse responseStrategy;

    //Es un hilo que esta esperando por respuestas de parte del servidor.
    //Al igual que en el request el strategy varia de proyecto en proyecto y parsea las respuestas del servidor
    //Segun sea necesario.
    public ClientResponseHandler(Client client, Socket clientSocket, IHandleResponse responseStrategy) throws IOException {
        this.client = client;
        this.waitingForResponse = true;
        this.responseStrategy = responseStrategy;
        this.input = new ObjectInputStream(clientSocket.getInputStream());
        start();
    }

    //Hilo que espera la lectura del socket de entrada. una vez recibe algo esto es enviado al parseo de la estrategia para mostrar en pantalla.
    @Override
    public void run() {
        while (waitingForResponse){
            try {
                parseResponse((IResponse) input.readObject());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void parseResponse(IResponse response) throws IOException, ClassNotFoundException {
        responseStrategy.parseResponse(response,this);
    }


    public Client getClient() {
        return client;
    }
}
