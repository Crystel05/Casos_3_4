package Request;
import Enums.AuctionRequestType;
import Enums.UserType;
import Network.Request.BaseRequest;

public class ConnectionRequest extends BaseRequest {

    public UserType userType;
    public String userName;

    public ConnectionRequest(UserType type,String userName){

        this.type = AuctionRequestType.CONNECT;
        this.userType = type;
        this.userName = userName;

    }

    @Override
    public Enum getType() {
        return type;
    }
}
