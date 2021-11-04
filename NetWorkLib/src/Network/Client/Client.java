package Network.Client;

import Network.Request.IRequest;
import Network.Response.IHandleResponse;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

    protected ClientResponseHandler responseHandler;
    protected ClientRequestSender requestSender;

    //Guarda los sockets con la conexion del servidor
    public Client(String host, int port, IHandleResponse responseHandler) throws IOException, ClassNotFoundException {
        Socket socketClient = new Socket(host, port);
        this.requestSender = new ClientRequestSender(new ObjectOutputStream(socketClient.getOutputStream()));
        this.responseHandler = new ClientResponseHandler(this,socketClient,responseHandler);
    }

    public void request(IRequest request) throws IOException, ClassNotFoundException {
        requestSender.sendRequest(request);
    }

}
