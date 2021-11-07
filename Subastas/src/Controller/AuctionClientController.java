package Controller;

import Model.ClientData;
import Model.ClientNetwork;
import ProjectNetwork.AuctionClientResponseHandler;
import Vista.Comprador;
import Vista.Subastar;


import java.io.IOException;
import java.util.ArrayList;

public class AuctionClientController {

    private static AuctionClientController controller;
    private Comprador comprador;
    private Subastar subastador;
    private int subastadorActualId;
    private ArrayList<ClientNetwork> clients;
    private ArrayList<ClientData> clientsData;

    public AuctionClientController( ) {

        this.clients = new ArrayList<ClientNetwork>();
    }

    public synchronized static AuctionClientController getInstance(){
        if(controller == null){
            controller = new AuctionClientController();
        }
        return controller;
    }
    public void nuevaConexion(String name) throws IOException, ClassNotFoundException {
        ClientNetwork clientNetwork = new ClientNetwork("localhost",9999,new AuctionClientResponseHandler(),this);
        clientNetwork.connect();
        clients.add(clientNetwork);
        System.out.println(name);

    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public Subastar getSubastador() {
        return subastador;
    }

    public void setSubastador(Subastar subastador) {
        this.subastador = subastador;
    }

    public void setClients(ArrayList<ClientData> clients) {
        this.clientsData = clients;
        //subastador.setClients(clients);
        //clients.loadPosts();
    }

    public int getSubastadorActualId() {
        return subastadorActualId;
    }

    public void setSubastadorActualId(int subastadorActualId) {
        this.subastadorActualId = subastadorActualId;
    }

    public void defaultUpdate(){
        subastador.defaultConectionUpdate();
    }



}
