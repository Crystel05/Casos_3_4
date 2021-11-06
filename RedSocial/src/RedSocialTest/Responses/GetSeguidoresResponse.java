package RedSocialTest.Responses;

import Network.Request.BaseRequest;
import Network.Response.BaseResponse;
import RedSocialTest.Enums.SocialResponseTypes;
import RedSocialTest.Model.Data.SeguidorData;

import java.util.ArrayList;

public class GetSeguidoresResponse extends BaseResponse {

    public ArrayList<SeguidorData> seguidores;

    public GetSeguidoresResponse(ArrayList<SeguidorData> seguidores){
        this.type = SocialResponseTypes.GET_SEGUIDORES;
        this.seguidores = seguidores;
    }
}
