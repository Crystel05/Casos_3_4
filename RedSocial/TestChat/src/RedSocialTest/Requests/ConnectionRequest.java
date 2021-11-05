package RedSocialTest.Requests;

import Network.Request.IRequest;
import RedSocialTest.Enums.SocialRequestTypes;
import RedSocialTest.Enums.UserType;

public class ConnectionRequest implements IRequest {

    public SocialRequestTypes type;
    public UserType userType;

    public ConnectionRequest(UserType type){

        this.type = SocialRequestTypes.CONNECT;
        this.userType = type;
    }

    @Override
    public Enum getType() {
        return type;
    }
}
