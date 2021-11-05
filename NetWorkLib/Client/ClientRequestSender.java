package Network.Client;

import Network.Request.IRequest;
import Network.Request.ISendRequest;

import java.io.IOException;
import java.io.ObjectOutputStream;

//Esta es la misma clase que hay en server creo que solo podria existir una
public class ClientRequestSender implements ISendRequest {

    ObjectOutputStream output;

    public ClientRequestSender(ObjectOutputStream output) {
        this.output = output;
    }

    @Override
    public void sendRequest(IRequest request) throws IOException {
        output.writeObject(request);
    }
}
