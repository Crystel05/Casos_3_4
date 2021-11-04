package Network.ObserverPattern;

import Network.Server.ServerRequestHandler;
import Network.Server.ServerResponseSender;

public class ConcreteObserver implements  IObserver{

    ServerRequestHandler requestHandler;//TODO:cAMBIAR NOMBRE A SOCKETS
    ServerResponseSender responseSender;

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
    public void update() {

    }
}
