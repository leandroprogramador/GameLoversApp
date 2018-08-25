package leandro.com.gameloversapp.Presentation.Detalhes;

import android.content.Context;

import java.util.List;

import leandro.com.gameloversapp.Data.Game;
import leandro.com.gameloversapp.Data.Genres;
import leandro.com.gameloversapp.Data.Platform;
import leandro.com.gameloversapp.R;
import leandro.com.gameloversapp.Server.GameServer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalhesPresenter implements DetalhesContract.Presenter {

    DetalhesContract.View view;
    Context context;

    public DetalhesPresenter(DetalhesContract.View view, Context context) {
        this.view = view;
        this.context = context;

        view.setToolbar();
    }

    @Override
    public void getGameDescription(int id) {
        view.showProgress();
        GameServer.getInstance(context).getGameDescription(id, context.getString(R.string.user_key), new Callback<List<Game>>() {
            @Override
            public void onResponse(Call<List<Game>> call, Response<List<Game>> response) {
                view.fillView(response.body().get(0));
                view.hideProgress();
            }

            @Override
            public void onFailure(Call<List<Game>> call, Throwable t) {
                view.showError("Cannot get game informations.");
                view.hideProgress();
            }
        });
    }

    @Override
    public void getGameGenres(String genres) {
        view.showProgress();
        GameServer.getInstance(context).getGenre(genres, context.getString(R.string.user_key), new Callback<List<Genres>>() {
            @Override
            public void onResponse(Call<List<Genres>> call, Response<List<Genres>> response) {
                view.fillGenres(Genres.getGenres(response.body()));
                view.hideProgress();
            }

            @Override
            public void onFailure(Call<List<Genres>> call, Throwable t) {
                view.fillGenres("Genre not found");
                view.hideProgress();
            }
        });
    }

    @Override
    public void getGamePlatforms(String platforms) {
        view.showProgress();
        GameServer.getInstance(context).getPlatform(platforms, context.getString(R.string.user_key), new Callback<List<Platform>>() {
            @Override
            public void onResponse(Call<List<Platform>> call, Response<List<Platform>> response) {
                view.fillPlatforms(Platform.getPlatforms(response.body()));
                view.hideProgress();
            }

            @Override
            public void onFailure(Call<List<Platform>> call, Throwable t) {
                view.fillPlatforms("Platform not found");
                view.hideProgress();
            }
        });
    }
}
