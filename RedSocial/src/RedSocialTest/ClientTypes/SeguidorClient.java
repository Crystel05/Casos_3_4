package RedSocialTest.ClientTypes;

import Network.Client.Client;
import Network.Response.IHandleResponse;
import RedSocialTest.Enums.UserType;
import RedSocialTest.Requests.ConnectionRequest;

import java.io.IOException;

public class SeguidorClient extends Client {
    public SeguidorClient(String host, int port, IHandleResponse responseHandler) throws IOException, ClassNotFoundException {
        super(host, port, responseHandler);

    }

    @Override
    public void connect() throws IOException, ClassNotFoundException {
        request(new ConnectionRequest(UserType.FOLLOWER,"Test"));
    }
}
