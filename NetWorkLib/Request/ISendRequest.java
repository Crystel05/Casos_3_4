package Network.Request;

import java.io.IOException;
import java.io.ObjectOutputStream;

public interface ISendRequest {
    void sendRequest(IRequest request) throws IOException;
}
