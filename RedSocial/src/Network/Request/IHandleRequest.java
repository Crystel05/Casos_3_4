package Network.Request;

import Network.Server.ServerRequestHandler;

import java.io.IOException;

public interface IHandleRequest {
    void parseRequest(IRequest request, ServerRequestHandler server) throws IOException, ClassNotFoundException;
}
