package RedSocialTest.Responses;

//import RedSocialTest.Network.Response.IResponse;

import Network.Response.BaseResponse;
import RedSocialTest.Enums.SocialResponseTypes;

public class ArtistaInactivoResponse extends BaseResponse {
    public String content = "This artist is inactive";
   public ArtistaInactivoResponse(){
       this.type = SocialResponseTypes.UNACTIVE_ARTIST;
   }
}
