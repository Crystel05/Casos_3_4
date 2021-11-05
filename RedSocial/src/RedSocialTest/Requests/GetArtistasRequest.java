package RedSocialTest.Requests;

//import RedSocialTest.Network.Request.IRequest;

import Network.Request.BaseRequest;
import RedSocialTest.Enums.SocialRequestTypes;

public class GetArtistasRequest extends BaseRequest {

    public GetArtistasRequest(){
        this.type = SocialRequestTypes.GET_ALL_ARTIST;
    }

}
