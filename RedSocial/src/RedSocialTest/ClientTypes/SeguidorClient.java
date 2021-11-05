package RedSocialTest.ClientTypes;

import Network.Client.Client;
import Network.Response.IHandleResponse;

import java.io.IOException;

public class SeguidorClient extends Client {
    public SeguidorClient(String host, int port, IHandleResponse responseHandler) throws IOException, ClassNotFoundException {
        super(host, port, responseHandler);
    }
}
