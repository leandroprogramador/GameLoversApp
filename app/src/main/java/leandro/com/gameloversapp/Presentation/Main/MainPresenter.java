package leandro.com.gameloversapp.Presentation.Main;

import android.content.Context;

import java.util.List;

import leandro.com.gameloversapp.Data.Game;
import leandro.com.gameloversapp.R;
import leandro.com.gameloversapp.Server.GameServer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainContract.Presenter {


    MainContract.View mainView;
    Context mContext;

    public MainPresenter(MainContract.View mView, Context context) {
        this.mainView = mView;
        this.mContext = context;

        mainView.setToolbar();
        mainView.setTabs();



    }



    @Override
    public List<Game> getGamesBylatform(int platform) {
        mainView.showProgress();
        GameServer.getInstance(mContext).getGameByPlatform(platform, mContext.getString(R.string.user_key), new Callback<List<Game>>() {
            @Override
            public void onResponse(Call<List<Game>> call, Response<List<Game>> response) {
                mainView.fillRecyclerView(platform, response.body());
                mainView.hideProgress();
            }

            @Override
            public void onFailure(Call<List<Game>> call, Throwable t) {
                mainView.showError("Erro ao recuperar lista de games.");
                mainView.hideProgress();
            }
        });
        return null;
    }
}
