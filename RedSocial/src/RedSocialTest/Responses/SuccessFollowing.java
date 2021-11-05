package RedSocialTest.Responses;


import Network.Response.BaseResponse;
import RedSocialTest.Enums.SocialResponseTypes;

public class SuccessFollowing extends BaseResponse {
   public SuccessFollowing(){
      this.type = SocialResponseTypes.SUCCESS_FOLLOWING;
   }
}
