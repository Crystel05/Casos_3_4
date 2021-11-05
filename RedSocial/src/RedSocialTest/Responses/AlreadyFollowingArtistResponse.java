package RedSocialTest.Responses;


import Network.Response.BaseResponse;
import RedSocialTest.Enums.SocialResponseTypes;

public class AlreadyFollowingArtistResponse extends BaseResponse {
    public AlreadyFollowingArtistResponse(){
        this.type = SocialResponseTypes.ALREADY_FOLLOWING;
    }
}
