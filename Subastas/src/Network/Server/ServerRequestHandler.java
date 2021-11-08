package Network.Server;

import Network.BaseServerClasses.BasicServerObject;
import Network.BaseServerClasses.BasicServerClient;
import Network.Request.IHandleRequest;
import Network.Request.IRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServerRequestHandler extends Thread {

    protected Server server;
    protected ObjectInputStream input;
    protected boolean waitingForRequest;
    protected IHandleRequest requestStrategy;
    protected ServerResponseSender responseSender;

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

    protected void addSockets(BasicServerClient observer){
        observer.setRequestHandler(this);
        observer.setResponseSender(responseSender);
    }

    public void parseRequest(IRequest request) throws IOException, ClassNotFoundException {
        requestStrategy.parseRequest(request,this);
    }
    public void addToClients(BasicServerClient observer){
        addSockets(observer);
        server.addCliente1(observer);
   }

    public void addToClients2(BasicServerClient observer){

        addSockets(observer);
        server.addCliente2(observer);
    }

    public void addToObjects(BasicServerObject observable){
        server.addObject(observable);
    }

    protected ObjectInputStream getInput() {
        return input;
    }

    public Server getServer(){
        return server;
    }

    public ServerResponseSender getResponseSender(){
        return responseSender;
    }

    public ArrayList<BasicServerClient> getClientes(){
        return server.getClientes();
    }

    public ArrayList<BasicServerClient> getClientes2(){
        return server.getClientes2();
    }

    public ArrayList<BasicServerObject> getObjects(){
        return server.getObjects();
    }


}
