package RedSocialTest.Responses;

//import RedSocialTest.Network.Response.IResponse;

import Network.Response.BaseResponse;
import RedSocialTest.Enums.SocialResponseTypes;

public class LikesAlcanzados extends BaseResponse {


    public LikesAlcanzados(int cantidadDeLikes) {
        this.type = SocialResponseTypes.LIKES_MILE;
    }


}
