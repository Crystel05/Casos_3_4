package Network.Request;

import java.io.IOException;

public interface ISendRequest {
    void sendRequest(IRequest request) throws IOException;
}
