package Request;
import Enums.AuctionRequestType;
import Enums.UserType;
import Network.Request.IRequest;

public class ConnectionRequest implements IRequest {

    public AuctionRequestType type;
    public UserType userType;
    public ConnectionRequest(UserType type){

        this.type = AuctionRequestType.CONNECT;
        this.userType = type;
    }


    @Override
    public Enum getType() {
        return userType;
    }
}
