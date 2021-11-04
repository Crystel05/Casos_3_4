package Network.Response;

import Network.Client.ClientResponseHandler;

import java.io.IOException;

public interface IHandleResponse {
    void parseResponse(IResponse request, ClientResponseHandler client) throws IOException, ClassNotFoundException;
}
