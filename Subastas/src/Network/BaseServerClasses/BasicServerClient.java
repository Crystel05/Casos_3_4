package Network.BaseServerClasses;

import Network.ObserverPattern.IObservable;
import Network.ObserverPattern.IObserver;
import Network.Server.ServerRequestHandler;
import Network.Server.ServerResponseSender;

import java.io.IOException;

public class BasicServerClient implements IObserver {

    ServerRequestHandler requestHandler;//TODO:cAMBIAR NOMBRE A SOCKETS
    ServerResponseSender responseSender;
    int objectId;

    public BasicServerClient(int objectId) {
        this.objectId = objectId;
    }

    public int getObjectId() {
        return objectId;
    }

    public ServerRequestHandler getRequestHandler() {
        return requestHandler;
    }

    public void setRequestHandler(ServerRequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    public ServerResponseSender getResponseSender() {
        return responseSender;
    }

    public void setResponseSender(ServerResponseSender responseSender) {
        this.responseSender = responseSender;
    }

    @Override
    public void update(IObservable observable) throws IOException {

    }
}
