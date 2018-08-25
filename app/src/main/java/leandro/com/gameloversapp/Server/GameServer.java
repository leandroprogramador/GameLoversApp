package leandro.com.gameloversapp.Server;

import android.content.Context;

import java.util.List;

import leandro.com.gameloversapp.Data.Game;
import leandro.com.gameloversapp.Data.Genres;
import leandro.com.gameloversapp.Data.Platform;
import leandro.com.gameloversapp.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GameServer {

    private static IGameApi iGameApi;
    private static GameServer gameServer;
    Context context;


    public GameServer(Context mContext) {
        this.context = mContext;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(context.getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        iGameApi = retrofit.create(IGameApi.class);
    }

    public static GameServer getInstance(Context context){
        if(gameServer == null){
            gameServer = new GameServer(context);
        }
        return gameServer;
    }

    public void getGameByPlatform(int platform,String user_key, Callback<List<Game>> callback){
        Call<List<Game>> gamesCall = iGameApi.getGameByPlatform(platform, user_key);
        gamesCall.enqueue(callback);
    }
    public void getGameDescription(int game,String user_key, Callback<List<Game>> callback){
        Call<List<Game>> gamesCall = iGameApi.getGameDescription(game, user_key);
        gamesCall.enqueue(callback);
    }

    public void getGenre(String genres,String user_key, Callback<List<Genres>> callback){
        Call<List<Genres>> gamesCall = iGameApi.getGenre(genres, user_key);
        gamesCall.enqueue(callback);
    }

    public void getPlatform(String platforms ,String user_key, Callback<List<Platform>> callback){
        Call<List<Platform>> gamesCall = iGameApi.getPlatform(platforms, user_key);
        gamesCall.enqueue(callback);
    }
}
