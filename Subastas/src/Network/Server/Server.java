package Network.Server;

import Network.BaseServerClasses.BasicServerObject;
import Network.BaseServerClasses.BasicServerClient;
import Network.Request.IHandleRequest;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends  Thread implements Serializable {

    private ServerSocket serverSocket;
    private ArrayList<BasicServerClient> clients;
    private ArrayList<BasicServerClient> clients2;
    private ArrayList<BasicServerObject> objects;
    private boolean online;
    private IHandleRequest requestHandler;

    public Server(int port, IHandleRequest requestHandler) throws IOException, ClassNotFoundException {
        this.requestHandler = requestHandler;
        this.serverSocket = new ServerSocket(port);
        this.online = true;
        this.clients = new ArrayList<>();
        this.clients2 = new ArrayList<>();
        this.objects = new ArrayList<>();
        System.out.println("Server Up");
        start();
    }

    @Override
    public void run() {
        while (online) {
            try {
                waitForConnection();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void waitForConnection() throws IOException, ClassNotFoundException {
        System.out.println("Waiting for a client ...");
        Socket client = serverSocket.accept();
        System.out.println("NEW CLIENT CONNECT");
        //Esto tiene que ser guardado en los observer/observable concretos para poder seguir comunicandose con ellos
        ServerResponseSender serverResponseSender = new ServerResponseSender(new ObjectOutputStream(client.getOutputStream()));
        new ServerRequestHandler(this, client,serverResponseSender, requestHandler);
    }

    public void addCliente1(BasicServerClient observer) {
        clients.add(observer);
    }

    public void addCliente2(BasicServerClient observer) {
        clients2.add(observer);
    }


    public void addObject(BasicServerObject observable) {
        objects.add(observable);
    }


    public ArrayList<BasicServerClient> getClientes() {
        return this.clients;
    }

    public ArrayList<BasicServerClient> getClientes2() {
        return this.clients2;
    }

    public ArrayList<BasicServerObject> getObjects() {
        return this.objects;
    }

    public void setOffline(){
        this.online = false;
    }

    public void setOnline(){
        this.online = true;
    }

    public BasicServerClient getClient(int id,ArrayList<BasicServerClient> clientsList){
        return clientsList.get(id);
    }

    public BasicServerObject getObject(int id){
        return objects.get(id);
    }
}
