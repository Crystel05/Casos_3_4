package RedSocialTest.Responses;

//import RedSocialTest.Network.Response.IResponse;

import Network.Response.BaseResponse;
import RedSocialTest.Enums.SocialResponseTypes;
import RedSocialTest.Model.Data.ArtistData;

public class SeguidoresAlcanzados extends BaseResponse {

    public String content;

    public SeguidoresAlcanzados(ArtistData artist) {
        this.type = SocialResponseTypes.FOLLOWER_MILE;
        content = "Artist "+artist.nickname +" reached"+ artist.seguidores+ " followers";
    }
}
