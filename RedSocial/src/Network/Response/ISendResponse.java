package Network.Response;

import java.io.IOException;
import java.io.ObjectOutputStream;

public interface ISendResponse {
    void sendResponse(IResponse response) throws IOException;
}
