package leandro.com.gameloversapp.Server;

import android.content.Context;

import java.util.List;

import leandro.com.gameloversapp.Data.Game;
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
}
