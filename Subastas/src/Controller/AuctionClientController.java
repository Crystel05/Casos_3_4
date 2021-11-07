package Controller;

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
    private int subastadorActual;
    private ArrayList<ClientNetwork> clients;  //AUN NO SE PARA QUE

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
}
