package Controller;

import Enums.UserType;
import Model.ClientNetwork;
import Network.Client.Client;
import ProjectNetwork.AuctionClientResponseHandler;
import Request.ConnectionRequest;
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


    public synchronized static AuctionClientController getInstance(){
        if(controller == null){
            controller = new AuctionClientController();
        }
        return controller;
    }
    public void nuevaConexion(String testName) throws IOException, ClassNotFoundException {
        ClientNetwork clientNetwork = new ClientNetwork("localhost",9999,new AuctionClientResponseHandler(),this);
        clientNetwork.connect();
        clients.add(clientNetwork);

    }
}
