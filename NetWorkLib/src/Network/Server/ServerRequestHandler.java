package Network.Server;

import Network.ObserverPattern.ConcreteObservable;
import Network.ObserverPattern.ConcreteObserver;
import Network.Request.IHandleRequest;
import Network.Request.IRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ServerRequestHandler extends Thread {

    private Server server;
    private ObjectInputStream input;
    private boolean waitingForRequest;
    private IHandleRequest requestStrategy;
    private ServerResponseSender responseSender;

    //Un hilo de lectura de request de parte de los clientes en el servidor.
    //Tiene asociada una estrategia para parsear los request
    public ServerRequestHandler(Server server, Socket client,ServerResponseSender responseSender, IHandleRequest requestStrategy) throws IOException {
        this.server = server;
        this.waitingForRequest = true;
        this.requestStrategy = requestStrategy;
        this.input = new ObjectInputStream(client.getInputStream());
        this.responseSender = responseSender;
        start();
    }

    @Override
    public void run() {
        while (waitingForRequest) {
            try {
                parseRequest((IRequest) input.readObject());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void addSockets(ConcreteObserver observer){
        observer.setRequestHandler(this);
        observer.setResponseSender(responseSender);
    }

    private void parseRequest(IRequest request) throws IOException, ClassNotFoundException {
        requestStrategy.parseRequest(request,this);
    }
    public void addToClients(ConcreteObserver observer){
        addSockets(observer);
        server.addCliente1(observer);
   }

    public void addToClients2(ConcreteObserver observer){

        addSockets(observer);
        server.addCliente2(observer);
    }

    public void addToObjects(ConcreteObservable observable){
        server.addObject(observable);
    }

    public ObjectInputStream getInput() {
        return input;
    }

    public Server getServer(){
        return server;
    }

    public ServerResponseSender getResponseSender(){
        return responseSender;
    }

}
