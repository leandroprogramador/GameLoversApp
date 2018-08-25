package leandro.com.gameloversapp.Server;

import java.util.List;

import leandro.com.gameloversapp.Data.Game;
import leandro.com.gameloversapp.Data.Genres;
import leandro.com.gameloversapp.Data.Platform;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IGameApi {


    @GET("/games/?fields=name,cover&limit=50")
    @Headers("Accept:application/json")
    Call<List<Game>> getGameByPlatform(@Query("filter[release_dates.platform][any]") int platform, @Header("user-key") String key);


    @GET("/games/{game}?fields=name,summary,cover,platforms,genres")
    @Headers("Accept:application/json")
    Call<List<Game>> getGameDescription(@Path("game") int game, @Header("user-key") String key);

    @GET("/genres/{genre}/?fields=name")
    @Headers("Accept:application/json")
    Call<List<Genres>> getGenre(@Path("genre") String genres, @Header("user-key") String key);

    @GET("/platforms/{platform}/?fields=name")
    @Headers("Accept:application/json")
    Call<List<Platform>> getPlatform(@Path("platform") String platforms, @Header("user-key") String key);
}
