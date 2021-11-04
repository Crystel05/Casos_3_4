package Network.Response;

import java.io.IOException;

public interface ISendResponse {
    void sendResponse(IResponse response) throws IOException;
}
