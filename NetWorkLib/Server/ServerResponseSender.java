package Network.Server;

import Network.Response.IResponse;
import Network.Response.ISendResponse;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class ServerResponseSender implements ISendResponse {

    ObjectOutputStream output;

    public ServerResponseSender(ObjectOutputStream output) {
        this.output = output;
    }

    @Override
    public void sendResponse(IResponse response) throws IOException {
        output.writeObject(response);
    }
}
