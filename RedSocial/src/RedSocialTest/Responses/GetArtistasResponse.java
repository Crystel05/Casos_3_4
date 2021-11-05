package RedSocialTest.Responses;

import Network.Response.BaseResponse;
import RedSocialTest.Enums.SocialResponseTypes;
import RedSocialTest.Model.ArtistaServer;
import RedSocialTest.Model.Data.ArtistData;

import java.util.ArrayList;

public class GetArtistasResponse extends BaseResponse {

    public ArrayList<ArtistData> artistas;//Si no funcionara se puede hacer una clase artista data lo mismo para post y seguidor

    public GetArtistasResponse(ArrayList<ArtistData> artistas){
        this.type = SocialResponseTypes.GET_ARTISTAS;
        this.artistas = artistas;
    }
}
