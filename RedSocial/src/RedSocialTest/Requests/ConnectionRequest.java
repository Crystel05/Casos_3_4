package RedSocialTest.Requests;

//import RedSocialTest.Network.Request.IRequest;
import Network.Request.BaseRequest;
import Network.Request.IRequest;
import RedSocialTest.Enums.SocialRequestTypes;
import RedSocialTest.Enums.UserType;

public class ConnectionRequest extends BaseRequest {

    public UserType userType;
    public String userName;

    public ConnectionRequest(UserType type,String userName) {

        this.type = SocialRequestTypes.CONNECT;
        this.userType = type;
        this.userName = userName;
    }


}
