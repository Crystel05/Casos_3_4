package RedSocialTest.Responses;

//import RedSocialTest.Network.Response.IResponse;

import Network.Response.BaseResponse;
import RedSocialTest.Enums.SocialResponseTypes;
import RedSocialTest.Model.Data.PostData;

public class LikesAlcanzados extends BaseResponse {

    public String content;
    public LikesAlcanzados(PostData postData) {
        this.type = SocialResponseTypes.LIKES_MILE;
        content = "Post: " + postData.id + " from "+postData.owner+" reached "+postData.likes+" likes";
    }


}
