package Controller;

import Model.Bid;
import Model.Data.AuctionData;
import Model.Data.ClientData;
import ClientTypes.ClientNetwork;
import ProjectNetwork.AuctionClientResponseHandler;
import Request.*;
import Vista.Comprador;
import Vista.Subastar;


import java.io.FileNotFoundException;
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
    private AuctionData subastaActual;

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
    }

    public void setSubastas(int subastadorId){
        System.out.println("Set subasta");
        subastadorPantalla.setSubastas(clientsData.get(subastadorId).subastasHechas);
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

    public void cerrarSubasta() throws IOException, ClassNotFoundException {
        getCurrentClient().request(new CloseAuctionRequest(subastaActual.subastaId,subastadorActualId));
    }

    public void cancelarSubasta() throws IOException, ClassNotFoundException {
        getCurrentClient().request(new CancelAuctionRequest(subastaActual.subastaId,subastadorActualId));
    }


    public void getClientes() throws IOException, ClassNotFoundException {
        getCurrentClient().request(new GetClientsRequest());
    }

    public void updateSubastaActual() throws FileNotFoundException {
        subastadorPantalla.llenarDatos(subastaActual);
    }

    public void setSubastaActual(int subastaActualPantalla) {
        this.subastaActual = clientsData.get(subastadorActualId).subastasHechas.get(subastaActualPantalla);
    }

    public void ofertar(int monto,int subastador) throws IOException, ClassNotFoundException {
        this.getCurrentClient().request(new BidRequest(new Bid(subastadorActualId,subastaActual.subastaId,monto),subastador));
    }

    public void updateCompradorPantalla() throws FileNotFoundException {
        compradorPantalla.llenarDatos(subastaActual);
    }


    //Se tiene que traer todas las subastas
    public void defaultUpdateComprador() {
        compradorPantalla.defaultConectionUpdate();
        compradorPantalla.setClients(clientsData);
        compradorPantalla.setSubastas(clientsData.get(0).subastasHechas);
    }
}
