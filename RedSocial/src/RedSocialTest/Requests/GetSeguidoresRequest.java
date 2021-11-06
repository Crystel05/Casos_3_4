package RedSocialTest.Requests;

import Network.Request.BaseRequest;
import Network.Request.IRequest;
import RedSocialTest.Enums.SocialRequestTypes;
import RedSocialTest.Model.Data.SeguidorData;

import java.util.ArrayList;

public class GetSeguidoresRequest extends BaseRequest {

    public GetSeguidoresRequest(){
        this.type = SocialRequestTypes.GET_ALL_FOLLOWERS;
    }
}
