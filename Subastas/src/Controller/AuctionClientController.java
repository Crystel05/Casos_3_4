package Controller;

import Model.Bid;
import Model.Data.AuctionData;
import Model.Data.ClientData;
import ClientTypes.ClientNetwork;
import ProjectNetwork.AuctionClientResponseHandler;
import Request.AprovedBid;
import Request.AuctionRequest;
import Vista.Comprador;
import Vista.Subastar;


import java.io.IOException;
import java.util.ArrayList;

public class AuctionClientController {

    private static AuctionClientController controller;
    private Comprador compradorPantalla;
    private Subastar subastadorPantalla;
    private int subastadorActualId;
    private ArrayList<ClientNetwork> clients;
    private ArrayList<ClientData> clientsData;
    private Bid bidToAccept;//Puede cambiarse a ser una cola de ofertas.

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
        ClientNetwork clientNetwork = new ClientNetwork("localhost",9999,new AuctionClientResponseHandler(),this,name);
        clientNetwork.connect();
        clients.add(clientNetwork);
        System.out.println(name);

    }
    public void crearSubasta(AuctionData auctionData) throws IOException, ClassNotFoundException {
        //Crea un request para crear subasta, para un subastador determinado
        clients.get(subastadorActualId).request(new AuctionRequest(auctionData,subastadorActualId));
    }

    public Comprador getComprador() {
        return compradorPantalla;
    }

    public void setComprador(Comprador compradorPantalla) {
        this.compradorPantalla = compradorPantalla;
    }

    public Subastar getSubastador() {
        return subastadorPantalla;
    }

    public void setSubastador(Subastar subastador) {
        this.subastadorPantalla = subastador;
    }

    public void setClients(ArrayList<ClientData> clients) {
        this.clientsData = clients;
        subastadorPantalla.setClients(clients);
        //clients.loadPosts();
    }

    public int getSubastadorActualId() {
        return subastadorActualId;
    }

    public void setSubastadorActualId(int subastadorActualId) {
        this.subastadorActualId = subastadorActualId;
    }

    public void defaultUpdate(){
        subastadorPantalla.defaultConectionUpdate();
    }


    public ClientNetwork getCurrentClient(){
        return clients.get(getSubastadorActualId());
    }

    public void setBidToAccept(Bid bid) {
        this.bidToAccept = bid;
    }

    public void addToNotifiacions(String string) {
        getCurrentClient().addToNotifications(string);
    }


    public void acceptActualBid() throws IOException, ClassNotFoundException {
        getCurrentClient().request(new AprovedBid(bidToAccept,subastadorActualId,true));
    }

    public void rejectActualBid() throws IOException, ClassNotFoundException {
        getCurrentClient().request(new AprovedBid(bidToAccept,subastadorActualId,false));
    }
}
