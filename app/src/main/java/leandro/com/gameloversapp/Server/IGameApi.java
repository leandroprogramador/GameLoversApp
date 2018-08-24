package leandro.com.gameloversapp.Server;

import java.util.List;

import leandro.com.gameloversapp.Data.Game;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface IGameApi {


    @GET("/games/?fields=name,cover&limit=50")
    @Headers("Accept:application/json")
    Call<List<Game>> getGameByPlatform(@Query("filter[release_dates.platform][any]") int platform, @Header("user-key") String key);
}
