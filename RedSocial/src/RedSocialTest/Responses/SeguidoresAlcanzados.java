package RedSocialTest.Responses;

//import RedSocialTest.Network.Response.IResponse;

import Network.Response.BaseResponse;
import RedSocialTest.Enums.SocialResponseTypes;

public class SeguidoresAlcanzados extends BaseResponse {
    public SeguidoresAlcanzados(int cantidadDeSeguidores) {
        this.type = SocialResponseTypes.FOLLOWER_MILE;
    }
}
