package Model;

import Controller.AuctionClientController;
import Enums.UserType;
import Network.Client.Client;
import Network.Response.IHandleResponse;
import Request.ConnectionRequest;
import Request.GetClientsRequest;

import java.io.IOException;

public class ClientNetwork extends Client {

    private AuctionClientController auctionController;

    public ClientNetwork(String host, int port, IHandleResponse responseHandler,AuctionClientController auctionController) throws IOException, ClassNotFoundException {
        super(host, port, responseHandler);
        this.auctionController = auctionController;
    }


    @Override
    public void connect() throws IOException, ClassNotFoundException {
        request(new ConnectionRequest(UserType.SUBASTADOR,"Cliente"+getClientId()));
        request(new GetClientsRequest());  //Pide que le devuelvan los clientes conectados
    }

    public AuctionClientController getAuctionClientController() {
        return auctionController;
    }

}
